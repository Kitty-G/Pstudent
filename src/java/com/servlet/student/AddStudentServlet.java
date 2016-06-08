/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet.student;

import com.javabean.common.Exception.ConvertException;
import com.javabean.common.User.Gender;
import com.javabean.common.User.Identity;
import com.javabean.student.StudentWorker;
import com.javabean.tools.Convert;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author KittyG
 */
public class AddStudentServlet extends HttpServlet {

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
            StudentWorker worker;
            boolean result;
            String userId;
            String password;
            String userName;
            Identity identity;
            Gender gender;
            int grade;
            String majorCode;
            int classNo;
            Date intendedTime;

            userId = request.getParameter("StudentId");
            password = request.getParameter("Password");
            userName = request.getParameter("UserName");
            identity = Identity.User;
            gender = Gender.values()[Integer.parseInt(request.getParameter("Gender"))];
            grade = Integer.parseInt(request.getParameter("Grade"));
            majorCode = request.getParameter("Major");
            classNo = Integer.parseInt(request.getParameter("Class"));
            intendedTime = Convert.ConvertStringToDate(request.getParameter("IntendedTime"), Convert.TimeFormat.YYYYMMDD);

            worker = new StudentWorker(userId, password, userName, identity, gender, grade, majorCode, classNo, intendedTime);
            result = worker.AddStudent();
            if (result) {
                
            } else {

            }

        } catch (ConvertException ex) {
            Logger.getLogger(AddStudentServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {

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
