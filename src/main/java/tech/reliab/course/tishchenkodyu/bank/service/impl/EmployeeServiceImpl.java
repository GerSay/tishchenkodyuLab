package tech.reliab.course.tishchenkodyu.bank.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import tech.reliab.course.tishchenkodyu.bank.entity.Bank;
import tech.reliab.course.tishchenkodyu.bank.entity.BankOffice;
import tech.reliab.course.tishchenkodyu.bank.entity.Employee;
import tech.reliab.course.tishchenkodyu.bank.service.BankService;
import tech.reliab.course.tishchenkodyu.bank.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

    private static int employeesCount = 0;

    private final BankService bankService;

    private List<Employee> employees = new ArrayList<>();

    public EmployeeServiceImpl(BankService bankService) {
        this.bankService = bankService;
    }

    public Employee createEmployee(String fullName, LocalDate birthDate, String position, Bank bank, boolean remoteWork,
                                   BankOffice bankOffice, boolean canIssueLoans, double salary) {
        Employee employee = new Employee(fullName, birthDate, position, bank, remoteWork,
                bankOffice, canIssueLoans, salary);
        employee.setId(employeesCount++);
        employees.add(employee);
        bankService.addEmployee(bank);
        return employee;
    }

    public Optional<Employee> getEmployeeById(int id) {
        return employees.stream()
                .filter(employee -> employee.getId() == id)
                .findFirst();
    }

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees);
    }

    public void updateEmployee(int id, String name) {
        Employee employee = getEmployeeIfExists(id);
        employee.setFullName(name);
    }

    public void deleteEmployee(int id) {
        employees.remove(getEmployeeIfExists(id));
    }

    public Employee getEmployeeIfExists(int id) {
        return getEmployeeById(id).orElseThrow(() -> new NoSuchElementException("Employee was not found"));
    }
}