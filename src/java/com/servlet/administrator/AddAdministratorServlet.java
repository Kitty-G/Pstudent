/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet.administrator;

import com.javabean.administrator.AdministratorWorker;
import com.javabean.common.User.Gender;
import com.javabean.common.User.Identity;
import com.javabean.tables.Administrator.ManageLevel;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author zxli
 */
public class AddAdministratorServlet extends HttpServlet {

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
        request.setCharacterEncoding("utf-8");
        try (PrintWriter out = response.getWriter()) {
            AdministratorWorker worker;
            boolean result;
            String userId;
            String password;
            String userName;
            Identity identity;
            Gender gender;
            ManageLevel manageLevel;
            String telephone;
            String email;

            userId = request.getParameter("AdminId");
            password = request.getParameter("Password");
            userName = request.getParameter("UserName");
            identity = Identity.Administrator;
            gender = Gender.values()[Integer.parseInt(request.getParameter("Gender"))];
            manageLevel = ManageLevel.values()[Integer.parseInt(request.getParameter("Level"))];
            telephone = request.getParameter("Telephone");
            email = request.getParameter("Email");

            worker = new AdministratorWorker(userId, password, userName, identity, gender, manageLevel, telephone, email);
            result = false;
            if (worker.getLogin() != null && worker.getAdministrator() != null) {
                result = worker.AddAdministrator();
            } else {
//                return false
            }
            if (result) {
//                return true
            } else {
//                return false
            }
        }
    }

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
