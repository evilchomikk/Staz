package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@Data
@DBClass
@NoArgsConstructor
public class Dog {
    @DBField(name="name")
    String name;
    @DBField(name = "age")
    int age;
    @DBField(name = "price")
    float price;
    @DBField(name = "id")
    UUID uuid;
   // @DateFormat(dateFormat = "yyyy-MM-dd")
    //@DBField(name="date")
    LocalDate date;
}
/*
        if (dateFormat.equals("yyyy-MM-dd"))
        myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        else if (dateFormat.equals("dd/MM/yyyy"))
        myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        else if (dateFormat.equals("dd-MMM-yyyy"))
        myFormatObj = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        else
        myFormatObj = DateTimeFormatter.ofPattern("E MMM dd yyyy");
        fieldValue = myFormatObj.format((TemporalAccessor) fieldValue);*/