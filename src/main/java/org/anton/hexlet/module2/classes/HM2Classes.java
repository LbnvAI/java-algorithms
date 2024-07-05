package org.anton.hexlet.module2.classes;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;

public class HM2Classes {
    //**************************************************************************************************************|
    //                                                   Library                                                    |
    //______________________________________________________________________________________________________________|
    //                                                 My Solution                                                  |
    public static Book[] find(Book[] library, Book book) {
        ArrayList<Integer> bookPosition = new ArrayList<>();
        for (int i = 0; i < library.length; i++) {
            if (library[i].equals(book)) bookPosition.add(i);
        }
        Book[] result = new Book[bookPosition.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = library[bookPosition.get(i)];
        }
        return result;
    }

    //______________________________________________________________________________________________________________|
    //                                              Hexlet Solution                                                 |
    public static Book[] HEXLET_find(Book[] library, Book book) {
        var result = new Book[library.length];
        var index = 0;
        for (var currentBook : library) {
            if (currentBook.equals(book)) {
                result[index] = currentBook;
                index++;
            }
        }
        return Arrays.copyOf(result, index);
    }

}
