package tech.reliab.course.tishchenkodyu.bank.service.impl;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import tech.reliab.course.tishchenkodyu.bank.entity.Bank;
import tech.reliab.course.tishchenkodyu.bank.entity.BankAtm;
import tech.reliab.course.tishchenkodyu.bank.entity.BankAtmStatusEnum;
import tech.reliab.course.tishchenkodyu.bank.entity.BankOffice;
import tech.reliab.course.tishchenkodyu.bank.entity.Employee;
import tech.reliab.course.tishchenkodyu.bank.service.BankAtmService;

import java.util.List;
import tech.reliab.course.tishchenkodyu.bank.service.BankService;

public class BankAtmServiceImpl implements BankAtmService {

    private int bankAtmsCount = 0;

    private List<BankAtm> bankAtms = new ArrayList<>();

    private final BankService bankService;

    public BankAtmServiceImpl(BankService bankService) {
        this.bankService = bankService;
    }

    public BankAtm createBankAtm(String name, String address, Bank bank, BankOffice location, Employee employee,
                                 boolean cashWithdrawal, boolean cashDeposit, double maintenanceCost) {
        BankAtm bankAtm = new BankAtm(name, address, bank, location, employee,
                cashWithdrawal, cashDeposit, maintenanceCost);
        bankAtm.setId(bankAtmsCount++);
        bankAtm.setStatus(generateStatus());
        bankAtm.setAtmMoney(generateAtmMoney(bank));
        bankService.addAtm(bank);
        bankAtms.add(bankAtm);
        return bankAtm;
    }

    /**
     * Генерация случайного статуса банкомата.
     *
     * @return Случайный статус банкомата.
     */
    private BankAtmStatusEnum generateStatus() {
        return BankAtmStatusEnum.randomStatus();
    }

    /**
     * Генерация случайного количества денег в банкомате.
     *
     * @param bank Банк, которому принадлежит банкомат.
     * @return Случайное количество денег в банкомате.
     */
    private double generateAtmMoney(Bank bank) {
        return new Random().nextDouble(bank.getTotalMoney());
    }

    public Optional<BankAtm> getBankAtmById(int id) {
        return bankAtms.stream()
                .filter(bankAtm -> bankAtm.getId() == id)
                .findFirst();
    }

    public List<BankAtm> getAllBankAtms() {
        return new ArrayList<>(bankAtms);
    }

    public List<BankAtm> getAllBankAtmsByBank(Bank bank) {
        return bankAtms.stream()
                .filter(bankAtm -> bankAtm.getBank().getId() == bank.getId())
                .collect(Collectors.toList());
    }

    public void updateBankAtm(int id, String name) {
        BankAtm bankAtm = getBankAtmIfExists(id);
        bankAtm.setName(name);
    }

    public void deleteBankAtm(int id) {
        BankAtm bankAtm = getBankAtmIfExists(id);
        bankAtms.remove(bankAtm);
        Bank bank = bankAtm.getBank();
        bankService.removeAtm(bank);
    }

    /**
     * Получение банкомата по идентификатору, если он существует.
     *
     * @param id Идентификатор банкомата.
     * @return Банкомат, если он найден.
     * @throws RuntimeException Если банкомат не найден.
     */
    private BankAtm getBankAtmIfExists(int id) {
        return getBankAtmById(id).orElseThrow(() -> new NoSuchElementException("BankAtm was not found"));
    }
}
