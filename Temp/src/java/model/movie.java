/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class movie {
    private int mid;
    private String mtitle;
    private Date date;
    private boolean adultcheck;
    private int cid;
    private category cate;

    public category getCate() {
        return cate;
    }

    public void setCate(category cate) {
        this.cate = cate;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getMtitle() {
        return mtitle;
    }

    public void setMtitle(String mtitle) {
        this.mtitle = mtitle;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isAdultcheck() {
        return adultcheck;
    }

    public void setAdultcheck(boolean adultcheck) {
        this.adultcheck = adultcheck;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }
    
    
}
