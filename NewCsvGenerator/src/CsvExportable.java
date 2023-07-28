import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class CsvExportable {
    public String[] toCsvRecord() {
        List<String> values = new ArrayList<>();
        Field[] fields = this.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object value = field.get(this);
                values.add(value != null ? value.toString() : "");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return values.toArray(new String[0]);
    }
}
