package mk.finki.ukim.mk.lab.web.controller;

import mk.finki.ukim.mk.lab.model.Album;
import mk.finki.ukim.mk.lab.model.Song;
import mk.finki.ukim.mk.lab.service.AlbumService;
import mk.finki.ukim.mk.lab.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/songs")
public class SongController {
    private final SongService songService;
    private final AlbumService albumService;

    public SongController(SongService songService, AlbumService albumService) {
        this.songService = songService;
        this.albumService = albumService;
    }

    @GetMapping
    public String getSongsPage(@RequestParam(required = false) String error, Model model){
        if(error != null && !error.isEmpty()){
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        model.addAttribute("songs", this.songService.listSongs());
        return "listSongs";
    }

    @GetMapping("/{id}")
    public String getSongDetailPage(@PathVariable Long id, Model model){
        if(songService.findById(id).isPresent()){
            Song song = songService.findById(id).get();
            model.addAttribute("song", song);
            return "songDetails";
        } else {
            return "redirect:/songs";
        }
    }

    @PostMapping()
    public String selectSong(@RequestParam Long selectedSong, Model model){
        if(selectedSong != null){
            Song song = songService.findById(selectedSong).get();
            model.addAttribute("song", song);
            return "redirect:/artists?songId=" + selectedSong;
        } else {
            return "redirect:/songs";
        }
    }

    @PostMapping("/add")
    public String saveSong(@RequestParam (required = true) Long trackId,
                           @RequestParam (required = false) Long songId,
                           @RequestParam(required = true)String title,
                           @RequestParam(required = true)String genre,
                           @RequestParam(required = true) String releaseYear,
                           @RequestParam(required = true)String albumId){
        if(songId != null){
            this.songService.update(songId, trackId, title, genre, releaseYear, albumId);
        }else{
            this.songService.saveSong(trackId, title, genre, releaseYear, albumId);
        }
        return "redirect:/songs";
    }

    @GetMapping("/add-form")
    public String getAddSongPage(Model model){
        List<Album> albums = albumService.findAll();
        model.addAttribute("albums", albums);
        return "add-song";
    }

    @GetMapping("/edit/{id}")
    public String editProductPage(@PathVariable Long id,
                                  Model model) {
        if (this.songService.findById(id).isPresent()) {
            Song song = songService.findById(id).get();
            model.addAttribute("song", song);
            List<Album> albums = albumService.findAll();
            model.addAttribute("albums", albums);
            return "add-song";
        }
        return "redirect:/song?error=SongNotFound";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteSong(@PathVariable Long id){
        if(this.songService.findById(id).isPresent()){
            this.songService.deleteById(id);
            return "redirect:/songs";
        }
        return "redirect:/song?error=SongNotFound";
    }

}
