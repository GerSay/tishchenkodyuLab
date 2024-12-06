package tech.reliab.course.tishchenkodyu.bank.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class User extends Entity {
    @ToString.Include(name = "name")
    private String fullName;
    @ToString.Include(name = "birth")
    private LocalDate birthDate;
    private String job;
    private double monthlyIncome;
    private int creditRating;
    @ToString.Exclude
    private List<Bank> banks = new ArrayList<>();
    @ToString.Exclude
    private List<CreditAccount> creditAccounts = new ArrayList<>();
    @ToString.Exclude
    private List<PaymentAccount> paymentAccounts = new ArrayList<>();

    public User(String fullName, LocalDate birthDate, String job) {
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.job = job;
    }
}
