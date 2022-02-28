/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controll;

import dao.DAO;
import entity.FilmType;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
 * @author tinqu
 */
@WebServlet(name = "UpdateFilmTypeControll", urlPatterns = {"/updatefilmtype"})
public class UpdateFilmTypeControll extends HttpServlet {

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
        dao.checkAccountAdmin( request.getSession(), response );
        
        try {
            int idFilmType = Integer.parseInt( request.getParameter("idFilmType") );
            
            String nameFilmType = request.getParameter("nameFilmType");

            boolean updateStatus = dao.updateFilmType(idFilmType, nameFilmType );
            
            FilmType detailFilmType = dao.getFilmTypeInfo(idFilmType);
            request.setAttribute("detailFilmType", detailFilmType);
            request.setAttribute("updateStatus", updateStatus);
            request.setAttribute("pageTitle", detailFilmType.getTypeName()+ " - Chỉnh sửa");
            request.setAttribute("adminCSSFiles", "admin.css");
            
            request.getRequestDispatcher("admin/updateFilmType.jsp").forward(request, response);
        } catch(NumberFormatException ex){
//            System.out.println( "LOIIIIIIIIIIIIIIIIIIIIIIIIIIIII: "+ ex.getMessage() );
//            response.sendRedirect("managefilmtype");
        } catch (SQLException ex) {
            Logger.getLogger(UpdateFilmTypeControll.class.getName()).log(Level.SEVERE, null, ex);
        } catch(Exception ex ){
            System.out.println( "LOIIIIIIIIIIIIIIIIIIIIIIIIIIIII: "+ ex.getMessage() );
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
