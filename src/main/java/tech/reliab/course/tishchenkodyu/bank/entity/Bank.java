package tech.reliab.course.tishchenkodyu.bank.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true, includeFieldNames = false)
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
}