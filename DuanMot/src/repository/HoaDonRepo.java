/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import JDBC.JDBCUtil;
import ViewModel.HoaDonVM;
import ViewModel.TBGioHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.HoaDon;
import model.KhachHang;
import model.thongKe;

/**
 *
 * @author Admin
 */
public class HoaDonRepo {

    public List<thongKe> getListTK() {
        List<thongKe> list = new ArrayList<>();

        String sql = "Select SUM(dbo.HoaDon.ThanhTien) As 'Doanhthu',dbo.HoaDon.NgayThanhToan as 'ngayTT' from HoaDon \n"
                + "                where  TrangThai like N'Đã thanh toán' \n"
                + "				GROUP BY HoaDon.NgayThanhToan order by NgayThanhToan desc";

        try (Connection con = JDBCUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                thongKe tk = new thongKe(rs.getDouble(1), rs.getString(2));

                list.add(tk);

            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<thongKe> getListSP() {
        List<thongKe> list = new ArrayList<>();

        String sql = "select top 5 sp.Ten,count(hdct.IdCTSP) as 'soluongspdaban' from HoaDonChiTiet hdct\n"
                + "       join ChiTietSP ctsp on ctsp.Id=hdct.IdCTSP \n"
                + "       join SanPham sp on sp.Id=ctsp.IdSP\n"
                + "	   join HoaDon hd on hd.Id=hdct.IdHD\n"
                + "	   where hd.TrangThai=N'Đã thanh toán'\n"
                + "       group by sp.Ten,hdct.IdCTSP\n"
                + "       order by soluongspdaban desc";

        try (Connection con = JDBCUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                thongKe tk = new thongKe(rs.getString(1), rs.getInt(2));

                list.add(tk);

            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<thongKe> getListKH() {
        List<thongKe> list = new ArrayList<>();

        String sql = "select sum(SoLuong) as'sohdct',kh.HoTen from HoaDonChiTiet ct\n"
                + "join HoaDon hd on hd.Id=ct.IdHD\n"
                + " join KhachHang kh on kh.Id=hd.IdKH\n"
                + "where hd.TrangThai=N'Đã thanh toán'\n"
                + " group by kh.HoTen";

        try (Connection con = JDBCUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                thongKe tk = new thongKe(rs.getInt(1), rs.getString(2));

                list.add(tk);

            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new HoaDonRepo().getListKH());
    }

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

                HoaDon hdv = new HoaDon(id, ma, ngaytt, ngaynhan, ngaytao, thanhtien, sdt, tt);
                listHD.add(hdv);
            }
            return listHD;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return null;

    }

    public List<HoaDonVM> getListHDVa(Date ngaytao1, Date ngayTao2) {
        List<HoaDonVM> listHDVM = new ArrayList<>();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "Select hd.Id,hd.Ma as'mahd',NgayTao,hd.TrangThai,kh.Sdt,SUM(ct.ThanhTien) as 'thanhtien',kh.HoTen as'tenkh',kh.Ma as 'makh',nv.HoTen as 'htnv',nv.Ma as 'manv'  From HoaDon hd\n"
                    + "left join KhachHang kh on kh.Id=hd.IdKH\n"
                    + "left join NhanVien nv on Nv.Id=hd.IdNV \n"
                    + "left join HoaDonChiTiet ct on ct.IdHD=hd.Id\n"
                    + "where NgayTao between ? and ?\n"
                    + "Group by hd.Id,hd.Ma,NgayTao,hd.TrangThai,kh.Sdt,kh.HoTen,kh.Ma,nv.HoTen,nv.Ma";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDate(1, ngaytao1);
            ps.setDate(2, ngayTao2);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("Id");
                String ma = rs.getString("mahd");

                Date ngaytao = rs.getDate("NgayTao");
                String manv = rs.getString("manv");
                String htennv = rs.getString("htnv");

                String makh = rs.getString("makh");
                String htenkh = rs.getString("tenkh");
                String sdt = rs.getString("Sdt");
                double thanhTien = rs.getDouble("thanhtien");
                String tt = rs.getString("TrangThai");
                HoaDonVM hdv = new HoaDonVM(ma, ngaytao, manv, htennv, makh, htenkh, sdt, tt, thanhTien);
                listHDVM.add(hdv);
            }
            return listHDVM;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return null;

    }

    public List<HoaDonVM> getListHDV() {
        List<HoaDonVM> listHDVM = new ArrayList<>();

        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "Select hd.Id,hd.Ma as'mahd',NgayTao,hd.TrangThai,kh.Sdt,SUM(ct.ThanhTien) as 'thanhtien',kh.HoTen as'tenkh',kh.Ma as 'makh',nv.HoTen as 'htnv',nv.Ma as 'manv'  From HoaDon hd\n"
                    + "left join KhachHang kh on kh.Id=hd.IdKH\n"
                    + "left join NhanVien nv on Nv.Id=hd.IdNV \n"
                    + "left join HoaDonChiTiet ct on ct.IdHD=hd.Id\n"
                    + "Group by hd.Id,hd.Ma,NgayTao,hd.TrangThai,kh.Sdt,kh.HoTen,kh.Ma,nv.HoTen,nv.Ma";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("Id");
                String ma = rs.getString("mahd");

                Date ngaytao = rs.getDate("NgayTao");
                String manv = rs.getString("manv");
                String htennv = rs.getString("htnv");

                String makh = rs.getString("makh");
                String htenkh = rs.getString("tenkh");
                String sdt = rs.getString("Sdt");
                double thanhTien = rs.getDouble("thanhtien");
                String tt = rs.getString("TrangThai");
                HoaDonVM hdv = new HoaDonVM(ma, (java.sql.Date) ngaytao, manv, htennv, makh, htenkh, sdt, tt, thanhTien);
                listHDVM.add(hdv);
            }
            return listHDVM;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return null;

    }
//search theo trạng thái

