package org.anton.hexlet.module2.functions;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class App {
    //**************************************************************************************************************|
    //                                          Get Min Element In List Of Book                                     |
    //______________________________________________________________________________________________________________|
    //                                                 My Solution                                                  |
    public static Book getMinValueBy(List<Book> books, Function<Book, Integer> fn) {
        Book minValue = books.getFirst();
        for (Book book : books) {
            if (fn.apply(book) < fn.apply(minValue)) minValue = book;
        }
        return minValue;
    }

    //______________________________________________________________________________________________________________|
    //                                              Hexlet Solution                                                 |
    public static Book HEXLET_getMinValueBy(List<Book> books, Function<Book, Integer> fn) {
        var sortedBooks = new ArrayList<Book>(books);
        sortedBooks.sort(Comparator.comparingInt(fn::apply));
        return sortedBooks.get(0);
    }

    //**************************************************************************************************************|
    //                                        Check strings in list by predicate                                    |
    //______________________________________________________________________________________________________________|
    //                                             My Solution same as Hexlet                                       |
    public static boolean every(List<String> words, Predicate<String> pr) {
        for (String word : words) {
            if (!pr.test(word)) return false;
        }
        return true;
    }

    //**************************************************************************************************************|
    //                                           Group words by lambda parameter                                    |
    //______________________________________________________________________________________________________________|
    //                                                   My Solution                                                |
    public static Map<String, List<String>> groupBy(List<String> words, Function<String, String> fn) {
        Map<String, List<String>> map = new HashMap<>();
        for (String word : words) {
            String key = fn.apply(word);
            map.putIfAbsent(key, new ArrayList<>());
            List<String> temp = map.get(key);
            temp.add(word);
            map.put(key, temp);
        }
        return map;
    }

    //______________________________________________________________________________________________________________|
    //                                              Hexlet Solution                                                 |
    public static Map<String, List<String>> HEXLET_groupBy(List<String> coll, Function<String, String> fn) {
        var result = new HashMap<String, List<String>>();
        coll.forEach((item) -> {
            var key = fn.apply(item);
            result.compute(key, (k, wordsGroup) -> {
                wordsGroup = wordsGroup == null ? new ArrayList<>() : wordsGroup;
                wordsGroup.add(item);
                return wordsGroup;
            });
        });
        return result;
    }
}
