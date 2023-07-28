package org.example;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortTable {
    //@TableOrder(sortByField = "name")
    public Field sorter() throws SecurityException, NoSuchMethodException, NoSuchFieldException {
        TableOrder order = getClass().getMethod("sorter", String.class).getAnnotation(TableOrder.class);
        //TableOrder or = getClass().getField(sorterImpl(order))
        return sorterImpl(order);
    }

    public Field sorterImpl(final TableOrder a) throws NoSuchFieldException {
        return a.annotationType().getField(String.valueOf(a));
    }
    List<Field> sortTable(List<Field> list, TableOrder tableOrder){
        //return list.stream().sorted(Comparator.comparing(value,String::compareToIgnoreCase));
        //Collections.sort(list, Comparator.comparingInt(tb->tb.getClass().getMethod("sorter")));
        return null;
    }
}
