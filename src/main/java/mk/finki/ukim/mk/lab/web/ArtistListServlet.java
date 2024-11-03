package mk.finki.ukim.mk.lab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.model.Song;
import mk.finki.ukim.mk.lab.service.ArtistService;
import mk.finki.ukim.mk.lab.service.SongService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;


@WebServlet (urlPatterns = "/artist")
public class ArtistListServlet extends HttpServlet {
    private final ArtistService artistService;
    private final SpringTemplateEngine templateEngine;
    private final SongService songService;

    public ArtistListServlet(ArtistService artistService, SpringTemplateEngine templateEngine, SongService songService) {
        this.artistService = artistService;
        this.templateEngine = templateEngine;
        this.songService = songService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);
        WebContext context = new WebContext(webExchange);
        Long trackId = Long.parseLong(req.getSession().getAttribute("selectedSong").toString());
        context.setVariable("trackId", trackId);
        context.setVariable("artists", this.artistService.listArtists());
        this.templateEngine.process("artistsList.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String trackId = req.getSession().getAttribute("selectedSong").toString();
        Long artistId = Long.parseLong(req.getParameter("selectedArtist"));
        Song song = this.songService.findByTrackId(trackId);
        Artist artist = this.artistService.findById(artistId);
        this.songService.addArtistToSong(artist, song);
        resp.sendRedirect("/songDetails?trackId=" + trackId);
    }
}
