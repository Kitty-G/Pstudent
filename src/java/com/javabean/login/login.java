package com.javabean.login;
public class login {
    private String usr;
    private String pwd;
    private String captcha;
    public login(){
        usr=null;
        pwd=null;
        captcha=null;
    }

    public login(String user,String password,String captchacode){
        usr=user;
        pwd=password;
        captcha=captchacode;
    }
    public String getUsr() {
        return usr;
    }

    public String getPwd() {
        return pwd;
    }
    
    public String getCaptcha() {
        return captcha;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    
    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }
}
