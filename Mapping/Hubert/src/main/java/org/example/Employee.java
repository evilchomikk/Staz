package org.example;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Builder
public class Employee {
    private String name;
    private String lastName;
    private float salary;
    private Role roles;
}
