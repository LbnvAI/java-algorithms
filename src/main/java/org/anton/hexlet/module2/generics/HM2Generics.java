package org.anton.hexlet.module2.generics;

import java.util.*;

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

    // From Pair to Map and from Map to Pair
    public static <K, V> Map<K, V> fromPairs(List<Pair<K, V>> pairs) {
        Map<K, V> result = new HashMap<>();
        pairs.forEach((pair) -> result.put(pair.getLeft(), pair.getRight()));
        return result;
    }

    public static <K, V> List<Pair<K, V>> toPairs(Map<K, V> pairs) {
        List<Pair<K, V>> result = new ArrayList<>();
        pairs.forEach((k, v) -> result.add(new SimplePair<>(k, v)));
        return result;
    }
}
