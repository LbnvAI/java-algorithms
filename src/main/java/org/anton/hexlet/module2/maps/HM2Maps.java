package org.anton.hexlet.module2.maps;

import java.util.*;

public class HM2Maps {
    //**************************************************************************************************************|
    //                                                  Scrabble                                                    |
    //______________________________________________________________________________________________________________|
    //                                                 My Solution                                                  |
    public static boolean scrabble(String test, String target) {
        var testMap = getCharMap(test);
        var targetMap = getCharMap(target);
        return checkScrabble(targetMap, testMap);
    }

    private static Map<Character, Integer> getCharMap(String line) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        String lowerCaseLine = line.toLowerCase();
        for (int i = 0; i < line.length(); i++) {
            map.put(lowerCaseLine.charAt(i), map.getOrDefault(lowerCaseLine.charAt(i), 0) + 1);
        }
        return map;
    }

    private static boolean checkScrabble(Map<Character, Integer> target, Map<Character, Integer> test) {
        for (Map.Entry<Character, Integer> entry : target.entrySet()) {
            if (entry.getValue() > test.getOrDefault(entry.getKey(), 0)) return false;
        }
        return true;
    }

    //______________________________________________________________________________________________________________|
    //                                             Hexlet Solution                                                  |
    public static boolean HEXLET_scrabble(String letters, String word) {
        var charsCount = countByChars(letters);
        for (var current : word.toLowerCase().toCharArray()) {
            var count = charsCount.getOrDefault(current, 0);
            if (count == 0) {
                return false;
            }
            charsCount.put(current, count - 1);
        }
        return true;
    }

    private static Map<Character, Integer> countByChars(String letters) {
        var chars = new HashMap<Character, Integer>();
        for (var current : letters.toCharArray()) {
            var count = chars.getOrDefault(current, 0);
            chars.put(current, count + 1);
        }
        return chars;
    }

    //**************************************************************************************************************|
    //                                                Query String                                                  |
    //______________________________________________________________________________________________________________|
    //                                                 My Solution                                                  |
    public static String bqs(Map<String, String> params) {
        StringBuilder queryStr = new StringBuilder();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            queryStr.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        if (queryStr.isEmpty()) return "";
        else {
            queryStr.deleteCharAt(queryStr.length() - 1);
            return queryStr.toString();
        }
    }

    //______________________________________________________________________________________________________________|
    //                                             Hexlet Solution                                                  |
    public static String HEXLET_bqs(Map<String, String> params) {
        var result = new ArrayList<String>();
        params.forEach((k, v) -> {
            result.add(k + "=" + v);
        });
        return String.join("&", result);
    }

    //**************************************************************************************************************|
    //                                                  Library                                                     |
    //______________________________________________________________________________________________________________|
    //                                                 My Solution                                                  |
    public static List<Map<String, String>> findWhere(List<Map<String, String>> library, Map<String, String> where) {
        List<Map<String, String>> result = new ArrayList<>();
        for (var current : library) {
            if (checkBook(current, where)) result.add(current);
        }
        return result;
    }

    private static boolean checkBook(Map<String, String> book, Map<String, String> where) {
        for (var current : where.entrySet()) {
            if (!book.get(current.getKey()).equals(current.getValue())) return false;
        }
        return true;
    }

    //______________________________________________________________________________________________________________|
    //                                             Hexlet Solution                                                  |
    public static List<Map<String, String>> HEXLET_findWhere(List<Map<String, String>> data, Map<String, String> items) {
        var result = new ArrayList<Map<String, String>>();
        for (var item : data) {
            boolean find = true;
            for (var entry : items.entrySet()) {
                var itemValue = item.getOrDefault(entry.getKey(), "");
                if (!itemValue.equals(entry.getValue())) {
                    find = false;
                }
            }
            if (find) {
                result.add(item);
            }
        }
        return result;
    }

    //**************************************************************************************************************|
    //                                             Difference Calculator                                            |
    //______________________________________________________________________________________________________________|
    //                                           My Solution same as Hexlet                                         |
    public static Map<String, Object> genDiff(Map<String, Object> first, Map<String, Object> second) {
        Set<String> keys = new TreeSet<>();
        addToTreeSet(first, keys);
        addToTreeSet(second, keys);
        Map<String, Object> diff = new LinkedHashMap<>();
        for (String key : keys) {
            if (first.containsKey(key) && !second.containsKey(key)) diff.put(key, "deleted");
            else if (!first.containsKey(key) && second.containsKey(key)) diff.put(key, "added");
            else {
                if (first.get(key).equals(second.get(key))) diff.put(key, "unchanged");
                else diff.put(key, "changed");
            }
        }
        return diff;
    }

    private static void addToTreeSet(Map<String, Object> map, Set<String> set) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            set.add(entry.getKey());
        }
    }
}
