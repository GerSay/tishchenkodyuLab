package tech.reliab.course.tishchenkodyu.bank.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true, includeFieldNames = false)
public class PaymentAccount extends Entity {
    private User user;
    private Bank bank;
    private double balance = 0;

    public PaymentAccount(User user, Bank bank) {
        this.user = user;
        this.bank = bank;
    }
}