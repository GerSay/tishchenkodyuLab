package tech.reliab.course.tishchenkodyu.bank.service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import tech.reliab.course.tishchenkodyu.bank.entity.Bank;
import tech.reliab.course.tishchenkodyu.bank.entity.CreditAccount;
import tech.reliab.course.tishchenkodyu.bank.entity.PaymentAccount;
import tech.reliab.course.tishchenkodyu.bank.entity.User;

public interface UserService {
    /**
     * Создание нового пользователя.
     *
     * @param fullName   Полное имя пользователя.
     * @param birthDate Дата рождения пользователя.
     * @param job        Профессия пользователя.
     * @return Созданный пользователь.
     */
    User createUser(String fullName, LocalDate birthDate, String job);

    /**
     * Чтение пользователя по его идентификатору.
     *
     * @param id Идентификатор пользователя.
     * @return Пользователь, если он найден, иначе - пустой Optional.
     */
    Optional<User> getUserById(int id);

    /**
     * Чтение всех пользователей.
     *
     * @return Список всех пользователей.
     */
    List<User> getAllUsers();

    /**
     * Обновление информации о пользователе по его идентификатору.
     *
     * @param id   Идентификатор пользователя.
     * @param name Новое имя пользователя.
     */
    void updateUser(int id, String name);

    /**
     * Удаление пользователя по его идентификатору.
     *
     * @param id Идентификатор пользователя.
     */
    void deleteUser(int id);

    /**
     * Получение пользователя по его идентификатору, если он существует.
     *
     * @param id Идентификатор пользователя.
     * @return Пользователь, если он найден.
     * @throws NoSuchElementException Если пользователь не найден.
     */
    User getUserIfExists(int id);

    /**
     * Добавление кредитного аккаунта пользователю.
     *
     * @param creditAccount Кредитный аккаунт.
     * @param user         Пользователь, которому принадлежит аккаунт.
     */
    void addCreditAccount(CreditAccount creditAccount, User user);

    /**
     * Добавление платежного аккаунта пользователю.
     *
     * @param paymentAccount Платежный аккаунт.
     * @param user           Пользователь, которому принадлежит аккаунт.
     */
    void addPaymentAccount(PaymentAccount paymentAccount, User user);

    /**
     * Добавление банка к списку банков пользователя.
     *
     * @param bank Банк.
     * @param user Пользователь, которому добавляется банк.
     */
    void addBank(Bank bank, User user);

    /**
     * Удаление кредитного аккаунта у пользователя.
     *
     * @param creditAccount Кредитный аккаунт.
     * @param user         Пользователь, у которого удаляется аккаунт.
     */
    void deleteCreditAccount(CreditAccount creditAccount, User user);

    /**
     * Удаление платежного аккаунта у пользователя.
     *
     * @param paymentAccount Платежный аккаунт.
     * @param user           Пользователь, у которого удаляется аккаунт.
     */
    void deletePaymentAccount(PaymentAccount paymentAccount, User user);

    /**
     * Удаление банка из списка банков пользователей.
     *
     * @param bank Банк, который нужно удалить.
     */
    void deleteBank(Bank bank);
}