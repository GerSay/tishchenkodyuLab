package tech.reliab.course.tishchenkodyu.bank.entity;

public class Bank extends Entity {

    private String name;
    private int officeCount = 0;
    private int atmCount = 0;
    private int employeeCount = 0;
    private int clientCount = 0;
    private int rating;
    private double totalMoney;
    private double interestRate;

    public Bank(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getOfficeCount() {
        return officeCount;
    }

    public int getAtmCount() {
        return atmCount;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public int getClientCount() {
        return clientCount;
    }

    public int getRating() {
        return rating;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOfficeCount(int officeCount) {
        this.officeCount = officeCount;
    }

    public void setAtmCount(int atmCount) {
        this.atmCount = atmCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    public void setClientCount(int clientCount) {
        this.clientCount = clientCount;
    }

    @Override
    public String toString() {
        return "Bank{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", officeCount=" + officeCount +
               ", atmCount=" + atmCount +
               ", employeeCount=" + employeeCount +
               ", clientCount=" + clientCount +
               ", rating=" + rating +
               ", totalMoney=" + totalMoney +
               ", interestRate=" + interestRate +
               '}';
    }
}