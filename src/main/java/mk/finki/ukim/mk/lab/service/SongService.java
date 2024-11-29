package mk.finki.ukim.mk.lab.service;



import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.model.Song;

import java.util.List;
import java.util.Optional;

public interface SongService {
    List<Song> listSongs();
    Artist addArtistToSong(Artist artist, Song song);
    public Optional<Song> findByTrackId(String trackId);
    List<String> findNamesByArtist(Artist artist);
    void saveSong(Long trackId, String title, String genre, String releaseDate, String albumId);
    Optional<Song> findById(Long id);

    void deleteById(Long id);

    void update(Long songId, Long trackId, String title, String genre, String releaseDate, String albumId);
}
