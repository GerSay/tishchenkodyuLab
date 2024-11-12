package tech.reliab.course.tishchenkodyu.bank.service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import tech.reliab.course.tishchenkodyu.bank.entity.Bank;
import tech.reliab.course.tishchenkodyu.bank.entity.BankOffice;
import tech.reliab.course.tishchenkodyu.bank.entity.Employee;

public interface EmployeeService {

    /**
     * Создание нового сотрудника банка.
     *
     * @param fullName     Полное имя сотрудника.
     * @param birthDate    Дата рождения сотрудника.
     * @param position     Должность сотрудника.
     * @param bank         Банк, в котором работает сотрудник.
     * @param remoteWork   Работает ли сотрудник удаленно.
     * @param bankOffice   Офис, в котором работает сотрудник.
     * @param canIssueLoans Может ли сотрудник выдавать кредиты.
     * @param salary       Зарплата сотрудника.
     * @return Созданный сотрудник банка.
     */
    Employee createEmployee(String fullName, LocalDate birthDate, String position, Bank bank, boolean remoteWork,
                            BankOffice bankOffice, boolean canIssueLoans, double salary);

    /**
     * Чтение сотрудника по его идентификатору.
     *
     * @param id Идентификатор сотрудника.
     * @return Сотрудник, если он найден, иначе - пустой Optional.
     */
    Optional<Employee> getEmployeeById(int id);

    /**
     * Чтение всех сотрудников.
     *
     * @return Список всех сотрудников.
     */
    List<Employee> getAllEmployees();

    /**
     * Обновление информации о сотруднике по его идентификатору.
     *
     * @param id   Идентификатор сотрудника.
     * @param name Новое имя сотрудника.
     */
    void updateEmployee(int id, String name);

    /**
     * Удаление сотрудника по его идентификатору.
     *
     * @param id Идентификатор сотрудника.
     */
    void deleteEmployee(int id);

    /**
     * Получение сотрудника по его идентификатору, если он существует.
     *
     * @param id Идентификатор сотрудника.
     * @return Сотрудник, если он найден.
     * @throws NoSuchElementException Если сотрудник не найден.
     */
    Employee getEmployeeIfExists(int id);
}