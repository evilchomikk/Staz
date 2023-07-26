package Mapping;

public class EmployeeMapperImpl implements EmployeeMapper{
    @Override
    public Employee employeeDTOToEmployee(EmployeeDTO employeeDTO) {
        if(employeeDTO==null)
            return null;
        Employee employee = new Employee();
        employee.setName(employeeDTO.getNameDTO());
        employee.setSurname(employeeDTO.getSurnameDTO());
        employee.setSalaryInHundreds(employeeDTO.getSalaryDTO()/100);
        employee.setPosition(employeeDTO.randomPosition());
        return employee;
    }

}
