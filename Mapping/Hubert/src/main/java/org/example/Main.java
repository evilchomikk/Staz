package org.example;


import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {

        FileManager manager = new FileManager();

        manager.readEmplyeeData("Employee");
        manager.readEmplyeeData("Employee");
        manager.readEmplyeeData("Employee");
        manager.readEmplyeeData("Employee");
        manager.readEmplyeeData("Employee");
        manager.readEmplyeeData("Employee");
        manager.readEmplyeeData("Employee");
        manager.readEmplyeeData("Employee");
        manager.readEmplyeeData("Employee");
        manager.clearEmployeeRam();
        manager.saveEmployeeData("xd2");


        System.out.println(new EmployeeDtoToEmployeeMapperImpl().employeeDtoToEmployee(
                EmployeeDTO.builder().name("Jan").lastName("Kowalksi").salary(20).build()
        ));
        long i = 1000000000;

    }
}