package org.example;

import org.mapstruct.Mapper;

import java.security.SecureRandom;
public class EmplyeeMapper implements EmployeeDtoToEmployeeMapper{
    private static final SecureRandom random = new SecureRandom();
    @Override
    public Employee employeeDtoToEmployee(EmployeeDTO employeeDTO) {
        return Employee.builder()
                .name(employeeDTO.getName())
                .lastName(employeeDTO.getLastName())
                .salary(employeeDTO.getSalary())
                .roles(randomEnum(Role.class))
                .build();

    }

    @Override
    public EmployeeDTO employeeToEmployeeDto(Employee employee) {
        return EmployeeDTO.builder()
                .name(employee.getName())
                .lastName(employee.getLastName())
                .salary(employee.getSalary())
                .build();
    }

    public static <T extends Enum<?>> T randomEnum(Class<T> clazz){
        int x = random.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }
}
