/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controll;

import dao.DAO;
import entity.Comment;
import entity.Film;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ReviewFilmControll", urlPatterns = {"/ReviewFilmControll"})
public class ReviewFilmControll extends HttpServlet {

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
        List<Comment> listC = new ArrayList<>();
        String idF = request.getParameter("idF");
        String idU = request.getParameter("idU");
        String review = request.getParameter("review");
        HttpSession s = request.getSession();
        User u = (User) s.getAttribute("User");
        DAO dao = new DAO();
        listC = dao.getListCommentFilm(Integer.parseInt(idF));
        if (review.equals("1")) {
            dao.updateLikeReviewFilm(idF);
            dao.updateUserReview(idF, idU, review);
        } else {
            dao.updateUnlikeReviewFilm(idF);
            dao.updateUserReview(idF, idU, review);
        }
        Film film = dao.getFilmInfo(Integer.parseInt(idF));
        request.setAttribute("r", review);
        request.setAttribute("listC", listC);
        request.setAttribute("o", film);
//        request.getRequestDispatcher("LoadFilmDetail?idF="+idF).forward(request, response);
        response.sendRedirect("LoadFilmDetail?idF="+idF);
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
            Logger.getLogger(ReviewFilmControll.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ReviewFilmControll.class.getName()).log(Level.SEVERE, null, ex);
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
