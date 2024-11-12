package tech.reliab.course.tishchenkodyu.bank.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import tech.reliab.course.tishchenkodyu.bank.entity.Bank;
import tech.reliab.course.tishchenkodyu.bank.entity.CreditAccount;
import tech.reliab.course.tishchenkodyu.bank.entity.Employee;
import tech.reliab.course.tishchenkodyu.bank.entity.PaymentAccount;
import tech.reliab.course.tishchenkodyu.bank.entity.User;
import tech.reliab.course.tishchenkodyu.bank.service.BankService;
import tech.reliab.course.tishchenkodyu.bank.service.CreditAccountService;
import tech.reliab.course.tishchenkodyu.bank.service.UserService;

public class CreditAccountServiceImpl implements CreditAccountService {

    private static int creditAccountsCount = 0;

    private final UserService userService;
    private final BankService bankService;

    private List<CreditAccount> creditAccounts = new ArrayList<>();

    public CreditAccountServiceImpl(UserService userService, BankService bankService) {
        this.userService = userService;
        this.bankService = bankService;
    }

    public CreditAccount createCreditAccount(User user, Bank bank, LocalDate startDate, int loanTermMonths,
                                             double loanAmount, double interestRate, Employee employee,
                                             PaymentAccount paymentAccount) {
        CreditAccount creditAccount = new CreditAccount(user, bank, startDate, loanTermMonths,
                interestRate, employee, paymentAccount);
        creditAccount.setId(creditAccountsCount++);
        creditAccount.setEndDate(calculateEndDate(startDate, loanTermMonths));
        creditAccount.setLoanAmount(calculateLoanAmount(loanAmount, bank));
        creditAccount.setMonthlyPayment(calculateMonthlyPayment(interestRate, loanAmount, loanTermMonths));
        creditAccount.setInterestRate(calculateInterestRate(interestRate, bank));
        creditAccounts.add(creditAccount);
        userService.addCreditAccount(creditAccount, user);
        return creditAccount;
    }

    /**
     * Вычисление даты окончания кредита.
     *
     * @param startDate         Дата начала кредита.
     * @param loanTermMonths    Срок кредита в месяцах.
     * @return Дата окончания кредита.
     */
    private LocalDate calculateEndDate(LocalDate startDate, int loanTermMonths) {
        return startDate.plusMonths(loanTermMonths);
    }

    /**
     * Расчет аннуитетного платежа по кредиту.
     *
     * @param interestRate      Процентная ставка по кредиту.
     * @param loanAmount        Сумма кредита.
     * @param loanTermMonths    Срок кредита в месяцах.
     * @return Размер аннуитетного платежа.
     */
    private double calculateMonthlyPayment(double interestRate, double loanAmount, int loanTermMonths) {
        double monthlyRate = interestRate / 12 / 100;
        return loanAmount * (monthlyRate / (1 - Math.pow(1 + monthlyRate, -loanTermMonths)));
    }

    /**
     * Расчет суммы кредита, не превышающей доступных средств банка.
     *
     * @param loanAmount Сумма кредита, запрошенная пользователем.
     * @param bank      Банк, который предоставляет кредит.
     * @return Сумма кредита, не превышающая доступные средства банка.
     */
    private double calculateLoanAmount(double loanAmount, Bank bank) {
        if (loanAmount > bank.getTotalMoney()) {
            loanAmount = bank.getTotalMoney();
        }
        return loanAmount;
    }

    /**
     * Расчет процентной ставки по кредиту, не превышающей процентную ставку банка.
     *
     * @param interestRate Процентная ставка по кредиту, запрошенная пользователем.
     * @param bank        Банк, который предоставляет кредит.
     * @return Процентная ставка по кредиту, не превышающая процентную ставку банка.
     */
    private double calculateInterestRate(double interestRate, Bank bank) {
        if (interestRate > bank.getInterestRate()) {
            System.out.println("Заданная процентная ставка превышает процентную ставку банка. Ставка будет скорректирована.");
            interestRate = bank.getInterestRate();
        }
        return interestRate;
    }

    public Optional<CreditAccount> getCreditAccountById(int id) {
        return creditAccounts.stream()
                .filter(creditAccount -> creditAccount.getId() == id)
                .findFirst();
    }

    public List<CreditAccount> getAllCreditAccounts() {
        return new ArrayList<>(creditAccounts);
    }

    public void updateCreditAccount(int id, Bank bank) {
        CreditAccount creditAccount = getCreditAccountIfExists(id);
        creditAccount.setBank(bank);
    }

    public void deleteCreditAccount(int accountId, int userId) {
        CreditAccount creditAccount = getCreditAccountIfExists(accountId);
        creditAccounts.remove(creditAccount);
        User user = userService.getUserIfExists(userId);
        userService.deleteCreditAccount(creditAccount, user);
    }

    /**
     * Получение кредитного аккаунта по его идентификатору, если он существует.
     *
     * @param id Идентификатор кредитного аккаунта.
     * @return Кредитный аккаунт, если он найден.
     * @throws NoSuchElementException Если кредитный аккаунт не найден.
     */
    private CreditAccount getCreditAccountIfExists(int id) {
        return getCreditAccountById(id).orElseThrow(() -> new NoSuchElementException("CreditAccount was not found"));
    }
}