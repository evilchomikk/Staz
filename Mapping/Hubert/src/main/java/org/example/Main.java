package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        FileManager manager = new FileManager();

        manager.readEmplyeeData("Employee");
        manager.saveEmployeeData("xd1");



    }
}