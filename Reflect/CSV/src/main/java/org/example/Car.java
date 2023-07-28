package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.Locale;
import java.util.UUID;
@AllArgsConstructor
@Data
public class Car {
        @DBField(name = "mark")
        String mark;
        @DBField(name = "cost")
        float price;
        @DBField(name = "color")
        String color;
        @DBField(name = "id")
        UUID uuid;
        @DBField(name = "name")
        @DateFormat(dateFormat = "yyyy-MM-dd")
        LocalDate date;

}
