import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class CsvFileWriter {
    public static <T extends CsvExportable> void writeToFile(List<T> listOfObjects, String path) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(path))) {
            T firstObject = listOfObjects.get(0);
            writer.writeNext(getFieldNames(firstObject));

            for (T obj : listOfObjects) {
                writer.writeNext(obj.toCsvRecord());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static <T extends CsvExportable> String[] getFieldNames(T object) {
        Field[] fields = object.getClass().getDeclaredFields();
        List<String> fieldNames = new ArrayList<>();

        for (Field field : fields) {
            fieldNames.add(field.getName());
        }
        return fieldNames.toArray(new String[0]);
    }
}
