package org.example;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface EmployeeDtoToEmployeeMapper {
    @Mapping(target = "name",source = "employeeDTO.name")
    @Mapping(target = "lastName",source = "employeeDTO.lastName")
    @Mapping(target = "salary",source = "employeeDTO.salary")
    Employee employeeDtoToEmployee(EmployeeDTO employeeDTO);

    @Mapping(target = "name",source = "employee.name")
    @Mapping(target = "lastName",source = "employee.lastName")
    @Mapping(target = "salary",source = "employee.salary")
    EmployeeDTO employeeToEmployeeDto(Employee employee);
}
