package org.anton.hexlet.module2.streams;

class Util {
    public static String[] chunk(String text, int chunkSize) {
        return text.split("(?<=\\G.{" + chunkSize + "})");
    }
}