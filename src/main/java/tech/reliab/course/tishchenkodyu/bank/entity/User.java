package tech.reliab.course.tishchenkodyu.bank.entity;

import java.util.Collection;
import java.util.Date;

public class User {
    private int id;
    private String fio;
    private Date dateOfBirth;
    private String workPlace;
    private int monthlyIncome;
    private String banksUsing;
    private Collection<Bank> banks;
    private Collection<CreditAccount> creditAccounts;
    private Collection<PaymentAccount> paymentAccounts;
    private int creditRating;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public int getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(int monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public String getBanksUsing() {
        return banksUsing;
    }

    public void setBanksUsing(String banksUsing) {
        this.banksUsing = banksUsing;
    }

    public Collection<Bank> getBanks() {
        return banks;
    }

    public void setBanks(Collection<Bank> banks) {
        this.banks = banks;
    }

    public Collection<CreditAccount> getCreditAccounts() {
        return creditAccounts;
    }

    public void setCreditAccounts(Collection<CreditAccount> creditAccounts) {
        this.creditAccounts = creditAccounts;
    }

    public Collection<PaymentAccount> getPaymentAccounts() {
        return paymentAccounts;
    }

    public void setPaymentAccounts(Collection<PaymentAccount> paymentAccounts) {
        this.paymentAccounts = paymentAccounts;
    }

    public int getCreditRating() {
        return creditRating;
    }

    public void setCreditRating(int creditRating) {
        this.creditRating = creditRating;
    }
}
