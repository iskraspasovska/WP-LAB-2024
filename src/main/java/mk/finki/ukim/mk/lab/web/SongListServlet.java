//package mk.finki.ukim.mk.lab.web;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mk.finki.ukim.mk.lab.service.SongService;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//
//@WebServlet (urlPatterns = "/listSongs")
//public class SongListServlet  extends HttpServlet {
//    private final SongService songService;
//    private final SpringTemplateEngine templateEngine;
//
//    public SongListServlet(SongService songService, SpringTemplateEngine templateEngine) {
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
//        context.setVariable("songs", this.songService.listSongs());
//        this.templateEngine.process("listSongs.html", context, resp.getWriter());
//    }
//
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Long trackId = Long.parseLong(req.getParameter("selectedSong"));
//        req.getSession().setAttribute("selectedSong", trackId);
//        resp.sendRedirect("/artist");
//    }
//}
