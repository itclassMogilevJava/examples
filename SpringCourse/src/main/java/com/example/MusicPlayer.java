package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class MusicPlayer {

    private Map<String, Music> musicList;
    @Value("${musicPlayer.name}")
    private String name;
    @Value("${musicPlayer.volume}")
    private int volume;

    @Autowired
    public MusicPlayer(Map<String, Music> musicList) {
        this.musicList = musicList;
    }

    public void play() {
        musicList.forEach((k, v) -> System.out.println(k + " ___ " + v.getSong()));
    }


    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setName(String name) {
        this.name = name;
    }
}
