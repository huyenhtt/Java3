/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import JDBC.JDBCUtil;
import model.NhanVien;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class NhanVienRepo {
    
    public void insert(NhanVien nv){
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "insert into NhanVien " + 
                    "(Ma, Hoten, NgaySinh, GioiTinh, Sdt, Email, Cmnd, DiaChi, MatKhau, ChucVu, TrangThai)" +
                    "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nv.getMa());
            ps.setString(2, nv.getHoTen());
            ps.setDate(3, nv.getNgaySinh());
            ps.setString(4, nv.getGioiTinh());
            ps.setString(5, nv.getSdt());
            ps.setString(6, nv.getEmail());
            ps.setString(7, nv.getCmnd());
            ps.setString(8, nv.getDiaChi());
            ps.setString(9, nv.getMatKhau());
            ps.setString(10, nv.getChucVu());
            ps.setInt(11, nv.getTrangThai());
            ps.execute();
        } catch (Exception ex) {
            Logger.getLogger(NhanVienRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delele(String id){
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "delete from NhanVien where Id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(NhanVienRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void update(String id, NhanVien nv){
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "update NhanVien set Ma = ?, Hoten = ?, NgaySinh = ?, GioiTinh = ?, Sdt = ?, Email = ?, Cmnd = ?, DiaChi = ?, MatKhau = ?, ChucVu = ?, TrangThai = ? where Id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nv.getMa());
            ps.setString(2, nv.getHoTen());
            ps.setDate(3, nv.getNgaySinh());
            ps.setString(4, nv.getGioiTinh());
            ps.setString(5, nv.getSdt());
            ps.setString(6, nv.getEmail());
            ps.setString(7, nv.getCmnd());
            ps.setString(8, nv.getDiaChi());
            ps.setString(9, nv.getMatKhau());
            ps.setString(10, nv.getChucVu());
            ps.setInt(11, nv.getTrangThai());
            ps.setString(12, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(NhanVienRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<NhanVien> getList(){
        ArrayList<NhanVien> listNV = new ArrayList<>();
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "select * from NhanVien";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {                
                String id = rs.getString("Id");
                String ma = rs.getString("Ma");
                String hoTen = rs.getString("Hoten");
                Date ngaySinh = rs.getDate("NgaySinh");
                String gioiTinh = rs.getString("GioiTinh");
                String sdt = rs.getString("Sdt");
                String email = rs.getString("Email");
                String cmnd = rs.getString("Cmnd");
                String diaChi = rs.getString("DiaChi");
                String matKhau = rs.getString("MatKhau");
                String chucVu = rs.getString("ChucVu");
                int trangThai = rs.getInt("TrangThai");
                NhanVien nv = new NhanVien(id, ma, hoTen, ngaySinh, gioiTinh, sdt, email, cmnd, diaChi, matKhau, chucVu, trangThai);
                listNV.add(nv);
            }
        } catch (Exception ex) {
            Logger.getLogger(NhanVienRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listNV;
    }
    
    public NhanVien searchByMa(String manv){
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "select * from NhanVien where Ma = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, manv);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            if(rs.next()){
                String id = rs.getString("Id");
                String ma = rs.getString("Ma");
                String hoTen = rs.getString("Hoten");
                Date ngaySinh = rs.getDate("NgaySinh");
                String gioiTinh = rs.getString("GioiTinh");
                String sdt = rs.getString("Sdt");
                String email = rs.getString("Email");
                String cmnd = rs.getString("Cmnd");
                String diaChi = rs.getString("DiaChi");
                String matKhau = rs.getString("MatKhau");
                String chucVu = rs.getString("ChucVu");
                int trangThai = rs.getInt("TrangThai");
                NhanVien nv = new NhanVien(id, ma, hoTen, ngaySinh, gioiTinh, sdt, email, cmnd, diaChi, matKhau, chucVu, trangThai);
                return nv;
            }
        } catch (Exception ex) {
            Logger.getLogger(NhanVienRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public NhanVien searchByTen(String tennv){
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "select * from NhanVien where HoTen = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tennv);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            if(rs.next()){
                String id = rs.getString("Id");
                String ma = rs.getString("Ma");
                String hoTen = rs.getString("Hoten");
                Date ngaySinh = rs.getDate("NgaySinh");
                String gioiTinh = rs.getString("GioiTinh");
                String sdt = rs.getString("Sdt");
                String email = rs.getString("Email");
                String cmnd = rs.getString("Cmnd");
                String diaChi = rs.getString("DiaChi");
                String matKhau = rs.getString("MatKhau");
                String chucVu = rs.getString("ChucVu");
                int trangThai = rs.getInt("TrangThai");
                NhanVien nv = new NhanVien(id, ma, hoTen, ngaySinh, gioiTinh, sdt, email, cmnd, diaChi, matKhau, chucVu, trangThai);
                return nv;
            }
        } catch (Exception ex) {
            Logger.getLogger(NhanVienRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
