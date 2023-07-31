package org.example.Generator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.Annotations.*;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CsvGenerate implements CsvGenerator<Object> {

    CsvData<?> csvData;
    private List<Field> classFields;
    @Override
    public void generate(List list, String targetLoc) throws IOException {

        FileWriter scan = new FileWriter(targetLoc + ".csv");
        BufferedWriter writer = new BufferedWriter(scan);

        if (!list.get(0).getClass().isAnnotationPresent(DontGenerate.class)) {
            this.csvData = new CsvData<>(list);

            System.out.println();
            getFields();
            getColTitles(writer);
            getRowValues(writer);
        }
        //scan.close();
        writer.close();

    }

    public void getColTitles(BufferedWriter writer) throws IOException {
        StringBuilder colTitle = new StringBuilder();


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
        // Field sortByField = null;





        if (!csvData.getListOfObjects().get(0).getClass().isAnnotationPresent(DontGenerate.class))
            csvData.getListOfObjects().forEach(obj -> {
                StringBuilder sb = new StringBuilder();
                LocalDate date = null;
                for (Field field : classFields) {  // tu zmiana
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
                        if (field.getType().equals(List.class)) {
                            if (!obj.getClass().isAnnotationPresent(IgnoreInnerLists.class)) {
                                sb.append(fieldValue).append(", ");
                            }
                        } else if (field.getType().equals(LocalDate.class)) {
                            if (obj.getClass().isAnnotationPresent(DateFormat.class)) {
                                date = (LocalDate) fieldValue;
                                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(obj.getClass().getAnnotation(DateFormat.class).dateFormat());
                                fieldValue = formatter.format(date);
                                sb.append(fieldValue.toString()).append(", ");
                            } else {
                                sb.append(fieldValue).append(", ");
                            }
                        } else {
                            sb.append(fieldValue).append(", ");
                        }
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


    public void read(Object obj, String sourceLoc) throws IOException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        FileReader scan = new FileReader(sourceLoc + ".csv");
        BufferedReader reader = new BufferedReader(scan);

        Class<?> aClass = obj.getClass();
        Field[] fields = aClass.getDeclaredFields();
        Constructor<?>[] constructor = aClass.getConstructors();
        var line = reader.readLine();//omija 1 linie
        Class[] niewiem = constructor[0].getParameterTypes();


        while ((line = reader.readLine()) != null) {
            String[] splitedLine = line.split(", ");
            System.out.println((Arrays.toString(splitedLine)));
            List<Object> splitedLineList = new ArrayList<>();


            for (int i = 0; i < fields.length; i++) {
                splitedLineList.add(convertValue(fields[i].getType(), splitedLine[i]));
            }

            System.out.println(splitedLineList);
            System.out.println( constructor[0].newInstance(splitedLineList.get(0),splitedLineList.get(1),splitedLineList.get(2),splitedLineList.get(3)));


            //JAK WSTAWIC W ARGUMENTY TA TABLICE PODZIELONA


        }
        reader.close();
    }

    private Object convertValue(Class<?> fieldType, String value) {
        try {
            if (fieldType == int.class || fieldType == Integer.class) {
                return Integer.parseInt(value);
            } else if (fieldType == double.class || fieldType == Double.class) {
                return Double.parseDouble(value);
            } else if (fieldType == boolean.class || fieldType == Boolean.class) {
                return Boolean.parseBoolean(value);
            } else if (fieldType == String.class) {
                return String.valueOf(value);
                // For other types, you might need additional handling
                // For this example, we assume all other fields are of type String
            } else {
                return null;
            }
        }catch (Exception e){
            return null;
        }

    }
    private void getFields(){
        classFields = new ArrayList<>(List.of(csvData.getListOfObjects().get(0).getClass().getDeclaredFields()));
        List<Field> superClassFields ;

        Class supeClass = csvData.getListOfObjects().get(0).getClass().getSuperclass();
        while(supeClass != Object.class){
            superClassFields = List.of(supeClass.getDeclaredFields());
            classFields.addAll(superClassFields);
            supeClass = supeClass.getSuperclass();
        }
    }
}

