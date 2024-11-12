package tech.reliab.course.tishchenkodyu.bank;

import java.time.LocalDate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tech.reliab.course.tishchenkodyu.bank.entity.Bank;
import tech.reliab.course.tishchenkodyu.bank.entity.BankAtm;
import tech.reliab.course.tishchenkodyu.bank.entity.BankOffice;
import tech.reliab.course.tishchenkodyu.bank.entity.CreditAccount;
import tech.reliab.course.tishchenkodyu.bank.entity.Employee;
import tech.reliab.course.tishchenkodyu.bank.entity.PaymentAccount;
import tech.reliab.course.tishchenkodyu.bank.entity.User;
import tech.reliab.course.tishchenkodyu.bank.service.BankAtmService;
import tech.reliab.course.tishchenkodyu.bank.service.BankOfficeService;
import tech.reliab.course.tishchenkodyu.bank.service.BankService;
import tech.reliab.course.tishchenkodyu.bank.service.CreditAccountService;
import tech.reliab.course.tishchenkodyu.bank.service.EmployeeService;
import tech.reliab.course.tishchenkodyu.bank.service.PaymentAccountService;
import tech.reliab.course.tishchenkodyu.bank.service.UserService;
import tech.reliab.course.tishchenkodyu.bank.service.impl.BankAtmServiceImpl;
import tech.reliab.course.tishchenkodyu.bank.service.impl.BankOfficeServiceImpl;
import tech.reliab.course.tishchenkodyu.bank.service.impl.BankServiceImpl;
import tech.reliab.course.tishchenkodyu.bank.service.impl.CreditAccountServiceImpl;
import tech.reliab.course.tishchenkodyu.bank.service.impl.EmployeeServiceImpl;
import tech.reliab.course.tishchenkodyu.bank.service.impl.PaymentAccountServiceImpl;
import tech.reliab.course.tishchenkodyu.bank.service.impl.UserServiceImpl;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

        UserService userService = new UserServiceImpl();
        User user = userService.createUser("Смирнова Елена Анатольевна", LocalDate.now(), "Программист");

        BankService bankService = new BankServiceImpl(userService);
        Bank bank = bankService.createBank("T-банк");

        BankOfficeService bankOfficeService = new BankOfficeServiceImpl(bankService);
        BankOffice bankOffice = bankOfficeService.createBankOffice("Офис", "Костюкова, 36", true, true,
                true, true, 500, bank);

        EmployeeService employeeService = new EmployeeServiceImpl(bankService);
        Employee employee = employeeService.createEmployee("Иванова Ирина Григорьевна", LocalDate.now(),
                "Кассир", bank, false, bankOffice, true, 30000);

        BankAtmService bankAtmService = new BankAtmServiceImpl(bankService);
        BankAtm bankAtm = bankAtmService.createBankAtm("Банкомат", "Костюкова, 36", bank, bankOffice, employee,
                true, true, 500);

        PaymentAccountService paymentAccountService = new PaymentAccountServiceImpl(userService, bankService);
        PaymentAccount paymentAccount = paymentAccountService.createPaymentAccount(user, bank);

        CreditAccountService creditAccountService = new CreditAccountServiceImpl(userService, bankService);
        CreditAccount creditAccount = creditAccountService.createCreditAccount(user, bank, LocalDate.now(), 8,
                500000, 14, employee, paymentAccount);

        System.out.println(bank);
        System.out.println(user);
        System.out.println(bankOffice);
        System.out.println(employee);
        System.out.println(bankAtm);
        System.out.println(paymentAccount);
        System.out.println(creditAccount);
    }}
