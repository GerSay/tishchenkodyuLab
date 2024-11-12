package tech.reliab.course.tishchenkodyu.bank.service;

import java.util.NoSuchElementException;
import java.util.Optional;
import tech.reliab.course.tishchenkodyu.bank.entity.Bank;

import java.util.List;

public interface BankService {

    /**
     * Создание нового банка.
     *
     * @param bankName Название банка.
     * @return Созданный банк.
     */
    Bank createBank(String bankName);

    /**
     * Чтение банка по его идентификатору.
     *
     * @param id Идентификатор банка.
     * @return Банк, если он найден, иначе - пустой Optional.
     */
    Optional<Bank> getBankById(int id);

    /**
     * Чтение всех банков.
     *
     * @return Список всех банков.
     */
    List<Bank> getAllBanks();

    /**
     * Обновление информации о банке по его идентификатору.
     *
     * @param id   Идентификатор банка.
     * @param name Новое название банка.
     */
    void updateBank(int id, String name);

    /**
     * Удаление банка по его идентификатору.
     *
     * @param id Идентификатор банка.
     */
    void deleteBank(int id);

    /**
     * Увеличение количества офисов в банке.
     *
     * @param bank Банк, для которого нужно увеличить количество офисов.
     */
    void addOffice(Bank bank);

    /**
     * Увеличение количества банкоматов в банке.
     *
     * @param bank Банк, для которого нужно увеличить количество банкоматов.
     */
    void addAtm(Bank bank);

    /**
     * Увеличение количества сотрудников в банке.
     *
     * @param bank Банк, для которого нужно увеличить количество сотрудников.
     */
    void addEmployee(Bank bank);

    /**
     * Увеличение количества клиентов в банке.
     *
     * @param bank Банк, для которого нужно увеличить количество клиентов.
     */
    void addClient(Bank bank);

    /**
     * Уменьшение количества офисов в банке.
     *
     * @param bank Банк, для которого нужно уменьшить количество офисов.
     */
    void removeOffice(Bank bank);

    /**
     * Уменьшение количества банкоматов в банке.
     *
     * @param bank Банк, для которого нужно уменьшить количество банкоматов.
     */
    void removeAtm(Bank bank);

    /**
     * Уменьшение количества сотрудников в банке.
     *
     * @param bank Банк, для которого нужно уменьшить количество сотрудников.
     */
    void removeEmployee(Bank bank);

    /**
     * Уменьшение количества клиентов в банке.
     *
     * @param bank Банк, для которого нужно уменьшить количество клиентов.
     */
    void removeClient(Bank bank);

    /**
     * Получение банка по идентификатору, если он существует.
     *
     * @param id Идентификатор банка.
     * @return Банк, если он найден.
     * @throws NoSuchElementException Если банк не найден.
     */
    Bank getBankIfExists(int id);
}
