/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javabean.tools;

import javax.servlet.http.HttpSession;

/**
 *
 * @author zxli
 */
public class CaptchaChecker {
    //Need better exception operate

    public boolean CheckCaptcha(String captcha, HttpSession session) {
        boolean result;
        try {
            String realCode = (String) session.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
            if (realCode == null) {
                return false;
            }
            result = realCode.equals(captcha);
        } catch (Exception ex) {
            result = false;
        }
        return result;
    }
}
