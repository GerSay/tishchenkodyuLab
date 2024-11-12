package tech.reliab.course.tishchenkodyu.bank.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import tech.reliab.course.tishchenkodyu.bank.entity.Bank;
import tech.reliab.course.tishchenkodyu.bank.entity.CreditAccount;
import tech.reliab.course.tishchenkodyu.bank.entity.Employee;
import tech.reliab.course.tishchenkodyu.bank.entity.PaymentAccount;
import tech.reliab.course.tishchenkodyu.bank.entity.User;

public interface CreditAccountService {

    /**
     * Создание нового кредитного аккаунта.
     *
     * @param user              Пользователь, которому принадлежит аккаунт.
     * @param bank              Банк, который предоставляет кредит.
     * @param startDate         Дата начала кредита.
     * @param loanTermMonths    Срок кредита в месяцах.
     * @param loanAmount        Сумма кредита.
     * @param interestRate      Процентная ставка по кредиту.
     * @param employee          Сотрудник, который выдал кредит.
     * @param paymentAccount    Платежный аккаунт пользователя.
     * @return Созданный кредитный аккаунт.
     */
    CreditAccount createCreditAccount(User user, Bank bank, LocalDate startDate, int loanTermMonths,
                                      double loanAmount, double interestRate, Employee employee,
                                      PaymentAccount paymentAccount);

    /**
     * Чтение кредитного аккаунта по его идентификатору.
     *
     * @param id Идентификатор кредитного аккаунта.
     * @return Кредитный аккаунт, если он найден, иначе - пустой Optional.
     */
    Optional<CreditAccount> getCreditAccountById(int id);

    /**
     * Чтение всех кредитных аккаунтов.
     *
     * @return Список всех кредитных аккаунтов.
     */
    List<CreditAccount> getAllCreditAccounts();

    /**
     * Обновление информации о кредитном аккаунте по его идентификатору.
     *
     * @param id   Идентификатор кредитного аккаунта.
     * @param bank Банк, который предоставляет кредит.
     */
    void updateCreditAccount(int id, Bank bank);

    /**
     * Удаление кредитного аккаунта по его идентификатору и идентификатору пользователя.
     *
     * @param accountId Идентификатор кредитного аккаунта.
     * @param userId     Идентификатор пользователя, которому принадлежит аккаунт.
     */
    void deleteCreditAccount(int accountId, int userId);
}