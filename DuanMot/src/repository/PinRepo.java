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
import model.Pin;

/**
 *
 * @author Admin
 */
public class PinRepo {

    public List<Pin> all() {
        List<Pin> listP = new ArrayList<>();
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "select * from Pin";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("Id");
                String ma = rs.getString("Ma");
                String dungLuong = rs.getString("DungLuong");
                Pin pin = new Pin(id, ma, dungLuong);
                listP.add(pin);
            }
            return listP;
        } catch (Exception e) {

            e.printStackTrace(System.out);
        }
        return null;

    }

    public Integer insertpin(Pin p) {
        Integer kq = -1;
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "Insert into Pin " + "(Ma,DungLuong)" + " Values(?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getMa());
            ps.setString(2, p.getDungLuong());

            return kq = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PinRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public Integer updatepin(Pin p, String ma) {
        Integer kq = -1;
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "Update Pin set DungLuong=? Where Ma=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getDungLuong());
            ps.setString(2, ma);

            return kq = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PinRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public Integer deletepin(String ma) {
        Integer kq = -1;
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "Delete From Pin Where Ma=?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);

            return kq = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PinRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
}