    public List<HoaDonVM> SearchTrangThai(String trangThai) {
        List<HoaDonVM> listHDVM = new ArrayList<>();

        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "Select hd.Id,hd.Ma as 'mahd',NgayTao,hd.TrangThai,kh.Sdt,SUM(ct.ThanhTien) as 'thanhtien',kh.HoTen as'tenkh',kh.Ma as 'makh',nv.HoTen as 'htnv',nv.Ma as 'manv'  From HoaDon hd\n"
                    + "left join KhachHang kh on kh.Id=hd.IdKH\n"
                    + "left join NhanVien nv on Nv.Id=hd.IdNV \n"
                    + "left join HoaDonChiTiet ct on ct.IdHD=hd.Id\n"
                    + "where hd.TrangThai = ?\n"
                    + "Group by hd.Id,hd.Ma,NgayTao,hd.TrangThai,kh.Sdt,kh.HoTen,kh.Ma,nv.HoTen,nv.Ma";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, trangThai);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("Id");
                String ma = rs.getString("mahd");

                Date ngaytao = rs.getDate("NgayTao");
                String manv = rs.getString("manv");
                String htennv = rs.getString("htnv");

                String makh = rs.getString("makh");
                String htenkh = rs.getString("tenkh");
                String sdt = rs.getString("Sdt");
                double thanhTien = rs.getDouble("thanhtien");
                HoaDonVM hdv = new HoaDonVM(ma, (java.sql.Date) ngaytao, manv, htennv, makh, htenkh, sdt, trangThai, thanhTien);
                listHDVM.add(hdv);
            }
            return listHDVM;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return null;

    }
    ///tìm theo ten hoặc ma sp

    public ArrayList<TBGioHang> SearchTenSP(String ten, String mahd) {
        ArrayList<TBGioHang> list = new ArrayList<>();
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "select hdct.Id,hd.Ma as'mahd',sp.Ma as'masp',sp.Ten as 'tensp',hdct.SoLuong,hdct.DonGia,hdct.SoLuong*hdct.DonGia as 'thanhtien',IdHD,IdCTSP from HoaDonChiTiet hdct \n"
                    + " join HoaDon hd on hd.Id=hdct.IdHD \n"
                    + " join ChiTietSP ctsp on ctsp.Id=hdct.IdCTSP\n"
                    + " join SanPham sp on sp.Id=ctsp.IdSP\n"
                    + "Where sp.Ten=? and hd.Ma=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ten);
            ps.setString(2, mahd);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("Id");
                String masp = rs.getString("masp");
                double gia = rs.getDouble("DonGia");
                double thanhtien = rs.getDouble("thanhtien");
                int sl = rs.getInt("SoLuong");
                String idhd = rs.getString("IdHD");
                String idctsp = rs.getString("IdCTSP");
                TBGioHang hdct = new TBGioHang(id, masp, ten, sl, gia, thanhtien, idhd, idctsp);
                list.add(hdct);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public ArrayList<TBGioHang> SearchMaSP(String masp, String mahd) {
        ArrayList<TBGioHang> list = new ArrayList<>();
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "select hdct.Id,hd.Ma as'mahd',sp.Ma as'masp',sp.Ten as 'tensp',hdct.SoLuong,hdct.DonGia,hdct.SoLuong*hdct.DonGia as 'thanhtien',IdHD,IdCTSP from HoaDonChiTiet hdct \n"
                    + " join HoaDon hd on hd.Id=hdct.IdHD \n"
                    + " join ChiTietSP ctsp on ctsp.Id=hdct.IdCTSP\n"
                    + " join SanPham sp on sp.Id=ctsp.IdSP\n"
                    + "Where sp.Ma=? and hd.Ma=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, masp);
            ps.setString(2, mahd);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("Id");
                String tensp = rs.getString("tensp");
                double gia = rs.getDouble("DonGia");
                double thanhtien = rs.getDouble("thanhtien");
                int sl = rs.getInt("SoLuong");
                String idhd = rs.getString("IdHD");
                String idctsp = rs.getString("IdCTSP");
                TBGioHang hdct = new TBGioHang(id, masp, tensp, sl, gia, thanhtien, idhd, idctsp);
                list.add(hdct);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    //lấy mã hd trên tb hoá đơn
    public ArrayList<TBGioHang> getListHDCT(String mahd) {
        ArrayList<TBGioHang> list = new ArrayList<>();
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "select hdct.Id,hd.Ma as'mahd',sp.Ma as'masp',sp.Ten as 'tensp',hdct.SoLuong,hdct.DonGia,hdct.SoLuong*hdct.DonGia as 'thanhtien',IdHD,IdCTSP from HoaDonChiTiet hdct \n"
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
                TBGioHang hdct = new TBGioHang(id, masp, tensp, sl, gia, thanhtien, idhd, idctsp);
                list.add(hdct);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    ///search theo khoảng tiền
    public List<HoaDonVM> searchkhoangTien() {
        List<HoaDonVM> listHDVM = new ArrayList<>();

        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "Select hd.Id,hd.Ma as 'mahd',NgayTao,hd.TrangThai,kh.Sdt,SUM(ct.ThanhTien) as 'thanhtien',kh.HoTen as'tenkh',kh.Ma as 'makh',nv.HoTen as 'htnv',nv.Ma as 'manv'  From HoaDon hd\n"
                    + "left join KhachHang kh on kh.Id=hd.IdKH\n"
                    + "left join NhanVien nv on Nv.Id=hd.IdNV \n"
                    + "left join HoaDonChiTiet ct on ct.IdHD=hd.Id\n"
                    + "\n"
                    + "Group by hd.Id,hd.Ma,NgayTao,hd.TrangThai,kh.Sdt,kh.HoTen,kh.Ma,nv.HoTen,nv.Ma\n"
                    + "Having SUM(ct.ThanhTien) < 10000000";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("Id");
                String ma = rs.getString("mahd");

                Date ngaytao = rs.getDate("NgayTao");
                String manv = rs.getString("manv");
                String htennv = rs.getString("htnv");

                String makh = rs.getString("makh");
                String htenkh = rs.getString("tenkh");
                String sdt = rs.getString("Sdt");
                double thanhTien = rs.getDouble("thanhtien");
                String tt = rs.getString("TrangThai");
                HoaDonVM hdv = new HoaDonVM(ma, (java.sql.Date) ngaytao, manv, htennv, makh, htenkh, sdt, tt, thanhTien);
                listHDVM.add(hdv);
            }
            return listHDVM;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return null;

    }

    public List<HoaDonVM> searchkhoangTien2() {
        List<HoaDonVM> listHDVM = new ArrayList<>();

        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "Select hd.Id,hd.Ma as 'mahd',NgayTao,hd.TrangThai,kh.Sdt,SUM(ct.ThanhTien) as 'thanhtien',kh.HoTen as'tenkh',kh.Ma as 'makh',nv.HoTen as 'htnv',nv.Ma as 'manv'  From HoaDon hd\n"
                    + "left join KhachHang kh on kh.Id=hd.IdKH\n"
                    + "left join NhanVien nv on Nv.Id=hd.IdNV \n"
                    + "left join HoaDonChiTiet ct on ct.IdHD=hd.Id\n"
                    + "\n"
                    + "Group by hd.Id,hd.Ma,NgayTao,hd.TrangThai,kh.Sdt,kh.HoTen,kh.Ma,nv.HoTen,nv.Ma\n"
                    + "Having SUM(ct.ThanhTien)  between 10000000 and 49999999";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("Id");
                String ma = rs.getString("mahd");

                Date ngaytao = rs.getDate("NgayTao");
                String manv = rs.getString("manv");
                String htennv = rs.getString("htnv");

                String makh = rs.getString("makh");
                String htenkh = rs.getString("tenkh");
                String sdt = rs.getString("Sdt");
                double thanhTien = rs.getDouble("thanhtien");
                String tt = rs.getString("TrangThai");
                HoaDonVM hdv = new HoaDonVM(ma, (java.sql.Date) ngaytao, manv, htennv, makh, htenkh, sdt, tt, thanhTien);
                listHDVM.add(hdv);
            }
            return listHDVM;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return null;

    }

    public List<HoaDonVM> searchkhoangTien3() {
        List<HoaDonVM> listHDVM = new ArrayList<>();

        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "Select hd.Id,hd.Ma as 'mahd',NgayTao,hd.TrangThai,kh.Sdt,SUM(ct.ThanhTien) as 'thanhtien',kh.HoTen as'tenkh',kh.Ma as 'makh',nv.HoTen as 'htnv',nv.Ma as 'manv'  From HoaDon hd\n"
                    + "left join KhachHang kh on kh.Id=hd.IdKH\n"
                    + "left join NhanVien nv on Nv.Id=hd.IdNV \n"
                    + "left join HoaDonChiTiet ct on ct.IdHD=hd.Id\n"
                    + "\n"
                    + "Group by hd.Id,hd.Ma,NgayTao,hd.TrangThai,kh.Sdt,kh.HoTen,kh.Ma,nv.HoTen,nv.Ma\n"
                    + "Having SUM(ct.ThanhTien)  between 50000000 and 100000000";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("Id");
                String ma = rs.getString("mahd");

                Date ngaytao = rs.getDate("NgayTao");
                String manv = rs.getString("manv");
                String htennv = rs.getString("htnv");

                String makh = rs.getString("makh");
                String htenkh = rs.getString("tenkh");
                String sdt = rs.getString("Sdt");
                double thanhTien = rs.getDouble("thanhtien");
                String tt = rs.getString("TrangThai");
                HoaDonVM hdv = new HoaDonVM(ma, (java.sql.Date) ngaytao, manv, htennv, makh, htenkh, sdt, tt, thanhTien);
                listHDVM.add(hdv);
            }
            return listHDVM;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return null;

    }

    public List<HoaDonVM> searchkhoangTien4() {
        List<HoaDonVM> listHDVM = new ArrayList<>();

        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "Select hd.Id,hd.Ma as 'mahd',NgayTao,hd.TrangThai,kh.Sdt,SUM(ct.ThanhTien) as 'thanhtien',kh.HoTen as'tenkh',kh.Ma as 'makh',nv.HoTen as 'htnv',nv.Ma as 'manv'  From HoaDon hd\n"
                    + "left join KhachHang kh on kh.Id=hd.IdKH\n"
                    + "left join NhanVien nv on Nv.Id=hd.IdNV \n"
                    + "left join HoaDonChiTiet ct on ct.IdHD=hd.Id\n"
                    + "\n"
                    + "Group by hd.Id,hd.Ma,NgayTao,hd.TrangThai,kh.Sdt,kh.HoTen,kh.Ma,nv.HoTen,nv.Ma\n"
                    + "Having SUM(ct.ThanhTien) > 100000000";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("Id");
                String ma = rs.getString("mahd");

                Date ngaytao = rs.getDate("NgayTao");
                String manv = rs.getString("manv");
                String htennv = rs.getString("htnv");

                String makh = rs.getString("makh");
                String htenkh = rs.getString("tenkh");
                String sdt = rs.getString("Sdt");
                double thanhTien = rs.getDouble("thanhtien");
                String tt = rs.getString("TrangThai");
                HoaDonVM hdv = new HoaDonVM(ma, (java.sql.Date) ngaytao, manv, htennv, makh, htenkh, sdt, tt, thanhTien);
                listHDVM.add(hdv);
            }
            return listHDVM;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return null;

    }
