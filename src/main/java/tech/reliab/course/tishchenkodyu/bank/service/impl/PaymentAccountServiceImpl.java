package tech.reliab.course.tishchenkodyu.bank.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import tech.reliab.course.tishchenkodyu.bank.entity.Bank;
import tech.reliab.course.tishchenkodyu.bank.entity.PaymentAccount;
import tech.reliab.course.tishchenkodyu.bank.entity.User;
import tech.reliab.course.tishchenkodyu.bank.service.BankService;
import tech.reliab.course.tishchenkodyu.bank.service.PaymentAccountService;
import tech.reliab.course.tishchenkodyu.bank.service.UserService;

public class PaymentAccountServiceImpl implements PaymentAccountService {

    private static int paymentAccountCount = 0;

    private final UserService userService;
    private final BankService bankService;

    private List<PaymentAccount> paymentAccounts = new ArrayList<>();

    public PaymentAccountServiceImpl (UserService userService, BankService bankService) {
        this.userService = userService;
        this.bankService = bankService;
    }

    public PaymentAccount createPaymentAccount(User user, Bank bank) {
        PaymentAccount paymentAccount = new PaymentAccount(user, bank);
        paymentAccount.setId(paymentAccountCount++);
        paymentAccounts.add(paymentAccount);
        userService.addPaymentAccount(paymentAccount, user);
        userService.addBank(bank, user);
        bankService.addClient(bank);
        return paymentAccount;
    }

    public Optional<PaymentAccount> getPaymentAccountById(int id) {
        return paymentAccounts.stream()
                .filter(paymentAccount -> paymentAccount.getId() == id)
                .findFirst();
    }

    public List<PaymentAccount> getAllPaymentAccounts() {
        return new ArrayList<>(paymentAccounts);
    }


    public void updatePaymentAccount(int id, Bank bank) {
        PaymentAccount paymentAccount = getPaymentAccountIfExists(id);
        paymentAccount.setBank(bank);
    }

    public void deletePaymentAccount(int id) {
        PaymentAccount paymentAccount = getPaymentAccountIfExists(id);
        paymentAccounts.remove(paymentAccount);
        userService.deletePaymentAccount(paymentAccount, paymentAccount.getUser());
    }

    /**
     * Получение платежного аккаунта по его идентификатору, если он существует.
     *
     * @param id Идентификатор платежного аккаунта.
     * @return Платежный аккаунт, если он найден.
     * @throws NoSuchElementException Если платежный аккаунт не найден.
     */
    private PaymentAccount getPaymentAccountIfExists(int id) {
        return getPaymentAccountById(id).orElseThrow(() -> new NoSuchElementException("PaymentAccount was not found"));
    }
}