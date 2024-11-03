package mk.finki.ukim.mk.lab.bootstrap;


import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.model.Song;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Artist> artists = new ArrayList<>();
    public static List<Song> songs = new ArrayList<>();

    @PostConstruct
    public void init(){
        artists.add(new Artist("Michael", "Jackson", "Michael Joseph Jackson was an American singer, songwriter, dancer, and philanthropist. Dubbed the \"King of Pop\", he is regarded as one of the most significant cultural figures of the 20th century. "));
        artists.add(new Artist("Lady", "Gaga", "Stefani Joanne Angelina Germanotta, known professionally as Lady Gaga, is an American singer, songwriter and actress. Known for her image reinventions and versatility across the entertainment industry, she is an influential figure in popular music and regarded as a pop icon."));
        artists.add(new Artist("Mariah", "Carey", "Mariah Carey is an American singer, songwriter, record producer, and actress. Referred to as the \"Songbird Supreme\" by Guinness World Records, she is known for her five-octave vocal range, melismatic singing style and signature use of the whistle register."));
        artists.add(new Artist("Madonna", "/", "Madonna Louise Ciccone is an American singer, songwriter, and actress. Regarded as the \"Queen of Pop\", she has been recognized for her continual reinvention and versatility in music production, songwriting and visual presentation."));
        artists.add(new Artist("Eminem", "/", "Marshall Bruce Mathers III, known professionally as Eminem, is an American rapper, songwriter, and record producer. He is credited with popularizing hip hop in Middle America and is regarded as among the greatest rappers of all time."));
        songs.add(new Song("Thriller", "Dance Pop", 1982));
        songs.add(new Song("Bad Romance", "Dance Pop", 2009));
        songs.add(new Song("All I Want For Christmas Is You", "Christmas music", 1994));
        songs.add(new Song("Hung Up", "Pop", 2005));
        songs.add(new Song("Lose Yourself", "Hip-hop", 2002));
    }
}