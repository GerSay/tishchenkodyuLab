package tech.reliab.course.tishchenkodyu.bank.entity;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true, includeFieldNames = false)
@AllArgsConstructor
public class Employee extends Entity {
    @ToString.Include(name = "name")
    private String fullName;
    @ToString.Include(name = "birth")
    private LocalDate birthDate;
    private String position;
    private Bank bank;
    private boolean remoteWork;
    private BankOffice bankOffice;
    private boolean canIssueLoans;
    private double salary;
}
