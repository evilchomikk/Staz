package Mapping;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface EmployeeMapper {
    @Mapping(target = "name", source = "nameDTO")
    @Mapping(target = "surname", source = "surnameDTO")
    @Mapping(target = "salary", source = "salaryDTO")
    @Mapping(target = "position", source = "positions")
    Employee employeeDTOToEmployee(EmployeeDTO employeeDTO);
}
