package com.project.medium.model;

import org.springframework.stereotype.Component;

@Component
public class Sendmail {
    private String MY_EMAIL = "khuatphongcg2020@gmail.com";

    private String MY_PASSWORD = "Anhphong97";

    private String href ="";


    private String email = "";
    //https://myaccount.google.com/lesssecureapps setup mail ở dạng nhận mail kém bảo mật

    public String getMY_EMAIL() {
        return MY_EMAIL;
    }

    public void setMY_EMAIL(String MY_EMAIL) {
        this.MY_EMAIL = MY_EMAIL;
    }

    public String getMY_PASSWORD() {
        return MY_PASSWORD;
    }

    public void setMY_PASSWORD(String MY_PASSWORD) {
        this.MY_PASSWORD = MY_PASSWORD;
    }

    public String getEmail() {
        return email;
    }

    public void setFRIEND_EMAIL(String email) {
        this.email = email;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }


}
