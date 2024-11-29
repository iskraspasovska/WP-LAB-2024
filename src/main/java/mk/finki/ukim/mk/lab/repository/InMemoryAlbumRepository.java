package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Album;
import mk.finki.ukim.mk.lab.model.Song;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InMemoryAlbumRepository {
    public List<Album> findAll() {
        return DataHolder.albums;
    }

    public Album findById(Long id) {
        return DataHolder.albums.stream().filter(a-> a.getId().equals(id)).findFirst().get();
    }
}
