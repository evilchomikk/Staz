package org.example.TestClasses;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.checkerframework.checker.units.qual.A;

@Data
@AllArgsConstructor
public class Animal {
    String kind;
    int numberOfLegs;
}
