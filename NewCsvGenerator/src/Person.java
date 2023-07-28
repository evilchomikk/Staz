import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Person extends CsvExportable {
    private String name;
    private String lastName;
    private int age;
}