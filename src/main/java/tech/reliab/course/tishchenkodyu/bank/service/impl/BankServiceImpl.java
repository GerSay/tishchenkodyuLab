package tech.reliab.course.tishchenkodyu.bank.service.impl;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Random;
import tech.reliab.course.tishchenkodyu.bank.entity.Bank;
import tech.reliab.course.tishchenkodyu.bank.service.BankService;

import java.util.List;
import tech.reliab.course.tishchenkodyu.bank.service.UserService;

public class BankServiceImpl implements BankService {

    private static final int RATING_BOUND = 101;
    private static final int TOTAL_MONEY_BOUND = 1000001;
    private static final int MAX_RATE = 20;
    private static final double DIVIDER = 10.0;
    private int banksCount = 0;

    private final UserService userService;

    private List<Bank> banks = new ArrayList<>();

    public BankServiceImpl(UserService userService) {
        this.userService = userService;
    }

    public Bank createBank(String bankName) {
        Bank bank = new Bank(bankName);
        bank.setId(banksCount++);
        bank.setRating(generateRating());
        bank.setTotalMoney(generateTotalMoney());
        bank.setInterestRate(calculateInterestRate(bank.getRating()));
        banks.add(bank);
        return bank;
    }

    /**
     * Генерация случайного рейтинга банка.
     *
     * @return Случайный рейтинг банка.
     */
    private int generateRating() {
        return new Random().nextInt(RATING_BOUND);
    }

    /**
     * Генерация случайного количества денег в банке.
     *
     * @return Случайное количество денег в банке.
     */
    private double generateTotalMoney() {
        return new Random().nextInt(TOTAL_MONEY_BOUND);
    }

    /**
     * Вычисление процентной ставки по кредитам.
     *
     * @param rating Рейтинг банка.
     * @return Процентная ставка.
     */
    private double calculateInterestRate(int rating) {
        return MAX_RATE - (rating / DIVIDER);
    }

    public Optional<Bank> getBankById(int id) {
        return banks.stream()
                .filter(bank -> bank.getId() == id)
                .findFirst();
    }

    public List<Bank> getAllBanks() {
        return new ArrayList<>(banks);
    }

    public void updateBank(int id, String name) {
        Bank bank = getBankIfExists(id);
        bank.setName(name);
    }

    public void deleteBank(int id) {
        Bank bank = getBankIfExists(id);
        banks.remove(bank);
        userService.deleteBank(bank);
    }


    public Bank getBankIfExists(int id) {
        return getBankById(id).orElseThrow(() -> new NoSuchElementException("Bank was not found"));
    }

    public void addOffice(Bank bank) {
        bank.setOfficeCount(bank.getOfficeCount() + 1);
    }

    public void addAtm(Bank bank) {
        bank.setAtmCount(bank.getAtmCount() + 1);
    }

    public void addEmployee(Bank bank) {
        bank.setEmployeeCount(bank.getEmployeeCount() + 1);
    }

    public void addClient(Bank bank) {
        bank.setClientCount(bank.getClientCount() + 1);
    }

    public void removeOffice(Bank bank) {
        bank.setOfficeCount(bank.getOfficeCount() - 1);
    }

    public void removeAtm(Bank bank) {
        bank.setAtmCount(bank.getAtmCount() - 1);
    }

    public void removeEmployee(Bank bank) {
        bank.setEmployeeCount(bank.getEmployeeCount() - 1);
    }

    public void removeClient(Bank bank) {
        bank.setClientCount(bank.getClientCount() - 1);
    }
}