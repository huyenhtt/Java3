/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import JDBC.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Hedieuhanh;
import model.Pin;

/**
 *
 * @author Administrator
 */
public class HeDHRepo {
    
    public List<Hedieuhanh> all() {
        List<Hedieuhanh> listP = new ArrayList<>();
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "select * from HeDieuHanh";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                Hedieuhanh h = new Hedieuhanh(rs.getString(1),rs.getString(2), rs.getString(3));
                listP.add(h);
            }
            return listP;
        } catch (Exception e) {

            e.printStackTrace(System.out);
        }
        return null;

    }

    public boolean insert(Hedieuhanh p) {
       int check = 0;
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "Insert into HeDieuHanh(Ma,Ten) Values(?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getMa());
            ps.setString(2, p.getTenHDH());

            check = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return check > 0;

    }

    public boolean update(Hedieuhanh p, String id) {
       int check = 0;
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "Update HeDieuHanh set ma = ?, ten=? Where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getMa());
            ps.setString(2,p.getTenHDH());
            ps.setString(3, id);

            check= ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PinRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check>0;

    }

    public boolean deletep(String id) {
       int check = 0;
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "Delete From HeDieuHanh Where id=?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);

            check = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PinRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;

    }
}
