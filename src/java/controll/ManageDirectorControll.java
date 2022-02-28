/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controll;

import dao.DAO;
import entity.Director;
import entity.Distributor;
import entity.FilmType;
import java.io.IOException;
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
@WebServlet(name = "ManageDirectorControll", urlPatterns = {"/managedirector"})
public class ManageDirectorControll extends HttpServlet {

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
        List<FilmType> listType = new ArrayList<>();
        List<Distributor> listDistributor = new ArrayList<>();
        List<Director> listDirector = new ArrayList<>();
        DAO dao = new DAO();
        dao.checkAccountAdmin(request.getSession(), response);
        listType = dao.getAllFilmType();
        listDirector = dao.getAllDirector();
        listDistributor = dao.getAllDistributor();
        try {

            request.setAttribute("listType", listType);
            request.setAttribute("listDirector", listDirector);
            request.setAttribute("listDistributor", listDistributor);
            request.setAttribute("pageTitle", "Quản lý Đạo diễn");

            request.setAttribute("listAllDirector", dao.getAllDirector());
            request.setAttribute("adminCSSFiles", "admin.css");
            request.getRequestDispatcher("admin/manageDirector.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ManageFilmControll.class.getName()).log(Level.SEVERE, null, ex);
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
