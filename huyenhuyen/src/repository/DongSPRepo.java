/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import ultinity.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.DongSP;

/**
 *
 * @author Admin
 */
public class DongSPRepo {

    public List<DongSP> all() {
        ArrayList<DongSP> lisdsp = new ArrayList<>();
        try {
            Connection con = DBContext.getConnection();
            String sql = "select Id,Ma,Ten from DongSP";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("Id");
                String ma = rs.getString("Ma");
                String ten = rs.getString("Ten");
                DongSP mm = new DongSP(id, ma, ten);
                lisdsp.add(mm);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lisdsp;
    }

    public void insertDSP(DongSP mau) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "Insert into DongSP " + "(Ma,Ten)" + "Values(?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, mau.getMaD());
            ps.setString(2, mau.getTenD());
            ps.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void updateDSP(String ma, DongSP hh) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "Update DongSP set Ten=? Where Ma=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, hh.getTenD());
            ps.setString(2, ma);
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public String checkMaDSP(String ma) {
        String text = null;
        try {
            Connection conn = DBContext.getConnection();
            String sql = "select Ma from DongSP where Ma=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                text = rs.getString("Ma");

            }
            return text;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void deleteDSP(String ma) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "Delete from DongSP where Ma=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
