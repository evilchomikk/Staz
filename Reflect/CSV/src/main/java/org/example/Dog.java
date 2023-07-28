package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@Data
@DBClass
public class Dog {
    @DBField(name="name")
    String name;
    @DBField(name = "age")
    int age;
    @DBField(name = "price")
    float price;
    //@DBField(name = "id")
    UUID uuid;
    @DateFormat(dateFormat = "dd/MM/yyyy")
    @DBField(name="date")
    LocalDate date;
}
