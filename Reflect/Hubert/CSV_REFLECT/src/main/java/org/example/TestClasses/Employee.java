package org.example.TestClasses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.Annotations.DateFormat;
import org.example.Annotations.IgnoreInnerLists;
import org.example.Annotations.NullsEquals;
import org.example.Annotations.SortBy;

import java.time.LocalDate;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
////@DontGenerate
//@IgnoreInnerLists
@NullsEquals(nullValue = "NIEDZIAŁA TUTAJ")
@DateFormat(dateFormat = "dd-yyyy-MM")
public class Employee {
    @SortBy
    private String name;
    //@IgnoreField
    private Integer id;
    List<String> role;
    LocalDate dateOfEmployment;


}
