package Mapping;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class EmployeeDTO {
    private String nameDTO;
    private String surnameDTO;
    private int salaryDTO;

    public String randomPosition(){
        List<String> position = List.of("Szef","Kierownik","Pracownik","Stażysta");
        int i = (int) (Math.random()*4);
        return position.get(i);
    }
}
