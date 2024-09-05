package tech.reliab.course.tishchenkodyu.bank.entity;

public class BankOffice {
    private int id;
    private String name;
    private String address;
    private boolean isWork;
    private boolean canPlaceBankAtm;
    private boolean canGiveCash;
    private boolean canTakeCash;
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

    public boolean isWork() {
        return isWork;
    }

    public void setWork(boolean work) {
        isWork = work;
    }

    public boolean isCanPlaceBankAtm() {
        return canPlaceBankAtm;
    }

    public void setCanPlaceBankAtm(boolean canPlaceBankAtm) {
        this.canPlaceBankAtm = canPlaceBankAtm;
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

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
