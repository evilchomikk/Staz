package org.example;

import com.opencsv.CSVReaderHeaderAware;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class BeanReader {
    @CsvBindByName(column = "name")
    private String name;
    @CsvBindByName(column = "age")
    private int age;
    @CsvBindByName(column = "price")
    private float price;
    @CsvBindByName(column = "uuid")
    private UUID uuid;
    @CsvBindByName(column = "date")
    private LocalDate date;
    @CsvBindByName(column = "type")
    private String type;
    @CsvBindByName(column = "numberOfDailyFeasts")
    private int numberOfDailyFeasts;

    Map<String, String> values = new CSVReaderHeaderAware(new FileReader("C:\\Users\\mmazurek\\Desktop\\pliki\\data-new.csv")).readMap();

    public BeanReader() throws CsvValidationException, IOException {
    }
}
