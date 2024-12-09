package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {
}
