package tech.reliab.course.tishchenkodyu.bank.entity;

import java.time.LocalDate;

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

    public Bank getBank() {
        return bank;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    @Override
    public String toString() {
        return "CreditAccount{" +
               "id=" + id +
               ", user=" + user.getFullName() +
               ", bank=" + bank.getName() +
               ", startDate=" + startDate +
               ", endDate=" + endDate +
               ", loanTermMonths=" + loanTermMonths +
               ", loanAmount=" + loanAmount +
               ", monthlyPayment=" + monthlyPayment +
               ", interestRate=" + interestRate +
               ", employee=" + (employee != null ? employee.getFullName() : "None") +
               ", paymentAccountId=" + (paymentAccount != null ? paymentAccount.getId() : "None") +
               '}';
    }
}
