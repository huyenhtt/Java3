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
import model.CardManHinh;

/**
 *
 * @author DELL
 */
public class CardManHinhRepo {

    public ArrayList<CardManHinh> getAll() {
        ArrayList<CardManHinh> list = new ArrayList<>();
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "select * from CardManHinh";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("Id");
                String ma = rs.getString("Ma");
                String loaiCard = rs.getString("LoaiCard");
                CardManHinh card = new CardManHinh(id, ma, loaiCard);
                list.add(card);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public void insert(CardManHinh card) {
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "insert into CardManHinh (Ma,LoaiCard) values(?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, card.getMa());
            ps.setString(2, card.getLoaiCard());
            ps.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void update(CardManHinh card, String id) {
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "update CardManHinh set Ma = ?, LoaiCard = ? where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, card.getMa());
            ps.setString(2, card.getLoaiCard());
            ps.setString(3, card.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void delete(String id) {
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "delete from CardManHinh where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}
