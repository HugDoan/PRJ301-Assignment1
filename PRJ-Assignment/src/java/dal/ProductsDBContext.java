/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import dal.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Products;

/**
 *
 * @author Admin
 */
public class ProductsDBContext extends DBContext<Products> {

    @Override
    public void insert(Products model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Products model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Products model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Products> list() {
        ArrayList<Products> pl = new ArrayList<>();
        PreparedStatement stm = null;
        try {
            String sql = "SELECT  [pId]\n"
                    + "      ,[pName]\n"
                    + "      ,[quantity]\n"
                    + "  FROM [Products]";
            stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Products p = new Products();
                p.setpId(rs.getInt("pId"));
                p.setpName(rs.getNString("pName"));
                p.setQuantity(rs.getInt("quantity"));
                pl.add(p);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductsDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stm.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductsDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return pl;
    }

    @Override
    public Products get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
