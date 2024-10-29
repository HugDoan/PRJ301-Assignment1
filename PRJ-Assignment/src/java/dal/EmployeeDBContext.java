/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import model.Employee;
import model.Department;
import model.Salary;
import dal.DBContext;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class EmployeeDBContext extends DBContext<Employee> {

    public ArrayList<Employee> search(Integer eid, String name, Boolean gender, Date from, Date to, String address, Integer did, String phonenumber, Integer sid) {
        String sql = "SELECT e.eid, e.ename, d.did, d.dname, e.phonenumber, e.address, s.sid, s.slevel, s.salary, e.gender, e.dob\n"
                + "FROM Employees e\n"
                + "INNER JOIN Departments d ON e.did = d.did\n"
                + "INNER JOIN Salaries s ON s.sid = e.sid\n"
                + "WHERE 1=1";
        ArrayList<Employee> emps = new ArrayList<>();
        ArrayList<Object> paramValues = new ArrayList<>();

        // Điều kiện tìm kiếm theo id
        if (eid != null) {
            sql += " AND e.eid = ?";
            paramValues.add(eid);
        }
        // Điều kiện tìm kiếm theo tên (LIKE)
        if (name != null && !name.trim().isEmpty()) {
            sql += " AND e.ename LIKE ?";
            paramValues.add("%" + name + "%"); // Sử dụng % trước và sau tên
        }
        // Điều kiện tìm kiếm theo giới tính
        if (gender != null) {
            sql += " AND e.gender = ?";
            paramValues.add(gender ? 1 : 0); // Chuyển boolean thành 1 (nam) và 0 (nữ)
        }
        // Điều kiện tìm kiếm theo địa chỉ (LIKE)
        if (address != null && !address.trim().isEmpty()) {
            sql += " AND e.address LIKE ?";
            paramValues.add("%" + address + "%"); // Sử dụng % trước và sau địa chỉ
        }
        // Điều kiện tìm kiếm theo số điện thoại
        if (phonenumber != null && !phonenumber.trim().isEmpty()) {
            sql += " AND e.phonenumber LIKE ?";
            paramValues.add("%" + phonenumber + "%"); // Tìm kiếm giống LIKE với số điện thoại
        }
        // Điều kiện tìm kiếm theo ngày sinh từ
        if (from != null) {
            sql += " AND e.dob >= ?";
            paramValues.add(from);
        }
        // Điều kiện tìm kiếm theo ngày sinh đến
        if (to != null) {
            sql += " AND e.dob <= ?";
            paramValues.add(to);
        }

        // Điều kiện tìm kiếm theo mã phòng ban
        if (did != null) {
            sql += " AND d.did = ?";
            paramValues.add(did);
        }
        // Điều kiện tìm kiếm theo Salary ID (sid)
        if (sid != null) {
            sql += " AND s.sid = ?";
            paramValues.add(sid);
        }
        PreparedStatement stm = null;

        try {
            // Chuẩn bị câu truy vấn với các tham số
            stm = connection.prepareStatement(sql);
            for (int i = 0; i < paramValues.size(); i++) {
                stm.setObject((i + 1), paramValues.get(i));
            }

            // Thực thi truy vấn
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Employee e = new Employee();
                e.setId(rs.getInt("eid"));
                e.setName(rs.getNString("ename"));
                e.setGender(rs.getBoolean("gender")); // Đọc giá trị giới tính
                e.setDob(rs.getDate("dob"));
                e.setAddress(rs.getNString("address"));
                e.setPhonenumber(rs.getNString("phonenumber")); // Đọc số điện thoại

                Department d = new Department();
                d.setId(rs.getInt("did"));
                d.setName(rs.getNString("dname"));

                e.setDept(d); // Gán phòng ban cho nhân viên

                Salary s = new Salary();
                s.setId(rs.getInt("sid")); // Đọc Salary ID
                s.setLevel(rs.getNString("slevel"));
                s.setSalary(rs.getBigDecimal("salary"));

                e.setSals(s); // Gán Salary ID cho nhân viên

                emps.add(e);

            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (stm != null) {
                    stm.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(EmployeeDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return emps;
    }

    @Override
    public void insert(Employee model) {
        try {
            connection.setAutoCommit(false);
            String sql_insert_employee = "INSERT INTO [Employees]\n"
                    + "           ([ename]\n"
                    + "           ,[did]\n"
                    + "           ,[phonenumber]\n"
                    + "           ,[address]\n"
                    + "           ,[sid]\n"
                    + "           ,[gender]\n"
                    + "           ,[dob]\n"
                    + "           ,[createdby])\n"
                    + "     VALUES\n"
                    + "           (?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement stm_insert_employee = connection.prepareStatement(sql_insert_employee);
            stm_insert_employee.setString(1, model.getName());
            stm_insert_employee.setInt(2, model.getDept().getId());
            stm_insert_employee.setString(3, model.getPhonenumber());
            stm_insert_employee.setString(4, model.getAddress());
            stm_insert_employee.setInt(5, model.getSals().getId());
            stm_insert_employee.setBoolean(6, model.isGender());
            stm_insert_employee.setDate(7, model.getDob());
            stm_insert_employee.setString(8, model.getCreatedby().getUsername());
            stm_insert_employee.executeUpdate();

            String sql_select_employee = "SELECT @@IDENTITY as eid";
            PreparedStatement stm_select_salary = connection.prepareStatement(sql_select_employee);
            ResultSet rs = stm_select_salary.executeQuery();
            if (rs.next()) {
                model.setId(rs.getInt("eid"));
            }

            String sql_insert_salary = "INSERT INTO [Salaries]\n"
                    + "           ([slevel]\n"
                    + "           ,[salary])\n"
                    + "     VALUES\n"
                    + "           (?, ?)";
            PreparedStatement stm_insert_salary = connection.prepareStatement(sql_insert_salary);
            Salary salary = model.getSals(); 

            stm_insert_salary.setString(1, salary.getLevel());
            stm_insert_salary.setBigDecimal(2, salary.getSalary());
            stm_insert_salary.executeUpdate();
            connection.commit();

        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDBContext.class.getName()).log(Level.SEVERE, null, ex);
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(EmployeeDBContext.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(EmployeeDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmployeeDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void update(Employee model) {
            String sql_update_employee = "UPDATE [Employees]\n"
            + "   SET [ename] = ?\n"
            + "      ,[gender] = ?\n"
            + "      ,[dob] = ?\n"
            + "      ,[address] = ?\n"
            + "      ,[did] = ?\n"
            + "      ,[updatedby] = ?\n"
            + "      ,[updatedtime] = GETDATE()\n"
            + " WHERE eid = ?";

    String sql_update_salary = "UPDATE [Salaries]\n"
            + "   SET [slevel] = ?\n"
            + "      ,[salary] = ?\n"
            + " WHERE sid = ?";  // Update based on salary ID (sid)

    PreparedStatement stm_update_employee = null;
    PreparedStatement stm_update_salary = null;

    try {
        // Start a transaction
        connection.setAutoCommit(false);

        // Update Employee table
        stm_update_employee = connection.prepareStatement(sql_update_employee);
        stm_update_employee.setString(1, model.getName());
        stm_update_employee.setBoolean(2, model.isGender());
        stm_update_employee.setDate(3, model.getDob());
        stm_update_employee.setString(4, model.getAddress());
        stm_update_employee.setInt(5, model.getDept().getId());
        stm_update_employee.setString(6, model.getUpdatedby().getUsername());
        stm_update_employee.setInt(7, model.getId());
        stm_update_employee.executeUpdate();

        // Update Salaries table
        stm_update_salary = connection.prepareStatement(sql_update_salary);
            Salary salary = model.getSals(); 

            stm_update_salary.setString(1, salary.getLevel());
            stm_update_salary.setBigDecimal(2, salary.getSalary());
            stm_update_salary.executeUpdate();

        // Commit the transaction
        connection.commit();

    } catch (SQLException ex) {
        Logger.getLogger(EmployeeDBContext.class.getName()).log(Level.SEVERE, null, ex);
        try {
            // Rollback the transaction in case of failure
            connection.rollback();
        } catch (SQLException ex1) {
            Logger.getLogger(EmployeeDBContext.class.getName()).log(Level.SEVERE, null, ex1);
        }
    } finally {
        try {
            if (stm_update_employee != null) stm_update_employee.close();
            if (stm_update_salary != null) stm_update_salary.close();
            connection.setAutoCommit(true);
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }

    @Override
    public void delete(Employee model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Employee> list() {
        ArrayList<Employee> emps = new ArrayList<>();
        PreparedStatement stm = null;
        try {
            String sql = "String sql = \"SELECT e.eid, e.ename, d.did, e.phonenumber, e.address, s.sid, e.gender, e.dob\\n\"\n"
                    + "                + \"FROM Employees e\\n\"\n"
                    + "                + \"INNER JOIN Departments d ON e.did = d.did\\n\"\n"
                    + "                + \"INNER JOIN Salaries s ON s.sid = e.sid\\n\"\n"
                    + "  + \"WHERE 1=1\";";

            stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Employee e = new Employee();
                e.setId(rs.getInt("eid"));
                e.setName(rs.getNString("ename"));
                e.setGender(rs.getBoolean("gender")); // Đọc giá trị giới tính
                e.setDob(rs.getDate("dob"));
                e.setAddress(rs.getNString("address"));
                e.setPhonenumber(rs.getNString("phonenumber")); // Đọc số điện thoại

                Department d = new Department();
                d.setId(rs.getInt("did"));
                d.setName(rs.getNString("dname"));

                e.setDept(d); // Gán phòng ban cho nhân viên

                Salary s = new Salary();
                s.setId(rs.getInt("sid")); // Đọc Salary ID
                s.setLevel(rs.getNString("slevel"));
                s.setSalary(rs.getBigDecimal("salary"));

                e.setSals(s); // Gán Salary ID cho nhân viên

                emps.add(e);

            }

        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDBContext.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stm.close();
                connection.close();

            } catch (SQLException ex) {
                Logger.getLogger(EmployeeDBContext.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        return emps;
    }

    @Override
    public Employee get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
