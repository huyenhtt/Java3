/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import model.Ram;
import JDBC.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class RamRepository {

    public ArrayList<Ram> getAll() {
        ArrayList<Ram> list = new ArrayList<>();
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "select * from Ram";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString(1);
                String ma = rs.getString(2);
                String dungLuong = rs.getString(3);
                Ram ram = new Ram(id, ma, dungLuong);
                list.add(ram);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public void insert(Ram ram) {
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "insert into Ram (Ma, DungLuong) values(?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ram.getMa());
            ps.setString(2, ram.getDungLuong());
            ps.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void update(Ram ram, String id) {
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "update Ram set Ma = ?, DungLuong = ? where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ram.getMa());
            ps.setString(2, ram.getDungLuong());
            ps.setString(3, ram.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void delete(String id) {
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "delete from Ram where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public List<Ram> searchRAM(String ma) {
        List<Ram> listRam = new ArrayList<>();
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "Select Id,Ma,DungLuong Where Ma=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            ps.executeUpdate();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("Id");
                String dungLuong = rs.getString("DungLuong");
                Ram ram = new Ram(id, ma, dungLuong);
                listRam.add(ram);
            }
            return listRam;
        } catch (Exception ex) {
            // Logger.getLogger(HoaDonRepo.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return null;
    }
}
