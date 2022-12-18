/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import JDBC.JDBCUtil;
import ViewModel.HoaDonVM;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.HoaDon;

/**
 *
 * @author Admin
 */
public class HoaDonRepo {

    public List<HoaDon> allH() {
        List<HoaDon> listHD = new ArrayList<>();

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
                Date ngaytao = rs.getDate("NgayTao");
                double thanhtien = rs.getDouble("ThanhTien");
                String sdt = rs.getString("SDTKhachHang");
                String tt = rs.getString("TrangThai");

                HoaDon hdv = new HoaDon(id, ma, ngaytt, ngaynhan, ngaytao, 0, sdt, tt);
                listHD.add(hdv);
            }
            return listHD;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return null;

    }

    public List<HoaDonVM> getListHDV() {
        List<HoaDonVM> listHDVM = new ArrayList<>();

        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "Select hd.Id,hd.Ma,NgayTao,hd.TrangThai,kh.Sdt,kh.HoTen as'tenkh',kh.Ma as 'makh',nv.HoTen as 'htnv',nv.Ma as 'manv'  From HoaDon hd\n"
                    + "join KhachHang kh on kh.Id=hd.IdKH\n"
                    + "join NhanVien nv on Nv.Id=hd.IdNV \n"
                    + "Group by hd.Id,hd.Ma,NgayTao,hd.TrangThai,kh.Sdt,kh.HoTen,kh.Ma,nv.HoTen,nv.Ma";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("Id");
                String ma = rs.getString("Ma");

                Date ngaytao = rs.getDate("NgayTao");
                String manv = rs.getString("manv");
                String htennv = rs.getString("htnv");

                String makh = rs.getString("makh");
                String htenkh = rs.getString("tenkh");
                String sdt = rs.getString("Sdt");

                String tt = rs.getString("TrangThai");
                HoaDonVM hdv = new HoaDonVM(ma, (java.sql.Date) ngaytao, manv, htennv, makh, htenkh, sdt, tt);
                listHDVM.add(hdv);
            }
            return listHDVM;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
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
            ps.setDate(1, (java.sql.Date) hd.getNgayThanhToan());
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
        List<HoaDon> listhdd = new ArrayList<>();
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

                HoaDon hdv = new HoaDon(id, ma, ngaytt, ngaynhan, ngaytao, 0, sdt, tt);
                listhdd.add(hdv);
            }
            return listhdd;
        } catch (Exception ex) {
            Logger.getLogger(HoaDonRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<HoaDon> searchHDonTrangThai(String trangThai) {
        List<HoaDon> listhdh = new ArrayList<>();
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

                HoaDon hdv = new HoaDon(id, ma, ngaytt, ngaynhan, ngaytao, 0, sdt, trangThai);
                listhdh.add(hdv);
            }
            return listhdh;
        } catch (Exception ex) {
            Logger.getLogger(HoaDonRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<HoaDon> searchNam(int nam) {
        List<HoaDon> listhdd = new ArrayList<>();
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "Select Id,Ma,NgayThanhToan,NgayNhan,NgayTao,ThanhTien,SDTKhachHang,TrangThai from HoaDon Where YEAR(NgayThanhToan)=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, nam);
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
                String tt = rs.getString("TrangThai");

                HoaDon hdv = new HoaDon(id, ma, ngaytt, ngaynhan, ngaytao, 0, sdt, tt);
                listhdd.add(hdv);
            }
            return listhdd;
        } catch (Exception ex) {
            Logger.getLogger(HoaDonRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<HoaDon> searchThang(int thang) {
        List<HoaDon> listhdd = new ArrayList<>();
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "Select Id,Ma,NgayThanhToan,NgayNhan,NgayTao,ThanhTien,SDTKhachHang,TrangThai from HoaDon Where Month(NgayThanhToan)=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, thang);
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
                String tt = rs.getString("TrangThai");

                HoaDon hdv = new HoaDon(id, ma, ngaytt, ngaynhan, ngaytao, 0, sdt, tt);
                listhdd.add(hdv);
            }
            return listhdd;
        } catch (Exception ex) {
            Logger.getLogger(HoaDonRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
