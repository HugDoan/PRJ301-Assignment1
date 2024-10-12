    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import model.auth.PPlan;
import dal.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.auth.PPlan;

/**
 *
 * @author Admin
 */
public class ProductionPlanDBContext extends DBContext<PPlan> {

    @Override
    public void insert(PPlan model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(PPlan model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(PPlan model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<PPlan> list() {
        ArrayList<PPlan> ppl = new ArrayList<>();
        PreparedStatement stm = null;
        try {
            String sql = "SELECT [Date]\n"
                    + "      ,[pID]\n"
                    + "      ,[pName]\n"
                    + "      ,[shiftId]\n"
                    + "      ,[quantity]\n"
                    + "      ,[note]\n"
                    + "  FROM [PPlan]";
            stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                PPlan pp = new PPlan();
                pp.setDate(rs.getDate("Date"));
                pp.setpId(rs.getInt("pID"));
                pp.setpName(rs.getNString("pName"));
                pp.setShirftId(rs.getNString("shiftId"));
                pp.setQuantity(rs.getInt("quantity"));
                pp.setNode(rs.getNString("note"));
                ppl.add(pp);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductionPlanDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stm.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductionPlanDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ppl;
    }

    @Override
    public PPlan get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
