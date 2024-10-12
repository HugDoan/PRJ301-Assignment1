/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.employee;

import controller.auth.BaseRBACController;
import dal.EmployeeDBContext;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import model.Employee;
import model.auth.User;

/**
 *
 * @author Admin
 */
public class EmployeeFilterController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String raw_id = request.getParameter("id");
        String raw_name = request.getParameter("name");
        String raw_gender = request.getParameter("gender");
        String raw_from = request.getParameter("from");
        String raw_to = request.getParameter("to");
        String raw_address = request.getParameter("address");
        String raw_did = request.getParameter("did");

        Integer id = (raw_id != null) && (!raw_id.isBlank())
                ? Integer.parseInt(raw_id) : null;
        String name = raw_name;
        Boolean gender = (raw_gender != null) && (!raw_gender.equals("both"))
                ? raw_gender.equals("male") : null;
        Date from = (raw_from != null) && (!raw_from.isBlank())
                ? Date.valueOf(raw_from) : null;
        Date to = (raw_to != null) && (!raw_to.isBlank())
                ? Date.valueOf(raw_to) : null;
        String adress = raw_address;
        Integer did = (raw_did != null) && (!raw_did.equals("-1"))
                ? Integer.parseInt(raw_did) : null;
//
//        EmployeeDBContext dbEmp = new EmployeeDBContext();
//        ArrayList<Employee> emps = dbEmp.search(id, name, gender, from, to, adress, did);
//        DepartmentDBContext dbDept = new DepartmentDBContext();
//        ArrayList<Department> depts = dbDept.list();

//        request.setAttribute("depts", depts);
//        request.setAttribute("emps", emps);

        request.getRequestDispatcher("../view/employee/filter.jsp").forward(request, response);

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
