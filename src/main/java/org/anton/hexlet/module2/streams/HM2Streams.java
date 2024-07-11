package org.anton.hexlet.module2.streams;

import org.apache.commons.lang3.StringUtils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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
    public static List<String> filterAnagram(String word, List<String> tests) {
        var wordMap = getCharMap(word);
        return tests.stream().filter(test -> (getCharMap(test)).equals(wordMap)).toList();
    }

    private static Map<Character, Integer> getCharMap(String word) {
        Map<Character, Integer> map = new TreeMap<>();
        for (char c : word.toLowerCase().toCharArray()) {
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

    //**************************************************************************************************************|
    //                                   Convert color from hex string to rgb and back                              |
    //______________________________________________________________________________________________________________|
    //                                                 My Solution                                                  |
    public static String rgbToHex(int r, int g, int b) {
        var R = Integer.toHexString(r);
        var G = Integer.toHexString(g);
        var B = Integer.toHexString(b);
        if (R.length() < 2) R = "0" + R;
        if (G.length() < 2) G = "0" + G;
        if (B.length() < 2) B = "0" + B;
        return "#" + R + G + B;
    }

    public static Map<String, Integer> hexToRgb(String hex) {
        var symbols = hex.split("");
        int R = 0, G = 0, B = 0;
        R = Integer.parseInt(symbols[1] + symbols[2], 16);
        G = Integer.parseInt(symbols[3] + symbols[4], 16);
        B = Integer.parseInt(symbols[5] + symbols[6], 16);
        Map<String, Integer> map = new HashMap<>();
        map.put("b", B);
        map.put("g", G);
        map.put("r", R);
        return map;
    }

    //______________________________________________________________________________________________________________|
    //                                             Hexlet Solution                                                  |
    public static String HEXLET_rgbToHex(int r, int g, int b) {
        var hex = Stream.of(r, g, b)
                .map(channel -> Integer.toString(channel, 16))
                .map(channel -> StringUtils.leftPad(channel, 2, "0"))
                .collect(Collectors.joining(""));

        return String.format("#%s", hex);

    }

    public static Map<String, Integer> HEXLET_hexToRgb(String hex) {
        String[] chunked = Util.chunk(hex.substring(1), 2);
        List<Integer> channels = Stream.of(chunked)
                .map(channel -> Integer.parseInt(channel, 16))
                .toList();
        return Map.of(
                "r", channels.get(0),
                "g", channels.get(1),
                "b", channels.get(2)
        );
    }

    //**************************************************************************************************************|
    //                             Convert ip from string to 32bit number(decimal) anb back                         |
    //______________________________________________________________________________________________________________|
    //                                                 My Solution                                                  |
    public static long ipToDec(String ip) {
        String result = Stream.of(ip.split("\\."))
                .map(Integer::parseInt)
                .map(Integer::toBinaryString)
                .map(str -> StringUtils.leftPad(str, 8, "0"))
                .reduce("", String::concat);
        return Long.parseLong(result, 2);
    }

    public static String decToIp(long ip) {
        return Stream.of(Util.chunk(StringUtils.leftPad(Long.toBinaryString(ip), 32, "0"), 8))
                .map(chunk -> Integer.parseInt(chunk, 2))
                .map(chunk -> Integer.toString(chunk))
                .collect(Collectors.joining("."));
    }

    //______________________________________________________________________________________________________________|
    //                                             Hexlet Solution                                                  |
    public static long HEXLET_ipToDec(String ip) {
        var ipInHex = Stream.of(ip.split("\\."))
                .map(octet -> Integer.parseInt(octet))
                .map(octet -> Integer.toString(octet, 16))
                .map(octet -> StringUtils.leftPad(octet, 2, "0"))
                .collect(Collectors.joining(""));

        return Long.parseLong(ipInHex, 16);
    }

    public static String HEXLET_decToIp(long decimal) {
        var ipInHex = Long.toString(decimal, 16);
        var normalizedIp = StringUtils.leftPad(ipInHex, 8, "0");
        return Stream.of(Util.chunk(normalizedIp, 2))
                .map(octet -> Integer.parseInt(octet, 16))
                .map(octet -> Integer.toString(octet))
                .collect(Collectors.joining("."));
    }

//    public static String nrzi(String signals) {
//
//    }

    //**************************************************************************************************************|
    //                                   Count probabilities for next cube roll                                     |
    //______________________________________________________________________________________________________________|
    //                                                 My Solution                                                  |
    public static Map<Integer, Map<Integer, Double>> calculateProbabilities(List<Integer> values) {
        Map<Integer, Map<Integer, Double>> result = new HashMap<>();
        Map<Integer, List<Integer>> nextValues = new HashMap<>();
        for (int i = 0; i < values.size(); i++) {
            List<Integer> next = nextValues.getOrDefault(values.get(i), new ArrayList<>());
            if (i != values.size() - 1) next.add(values.get(i + 1));
            nextValues.put(values.get(i), next);
        }
        for (var entry : nextValues.entrySet()) {
            result.put(entry.getKey(), getProbFromList(entry.getValue()));
        }
        return result;
    }

    private static Map<Integer, Double> getProbFromList(List<Integer> values) {
        Map<Integer, Double> result = new HashMap<>();
        var counter = values.stream().collect(Collectors.groupingBy(value -> value, Collectors.counting()));
        for (int value : values) {
            result.put(value, 1.0 / values.size() * counter.get(value));
        }
        return result;
    }

    //______________________________________________________________________________________________________________|
    //                                             Hexlet Solution                                                  |
    private static long countElements(List<Integer> elements, int element) {
        return elements.stream()
                .filter(currentElement -> currentElement == element)
                .count();
    }

    private static Map<Integer, Double> findProbabilityForElement(List<Integer> elements, int element) {
        List<Integer> filtered = IntStream.range(1, elements.size())
                .filter(index -> elements.get(index - 1) == element)
                .mapToObj(i -> elements.get(i))
                .toList();
        return filtered.stream()
                .distinct()
                .collect(Collectors.toMap(
                        Function.identity(),
                        current -> (double) countElements(filtered, current) / filtered.size()
                ));
    }

    public static Map<Integer, Map<Integer, Double>> HEXLET_calculateProbabilities(List<Integer> droppedNumbers) {
        return droppedNumbers.stream()
                .distinct()
                .collect(Collectors.toMap(
                        Function.identity(),
                        current -> findProbabilityForElement(droppedNumbers, current)
                ));
    }

    //**************************************************************************************************************|
    //                                        Find variables in conf file                                           |
    //______________________________________________________________________________________________________________|
    //                                         My Solution same as Hexlet                                           |

    // var content = Files.readString(Path.of("src/main/resources/s2.conf"));
    public static String getForwardedVariables(String content) {
        // Создаем поток строк, разделяя исходную по символу переноса строки
        return Stream.of(content.split("\r\n")) // "\r\n" для Windows Line Separator
                // Фильтруем те, которые начинаются с "environment"
                .filter(line -> line.startsWith("environment"))
                // Удаляем "environment" и двойные кавычки из каждой строки
                .map(line -> line.substring(13, line.length() - 1))
                // Создаем поток из массива строк, элементы массива - строки, разделенные запятой,
                // Чтобы каждая переменная была представлена своей строкой
                .map(line -> line.split(","))
                // Соединяем все обратно в поток строк
                .flatMap(Arrays::stream)
                // Удаляем из потока, строки, не начинающиеся с "X_FORWARDED_"
                .filter(line -> line.startsWith("X_FORWARDED_"))
                // Удаляем из каждой строки "X_FORWARDED_"
                .map(line -> line.substring(12))
                // Собираем все в одну строку с разделителем в виде запятой
                .collect(Collectors.joining(","));
    }
}
