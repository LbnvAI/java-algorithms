package org.anton.hexlet.module2.generics;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class HM2Generics {
    //**************************************************************************************************************|
    //                                         Get uniq elements using generics                                     |
    //______________________________________________________________________________________________________________|
    //                                                 My Solution                                                  |
    public static <T> List<T> uniq(List<T> list) {
        Set<T> set = new LinkedHashSet<>(list);
        return new ArrayList<>(set);
    }

    //______________________________________________________________________________________________________________|
    //                                              Hexlet Solution                                                 |
    public static <T> List<T> HEXLET_uniq(List<T> elements) {
        var result = new ArrayList<T>();
        for (T element : elements) {
            if (!result.contains(element)) {
                result.add(element);
            }
        }
        return result;
    }
}
