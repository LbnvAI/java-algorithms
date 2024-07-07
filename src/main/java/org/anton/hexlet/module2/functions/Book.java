package org.anton.hexlet.module2.functions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Book {
    private String title;
    private String author;
    private int published;
    private int pagesCount;
}
