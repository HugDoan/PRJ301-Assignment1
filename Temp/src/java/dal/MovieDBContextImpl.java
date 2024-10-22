/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.category;
import model.movie;

public class MovieDBContextImpl extends DBContext<movie> {
     public ArrayList<movie> search (String mtitle, Date releaseddate, Boolean adultonly, String cname){
          ArrayList<movie> mvs = new ArrayList<>();
        ArrayList<category> cts = new ArrayList<>();
        PreparedStatement stm = null;
        try {
            String sql = "SELECT m.mtitle,m.releaseddate,m.adultonly,c.cname\n"
                    + "  FROM Movie m join Category c on m.cid= c.cid";
            stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                movie m = new movie();
                m.setMtitle(rs.getNString("mtitle"));
                m.setDate(rs.getDate("releaseddate"));
                m.setAdultcheck(rs.getBoolean("adultonly"));
                
                category c = new category();
                c.setName(rs.getNString("cname"));
                
                m.setCate(c);
                mvs.add(m);
               
            }

        } catch (SQLException ex) {
            Logger.getLogger(MovieDBContextImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stm.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(MovieDBContextImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return mvs;
     }

    @Override
    public void insert(movie model) {
            PreparedStatement stm = null;
    try {
        String sql = "INSERT INTO Movie (mtitle, releaseddate, adultonly, cid) VALUES (?, ?, ?, ?)";
        stm = connection.prepareStatement(sql);
        stm.setString(1, model.getMtitle());
        stm.setDate(2, new java.sql.Date(model.getDate().getTime()));
        stm.setBoolean(3, model.isAdultcheck());
        stm.setInt(4, model.getCid());
        stm.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(MovieDBContextImpl.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            if (stm != null) stm.close();
            if (connection != null) connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(MovieDBContextImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    }

    @Override
    public void update(movie model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(movie model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<movie> list() {
        ArrayList<movie> mvs = new ArrayList<>();
        ArrayList<category> cts = new ArrayList<>();
        PreparedStatement stm = null;
        try {
            String sql = "SELECT m.mtitle,m.releaseddate,m.adultonly,c.cname\n"
                    + "  FROM Movie m join Category c on m.cid= c.cid";
            stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                movie m = new movie();
                m.setMtitle(rs.getNString("mtitle"));
                m.setDate(rs.getDate("releaseddate"));
                m.setAdultcheck(rs.getBoolean("adultonly"));
                
                category c = new category();
                c.setName(rs.getNString("cname"));
                
                m.setCate(c);
                mvs.add(m);
               
            }

        } catch (SQLException ex) {
            Logger.getLogger(MovieDBContextImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stm.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(MovieDBContextImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return mvs;
    }
}


