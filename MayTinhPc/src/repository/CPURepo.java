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
import model.CPU;

/**
 *
 * @author DELL
 */
public class CPURepo {

    public ArrayList<CPU> getAll() {
        ArrayList<CPU> list = new ArrayList<>();
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "select * from CPU";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("Id");
                String ma = rs.getString("Ma");
                String ten = rs.getString("Ten");
                CPU cpu = new CPU(id, ma, ten);
                list.add(cpu);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public void insert(CPU cpu) {
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "insert into CPU(Ma,Ten) values(?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cpu.getMa());
            ps.setString(2, cpu.getTen());
            ps.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void update(CPU cpu, String id) {
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "update CPU set Ma = ?, Ten = ? where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cpu.getMa());
            ps.setString(2, cpu.getTen());
            ps.setString(3, cpu.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void delete(String id) {
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "delete from CPU where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}
