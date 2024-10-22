package org.anton.hexlet.module4.music_service;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Song {
    private Long id;
    private String title;
    private String artist;
}
