package org.anton.hexlet.module2.generics;

import java.util.function.Function;

//**************************************************************************************************************|
//                                      Convert one type to another using lambda                                |
//______________________________________________________________________________________________________________|
//                                            My Solution same as Hexlet                                        |
public class FunctionConverter<T, U> implements Converter<T, U> {
    public FunctionConverter(Function<T, U> fn) {
        this.fn = fn;
    }

    private final Function<T, U> fn;

    @Override
    public U convert(T value) {
        return fn.apply(value);
    }
}
