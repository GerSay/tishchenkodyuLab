package tech.reliab.course.tishchenkodyu.bank.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true, includeFieldNames = false)
public class BankOffice extends Entity {
    private String name;
    private String address;
    private BankOfficeStatusEnum status;
    private boolean canPlaceAtm;
    private int atmCount = 0;
    private boolean canIssueLoan;
    private boolean cashWithdrawal;
    private boolean cashDeposit;
    private double officeMoney;
    private double rentCost;

    public BankOffice(String name, String address, boolean canPlaceAtm, boolean canIssueLoan, boolean cashWithdrawal, boolean cashDeposit, double rentCost) {
        this.name = name;
        this.address = address;
        this.canPlaceAtm = canPlaceAtm;
        this.canIssueLoan = canIssueLoan;
        this.cashWithdrawal = cashWithdrawal;
        this.cashDeposit = cashDeposit;
        this.rentCost = rentCost;
    }
}