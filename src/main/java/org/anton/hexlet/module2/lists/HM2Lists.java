package org.anton.hexlet.module2.lists;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//**************************************************************************************************************|
//                                          Reverse Polish Notation, RPN                                        |
//**************************************************************************************************************|
//                                                                                                              |
//                                                 My Solution                                                  |

public class HM2Lists {
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
//                                                                                                              |
//                                             Hexlet Solution                                                  |
//                                                                                                              |
    public static int HEXLET_calcInPolishNotation(String expression) {
        String[] values = expression.split(" ");
        var stack = new LinkedList<Integer>();
        var operators = List.of("+", "-", "*", "/");

        for (var value: values) {
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
}

