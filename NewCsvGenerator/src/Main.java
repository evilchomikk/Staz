import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> listOfPerson = new ArrayList<>();
        listOfPerson.add(new Person("Jan", "Kowalski", 30));
        listOfPerson.add(new Person("Anna", "Nowak", 25));
        listOfPerson.add(new Person("Marek", "Zawadzki", 40));

        String pathPerson = "C:\\Users\\pzientara\\Desktop\\csv_file\\PersonTable.csv";

        CsvFileWriter.writeToFile(listOfPerson, pathPerson);

        List<Car> ListOfCar = new ArrayList<>();
        ListOfCar.add(new Car("Ford", "Mondeo", 3200));
        ListOfCar.add(new Car("Fiat", "Stilo", 3000));
        ListOfCar.add(new Car("Mercedes", "e500", 53000));

        String pathCar = "C:\\Users\\pzientara\\Desktop\\csv_file\\CarTable.csv";

        CsvFileWriter.writeToFile(ListOfCar, pathCar);


    }
}