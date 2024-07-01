package org.anton.hexlet.module2.lists;


import java.util.*;


public class HM2Lists {
    //**************************************************************************************************************|
    //                                          Reverse Polish Notation, RPN                                        |
    //______________________________________________________________________________________________________________|
    //                                                 My Solution                                                  |
    //                                                                                                              |
    public static int calcInPolishNotation(String expression) {
        int var1 = 0, var2 = 0, pos = 0, result = 0;
        ArrayList<String> signs = new ArrayList<>(Arrays.asList("+", "-", "*", "/"));
        String[] splitExpression = expression.split(" ");
        LinkedList<String> expressionList = new LinkedList<>(Arrays.asList(splitExpression));
        while (expressionList.size() != 1) {
            if (signs.contains(expressionList.get(pos))) {
                var1 = Integer.parseInt(expressionList.get(pos - 2));
                var2 = Integer.parseInt(expressionList.get(pos - 1));
                result = calculate(var1, var2, expressionList.get(pos));
                expressionList.remove(pos);
                expressionList.add(pos, Integer.toString(result));
                expressionList.remove(pos - 1);
                expressionList.remove(pos - 2);
                pos = 0;
            }
            pos++;
        }
        return Integer.parseInt(expressionList.getFirst());
    }

    private static int calculate(int var1, int var2, String sign) {
        switch (sign) {
            case "+":
                return var1 + var2;
            case "-":
                return var1 - var2;
            case "*":
                return var1 * var2;
            case "/": {
                if (var2 == 0) throw new ArithmeticException();
                else return var1 / var2;
            }
            default:
                throw new ArithmeticException();
        }
    }

    //______________________________________________________________________________________________________________|
    //                                             Hexlet Solution                                                  |
    //                                                                                                              |
    public static int HEXLET_calcInPolishNotation(String expression) {
        String[] values = expression.split(" ");
        var stack = new LinkedList<Integer>();
        var operators = List.of("+", "-", "*", "/");

        for (var value : values) {
            if (!operators.contains(value)) {
                stack.add(Integer.parseInt(value));
                continue;
            }
            var b = stack.pollLast();
            var a = stack.pollLast();
            var result = calculate(a, b, value);
            stack.add(result);
        }
        return stack.pollLast();
    }

    //**************************************************************************************************************|
    //                                              Longest Substring                                               |
    //______________________________________________________________________________________________________________|
    //                                                 My Solution                                                  |
    public static int getLongestLength(String symbols) {
        if (symbols.isEmpty()) return 0;
        else if (symbols.length() == 1) return 1;
        else {
            for (int i = symbols.length(); i > 1; i--) {
                if (checkSubstring(createSubstrings(symbols, i))) return i;
            }
        }
        return 1;
    }

    private static String[] createSubstrings(String line, int subLength) {
        String[] substrings = new String[line.length() - subLength + 1];
        for (int i = 0; i < substrings.length; i++) {
            substrings[i] = line.substring(i, i + subLength);
        }
        return substrings;
    }

    private static boolean checkSubstring(String[] substrings) {
        for (String substring : substrings) {
            char[] chars = substring.toCharArray();
            HashSet<Character> set = new HashSet<>();
            for (char c : chars) {
                set.add(c);
            }
            if (substring.length() == set.size()) return true;
        }
        return false;
    }

    //______________________________________________________________________________________________________________|
    //                                             Hexlet Solution                                                  |
    //                                                                                                              |
    public static int HEXLET_getLongestLength(String str) {
        var sequence = new ArrayList<Character>();
        var maxLength = 0;
        for (var currentChar : str.toCharArray()) {
            var index = sequence.indexOf(currentChar);
            sequence.add(currentChar);
            if (index != -1) {
                sequence.subList(0, index + 1).clear();
            }
            int sequenceLength = sequence.size();
            if (sequenceLength > maxLength) {
                maxLength = sequenceLength;
            }
        }
        return maxLength;
    }
}





























































