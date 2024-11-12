package tech.reliab.course.tishchenkodyu.bank.service;

import java.util.List;
import java.util.Optional;
import tech.reliab.course.tishchenkodyu.bank.entity.Bank;
import tech.reliab.course.tishchenkodyu.bank.entity.BankAtm;
import tech.reliab.course.tishchenkodyu.bank.entity.BankOffice;
import tech.reliab.course.tishchenkodyu.bank.entity.Employee;

public interface BankAtmService {
    /**
     * Создание нового банкомата.
     *
     * @param name           Название банкомата.
     * @param address        Адрес банкомата.
     * @param bank           Банк, которому принадлежит банкомат.
     * @param location       Офис банка, где расположен банкомат.
     * @param employee       Сотрудник, ответственный за банкомат.
     * @param cashWithdrawal Возможность снятия наличных.
     * @param cashDeposit    Возможность пополнения счета.
     * @param maintenanceCost Стоимость обслуживания банкомата.
     * @return Созданный банкомат.
     */
    BankAtm createBankAtm(String name, String address, Bank bank, BankOffice location, Employee employee,
                          boolean cashWithdrawal, boolean cashDeposit, double maintenanceCost);

    /**
     * Чтение банкомата по его идентификатору.
     *
     * @param id Идентификатор банкомата.
     * @return Банкомат, если он найден, иначе - пустой Optional.
     */
    Optional<BankAtm> getBankAtmById(int id);

    /**
     * Чтение всех банкоматов.
     *
     * @return Список всех банкоматов.
     */
    List<BankAtm> getAllBankAtms();

    /**
     * Чтение всех банкоматов определенного банка.
     *
     * @param bank Банк, для которого нужно получить банкоматы.
     * @return Список банкоматов, принадлежащих указанному банку.
     */
    List<BankAtm> getAllBankAtmsByBank(Bank bank);

    /**
     * Обновление информации о банкомате по его идентификатору.
     *
     * @param id   Идентификатор банкомата.
     * @param name Новое название банкомата.
     */
    void updateBankAtm(int id, String name);

    /**
     * Удаление банкомата по его идентификатору.
     *
     * @param id Идентификатор банкомата.
     */
    void deleteBankAtm(int id);
}