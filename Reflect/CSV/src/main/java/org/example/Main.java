package org.example;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Main {


    public static void main(String[] args) throws IllegalAccessException, IOException {

        Lists list = new Lists();
        CsvConverter sw = new CsvConverter(list.dogList);
       sw.generate();
        sw = new CsvConverter(list.carList);
        sw.generate();

    }
}
