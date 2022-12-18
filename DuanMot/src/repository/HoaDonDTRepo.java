/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import JDBC.JDBCUtil;
import ViewModel.HoaDonCTDoiTra;
import ViewModel.HoaDonDoiTraVM;
import ViewModel.TBGioHang;
import model.HoaDonDoiTra;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class HoaDonDTRepo {

    public List<HoaDonDoiTra> allDT() {
        List<HoaDonDoiTra> lisstHDDT = new ArrayList<>();
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "select Id,Ma,NgayDoiTra,NgayNhanSP,SoLuong from HoaDonDoiTra";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("Id");
                String madt = rs.getString("Ma");
                Date ngayDt = rs.getDate("NgayDoiTra");
                Date ngayNhan = rs.getDate("NgayNhanSP");
                int sl = rs.getInt("SoLuong");
                HoaDonDoiTra hdv = new HoaDonDoiTra();
                hdv.setId(id);
                hdv.setMa(madt);
                hdv.setNgayDoi((java.sql.Date) ngayDt);
                hdv.setNgayNhan((java.sql.Date) ngayNhan);
                hdv.setSoLuong(sl);
                lisstHDDT.add(hdv);
            }
            return lisstHDDT;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;

    }

    public List<HoaDonDoiTraVM> getAllDT() {
        List<HoaDonDoiTraVM> lisstHDDT = new ArrayList<>();
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = " select dt.Id,dt.Ma as 'madt',hd.Ma as 'mahd',kh.Ma as 'makh',kh.HoTen,dt.SoLuong,ct.DonGia,NgayDoiTra,LiDoDT,nv.HoTen as'htnv' from HoaDonDoiTra dt join HoaDonChiTiet ct on ct.Id=dt.IdHDCT \n"
                    + " join HoaDon hd on hd.Id=ct.IdHD \n"
                    + " join KhachHang kh on kh.Id=hd.IdKH\n"
                    + " join NhanVien nv on nv.Id=hd.IdNV\n"
                    + " group by dt.Id,hd.Ma ,kh.Ma ,kh.HoTen,dt.SoLuong,ct.DonGia,NgayDoiTra,LiDoDT,nv.HoTen,dt.Ma";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("Id");
                String mahd = rs.getString("mahd");
                String madt = rs.getString("madt");
                String makh = rs.getString("makh");
                String hoTen = rs.getString("HoTen");
                double gia = rs.getDouble("DonGia");
                java.sql.Date ngayDt = rs.getDate("NgayDoiTra");
                String lido = rs.getString("liDoDT");
                String nvhoten = rs.getString("htnv");
                int sl = rs.getInt("SoLuong");
                HoaDonDoiTraVM hdv = new HoaDonDoiTraVM(id, mahd, madt, makh, hoTen, sl, gia, ngayDt, lido, nvhoten);

                lisstHDDT.add(hdv);
            }
            return lisstHDDT;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;

    }

    public Integer insertHDDTR(HoaDonDoiTra hdt) {
        Integer kq = -1;
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "Insert into HoaDonDoiTra " + "(Ma,NgayDoiTra,NgayNhanSP,SoLuong)" + " Values(?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, hdt.getMa());
            ps.setDate(2, (java.sql.Date) hdt.getNgayDoi());
            ps.setDate(3, (java.sql.Date) hdt.getNgayNhan());
            ps.setInt(4, hdt.getSoLuong());
            kq = ps.executeUpdate();
            return kq;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Integer insertHDDTRVM(HoaDonDoiTra hdt) {
        Integer kq = -1;
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "Insert into HoaDonDoiTra " + "(Ma,SoLuong,NgayDoiTra,LiDoDT,IdHDCT,IdNV)" + " Values(?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, hdt.getMa());
            ps.setDate(3, hdt.getNgayDoi());
            ps.setInt(2, hdt.getSoLuong());
            ps.setString(4, hdt.getLido());
            ps.setString(5, hdt.getIdhdct());
            ps.setString(6, hdt.getIdnv());
            kq = ps.executeUpdate();
            return kq;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Integer updateHDDTR(HoaDonDoiTra hdt, String id) {
        Integer kq = -1;
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "Update HoaDonDoiTra Set NgayDoiTra=?,NgayNhanSP=?,SoLuong=? Where Id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDate(1, (java.sql.Date) hdt.getNgayDoi());
            ps.setDate(2, (java.sql.Date) hdt.getNgayNhan());
            ps.setInt(3, hdt.getSoLuong());
            ps.setString(4, id);
            kq = ps.executeUpdate();
            return kq;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Integer deleteHDDTR(String madt) {
        Integer kq = -1;
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "Delete from HoaDonDoiTra Where Ma=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, madt);
            kq = ps.executeUpdate();
            return kq;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public ArrayList<HoaDonCTDoiTra> getListHDCT(String mahd) {
        ArrayList<HoaDonCTDoiTra> list = new ArrayList<>();
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "select hdct.Id,hd.Ma as'mahd',sp.Ma as'masp',sp.Ten as 'tensp',hdct.SoLuong,hdct.DonGia,hdct.SoLuong*hdct.DonGia as 'thanhtien',IdHD,IdCTSP, SerialNumBer as 'sn' from HoaDonChiTiet hdct \n"
                    + " join HoaDon hd on hd.Id=hdct.IdHD \n"
                    + " join ChiTietSP ctsp on ctsp.Id=hdct.IdCTSP\n"
                    + " join SanPham sp on sp.Id=ctsp.IdSP\n"
                    + "Where hd.Ma=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, mahd);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("Id");
                String masp = rs.getString("masp");
                String tensp = rs.getString("tensp");
                double gia = rs.getDouble("DonGia");
                double thanhtien = rs.getDouble("thanhtien");
                int sl = rs.getInt("SoLuong");
                String idhd = rs.getString("IdHD");
                String idctsp = rs.getString("IdCTSP");
                String sn = rs.getString("sn");
                HoaDonCTDoiTra hdct = new HoaDonCTDoiTra(id, masp, tensp, sl, gia, thanhtien, idhd, idctsp, sn);
                list.add(hdct);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
}
