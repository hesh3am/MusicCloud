package com.example.hesham.musiccloud;

/*
 * Created by Hesham on 01-Jul-18.
 */

public class MusicType {

    private String singer_name;
    private String song_name;
    private int song_image;

    public MusicType(String singerName, String songName, int songImage) {
        singer_name = singerName;
        song_name = songName;
        song_image = songImage;
    }

    public MusicType(String singerName, String songName) {
        singer_name = singerName;
        song_name = songName;
    }

    public String getVersionName() {
        return singer_name;
    }

    public String getVersionNumber() {
        return song_name;
    }

    public int getImageResourceId() {
        return song_image;
    }
}
