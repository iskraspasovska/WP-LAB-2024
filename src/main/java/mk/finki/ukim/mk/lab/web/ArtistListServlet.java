//package mk.finki.ukim.mk.lab.web;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mk.finki.ukim.mk.lab.model.Artist;
//import mk.finki.ukim.mk.lab.model.Song;
//import mk.finki.ukim.mk.lab.service.ArtistService;
//import mk.finki.ukim.mk.lab.service.SongService;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//import java.util.List;
//
//@WebServlet(urlPatterns = "/artistList")
//public class ArtistListServlet extends HttpServlet {
//    private final ArtistService artistService;
//    private final SongService songService;
//    private final SpringTemplateEngine templateEngine;;
//
//    public ArtistListServlet(ArtistService artistService, SongService songService, SpringTemplateEngine templateEngine) {
//        this.artistService = artistService;
//        this.songService = songService;
//        this.templateEngine = templateEngine;
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        IWebExchange webExchange = JakartaServletWebApplication
//                .buildApplication(getServletContext())
//                .buildExchange(req, resp);
//        WebContext context = new WebContext(webExchange);
//        List<Artist> artistList = this.artistService.listArtists();
//        context.setVariable("artistList", artistList);
//
//        this.templateEngine.process("realArtistsList.html", context, resp.getWriter());
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Long artistId = Long.parseLong(req.getParameter("selectedArtist"));
//        Artist artist = this.artistService.findById(artistId);
//        req.getSession().setAttribute("songs", this.songService.findNamesByArtist(artist));
//        req.getSession().setAttribute("artistId", artistId);
//        resp.sendRedirect("/artistDetails?id=" + artistId);
//    }
//}
