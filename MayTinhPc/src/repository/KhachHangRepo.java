/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import JDBC.JDBCUtil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.KhachHang;

/**
 *
 * @author PC
 */
public class KhachHangRepo {
    public void insert(KhachHang kh){
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "insert into KhachHang " + 
                    "(Ma, HoTen, NgaySinh, GioiTinh, Sdt, Email) " + 
                    "values (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, kh.getMa());
            ps.setString(2, kh.getHoTen());
            ps.setDate(3, kh.getNgaySinh());
            ps.setString(4, kh.getGioiTinh());
            ps.setString(5, kh.getSdt());
            ps.setString(6, kh.getEmail());
            ps.execute();
        } catch (Exception ex) {
            Logger.getLogger(NhanVienRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(String id){
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "delete from KhachHang where Id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(NhanVienRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void update(String id, KhachHang kh){
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "update KhachHang set Ma = ?, HoTen = ?, NgaySinh = ?, GioiTinh = ?, Sdt = ?, Email = ? where Id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, kh.getMa());
            ps.setString(2, kh.getHoTen());
            ps.setDate(3, kh.getNgaySinh());
            ps.setString(4, kh.getGioiTinh());
            ps.setString(5, kh.getSdt());
            ps.setString(6, kh.getEmail());
            ps.setString(7, kh.getId());
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(NhanVienRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<KhachHang> getList(){
        ArrayList<KhachHang> listKH = new ArrayList<>();
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "select * from KhachHang";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {                
                String id = rs.getString("Id");
                String ma = rs.getString("Ma");
                String hoTen = rs.getString("HoTen");
                Date ngaySinh = rs.getDate("NgaySinh");
                String gioiTinh = rs.getString("GioiTinh");
                String sdt = rs.getString("Sdt");
                String email = rs.getString("Email");
                KhachHang kh = new KhachHang(id, ma, hoTen, ngaySinh, gioiTinh, sdt, email);
                listKH.add(kh);
            }
        } catch (Exception ex) {
            Logger.getLogger(NhanVienRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listKH;
    }
    
    public KhachHang searchByMa(String makh){
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "select * from KhachHang where Ma = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, makh);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            if(rs.next()){
                String id = rs.getString("Id");
                String ma = rs.getString("Ma");
                String hoTen = rs.getString("HoTen");
                Date ngaySinh = rs.getDate("NgaySinh");
                String gioiTinh = rs.getString("GioiTinh");
                String sdt = rs.getString("Sdt");
                String email = rs.getString("Email");
                KhachHang kh = new KhachHang(id, ma, hoTen, ngaySinh, gioiTinh, sdt, email);
                return kh;
            }else{
                return null;
            }
        } catch (Exception ex) {
            Logger.getLogger(NhanVienRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public KhachHang searchByTen(String tenkh){
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "select * from KhachHang where HoTen = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tenkh);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            if(rs.next()){
                String id = rs.getString("Id");
                String ma = rs.getString("Ma");
                String hoTen = rs.getString("HoTen");
                Date ngaySinh = rs.getDate("NgaySinh");
                String gioiTinh = rs.getString("GioiTinh");
                String sdt = rs.getString("Sdt");
                String email = rs.getString("Email");
                KhachHang kh = new KhachHang(id, ma, hoTen, ngaySinh, gioiTinh, sdt, email);
                return kh;
            }
        } catch (Exception ex) {
            Logger.getLogger(NhanVienRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
