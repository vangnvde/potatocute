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
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "HomeControll", urlPatterns = {"/home"})
public class HomeControll extends HttpServlet {

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
            throws ServletException, IOException, Exception {
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
            String pageTitle = "";
            DAO dao = new DAO();
            int listFull = 0;
            try {
                String listFullParam = request.getParameter("viewAll");
                if( listFullParam != null ){
                    listFull = Integer.parseInt( listFullParam );
                    if( listFull != 1 && listFull != 0 ){
                        response.sendRedirect("home");
                    }
                }
            } catch( Exception ex ){
                response.sendRedirect("home");
            }
            
            String pageParam = request.getParameter("page");
            
            int filmPerPage = 21;
            int filmNumber = dao.getNumberOfFilm();
            int pageNumber = filmNumber / filmPerPage;
            if( filmNumber % filmPerPage != 0 ){
                pageNumber++;
            }
            
            int page = 1;
            if( pageParam != null ){
                try {
                    page = Integer.parseInt( pageParam );
                    if( page > pageNumber ){
                        page = pageNumber;
                    } else if( page < 1 ){
                        page = 1;
                    }
                } catch(NumberFormatException ex){
                    page = 1;
                }
            }

//            listF = dao.getAllFilm(); 
            listF = dao.getAllFilmPagination( page, filmPerPage ); 
            listTR = dao.getTopRatingFilm();
            listTV = dao.getTopViewFilm();
            listC = dao.getNewComment();
            if ( listFull == 1 ) {
                request.setAttribute("listFull", 1);
                pageTitle = "Trang "+page+" - Xem tất cả";
            } else{
                request.setAttribute("listFull", 0);
                pageTitle = "Trang chủ";
            }
            listType = dao.getAllFilmType();                    
            listDirector = dao.getAllDirector();                     
            listDistributor = dao.getAllDistributor();
            
            request.setAttribute("pageNumber", pageNumber);
            request.setAttribute("page", page);
            request.setAttribute("pageTitle", pageTitle); 
            request.setAttribute("listType", listType);
            request.setAttribute("listDirector", listDirector);   
            request.setAttribute("listDistributor", listDistributor);
            request.setAttribute("listFilmPopular", listF);      
            request.setAttribute("listFilmTopRating", listTR); 
            request.setAttribute("listFilmTopView", listTV); 
            request.setAttribute("listNewComment", listC); 
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch(NullPointerException ex){
            out.println( "asd"+ ex.getMessage() );
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(HomeControll.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (Exception ex) {
            Logger.getLogger(HomeControll.class.getName()).log(Level.SEVERE, null, ex);
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
