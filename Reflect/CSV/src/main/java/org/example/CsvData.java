package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@AllArgsConstructor
@Data
public class CsvData<T> {
    List list;
}
