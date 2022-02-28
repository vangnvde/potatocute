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
 * @author Vang Nguyen
 */
@WebServlet(name = "DoFilterControll", urlPatterns = {"/DoFilterControll"})
public class DoFilterControll extends HttpServlet {

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
        String filter = request.getParameter("filter");
        String id = request.getParameter("id");
        List<Film> listF = new ArrayList<>();
        List<Film> listTR = new ArrayList<>();
        List<Film> listTV = new ArrayList<>();
        List<Comment> listC = new ArrayList<>();
        List<FilmType> listType = new ArrayList<>();
        List<Distributor> listDistributor = new ArrayList<>();
        List<Director> listDirector = new ArrayList<>();
                 
        DAO dao = new DAO();   
        if (filter.equals("Type")) {
            listF = dao.getFilmByType(id);
        } else if(filter.equals("Director")){
             listF = dao.getFilmByDirector(id);
        } else if(filter.equals("Distributor")){
             listF = dao.getFilmByDistributor(id);
        }
        
        listTR = dao.getTopRatingFilm();
        listTV = dao.getTopViewFilm();
        listC = dao.getNewComment();       
        request.setAttribute("listFull", 1);
       
        listType = dao.getAllFilmType();                    
        listDirector = dao.getAllDirector();                     
        listDistributor = dao.getAllDistributor();
        request.setAttribute("listType", listType);
        request.setAttribute("listDirector", listDirector);   
        request.setAttribute("listDistributor", listDistributor);
        request.setAttribute("listFilmPopular", listF);      
        request.setAttribute("listFilmTopRating", listTR); 
        request.setAttribute("listFilmTopView", listTV); 
        request.setAttribute("listNewComment", listC); 
        request.getRequestDispatcher("index.jsp").forward(request, response);
        
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
            Logger.getLogger(DoFilterControll.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(DoFilterControll.class.getName()).log(Level.SEVERE, null, ex);
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
