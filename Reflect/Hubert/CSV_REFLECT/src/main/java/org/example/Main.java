package org.example;

import org.checkerframework.checker.units.qual.C;
import org.example.Generator.CsvGenerate;
import org.example.TestClasses.Animal;
import org.example.TestClasses.Cat;
import org.example.TestClasses.Employee;

import java.awt.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, IOException, InvocationTargetException, NoSuchMethodException, InstantiationException {
        System.out.println("Hello world!");

        List<Employee> listOfEemployee = List.of(new Employee("Jan", 1, List.of("Kierwoca", "Piekarz", "Policjant"),  LocalDate.of(120,11,1)),
                new Employee("Krzysztof", null, List.of("1", "2", "3"), LocalDate.of(120,10,10)),
                new Employee("Hubert", 4, List.of("a", "b", "c"),  LocalDate.of(120,10,10)),
                new Employee("Jan", 3, List.of("Piekarz", "1", "a"),  LocalDate.of(120,10,10))

        );



        List listOfAnimals = List.of(
                new Cat(true,"Pies", 4, "Black"),
                new Cat(true,"Kangur", 2,"Blue"),
                new Cat(true,"Kot", 4,"Cyan"),
                new Cat(false,"Chomik", 4,"Grey"),
                new Cat(false,"Niewiem", 3,"Green")
        );

        //@IgnoreLists
        CsvGenerate generator = new CsvGenerate();
        generator.generate(listOfAnimals,"C:\\Users\\kulkah\\Desktop\\pliki\\jakasnazwa");
        generator.read(new Cat(),"C:\\Users\\kulkah\\Desktop\\pliki\\jakasnazwa");
    }
}