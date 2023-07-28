package org.example.Generator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public interface CsvGenerator<T> {
    void generate(List list,String targetLoc) throws IOException;


}
