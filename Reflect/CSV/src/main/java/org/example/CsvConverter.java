package org.example;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class CsvConverter{
    CsvData<Object> csvData;

    public CsvConverter(List list)  {
        this.csvData = new CsvData<>(list);
    }

    public void generate() throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {

        URL fileUrl = CsvConverter.class.getClassLoader().getResource("C:\\Users\\mmazurek\\Desktop\\pliki\\data.csv");

        //CSVWriter writer2 = new CSVWriter(new FileWriter("C:\\Users\\mmazurek\\Desktop\\pliki\\data-new.csv"));
        CSVWriter writer2 = new CSVWriter(new FileWriter("C:\\Users\\mmazurek\\Desktop\\pliki\\data-new.csv"), ',',
                CSVWriter.NO_QUOTE_CHARACTER,
                CSVWriter.NO_ESCAPE_CHARACTER,
                CSVWriter.DEFAULT_LINE_END);
        StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer2).build();
        // feed in your array (or convert your data to an array)
        StringBuilder entries = new StringBuilder();



        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\mmazurek\\Desktop\\pliki\\data.csv"));
        List<Field> csvFields = new ArrayList<>();
        List<Field> classFields = List.of(csvData.getList().get(0).getClass().getDeclaredFields());
        List headers = new ArrayList<>();
        csvFields.addAll(classFields);
        List<Field> superclassFields = null;
        Class superclass = csvData.getList().get(0).getClass().getSuperclass();
        while(superclass!=Object.class){
         superclassFields = List.of(superclass.getDeclaredFields());
            csvFields.addAll(superclassFields);
        superclass=superclass.getSuperclass();
        }
        //String[] entries = new String[]{String.format(csvFields.stream().filter(field -> Boolean.parseBoolean(field.getName())).toString())};
        //writer2.writeNext(new String[]{String.format(csvFields.stream().filter(field -> Boolean.parseBoolean(field.getName())).toString())});

        csvFields.forEach(field -> {
            StringBuilder stringBuilder = new StringBuilder();
            DBField dbField = field.getAnnotation(DBField.class);
            if(csvData.getList().get(0).getClass().isAnnotationPresent(DBClass.class)) {

                if(dbField !=null)
                {
                    try {
                        System.out.print(dbField.name() + ',');
                        writer.write(dbField.name() + ',');
                       // headers.add(dbField.name());
                        entries.append(dbField.name()).append(',');
                         //writer2.writeNext(entriesx);
                        //entries.insert(6,dbField.name());
                       
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            else
                try {
                    System.out.print(field.getName() + ',');
                    writer.write(field.getName() + ',');
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
        });
        if(entries.length()>1)
            entries.setLength(entries.length()-1);
        writer2.writeNext(new String[]{String.valueOf(entries)});
        System.out.println();
        writer.newLine();
        beanToCsv.write(headers);
        csvData.getList().forEach(obj -> {
            StringBuilder stringBuilder = new StringBuilder();
            for (Field field : csvFields) {

                Object fieldValue = null;
                try {
                    field.setAccessible(true);
                    if(field.isAnnotationPresent(DBField.class)) {
                        fieldValue = field.get(obj);

                        if (field.isAnnotationPresent(DateFormat.class)) {
                            String dateFormat = field.getAnnotation(DateFormat.class).dateFormat();
                            DateTimeFormatter myFormatObj;


                            if (dateFormat.equals("yyyy-MM-dd"))
                                myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                            else if (dateFormat.equals("dd/MM/yyyy"))
                                myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            else if (dateFormat.equals("dd-MMM-yyyy"))
                                myFormatObj = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
                            else
                                myFormatObj = DateTimeFormatter.ofPattern("E MMM dd yyyy");
                            fieldValue = myFormatObj.format((TemporalAccessor) fieldValue);


                        }
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
                    if(field.isAnnotationPresent(DBField.class))
                        stringBuilder.append(fieldValue).append(",");
                   // else
                        //stringBuilder.append(",");

            }
            if (stringBuilder.length() > 1) {
                stringBuilder.setLength(stringBuilder.length() - 1);
            }
            try {
                System.out.println(stringBuilder);
                writer.write(String.valueOf(stringBuilder));
                String[] entriess = new String[]{String.format(String.valueOf(stringBuilder))};
                writer2.writeNext(entriess);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    writer.close();
    writer2.close();
    }

    public static int createRandomIntBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }
}

/*public LocalDate dateFormat(DateFormat dateFormat) {
        DateTimeFormatter myFormatObj;
        int day = createRandomIntBetween(1, 28);
        int month = createRandomIntBetween(1, 12);
        int year = createRandomIntBetween(1945, 2023);
        if(dateFormat.getClass().getAnnotation(DateFormat.class).equals("yyyy-MM-dd"))
        myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        if(dateFormat.equals("dd/MM/yyyy\""))
        myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        if(dateFormat.equals("dd-MMM-yyyy"))
        myFormatObj = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        else
        return null;
        */