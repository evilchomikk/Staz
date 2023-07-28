import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Car extends CsvExportable{
    private String manufacturer;
    private String model;
    private float price;
}
