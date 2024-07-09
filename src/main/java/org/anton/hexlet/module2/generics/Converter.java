package org.anton.hexlet.module2.generics;

public interface Converter<T, U> {
    U convert(T value);
}
