package Mapping;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        DataReader dataReader = new DataReader();
        dataReader.readData();
        dataReader.transform();
        dataReader.showData();


    }
}
