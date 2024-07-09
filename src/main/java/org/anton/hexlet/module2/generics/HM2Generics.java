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

    //**************************************************************************************************************|
    //                                      From Pair to Map and from Map to Pair                                   |
    //______________________________________________________________________________________________________________|
    //                                            My Solution same as Hexlet                                        |
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

    //**************************************************************************************************************|
    //                            Find max in List where elements extends Comparable                                |
    //______________________________________________________________________________________________________________|
    //                                            My Solution                                                       |
    public static <T> T findMax(List<? extends Comparable<T>> elements) {
        var max = elements.getFirst();
        for (var element : elements) {
            if (element.compareTo((T) max) > 0) max = element;
        }
        return (T) max;
    }

    //______________________________________________________________________________________________________________|
    //                                              Hexlet Solution                                                 |
    public static <T extends Comparable<? super T>> T HEXLET_findMax(List<T> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        T max = list.getFirst();
        for (T item : list) {
            if (item.compareTo(max) > 0) {
                max = item;
            }
        }
        return max;
    }
}
