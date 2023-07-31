package org.example;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
@Setter
@Getter
@ToString
public class CsvReader {
    private static final String COMMA_DELIMITER = ",";

    @CsvBindByName(column = "name")
    String name;
    @CsvBindByName(column = "age")
    int age;
    @CsvBindByName(column = "price")
    float price;
    @CsvBindByName(column = "id")
    UUID uuid;
    @CsvBindByName(column = "date")
    LocalDate date;
    @CsvBindByName(column = "type")
    String type;
    @CsvBindByName(column = "numberOfDailyFeasts")
    int numberOfDailyFeasts;

    public List readCsvBeans() throws FileNotFoundException {
        List beans = new CsvToBeanBuilder(new FileReader("C:\\Users\\mmazurek\\Desktop\\pliki\\data-new.csv"))
                .withType(CsvReader.class).build().parse();
        return beans;
    }

}

