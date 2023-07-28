package org.example.TestClasses;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.Annotations.DontGenerate;
import org.example.Annotations.IgnoreInnerLists;
import org.example.Annotations.NullsEquals;

import java.util.*;

@Data
@AllArgsConstructor
//@DontGenerate
@IgnoreInnerLists
@NullsEquals(nullValue = "NIEDZIAŁA TUTAJ")
public class Employee {
    private String name;
    //@IgnoreField
    private Integer id;
    List<String> role;
}
