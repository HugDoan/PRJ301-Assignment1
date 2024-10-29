/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
import java.util.ArrayList;
import model.auth.User;

/**
 *
 * @author Admin
 */
public class Employee {

    private int id;
    private String name;
    private Department did;
    private String phonenumber;
    private String address;
    private Salary sid;
    private boolean gender;
    private Date dob;
    private Department dept;
    private Salary sals;
    private User createdby;
    private User updatedby;
    private java.util.Date updatedtime;
    private ArrayList<Salary> salaries = new ArrayList<>();

    public ArrayList<Salary> getSalaries() {
        return salaries;
    }

    public void setSalaries(ArrayList<Salary> salaries) {
        this.salaries = salaries;
    }
    
    public User getCreatedby() {
        return createdby;
    }

    public void setCreatedby(User createdby) {
        this.createdby = createdby;
    }

    public User getUpdatedby() {
        return updatedby;
    }

    public void setUpdatedby(User updatedby) {
        this.updatedby = updatedby;
    }

    public java.util.Date getUpdatedtime() {
        return updatedtime;
    }

    public void setUpdatedtime(java.util.Date updatedtime) {
        this.updatedtime = updatedtime;
    }
    
    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    public Salary getSals() {
        return sals;
    }

    public void setSals(Salary sals) {
        this.sals = sals;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDid() {
        return did;
    }

    public void setDid(Department did) {
        this.did = did;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }



    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Salary getSid() {
        return sid;
    }

    public void setSid(Salary sid) {
        this.sid = sid;
    }
    
    
    



    
}
