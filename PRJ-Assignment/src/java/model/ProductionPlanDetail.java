/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class ProductionPlanDetail {
    private ProductionPlanHeader header;
    private int sid;
    private java.sql.Date date;
    private int quantity;

    public ProductionPlanDetail(ProductionPlanHeader header, int sid, java.sql.Date date, int quantity) {
        this.header = header;
        this.sid = sid;
        this.date = date;
        this.quantity = quantity;
    }

    public ProductionPlanDetail() {
    }

    public ProductionPlanHeader getHeader() {
        return header;
    }

    public void setHeader(ProductionPlanHeader header) {
        this.header = header;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public java.sql.Date getDate() {
        return date;
    }

    public void setDate(java.sql.Date date) {
        this.date = date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
