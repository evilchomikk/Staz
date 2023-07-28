package org.example;

import lombok.AllArgsConstructor;

import java.lang.annotation.Annotation;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateFormatImpl{

    public LocalDate dateFormat() {
        DateTimeFormatter myFormatObj;
        int day = createRandomIntBetween(1, 28);
        int month = createRandomIntBetween(1, 12);
        int year = createRandomIntBetween(1945, 2023);
        return LocalDate.of(year,month,day);
    }

    public static int createRandomIntBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }
}

