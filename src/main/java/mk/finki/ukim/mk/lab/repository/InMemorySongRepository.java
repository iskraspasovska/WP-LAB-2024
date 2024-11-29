package mk.finki.ukim.mk.lab.repository;



import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Album;
import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.model.Song;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemorySongRepository {
    public List<Song> findAll(){
        return DataHolder.songs;
    }

    public Optional<Song> findByTrackId(Long trackId){
        return DataHolder.songs.stream().filter(s -> s.getTrackId().equals(trackId)).findFirst();
    }

    public Artist addArtistToSong(Artist artist, Song song) {
        if(song.getPerformers().contains(artist)) {return artist;}
        Song song1 = DataHolder.songs.stream().filter(s-> s.getTrackId().equals(song.getTrackId())).findFirst().get();

        song1.getPerformers().add(artist);
        return artist;
    }

    public List<String> findNamesByArtistId(Artist artist) {
        List <Song> songs = DataHolder.songs.stream().filter(s -> s.getPerformers().contains(artist)).toList();
        List<String> names = new ArrayList<>();
        songs.forEach(song -> {names.add(song.getTitle());});
        return names;
    }

    public void saveSong(Long trackId, String title, String genre, String releaseDate, Album album) {
        DataHolder.songs.add(new Song(trackId, title, genre, Integer.parseInt(releaseDate), album));
    }

    public Optional<Song> findById(Long id) {
        return DataHolder.songs.stream().filter(s -> s.getId().equals(id)).findFirst();
    }

    public void deleteById(Long id) {
        DataHolder.songs.removeIf(s -> s.getId().equals(id));
    }
}
