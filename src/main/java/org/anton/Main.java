package org.anton;

import org.anton.hexlet.module2.maps.HM2Maps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.anton.hexlet.module2.lists.HM2Lists.*;
import static org.anton.hexlet.module2.maps.HM2Maps.HEXLET_scrabble;
import static org.anton.hexlet.module2.maps.HM2Maps.scrabble;

public class Main {
    public static void main(String[] args) {
        var books = new ArrayList<Map<String, String>>();

        var book1 = Map.of("title", "Cymbeline", "author", "Shakespeare", "year", "1611");
        var book2 = Map.of("title", "Book of Fooos", "author", "FooBar", "year", "1111");
        var book3 = Map.of("title", "The Tempest", "author", "Shakespeare", "year", "1611");
        var book4 = Map.of("title", "Book of Foos Barrrs", "author", "FooBar", "year", "2222");
        var book5 = Map.of("title", "Still foooing", "author", "FooBar", "year", "3333");
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
        var where = Map.of(
                "author", "Shakespeare",
                "year", "1611"
        );
        var result = HM2Maps.findWhere(books, where);
        System.out.println(result);
    }
}