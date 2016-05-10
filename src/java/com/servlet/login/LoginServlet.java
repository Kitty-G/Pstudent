/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet.login;

import com.javabean.common.User.Identity;
import com.javabean.login.LoginWorker;
import com.javabean.tools.CaptchaChecker;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author zxli
 */
public class LoginServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            HttpSession session;
            String userId;
            String password;
            String captchaCode;
            int userType;
            Identity identity;
            CaptchaChecker captchaChecker;
            LoginWorker loginWorker;

            session = request.getSession();
            userId = request.getParameter("UserId");
            captchaCode = request.getParameter("Captcha");
            password = request.getParameter("Password");
            userType = Integer.parseInt(request.getParameter("UserType"));
            captchaChecker = new CaptchaChecker();
            try {
                identity = Identity.values()[userType];
            } catch (Exception ex) {
//               output return false;
                throw ex;
            }

            if (captchaChecker.CheckCaptcha(captchaCode, session)) {
//                return false;
            }
            loginWorker = new LoginWorker(userId, password, identity);

            if (loginWorker.LoginChecker()) {
                switch (loginWorker.getLogin().getIdentity()) {
                    case User:
                        out.print("<script>alert('bingo');</script>");
                        break;
                    case Administrator:
                        //Administrator UI
                        break;
                    case SuperAdministrator:
                        //Check unique
                        break;
                }
            } else {
                out.print("<script>alert('false');</script>");
//                return false;
            }
        } catch (Exception ex) {
            //
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
