/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet.tools;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author KittyG
 */
public class CaptchaCheckServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            HttpSession session=request.getSession();
            String code = (String)session.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
            String captcha= (String)request.getParameter("captcha");
            if(code.equals(captcha)){
                out.write("1");
            }else{
                out.write("0");
            }
        } finally {            
            out.close();
        }
//        response.setStatus(404);
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    try {
        out.print("Hello world!");
    } finally {            
            out.close();
        }
     response.setStatus(200);
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
