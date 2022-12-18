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
import model.CongKetNoi;

/**
 *
 * @author Admin
 */
public class CongKetNoiRepo {

    public List<CongKetNoi> getList() {
        List<CongKetNoi> lisstC = new ArrayList<>();
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "Select * from CongKetNoi";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("Id");
                String ma = rs.getString("Ma");
                String ten = rs.getString("Ten");
                CongKetNoi kn = new CongKetNoi(id, ma, ten);
                lisstC.add(kn);
            }
            return lisstC;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);

        }
        return null;
    }

    public Integer inssertKNS(CongKetNoi kn) {
        Integer kq = -1;
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "Insert into CongKetNoi " + "(Ma,Ten)" + " Values(?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, kn.getMa());
            ps.setString(2, kn.getTen());
            return kq = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);

        }
        return null;
    }

    public Integer updateKN(CongKetNoi kn, String ma) {
        Integer kq = -1;
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "Update CongKetNoi set Ten=? Where Ma=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, kn.getTen());
            ps.setString(2, ma);
            return kq = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }

    public CongKetNoi searchKN(String ma) {
        CongKetNoi kn = null;
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "Select * from CongKetNoi Where Ma=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("Id");
                String ten = rs.getString("Ten");
                kn = new CongKetNoi(id, ma, ten);
            }
            return kn;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }

    public Integer deleteMS(String ma) {
        Integer kq = -1;
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "Delete From CongKetNoi Where Ma=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            return kq = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);

        }
        return null;
    }
}
