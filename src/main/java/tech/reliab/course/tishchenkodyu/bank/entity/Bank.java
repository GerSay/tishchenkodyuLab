package tech.reliab.course.tishchenkodyu.bank.entity;

import tech.reliab.course.tishchenkodyu.bank.utils.RandomValueUtil;

public class Bank {
    private static final int MIN_RATING = 0;
    private static final int MAX_RATING = 100;
    private static final int MIN_ALL_CASH = 0;
    private static final int MAX_ALL_CASH = 1000000;
    private static final int MAX_INTEREST_RATE = 20;
    private static final int MIN_INTEREST_RATE = 0;
    private static final int BANK_RATING_DIVISOR = 10;

    private int id;
    private String name;
    private int countOffice;
    private int countBankAtm;
    private int countEmployee;
    private int countClient;
    private int bankRating;
    private int allCash;
    private int interestRate;

    Bank(RandomValueUtil randomValueUtil) {
        this.countOffice = 0;
        this.countBankAtm = 0;
        this.countEmployee = 0;
        this.countClient = 0;
        this.bankRating = randomValueUtil.getRandomIntInRange(MIN_RATING, MAX_RATING);
        this.allCash = randomValueUtil.getRandomIntInRange(MIN_ALL_CASH, MAX_ALL_CASH);
        this.interestRate = Math.max(MIN_INTEREST_RATE,
                randomValueUtil.getRandomIntInRange(MIN_INTEREST_RATE, MAX_INTEREST_RATE) -
                        Math.floorDiv(this.bankRating, BANK_RATING_DIVISOR));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountOffice() {
        return countOffice;
    }

    public void setCountOffice(int countOffice) {
        this.countOffice = countOffice;
    }

    public int getCountBankAtm() {
        return countBankAtm;
    }

    public void setCountBankAtm(int countBankAtm) {
        this.countBankAtm = countBankAtm;
    }

    public int getCountEmployee() {
        return countEmployee;
    }

    public void setCountEmployee(int countEmployee) {
        this.countEmployee = countEmployee;
    }

    public int getCountClient() {
        return countClient;
    }

    public void setCountClient(int countClient) {
        this.countClient = countClient;
    }

    public int getBankRating() {
        return bankRating;
    }

    public void setBankRating(int bankRating) {
        this.bankRating = bankRating;
    }

    public int getAllCash() {
        return allCash;
    }

    public void setAllCash(int allCash) {
        this.allCash = allCash;
    }

    public int getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(int interestRate) {
        this.interestRate = interestRate;
    }

    public void addCountOffice(int count) {
        this.countOffice += count;
    }
}
