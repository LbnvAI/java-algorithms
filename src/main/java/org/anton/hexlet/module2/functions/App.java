package org.anton.hexlet.module2.functions;
;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

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
}
