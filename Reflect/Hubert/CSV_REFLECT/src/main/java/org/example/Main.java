package org.example;

import org.example.Generator.CsvGenerate;
import org.example.TestClasses.Animal;
import org.example.TestClasses.Employee;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, IOException {
        System.out.println("Hello world!");

        List<Employee> listOfEemployee = List.of(new Employee("Jan", 1, List.of("Kierwoca", "Piekarz", "Policjant")),
                new Employee("Krzysztof", null, List.of("1", "2", "3")),
                new Employee("Hubert", 4, List.of("a", "b", "c")),
                new Employee("Jan", 3, List.of("Piekarz", "1", "a"))

        );



        List listOfAnimals = List.of(
                new Animal("Pies", 4),
                new Animal("Kangur", 2),
                new Animal("Kot", 4),
                new Animal("Chomik", 4),
                new Animal("Niewiem", 3)
        );

        //@IgnoreLists
        CsvGenerate generator = new CsvGenerate();
        generator.generate(listOfEemployee,"C:\\Users\\kulkah\\Desktop\\pliki\\jakasnazwa");
    }
}