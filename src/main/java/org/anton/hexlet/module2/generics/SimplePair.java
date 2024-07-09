package org.anton.hexlet.module2.generics;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public final class SimplePair<L, R> implements Pair<L, R> {

    private L left;
    private R right;

}
