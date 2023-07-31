import com.opencsv.CSVWriter;
import org.apache.commons.lang3.ArrayUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import static java.io.ObjectInputFilter.merge;

public class CsvWriter<T> {
    public void writeObjectsToCsv(String path, List<T> objects) {
        try {
            FileWriter fileWriter = new FileWriter(path);
            CSVWriter csvWriter = new CSVWriter(fileWriter, CSVWriter.DEFAULT_SEPARATOR, CSVWriter.DEFAULT_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);

            Field[] fieldsChildClass = objects.get(0).getClass().getDeclaredFields();
            Field[] fieldsParentClass = objects.get(0).getClass().getSuperclass().getDeclaredFields();
            Field[] allFields =  ArrayUtils.addAll(fieldsParentClass, fieldsChildClass);

            String[] headerRecord = new String[allFields.length];
            for (int i = 0; i < allFields.length; i++) {
                headerRecord[i] = allFields[i].getName();
            }
            csvWriter.writeNext(headerRecord);

            for (T obj : objects) {

                String[] record = new String[allFields.length];
                for (int i = 0; i < allFields.length; i++) {
                    allFields[i].setAccessible(true);
                    Object value = allFields[i].get(obj);
                    record[i] = value != null ? value.toString() : "";
                }
                csvWriter.writeNext(record);
            }
            csvWriter.close();
        } catch (IOException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}


