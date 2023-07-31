package org.example;


import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Main {


    public static void main(String[] args) throws IllegalAccessException, IOException, CsvValidationException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException, CsvConstraintViolationException {

        Lists list = new Lists();
        CsvReader csvReader = new CsvReader();
        CsvConverter sw = new CsvConverter(list.dogList);
       sw.generate();
        sw = new CsvConverter(list.carList);
        sw.generate();
        sw = new CsvConverter(list.underunderdogList);
        sw.generate();
        //System.out.println(csvReader.readCsv());
       System.out.println("hhahhahahah\n");
        System.out.println(csvReader.readCsvBeans());
        DogFromCSV dogFromCSV = new DogFromCSV();
        System.out.println(dogFromCSV.convertToRead(csvReader.readCsvBeans().toString()));

       //BeanReader beanReader = new BeanReader();
        //System.out.println(beanReader.values);
        //System.out.println(Arrays.toString(csvReader.getConstructorData()));

    }
}
