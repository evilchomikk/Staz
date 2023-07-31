package org.example;

import com.opencsv.bean.AbstractCsvConverter;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;

import java.util.UUID;

public class DogFromCSV extends AbstractCsvConverter {
    @Override
    public Object convertToRead(String s) throws CsvDataTypeMismatchException, CsvConstraintViolationException {
        Underunderdog underunderdog = new Underunderdog();
        String[] split = s.split("\\.", 2);
        underunderdog.setName(split[0]);
        underunderdog.setAge(Integer.parseInt(split[1]));
        underunderdog.setPrice(Float.parseFloat(split[2]));
        underunderdog.setUuid(UUID.fromString(split[3]));
        //underunderdog.setDate();
        underunderdog.setType(split[4]);
        underunderdog.setNumberOfDailyFeasts(Integer.parseInt(split[5]));

xdd
        1) zmien annointy
                2)



        return underunderdog;
    }
}
