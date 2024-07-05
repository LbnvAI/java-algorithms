package org.anton.hexlet.module2.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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
}
