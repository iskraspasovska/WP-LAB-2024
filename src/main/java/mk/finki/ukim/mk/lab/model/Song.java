package mk.finki.ukim.mk.lab.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Song {
    private Long trackId;
    private String title;
    private String genre;
    int releaseYear;
    List<Artist> performers;

    public Song(String title, String genre, int releaseYear) {
        this.trackId = (long) (Math.random() * 1000);
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.performers = new ArrayList<>();
    }
}
