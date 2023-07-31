package org.example;

import lombok.AllArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@DBClass
@Setter
public class Underdog extends Dog{
    @DBField(name = "type")
    String type;

    public Underdog(String name, int age, float price, UUID uuid, LocalDate date, String type) {
        super(name, age, price, uuid, date);
        this.type=type;
    }

    public Underdog() {

    }
}
