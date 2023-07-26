package org.example;

import org.mapstruct.Mapper;

@Mapper
public class EmployeeDtoToEmployeeMapperimp implements EmployeeDtoToEmployeeMapper {


    @Override
    public Employee employeeDtoToEmployee(EmployeeDTO employeeDTO) {
        return null;
    }

    @Override
    public EmployeeDTO employeeToEmployeeDto(Employee employee) {
        return null;
    }
}
