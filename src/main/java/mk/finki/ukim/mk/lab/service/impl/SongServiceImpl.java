package mk.finki.ukim.mk.lab.service.impl;


import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.model.Song;
import mk.finki.ukim.mk.lab.repository.InMemorySongRepository;
import mk.finki.ukim.mk.lab.service.SongService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {

    private final InMemorySongRepository songRepository;

    public SongServiceImpl(InMemorySongRepository songRepository) {
        this.songRepository = songRepository;
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
    public Song findByTrackId(String trackId) {
        return songRepository.findByTrackId(Long.valueOf(trackId)).orElseThrow(IllegalArgumentException::new);
    }
}
