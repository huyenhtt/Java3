/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import JDBC.JDBCUtil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.HoaDon;

/**
 *
 * @author Admin
 */
public class HoaDonRepo {

    public List<HoaDon> allHD() {
        List<HoaDon> lisst = new ArrayList<>();
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "Select Id,Ma,NgayThanhToan,NgayNhan,NgayTao,ThanhTien,SDTKhachHang,TrangThai From HoaDon";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("Id");
                String ma = rs.getString("Ma");
                Date ngaytt = rs.getDate("NgayThanhToan");
                Date ngaynhan = rs.getDate("NgayNhan");
                Date ngayTao = rs.getDate("NgayTao");
                double thanhTien = rs.getDouble("ThanhTien");
                String sdt = rs.getString("SDTKhachHang");

                String trangThai = rs.getString("TrangThai");
                HoaDon hd = new HoaDon(id ma, ngaytt, ngaynhan, ngayTao, sdt, 0, trangThai);
                lisst.add(hd);
            }
            return lisst;
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public Integer insertHDR(HoaDon hd) {
        Integer kq = -1;
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "Insert into HoaDon " + "(Ma,NgayThanhToan,NgayNhan,NgayTao,SDTKhachHang,TrangThai)" + " Values(?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, hd.getMa());
            ps.setDate(2, (java.sql.Date) hd.getNgayThanhToan());
            ps.setDate(3, (java.sql.Date) hd.getNgayNhan());
            ps.setDate(4, (java.sql.Date) hd.getNgayTao());
            ps.setString(5, hd.getSdt());
            ps.setString(6, hd.getTrangThai());
            kq = ps.executeUpdate();
            return kq;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }

    public Integer upadteHDR(HoaDon hd, String ma) {
        Integer kq = -1;
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "Update HoaDon Set NgayThanhToan=?,NgayNhan=?,NgayTao=?,SDTKhachHang=?,TrangThai=? Where Ma=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(6, ma);
            ps.setDate(1, (java.sql.Date) hd.getNgaythanhToan());
            ps.setDate(2, (java.sql.Date) hd.getNgayNhan());
            ps.setDate(3, (java.sql.Date) hd.getNgayTao());
            ps.setString(4, hd.getSdt());
            ps.setString(5, hd.getTrangThai());
            kq = ps.executeUpdate();
            return kq;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }

    public Integer deleteHDR(String ma) {
        Integer kq = -1;
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "Delete From HoaDon Where Ma=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);

            kq = ps.executeUpdate();
            return kq;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }

    public List<HoaDon> searchHDon(String ma) {
        List<HoaDon> listhd = new ArrayList<>();
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "Select Id,Ma,NgayThanhToan,NgayNhan,NgayTao,ThanhTien,SDTKhachHang,TrangThai from HoaDon Where Ma=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("Id");
//                  String ma = rs.getString("Ma");
                Date ngaytt = rs.getDate("NgayThanhToan");
                Date ngaynhan = rs.getDate("NgayNhan");
                Date ngaytao = rs.getDate("NgayTao");
                double thanhtien = rs.getDouble("ThanhTien");
                String sdt = rs.getString("SDTKhachHang");
                String tt = rs.getString("TrangThai");

                HoaDon hdv = new HoaDon(id, ma, ngaytt, ngaynhan, ngaytao, sdt, 0, tt);
                listhd.add(hdv);
            }
            return listhd;
        } catch (Exception ex) {
            Logger.getLogger(HoaDonRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<HoaDon> searchHDonTinhTrang(String trangThai) {
        List<HoaDon> listhd = new ArrayList<>();
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "Select Id,Ma,NgayThanhToan,NgayNhan,NgayTao,ThanhTien,SDTKhachHang,TrangThai from HoaDon Where TrangThai=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, trangThai);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("Id");
                String ma = rs.getString("Ma");
                Date ngaytt = rs.getDate("NgayThanhToan");
                Date ngaynhan = rs.getDate("NgayNhan");
                Date ngaytao = rs.getDate("NgayTao");
                double thanhtien = rs.getDouble("ThanhTien");
                String sdt = rs.getString("SDTKhachHang");
//                String tt = rs.getString("TinhTrang");

                HoaDon hdv = new HoaDon(id, ma, ngaytt, ngaynhan, ngaytao, sdt, 0, trangThai);
                listhd.add(hdv);
            }
            return listhd;
        } catch (Exception ex) {
            Logger.getLogger(HoaDonRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
