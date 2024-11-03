/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package dal;

import dal.DBContext;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.*;
import model.Department;
import model.Employee;

import model.Product;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.ProductionPlan;
import model.ProductionPlanHeader;

/**
 *
 * @author Admin
 */
@WebServlet(name = "ProductionPlanHeaderDBContext", urlPatterns = {"/ProductionPlanHeaderDBContext"})
public class ProductionPlanHeaderDBContext extends DBContext<ProductionPlanHeader> {

    @Override
    public void insert(ProductionPlanHeader model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(ProductionPlanHeader model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(ProductionPlanHeader model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<ProductionPlanHeader> list() {
        ArrayList<ProductionPlanHeader> pplist = new ArrayList<>();
        PreparedStatement stm = null;
        try {
            String sql = "SELECT pl.plid,pl.plname, pl.startdate, pl.enddate, ph.quantity, p.pname, ph.estimatedeffort  FROM PlanHeaders ph\n"
                    + "inner join Plans pl on pl.plid = ph.plid\n"
                    + "inner join Products p on p.pid = ph.pid\n"
                    + "where 1 = 1";

            stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                ProductionPlanHeader ph = new ProductionPlanHeader();
                ph.setQuantity(rs.getInt("quantity"));
                ph.setEstimatedeffort(rs.getFloat("estimatedeffort"));

                ProductionPlan pl = new ProductionPlan();
                pl.setName(rs.getNString("plname"));
                pl.setStart(rs.getDate("startdate"));
                pl.setEnd(rs.getDate("enddate"));
                pl.setId(rs.getInt("plid"));
                ph.setPlan(pl);

                Product p = new Product();
                p.setName(rs.getNString("pname"));
                ph.setProduct(p);

                pplist.add(ph);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductionPlanHeaderDBContext.class.getName())
                    .log(Level.SEVERE, null, ex);
        } finally {
            try {
                stm.close();
                connection.close();

            } catch (SQLException ex) {
                Logger.getLogger(ProductionPlanHeaderDBContext.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        }
        return pplist;
    }

    @Override
    public ProductionPlanHeader get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
