package mk.finki.ukim.mk.lab.web.controller;

import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.model.Song;
import mk.finki.ukim.mk.lab.service.ArtistService;
import mk.finki.ukim.mk.lab.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/artists")
public class ArtistController {
    private final ArtistService artistService;
    private final SongService songService;

    public ArtistController(ArtistService artistService, SongService songService) {
        this.artistService = artistService;
        this.songService = songService;
    }

    @GetMapping
    public String listArtists(@RequestParam Long songId, Model model) {
        Song song = songService.findById(songId).get();
        model.addAttribute("song", song);
        List<Artist> artists = artistService.listArtists();
        model.addAttribute("trackId", song.getTrackId());
        model.addAttribute("artists", artists);
        return "artistsList";
    }
    @PostMapping()
    public String addArtist(@RequestParam Long songId, @RequestParam Long selectedArtist, Model model) {
        Song song = songService.findById(songId).get();
        Artist artist = artistService.findById(selectedArtist);
        songService.addArtistToSong(artist, song);
        return "redirect:/songs/" + songId;
    }
}
