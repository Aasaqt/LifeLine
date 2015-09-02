package com.lifeline.lifelineforyou.dboperation;

import android.widget.EditText;

public class DBLoginBean {
    String userName,loginId,number,email,address;

    public DBLoginBean()
    {

    }

    public DBLoginBean(String loginId,String userName,String number,String email,String address)
    {
        this.userName=userName;
        this.loginId=loginId;
        this.number=number;
        this.email=email;
        this.address=address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {this.address = address;}

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
