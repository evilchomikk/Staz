import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception{
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("Dog Niemiecki", 3, "Burek", "Czarny"));
        dogs.add(new Dog("Corgi", 5, "Sunia", "Siwy"));

        String pathDog = "C:\\Users\\pzientara\\Desktop\\csv_file\\DogTable.csv";

        CsvWriter<Dog> csvWriter = new CsvWriter<>();
        csvWriter.writeObjectsToCsv(pathDog, dogs);

        ReaderCsvFile readerCsvFile = new ReaderCsvFile();
        readerCsvFile.readFile(pathDog);

    }
}




