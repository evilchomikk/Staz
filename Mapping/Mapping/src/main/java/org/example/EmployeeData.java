package org.example;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class EmployeeData {


    List<Employee> employeeList =Lists.newArrayList();

    public void add(Employee employee){
        employeeList.add(employee);
    }

}
