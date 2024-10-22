/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;


import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.ArrayList;
import model.category;
import model.movie;
import dal.MovieDBContextImpl;
import dal.CategoryDBContext;

/**
 *
 * @author sonnt-local hand-some
 */
public class MovieFilterController extends HttpServlet {
   

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        
        String raw_title = request.getParameter("title");
        String raw_date = request.getParameter("releaseddate");
        String raw_adultonly = request.getParameter("adultonly");
        String raw_cname = request.getParameter("cname");
        
        //validate data - regular expression (XSS,SQL Injection, Command Injection, Business Rules)
        
        
        String title = raw_title;
        Boolean adultonly = (raw_adultonly!=null)&&(!raw_adultonly.equals("both"))
                ?raw_adultonly.equals("male"):null;
        Date releaseddate = (raw_date!=null)&&(!raw_date.isBlank())
                ?Date.valueOf(raw_date):null;
        
        String cname = raw_cname;
        
        MovieDBContextImpl dbMV = new MovieDBContextImpl();
        ArrayList<movie> mvs = dbMV.search(title, releaseddate, adultonly, cname);
        CategoryDBContext dbC = new CategoryDBContext();
        ArrayList<category> cts = dbC.list();
        request.setAttribute("dbC", dbC);
        request.setAttribute("dbMV", dbMV);
        request.getRequestDispatcher("../movie/list.jsp").forward(request, response);
    } 


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
