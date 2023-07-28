package org.example;


import java.io.*;

import java.nio.file.Path;


public class FileManager {
    File sourceFile;
    File targetFile;
    Path directoryPath = Path.of("C:\\Users\\kulkah\\Desktop\\pliki");
    EmployeeData employeeData = new EmployeeData();


    public void readEmplyeeData(String source) throws IOException {
        this.sourceFile = new File(directoryPath.toString() + "\\" + source + ".txt");
        FileReader scan = new FileReader(sourceFile);
        BufferedReader reader = new BufferedReader(scan);

        EmplyeeMapper mapper = new EmplyeeMapper();
        if (sourceFile.canRead()) {

            String name, surname;
            float salary;

            String line;
            String[] tokens;
            while ((line = reader.readLine()) != null) {
                tokens = line.split(" ");
                name = tokens[0];
                surname = tokens[1];
                salary = Float.parseFloat(tokens[2]);

                EmployeeDTO employeeDTO = EmployeeDTO.builder()
                        .name(name)
                        .lastName(surname)
                        .salary(salary)
                        .build();


                employeeData.add(mapper.employeeDtoToEmployee(employeeDTO));
            }
            System.out.println(employeeData.getEmployeeList());
            reader.close();
        }

    }


    public void saveEmployeeData(String target) throws IOException {
        this.targetFile = new File(directoryPath.toString() + "\\" + target + ".txt");
        FileWriter scan = new FileWriter(targetFile);
        BufferedWriter writer = new BufferedWriter(scan);
        EmplyeeMapper mapper = new EmplyeeMapper();

        if (targetFile.canWrite()) {

            employeeData.getEmployeeList().stream()
                    .map(mapper::employeeToEmployeeDto)
                    .forEach(employeeDTO -> {
                        try {
                            writer.write(employeeDTO.getName() + " ");
                            writer.write(employeeDTO.getLastName() + " ");
                            writer.write(String.valueOf(employeeDTO.getSalary()));
                            writer.write("\r");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });

        }
        writer.close();
    }

    public void clearEmployeeRam() {
        employeeData.getEmployeeList().clear();


    }
}