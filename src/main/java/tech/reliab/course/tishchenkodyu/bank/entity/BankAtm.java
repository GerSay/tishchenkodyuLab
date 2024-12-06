package tech.reliab.course.tishchenkodyu.bank.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true, includeFieldNames = false)
public class BankAtm extends Entity {
    private String name;
    private String address;
    private BankAtmStatusEnum status;
    private Bank bank;
    private BankOffice location;
    private Employee employee;
    private boolean cashWithdrawal;
    private boolean cashDeposit;
    private double atmMoney;
    private double maintenanceCost;

    public BankAtm(String name, String address, Bank bank, BankOffice location, Employee employee, boolean cashWithdrawal, boolean cashDeposit, double maintenanceCost) {
        this.name = name;
        this.address = address;
        this.bank = bank;
        this.location = location;
        this.employee = employee;
        this.cashWithdrawal = cashWithdrawal;
        this.cashDeposit = cashDeposit;
        this.maintenanceCost = maintenanceCost;
    }
}
