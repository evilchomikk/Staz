package org.example;

import lombok.AllArgsConstructor;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
@AllArgsConstructor
public class CsvGenerator {
    CsvConverter csvConverter;
    public <T> void generateCSV(List<T> list) throws IOException, IllegalAccessException {
        csvConverter.generate();
    }
    public <T> List convertCSV(List<T> list) {
        return list;
    }


}
