package tech.reliab.course.tishchenkodyu.bank.entity;

public class BankAtm {
    private int id;
    private String name;
    private String address;
    private String status;
    private Bank bank;
    private BankOffice bankOffice;
    private String serviceEmployee;
    private boolean canGiveCash;
    private boolean canTakeCash;
    private int allCash;
    private int cost;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public BankOffice getBankOffice() {
        return bankOffice;
    }

    public void setBankOffice(BankOffice bankOffice) {
        this.bankOffice = bankOffice;
    }

    public String getServiceEmployee() {
        return serviceEmployee;
    }

    public void setServiceEmployee(String serviceEmployee) {
        this.serviceEmployee = serviceEmployee;
    }

    public boolean isCanGiveCash() {
        return canGiveCash;
    }

    public void setCanGiveCash(boolean canGiveCash) {
        this.canGiveCash = canGiveCash;
    }

    public boolean isCanTakeCash() {
        return canTakeCash;
    }

    public void setCanTakeCash(boolean canTakeCash) {
        this.canTakeCash = canTakeCash;
    }

    public int getAllCash() {
        return allCash;
    }

    public void setAllCash(int allCash) {
        this.allCash = allCash;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
