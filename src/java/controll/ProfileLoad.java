/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controll;

import dao.DAO;
import entity.User;
import java.io.IOException;
import java.sql.SQLException;
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
@WebServlet(name = "ProfileLoad", urlPatterns = {"/profileload"})
public class ProfileLoad extends HttpServlet {

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

        DAO dao = new DAO();
        dao.checkAccountUser(request.getSession(), response);
        User user = (User) request.getSession().getAttribute("User");
        String updateParam = (String) request.getAttribute("updateStatus");
        if (updateParam != null) {
            if (updateParam.equals("success")) {
                request.setAttribute("updateStatus", true);
            } else {
                request.setAttribute("updateStatus", false);
            }
        }

        request.setAttribute("detailUser", user);

        try {
            request.setAttribute("pageTitle", user.getFullname() + " - Cập nhật Profile");

            request.setAttribute("listType", dao.getAllFilmType());
            request.setAttribute("listDirector", dao.getAllDirector());
            request.setAttribute("listDistributor", dao.getAllDistributor());
            request.setAttribute("listAllFilms", dao.getAllFilm());
            request.setAttribute("adminCSSFiles", "admin.css");
            request.getRequestDispatcher("profile.jsp").forward(request, response);
        } catch (SQLException ex) {
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
