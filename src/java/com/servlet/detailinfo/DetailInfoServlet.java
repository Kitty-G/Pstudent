/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet.detailinfo;

import com.javabean.std_info.d_info;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author KittyG
 */
public class DetailInfoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
                HttpSession session = request.getSession();
                String stdid=(String)session.getAttribute("stdid");
                String rname=request.getParameter("rname");
                int sex=Integer.parseInt(request.getParameter("sex"));
                String id=request.getParameter("id");
                String major=request.getParameter("major");
                String grade=request.getParameter("grade");
                String class_no=request.getParameter("class");
                String tel=request.getParameter("tel");
                String email1=request.getParameter("email1");
                String email2=request.getParameter("email2");
                String addr=request.getParameter("addr");
                int result;
                String output=rname+" "+sex+" "+id+" "+major+" "+grade+" "+class_no+" "+tel+" "+email1+"@"+email2+" "+addr;
//                out.println("<script>alert('"+output+"');</script>");
                
                System.out.println(output);
//                d_info d_info=new d_info(stdid,rname,sex,id,major,grade,class_no,tel,email1+"@"+email2,addr);
//                result=d_info.dataUpdate();
//                System.out.println("result is "+result);
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
            Logger.getLogger(DetailInfoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
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
            Logger.getLogger(DetailInfoServlet.class.getName()).log(Level.SEVERE, null, ex);
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
