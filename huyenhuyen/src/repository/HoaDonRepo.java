/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import model.HoaDon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ultinity.DBContext;

/**
 *
 * @author Admin
 */
public class HoaDonRepo {

    public List<HoaDon> all() {
        List<HoaDon> listHD = new ArrayList<>();

        try {
            Connection conn = DBContext.getConnection();
            String sql = "Select Id,Ma,NgayThanhToan,NgayNhan,NgayTao,SDTKhachHang,TrangThai From HoaDon";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("Id");
                String ma = rs.getString("Ma");
                Date ngaytt = rs.getDate("NgayThanhToan");
                Date ngaynhan = rs.getDate("NgayNhan");
                Date ngaytao = rs.getDate("NgayTao");
//                double thanhtien = rs.getDouble("ThanhTien");
                String sdt = rs.getString("SDTKhachHang");
                String tt = rs.getString("TrangThai");

                HoaDon hdv = new HoaDon(id, ma, ngaytt, ngaynhan, ngaytao, sdt, tt);
                listHD.add(hdv);
            }
            return listHD;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return null;

    }

    public Integer insertHDR(HoaDon hd) {
        Integer kq = -1;
        try {
            Connection conn = DBContext.getConnection();
            String sql = "Insert into HoaDon " + "(Ma,NgayThanhToan,NgayNhan,NgayTao,SDTKhachHang,TrangThai)" + " Values(?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, hd.getMa());
            ps.setDate(2, (java.sql.Date) hd.getNgayThanhToan());
            ps.setDate(3, (java.sql.Date) hd.getNgayNhan());
            ps.setDate(4, (java.sql.Date) hd.getNgayTao());
            ps.setString(5, hd.getSdt());
            ps.setString(6, hd.getTinhTrang());
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
            Connection conn = DBContext.getConnection();
            String sql = "Update HoaDon Set NgayThanhToan=?,NgayNhan=?,NgayTao=?,SDTKhachHang=?,TrangThai=? Where Ma=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(6, ma);
            ps.setDate(1, (java.sql.Date) hd.getNgayThanhToan());
            ps.setDate(2, (java.sql.Date) hd.getNgayNhan());
            ps.setDate(3, (java.sql.Date) hd.getNgayTao());
            ps.setString(4, hd.getSdt());
            ps.setString(5, hd.getTinhTrang());
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
            Connection conn = DBContext.getConnection();
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
            Connection conn = DBContext.getConnection();
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
                String tt = rs.getString("TinhTrang");

                HoaDon hdv = new HoaDon(id, ma, ngaytt, ngaynhan, ngaytao, sdt, tt);
                listhd.add(hdv);
            }
            return listhd;
        } catch (Exception ex) {
            Logger.getLogger(HoaDonRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<HoaDon> searchHDonTinhTrang(String tinhTrang) {
        List<HoaDon> listhd = new ArrayList<>();
        try {
            Connection conn = DBContext.getConnection();
            String sql = "Select Id,Ma,NgayThanhToan,NgayNhan,NgayTao,ThanhTien,SDTKhachHang,TrangThai from HoaDon Where TrangThai=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tinhTrang);
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

                HoaDon hdv = new HoaDon(id, ma, ngaytt, ngaynhan, ngaytao, sdt, tinhTrang);
                listhd.add(hdv);
            }
            return listhd;
        } catch (Exception ex) {
            Logger.getLogger(HoaDonRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
