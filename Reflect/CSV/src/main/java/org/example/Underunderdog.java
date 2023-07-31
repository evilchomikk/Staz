package org.example;

import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;
@DBClass
@Setter
public class Underunderdog extends Underdog{
    @DBField(name = "numberOfDailyFeasts")
    int numberOfDailyFeasts;
    public Underunderdog(String name, int age, float price, UUID uuid, LocalDate date, String type, int numberOfDailyFeasts) {
        super(name, age, price, uuid, date, type);
        this.numberOfDailyFeasts=numberOfDailyFeasts;
    }

    public Underunderdog() {
    }
}
