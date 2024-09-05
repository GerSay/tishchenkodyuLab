package tech.reliab.course.tishchenkodyu.bank.entity;

import java.time.Instant;

public class CreditAccount {
    private int id;
    private User user;
    private String bankName;
    private Instant openCredit;
    private Instant closeCredit;
    private int countMonthForCredit;
    private int sumCredit;
    private int monthlyPayment;
    private int interestRate;
    private Employee employee;
    private PaymentAccount paymentAccount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Instant getOpenCredit() {
        return openCredit;
    }

    public void setOpenCredit(Instant openCredit) {
        this.openCredit = openCredit;
    }

    public Instant getCloseCredit() {
        return closeCredit;
    }

    public void setCloseCredit(Instant closeCredit) {
        this.closeCredit = closeCredit;
    }

    public int getCountMonthForCredit() {
        return countMonthForCredit;
    }

    public void setCountMonthForCredit(int countMonthForCredit) {
        this.countMonthForCredit = countMonthForCredit;
    }

    public int getSumCredit() {
        return sumCredit;
    }

    public void setSumCredit(int sumCredit) {
        this.sumCredit = sumCredit;
    }

    public int getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(int monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public int getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(int interestRate) {
        this.interestRate = interestRate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public PaymentAccount getPaymentAccount() {
        return paymentAccount;
    }

    public void setPaymentAccount(PaymentAccount paymentAccount) {
        this.paymentAccount = paymentAccount;
    }
}
