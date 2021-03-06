/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controll;

import dao.DAO;
import entity.Comment;
import entity.Director;
import entity.Distributor;
import entity.Film;
import entity.FilmType;
import entity.Review;
import entity.Trailer;
import entity.User;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Vang Nguyen
 */
@WebServlet(name = "LoadFilmDetail", urlPatterns = {"/LoadFilmDetail"})
public class LoadFilmDetail extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        int id = Integer.parseInt(request.getParameter("idF"));
        List<Comment> listC = new ArrayList<>();
        List<FilmType> listType = new ArrayList<>();
        List<Distributor> listDistributor = new ArrayList<>();
        List<Director> listDirector = new ArrayList<>();
        HttpSession s = request.getSession();
        User u = (User) s.getAttribute("User");
        DAO dao = new DAO();
        Film film = dao.getFilmInfo(id);
        Trailer trailer = dao.getTrailer(id);
        if (u != null) {
            Review review = dao.getListReview(id, u.getId());
            request.setAttribute("r", review);
        }
        listType = dao.getAllFilmType();
        listDirector = dao.getAllDirector();
        listDistributor = dao.getAllDistributor();

        listC = dao.getListCommentFilm(id);
         request.setAttribute("e", trailer);
        request.setAttribute("listType", listType);
        request.setAttribute("listDirector", listDirector);
        request.setAttribute("listDistributor", listDistributor);
        request.setAttribute("o", film);
        request.setAttribute("listC", listC);
        request.setAttribute("pageTitle", film.getNameFilm());
        request.getRequestDispatcher("film-details.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(LoadFilmDetail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(LoadFilmDetail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
