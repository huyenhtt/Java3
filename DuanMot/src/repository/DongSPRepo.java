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
import model.DongSP;

/**
 *
 * @author Admin
 */
public class DongSPRepo {

    public ArrayList<DongSP> getAll() {
        ArrayList<DongSP> list = new ArrayList<>();
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "select * from DongSP";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("Id");
                String ma = rs.getString("Ma");
                String ten = rs.getString("Ten");
                DongSP dsp = new DongSP(id, ma, ten);
                list.add(dsp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);

        }
        return list;
    }

    public void insert(DongSP dsp) {
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "Insert into DongSP " + "(Ma,Ten)" + " Values(?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, dsp.getMa());
            ps.setString(2, dsp.getTen());
            ps.execute();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);

        }
    }

    public static void main(String[] args) {
        new DongSPRepo().insert(new DongSP("", "dsp01", "acer"));
    }

    public void update(DongSP dsp, String ma) {
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "update DongSP set Ma = ?,Ten = ? where Ma = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, dsp.getMa());
            ps.setString(2, dsp.getTen());
            ps.setString(3, ma);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);

        }
    }

    public void delete(String ma) {
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "delete from DongSP where Ma = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);

        }
    }

}
