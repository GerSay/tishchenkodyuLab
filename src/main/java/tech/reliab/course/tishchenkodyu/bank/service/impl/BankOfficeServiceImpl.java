package tech.reliab.course.tishchenkodyu.bank.service.impl;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import tech.reliab.course.tishchenkodyu.bank.entity.Bank;
import tech.reliab.course.tishchenkodyu.bank.entity.BankOffice;
import tech.reliab.course.tishchenkodyu.bank.entity.BankOfficeStatusEnum;
import tech.reliab.course.tishchenkodyu.bank.service.BankOfficeService;

import java.util.List;
import tech.reliab.course.tishchenkodyu.bank.service.BankService;

@RequiredArgsConstructor
public class BankOfficeServiceImpl implements BankOfficeService {
    private int bankOfficesCount = 0;
    private List<BankOffice> bankOffices = new ArrayList<>();
    private final BankService bankService;

    public BankOffice createBankOffice(String name, String address, boolean canPlaceAtm,
                                       boolean canIssueLoan, boolean cashWithdrawal, boolean cashDeposit,
                                       double rentCost, Bank bank) {
        BankOffice bankOffice = new BankOffice(name, address, canPlaceAtm, canIssueLoan,
                cashWithdrawal, cashDeposit, rentCost);
        bankOffice.setId(bankOfficesCount++);
        bankOffice.setStatus(generateStatus());
        bankOffice.setOfficeMoney(generateOfficeMoney(bank));
        bankOffices.add(bankOffice);
        bankService.addOffice(bank);
        return bankOffice;
    }

    /**
     * Генерация случайного статуса офиса банка.
     *
     * @return Случайный статус офиса банка.
     */
    private BankOfficeStatusEnum generateStatus() {
        return BankOfficeStatusEnum.randomStatus();
    }

    /**
     * Генерация случайного количества денег в офисе банка.
     *
     * @param bank Банк, которому принадлежит офис.
     * @return Случайное количество денег в офисе банка.
     */
    private double generateOfficeMoney(Bank bank) {
        return new Random().nextDouble(bank.getTotalMoney());
    }

    public Optional<BankOffice> getBankOfficeById(int id) {
        return bankOffices.stream()
                .filter(bankOffice -> bankOffice.getId() == id)
                .findFirst();
    }

    public List<BankOffice> getAllBankOffices() {
        return new ArrayList<>(bankOffices);
    }

    public void updateBankOffice(int id, String name) {
        BankOffice bankOffice = getBankOfficeIfExists(id);
        bankOffice.setName(name);
    }

    public void deleteBankAtm(int officeId, int bankId) {
        BankOffice bankOffice = getBankOfficeIfExists(officeId);
        bankOffices.remove(bankOffice);
        Bank bank = bankService.getBankIfExists(bankId);
        bankService.removeOffice(bank);
    }

    /**
     * Получение офиса банка по его идентификатору, если он существует.
     *
     * @param id Идентификатор офиса банка.
     * @return Офис банка, если он найден.
     * @throws NoSuchElementException Если офис банка не найден.
     */
    private BankOffice getBankOfficeIfExists(int id) {
        return getBankOfficeById(id).orElseThrow(() -> new NoSuchElementException("BankOffice was not found"));
    }
}
