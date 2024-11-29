package mk.finki.ukim.mk.lab.service.impl;


import mk.finki.ukim.mk.lab.model.Album;
import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.model.Song;
import mk.finki.ukim.mk.lab.repository.InMemoryAlbumRepository;
import mk.finki.ukim.mk.lab.repository.InMemorySongRepository;
import mk.finki.ukim.mk.lab.service.AlbumService;
import mk.finki.ukim.mk.lab.service.ArtistService;
import mk.finki.ukim.mk.lab.service.SongService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongServiceImpl implements SongService {

    private final InMemorySongRepository songRepository;
    private final InMemoryAlbumRepository albumRepository;

    public SongServiceImpl(InMemorySongRepository songRepository, InMemoryAlbumRepository albumRepository) {
        this.songRepository = songRepository;
        this.albumRepository = albumRepository;
    }

    @Override
    public List<Song> listSongs() {
        return songRepository.findAll();
    }

    @Override
    public Artist addArtistToSong(Artist artist, Song song) {
        return songRepository.addArtistToSong(artist,song);
    }

    @Override
    public Optional<Song> findByTrackId(String trackId) {
        return Optional.of(songRepository.findByTrackId(Long.valueOf(trackId)).orElseThrow(IllegalArgumentException::new));
    }

    @Override
    public List<String> findNamesByArtist(Artist artist) {
        return songRepository.findNamesByArtistId(artist);
    }

    @Override
    public void saveSong(Long trackId, String title, String genre, String releaseDate, String albumId) {
        Album album = albumRepository.findById(Long.valueOf(albumId));
        songRepository.saveSong(trackId, title, genre, releaseDate, album);
    }


    @Override
    public Optional<Song> findById(Long id) {
        return songRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        if(findById(id).isPresent()) {
            songRepository.deleteById(id);
        } else throw new IllegalArgumentException("Song not found");
    }

    @Override
    public void update(Long songId, Long trackId, String title, String genre, String releaseDate, String albumId) {
        if(findById(songId).isPresent()) {
            songRepository.deleteById(songId);
            Album newAlbum = albumRepository.findById(Long.valueOf(albumId));
            songRepository.saveSong(trackId, title, genre, releaseDate, newAlbum);
        } else {
            saveSong(trackId, title, genre, releaseDate, albumId);
        }
    }
}
