package org.example.TestClasses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.Annotations.IgnoreField;


public class Animal extends Living{

    String name;
    int numberOfLegs;

    public Animal(boolean lives, String name, int numberOfLegs) {
        super(lives);
        this.name = name;
        this.numberOfLegs = numberOfLegs;
    }


}
