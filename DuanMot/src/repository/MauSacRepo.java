/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import model.MauSac;

/**
 *
 * @author Admin
 */
public class MauSacRepo {

    public List<MauSac> getList() {
        List<MauSac> lisstM = new ArrayList<>();
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "Select * from MauSac";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("Id");
                String ma = rs.getString("Ma");
                String ten = rs.getString("Ten");
                MauSac ms = new MauSac(id, ma, ten);
                lisstM.add(ms);
            }
            return lisstM;
        } catch (SQLException ex) {
            Logger.getLogger(MauSacRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Integer inssertMS(MauSac ms) {
        Integer kq = -1;
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "Insert into MauSac " + "(Ma,Ten)" + " Values(?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ms.getMa());
            ps.setString(2, ms.getTen());
            return kq = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MauSacRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Integer updateMS(MauSac ms, String ma) {
        Integer kq = -1;
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "Update MauSac set Ten=? Where Ma=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ms.getTen());
            ps.setString(2, ma);
            return kq = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MauSacRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public MauSac searchMau(String ma) {
        MauSac ms = null;
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "Select * from MauSac Where Ma=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("Id");
                String ten = rs.getString("Ten");
                ms = new MauSac(id, ma, ten);
            }
            return ms;
        } catch (SQLException ex) {
            Logger.getLogger(MauSacRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Integer deleteMS(String ma) {
        Integer kq = -1;
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "Delete From MauSac Where Ma=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            return kq = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MauSacRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
