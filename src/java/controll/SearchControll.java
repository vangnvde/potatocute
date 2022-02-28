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

/**
 *
 * @author tinqu
 */
@WebServlet(name = "SearchControll", urlPatterns = {"/search"})
public class SearchControll extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        try {
            List<Film> listF = new ArrayList<>();
            List<Film> listTR = new ArrayList<>();
            List<Film> listTV = new ArrayList<>();
            List<Comment> listC = new ArrayList<>();
            List<FilmType> listType = new ArrayList<>();
            List<Distributor> listDistributor = new ArrayList<>();
            List<Director> listDirector = new ArrayList<>();

            String searchQuery = request.getParameter("searchQuery");
            DAO dao = new DAO();
            listTR = dao.getTopRatingFilm();
            listTV = dao.getTopViewFilm();
            listC = dao.getNewComment();
            listType = dao.getAllFilmType();                    
            listDirector = dao.getAllDirector();                     
            listDistributor = dao.getAllDistributor();
            List<Film> searchFilmList = dao.getSearchFilm(searchQuery);
            
            request.setAttribute("listFilmPopular", searchFilmList);
            request.setAttribute("listType", listType);
            request.setAttribute("listDirector", listDirector);
            request.setAttribute("listDistributor", listDistributor);
            request.setAttribute("listFilmTopRating", listTR);
            request.setAttribute("listFilmTopView", listTV);
            request.setAttribute("listNewComment", listC);

            request.setAttribute("pageTitle", searchQuery + " - Kết quả tìm kiếm");
            request.getRequestDispatcher("search.jsp").forward(request, response);
        } catch (SQLException ex) {
            out.println("ERROR:" + ex.getMessage());
        }
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
        processRequest(request, response);
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
        processRequest(request, response);
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
