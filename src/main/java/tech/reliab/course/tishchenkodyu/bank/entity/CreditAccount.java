package tech.reliab.course.tishchenkodyu.bank.entity;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true, includeFieldNames = false)
public class CreditAccount extends Entity {
    private User user;
    private Bank bank;
    private LocalDate startDate;
    private LocalDate endDate;
    private int loanTermMonths;
    private double loanAmount;
    private double monthlyPayment;
    private double interestRate;
    private Employee employee;
    private PaymentAccount paymentAccount;

    public CreditAccount(User user, Bank bank, LocalDate startDate, int loanTermMonths, double interestRate, Employee employee, PaymentAccount paymentAccount) {
        this.user = user;
        this.bank = bank;
        this.startDate = startDate;
        this.loanTermMonths = loanTermMonths;
        this.interestRate = interestRate;
        this.employee = employee;
        this.paymentAccount = paymentAccount;
    }
}