//sdt search

    public List<KhachHang> getSDTVM() {
        List<KhachHang> listHDVM = new ArrayList<>();

        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "select Sdt from KhachHang";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String sdt = rs.getString("Sdt");
                KhachHang kh = new KhachHang();
                kh.setSdt(sdt);
                listHDVM.add(kh);
            }
            return listHDVM;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return null;

    }

    public List<KhachHang> getHoTen() {
        List<KhachHang> listHDVM = new ArrayList<>();

        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "select HoTen from KhachHang";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String hoten = rs.getString("HoTen");
                KhachHang kh = new KhachHang();
                kh.setHoTen(hoten);
                listHDVM.add(kh);
            }
            return listHDVM;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return null;

    }

    public List<HoaDonVM> searchSDT(String sdt) {
        List<HoaDonVM> listHDVM = new ArrayList<>();

        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "Select hd.Id,hd.Ma as 'mahd',NgayTao,hd.TrangThai,kh.Sdt,SUM(ct.ThanhTien) as 'thanhtien',kh.HoTen as'tenkh',kh.Ma as 'makh',nv.HoTen as 'htnv',nv.Ma as 'manv'  From HoaDon hd\n"
                    + "left join KhachHang kh on kh.Id=hd.IdKH\n"
                    + "left join NhanVien nv on Nv.Id=hd.IdNV \n"
                    + "left join HoaDonChiTiet ct on ct.IdHD=hd.Id\n"
                    + "Where kh.sdt=?\n"
                    + "Group by hd.Id,hd.Ma,NgayTao,hd.TrangThai,kh.Sdt,kh.HoTen,kh.Ma,nv.HoTen,nv.Ma";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sdt);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("Id");
                String ma = rs.getString("mahd");

                Date ngaytao = rs.getDate("NgayTao");
                String manv = rs.getString("manv");
                String htennv = rs.getString("htnv");

                String makh = rs.getString("makh");
                String htenkh = rs.getString("tenkh");
                double thanhTien = rs.getDouble("thanhtien");
                String tt = rs.getString("TrangThai");
                HoaDonVM hdv = new HoaDonVM(ma, (java.sql.Date) ngaytao, manv, htennv, makh, htenkh, sdt, tt, thanhTien);
                listHDVM.add(hdv);
            }
            return listHDVM;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return null;

    }
