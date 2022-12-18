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
import model.OCung;

/**
 *
 * @author Admin
 */
public class OCungRepo {

    public ArrayList<OCung> getAll() {
        ArrayList<OCung> list = new ArrayList<>();
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "Select * from OCung";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("Id");
                String ma = rs.getString("Ma");
                String ten = rs.getString("Ten");
                String dungLuong = rs.getString("DungLuong");
                OCung oc = new OCung(id, ma, ten, dungLuong);
                list.add(oc);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);

        }
        return list;
    }
    
    public void insert(OCung oc){
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "Insert into OCung " + "(Ma,Ten,DungLuong)" + " Values(?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, oc.getMa());
            ps.setString(2, oc.getTen());
            ps.setString(3, oc.getDungLuong());
            ps.execute();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);

        }
    }
    public void update(OCung oc, String ma){
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "update OCung set Ma = ?,Ten = ?,DungLuong = ? where Ma = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, oc.getMa());
            ps.setString(2, oc.getTen());
            ps.setString(3, oc.getDungLuong());
            ps.setString(4, ma);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);

        }
    }
    public void delete(String ma){
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "delete from OCung where Ma = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);

        }
    }

}
