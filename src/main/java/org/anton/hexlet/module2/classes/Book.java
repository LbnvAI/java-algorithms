package org.anton.hexlet.module2.classes;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class Book {
    private String title;
    private String author;
    @EqualsAndHashCode.Exclude
    private int published;
}