///

    public List<HoaDonVM> searchThangV(int thang) {
        List<HoaDonVM> listHDVM = new ArrayList<>();

        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "Select hd.Id,hd.Ma as 'mahd',NgayTao,hd.TrangThai,kh.Sdt,SUM(ct.ThanhTien) as 'thanhtien',kh.HoTen as'tenkh',kh.Ma as 'makh',nv.HoTen as 'htnv',nv.Ma as 'manv'  From HoaDon hd\n"
                    + "left join KhachHang kh on kh.Id=hd.IdKH\n"
                    + "left join NhanVien nv on Nv.Id=hd.IdNV \n"
                    + "left join HoaDonChiTiet ct on ct.IdHD=hd.Id\n"
                    + "Where MONTH(NgayTao)=?\n"
                    + "Group by hd.Id,hd.Ma,NgayTao,hd.TrangThai,kh.Sdt,kh.HoTen,kh.Ma,nv.HoTen,nv.Ma";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, thang);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("Id");
                String ma = rs.getString("mahd");

                Date ngaytao = rs.getDate("NgayTao");
                String manv = rs.getString("manv");
                String htennv = rs.getString("htnv");
                String sdt = rs.getString("Sdt");
                String makh = rs.getString("makh");
                String htenkh = rs.getString("tenkh");
                double thanhTien = rs.getDouble("thanhtien");
                String tt = rs.getString("TrangThai");
                HoaDonVM hdv = new HoaDonVM(ma, (java.sql.Date) ngaytao, manv, htennv, makh, htenkh, sdt, tt, thanhTien);
                listHDVM.add(hdv);
            }
            return listHDVM;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return null;

    }

    public List<HoaDonVM> searchNamV(int nam) {
        List<HoaDonVM> listHDVM = new ArrayList<>();

        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "Select hd.Id,hd.Ma as 'mahd',NgayTao,hd.TrangThai,kh.Sdt,SUM(ct.ThanhTien) as 'thanhtien',kh.HoTen as'tenkh',kh.Ma as 'makh',nv.HoTen as 'htnv',nv.Ma as 'manv'  From HoaDon hd\n"
                    + "left join KhachHang kh on kh.Id=hd.IdKH\n"
                    + "left join NhanVien nv on Nv.Id=hd.IdNV \n"
                    + "left join HoaDonChiTiet ct on ct.IdHD=hd.Id\n"
                    + "Where YEAR(NgayTao)=?\n"
                    + "Group by hd.Id,hd.Ma,NgayTao,hd.TrangThai,kh.Sdt,kh.HoTen,kh.Ma,nv.HoTen,nv.Ma";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, nam);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("Id");
                String ma = rs.getString("mahd");

                Date ngaytao = rs.getDate("NgayTao");
                String manv = rs.getString("manv");
                String htennv = rs.getString("htnv");
                String sdt = rs.getString("Sdt");
                String makh = rs.getString("makh");
                String htenkh = rs.getString("tenkh");
                double thanhTien = rs.getDouble("thanhtien");
                String tt = rs.getString("TrangThai");
                HoaDonVM hdv = new HoaDonVM(ma, (java.sql.Date) ngaytao, manv, htennv, makh, htenkh, sdt, tt, thanhTien);
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
