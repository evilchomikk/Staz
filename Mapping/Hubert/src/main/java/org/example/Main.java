package org.example;

import org.mapstruct.factory.Mappers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        FileManager manager = new FileManager();

        manager.readEmplyeeData("Employee");
        manager.saveEmployeeData("xd1");

        System.out.println(Mappers.getMapper(EmployeeDtoToEmployeeMapperimp.class).employeeDtoToEmployee(
                EmployeeDTO.builder().name("Jan").lastName("Kowalksi").salary(20).build()
        ));

        System.out.println( new EmployeeDtoToEmployeeMapperImpl().employeeDtoToEmployee(
                EmployeeDTO.builder().name("Jan").lastName("Kowalksi").salary(20).build()
        ));


    }
}