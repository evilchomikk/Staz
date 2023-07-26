package Mapping;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataReader {
        FileReader file = new FileReader("C:\\Users\\mmazurek\\Downloads\\demo\\Wzorce\\src\\Mapping\\EmployeeData");
        BufferedReader reader = new BufferedReader(file);

        String line = "";
        String[] tokens;
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        List<Employee> employeeList = new ArrayList<>();


    public DataReader() throws FileNotFoundException {
    }

    public void readData() throws IOException {
        String name, surname;
        int salary;

            while ((line = reader.readLine()) != null) {
                tokens = line.split(" ");
                name = tokens[0];
                surname = tokens[1];
                salary = Integer.parseInt(tokens[2]);
                EmployeeDTO employeeDTO = new EmployeeDTO(name,surname,salary);
                employeeDTOList.add(employeeDTO);
            }
        }
        public void showData(){

            System.out.println("EmployeeDTO list: \n" + employeeDTOList);
            System.out.println("Employee list: \n" + employeeList);
        }

        public void transform(){
            EmployeeMapperImpl employeeMapper = new EmployeeMapperImpl();
            employeeDTOList.forEach(employeeDTO -> employeeList.add(employeeMapper.employeeDTOToEmployee(employeeDTO)));
        }
}

