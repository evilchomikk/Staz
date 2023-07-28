package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.List;

public class CsvConverter{
    CsvData<Object> csvData;

    public CsvConverter(List list)  {
        this.csvData = new CsvData<>(list);
    }

    public void generate() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\mmazurek\\Desktop\\pliki\\data.csv"));
        List<Field> classFields = List.of(csvData.getList().get(0).getClass().getDeclaredFields());

        classFields.forEach(field -> {
            DBField dbField = field.getAnnotation(DBField.class);
            if(csvData.getList().get(0).getClass().isAnnotationPresent(DBClass.class)) {

                if(dbField !=null)
                {
                    try {
                        System.out.print(dbField.name() + ',');
                        writer.write(dbField.name() + ',');
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
        System.out.println("\n");
        writer.newLine();
        csvData.getList().forEach(obj -> {
            StringBuilder stringBuilder = new StringBuilder();
            for (Field field : obj.getClass().getDeclaredFields()) {

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
                        stringBuilder.append(fieldValue).append(", ");
                    else
                        stringBuilder.append(",");

            }
            if (stringBuilder.length() > 2) {
                stringBuilder.setLength(stringBuilder.length() - 2);
                stringBuilder.append("\n");
            }
            try {
                System.out.println(stringBuilder);
                writer.write(String.valueOf(stringBuilder));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    writer.close();
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