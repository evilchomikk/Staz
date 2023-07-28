package org.example.Generator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.Annotations.*;

import java.io.*;
import java.lang.reflect.Field;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CsvGenerate implements CsvGenerator<Object> {

    CsvData<?> csvData;

    @Override
    public void generate(List list, String targetLoc) throws IOException {

        FileWriter scan = new FileWriter(targetLoc + ".csv");
        BufferedWriter writer = new BufferedWriter(scan);

        if (!list.get(0).getClass().isAnnotationPresent(DontGenerate.class)) {
            this.csvData = new CsvData<>(list);
            getColTitles(writer);
            getRowValues(writer);
        }
        //scan.close();
        writer.close();

    }

    public void getColTitles(BufferedWriter writer) throws IOException {
        StringBuilder colTitle = new StringBuilder();

        List<Field> classFields = List.of(csvData.getListOfObjects().get(0).getClass().getDeclaredFields());


        classFields.forEach(field -> {
            if (!csvData.getListOfObjects().get(0).getClass().isAnnotationPresent(DontGenerate.class))
                if (!field.isAnnotationPresent(IgnoreField.class))
                    if (csvData.getListOfObjects().get(0).getClass().isAnnotationPresent(IgnoreInnerLists.class)) {
                        if (!field.getType().equals(List.class))
                            colTitle.append(field.getName()).append(", ");
                    } else {
                        colTitle.append(field.getName()).append(", ");
                    }


        });


        colTitle.setLength(colTitle.length() - 2);
        colTitle.append("\r");

        writer.write(colTitle.toString());
        System.out.println(colTitle);


    }

    public void getRowValues(BufferedWriter writer) {

        GetAmmount getAmmount;
        if (!csvData.getListOfObjects().get(0).getClass().isAnnotationPresent(DontGenerate.class))
            csvData.getListOfObjects().forEach(obj -> {
                StringBuilder sb = new StringBuilder();

                for (Field field : obj.getClass().getDeclaredFields()) {
                    Object fieldValue;
                    try {
                        field.setAccessible(true);
                        fieldValue = field.get(obj);

                        if (csvData.getListOfObjects().get(0).getClass().isAnnotationPresent(NullsEquals.class))
                            if (fieldValue == null)
                                fieldValue = csvData.getListOfObjects().get(0).getClass().getAnnotation(NullsEquals.class).nullValue();


                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }


                    if (!field.isAnnotationPresent(IgnoreField.class))
                        if (obj.getClass().isAnnotationPresent(IgnoreInnerLists.class)) {
                            if (!field.getType().equals(List.class))
                                sb.append(fieldValue).append(", ");

                        } else
                            sb.append(fieldValue).append(", ");

                }


                if (sb.length() > 2) {
                    sb.setLength(sb.length() - 2);
                }
                sb.append("\r");
                try {
                    writer.write(sb.toString());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(sb);

            });
    }


}
