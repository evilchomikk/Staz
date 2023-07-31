package org.example;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import lombok.AllArgsConstructor;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
@AllArgsConstructor
public class CsvGenerator {
    CsvConverter csvConverter;
    public <T> void generateCSV(List<T> list) throws IOException, IllegalAccessException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        csvConverter.generate();
    }
    public <T> List convertCSV(List<T> list) {
        return list;
    }


}
