package tech.reliab.course.tishchenkodyu.bank.service;

import java.util.List;
import java.util.Optional;
import tech.reliab.course.tishchenkodyu.bank.entity.Bank;
import tech.reliab.course.tishchenkodyu.bank.entity.PaymentAccount;
import tech.reliab.course.tishchenkodyu.bank.entity.User;

public interface PaymentAccountService {
    /**
     * Создание нового платежного аккаунта.
     *
     * @param user Пользователь, которому принадлежит аккаунт.
     * @param bank Банк, в котором открыт аккаунт.
     * @return Созданный платежный аккаунт.
     */
    PaymentAccount createPaymentAccount(User user, Bank bank);

    /**
     * Чтение платежного аккаунта по его идентификатору.
     *
     * @param id Идентификатор платежного аккаунта.
     * @return Платежный аккаунт, если он найден, иначе - пустой Optional.
     */
    Optional<PaymentAccount> getPaymentAccountById(int id);

    /**
     * Чтение всех платежных аккаунтов.
     *
     * @return Список всех платежных аккаунтов.
     */
    List<PaymentAccount> getAllPaymentAccounts();

    /**
     * Обновление информации о платежном аккаунте по его идентификатору.
     *
     * @param id   Идентификатор платежного аккаунта.
     * @param bank Банк, в котором открыт аккаунт.
     */
    void updatePaymentAccount(int id, Bank bank);

    /**
     * Удаление платежного аккаунта по его идентификатору.
     *
     * @param id Идентификатор платежного аккаунта.
     */
    void deletePaymentAccount(int id);
}