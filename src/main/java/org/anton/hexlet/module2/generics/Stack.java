package org.anton.hexlet.module2.generics;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.List;

//**************************************************************************************************************|
//                                          Create generic class Stack                                          |
//______________________________________________________________________________________________________________|
//                                          My Solution same as Hexlet                                          |
public class Stack <T> {
    List<T> stack = new LinkedList<>();

    public T push(T value) {
        stack.addFirst(value);
        return value;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public T pop() {
        if (stack.isEmpty()) throw new EmptyStackException();
        else {
            var value = stack.getFirst();
            stack.removeFirst();
            return value;
        }
    }

    public T peek() {
        if (stack.isEmpty()) throw new EmptyStackException();
        else return stack.getFirst();
    }
}
