package mk.finki.ukim.mk.lab.model;

import lombok.Data;
import mk.finki.ukim.mk.lab.bootstrap.DataHolder;

import java.util.ArrayList;
import java.util.List;

@Data
public class Song {
    private Long id;
    private Long trackId;
    private String title;
    private String genre;
    int releaseYear;
    List<Artist> performers;
    private Album album;

    public Song(String title, String genre, int releaseYear, Album album) {
        this.id = (long) (Math.random() * 1000);
        this.trackId = (long) (Math.random() * 1000);
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.performers = new ArrayList<>();
        this.album = album;
    }

    public Song(Long trackId, String title, String genre, int releaseYear, Album album) {
        this.id = (long) (Math.random() * 1000);
        this.trackId = trackId;
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.album = album;
    }
}
