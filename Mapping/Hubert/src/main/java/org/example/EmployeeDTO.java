package org.example;

import lombok.*;

@AllArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class EmployeeDTO {
    private String name;
    private String lastName;
    private float salary;


}
