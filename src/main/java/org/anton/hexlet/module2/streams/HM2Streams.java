package org.anton.hexlet.module2.streams;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Math.abs;

public class HM2Streams {
    //**************************************************************************************************************|
    //                                           Get Map of same aged users                                         |
    //______________________________________________________________________________________________________________|
    //                                                 My Solution                                                  |
    public static Map<Integer, Long> getMenCountByYear(List<Map<String, String>> users) {
        return users.stream()
                .filter((user) -> user.get("gender").equals("male"))
                .collect(Collectors.groupingBy(user -> LocalDate.parse(user.get("birthday")).getYear(), Collectors.counting()));
    }

    //______________________________________________________________________________________________________________|
    //                                             Hexlet Solution                                                  |
    public static Map<Integer, Long> HEXLET_getMenCountByYear(List<Map<String, String>> users) {
        return users.stream()
                .filter(user -> user.get("gender").equals("male"))
                .map(user -> LocalDate.parse(user.get("birthday")).getYear())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    //**************************************************************************************************************|
    //                                        Get list of same parity numbers                                       |
    //______________________________________________________________________________________________________________|
    //                                                 My Solution                                                  |
    public static List<Integer> sameParityFilter(List<Integer> numbers) {
        if (numbers.isEmpty()) return numbers;
        boolean even = numbers.getFirst() % 2 == 0;
        return numbers.stream().filter(number -> (number % 2 == 0) == even).toList();
    }

    //______________________________________________________________________________________________________________|
    //                                             Hexlet Solution                                                  |
    public static List<Integer> HEXLET_sameParityFilter(List<Integer> coll) {
        if (coll.isEmpty()) {
            return new ArrayList<Integer>();
        }
        final boolean firsItemParity = isEven(coll.get(0));
        return coll.stream().filter(item -> isEven(item) == firsItemParity).toList();
    }

    private static boolean isEven(int num) {
        return num % 2 == 0;
    }

    //**************************************************************************************************************|
    //                                       Find index of nearest number in list                                   |
    //______________________________________________________________________________________________________________|
    //                                                 My Solution                                                  |
    public static int findIndexOfNearest(List<Integer> numbers, int target) {
        var differences = numbers.stream().map(number -> abs(number - target)).toList();
        return differences.indexOf(differences.stream().sorted().findFirst().orElse(-1));
    }

    //______________________________________________________________________________________________________________|
    //                                             Hexlet Solution                                                  |
    public static int HEXLET_findIndexOfNearest(List<Integer> numbers, int num) {
        if (numbers.isEmpty()) {
            return -1;
        }
        List<Integer> diffs = numbers.stream()
                .map(element -> Math.abs(num - element))
                .toList();
        var minDiff = diffs.stream().mapToInt(Integer::intValue).min().getAsInt();
        return diffs.indexOf(minDiff);
    }
    //**************************************************************************************************************|
    //                                   Find anagrams of string in list of strings                                 |
    //______________________________________________________________________________________________________________|
    //                                                 My Solution                                                  |
    public static List<String>filterAnagram(String word, List<String> tests) {
        var wordMap = getCharMap(word);
        return tests.stream().filter(test->(getCharMap(test)).equals(wordMap)).toList();
    }

    private static Map<Character, Integer> getCharMap(String word) {
        Map<Character, Integer> map = new TreeMap<>();
        for(char c : word.toLowerCase().toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }
    //______________________________________________________________________________________________________________|
    //                                             Hexlet Solution                                                  |
    private static String normalize(String word) {
        return Stream.of(word.split(""))
                .sorted()
                .collect(Collectors.joining(""));
    }

    public static List<String> HEXLET_filterAnagram(String word, List<String> words) {
        var normalizedWord = normalize(word);
        return words.stream()
                .filter(item -> normalize(item).equals(normalizedWord))
                .toList();
    }
}
