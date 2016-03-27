/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet.login;

import com.javabean.login.Login;
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
public class AdminLoginServlet extends HttpServlet {

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
            String user=request.getParameter("stdid_log");
            String pwd =request.getParameter("password_log");
            String captcha=request.getParameter("Captcha_log");
            String code=(String)session.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
            if(code.equals(captcha)){
                Login login=new Login(user,pwd,0);
                int power=login.loginVerify();
                if(power<1){
                    out.println("<script>alert('帐号或密码错误！');</script>");
                    response.setHeader("refresh","0.0001;url=/project/jsp/admin/login.jsp");
//                    response.sendRedirect("/project/jsp/login/login.jsp");
                }else{
//                    out.println("<script>alert('Bingo!"+power+"')</script>");
                    session.setAttribute("adminid", user);
                    session.setAttribute("username",login.getUsername());
                    session.setAttribute("power",power);
                    response.sendRedirect("/project/admin/home.jsp");
                }
            }else{
                out.println("<script>alert('CaptchaError!')</script>");
            }
            session.setAttribute("stdid", user);
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
            Logger.getLogger(AdminLoginServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AdminLoginServlet.class.getName()).log(Level.SEVERE, null, ex);
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
