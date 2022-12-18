/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import model.ChiTietSP;
import JDBC.JDBCUtil;
import ViewModel.CTSPViewModel;
import ViewModel.SanPhamBanHangViewModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class ChiTietSPRepo {

    public static void main(String[] args) {
        new ChiTietSPRepo().getAllSPBH();
    }

    public ArrayList<ChiTietSP> getAll() {
        ArrayList<ChiTietSP> list = new ArrayList<>();
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "select * from ChiTietSP";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString(1);
                double gia = rs.getDouble(2);
                int sl = rs.getInt(3);
                int tt = rs.getInt(4);
                String idms = rs.getString(5);
                String iddsp = rs.getString(6);
                String idoc = rs.getString(7);
                String idckn = rs.getString(8);
                String idpin = rs.getString(9);
                String idcpu = rs.getString(10);
                String idram = rs.getString(11);
                String idcard = rs.getString(12);
                String idhdh = rs.getString(13);
                String idsp = rs.getString(14);
                ChiTietSP ctsp = new ChiTietSP(id, gia, sl, tt, idms, iddsp, idoc, idckn, idpin, idcpu, idram, idcard, idhdh, idsp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public List<SanPhamBanHangViewModel> getAllSPBH() {
        String sql = "SELECT dbo.SanPham.Ma, dbo.SanPham.Ten, dbo.MauSac.Ten AS Expr1, dbo.DongSP.Ten AS Expr2, dbo.OCung.DungLuong AS Expr3, dbo.Pin.DungLuong, dbo.CPU.Ten AS Expr4, dbo.Ram.DungLuong AS Expr5, dbo.HeDieuHanh.Ten AS Expr6, dbo.ChiTietSP.SoLuongTon, \n"
                + "             dbo.ChiTietSP.GiaBan\n, dbo.ChiTietSP.Id as 'idctsp'"
                + "FROM   dbo.CPU INNER JOIN\n"
                + "             dbo.ChiTietSP ON dbo.CPU.Id = dbo.ChiTietSP.IdCPU INNER JOIN\n"
                + "             dbo.DongSP ON dbo.ChiTietSP.IdDongsp = dbo.DongSP.Id INNER JOIN\n"
                + "             dbo.HeDieuHanh ON dbo.ChiTietSP.IdHeDH = dbo.HeDieuHanh.Id INNER JOIN\n"
                + "             dbo.MauSac ON dbo.ChiTietSP.IdMauSac = dbo.MauSac.Id INNER JOIN\n"
                + "             dbo.OCung ON dbo.ChiTietSP.IdOCung = dbo.OCung.Id INNER JOIN\n"
                + "             dbo.Pin ON dbo.ChiTietSP.IdPin = dbo.Pin.Id INNER JOIN\n"
                + "             dbo.Ram ON dbo.ChiTietSP.IdRam = dbo.Ram.Id INNER JOIN\n"
                + "             dbo.SanPham ON dbo.ChiTietSP.IdSP = dbo.SanPham.Id";
        try (Connection con = JDBCUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            List<SanPhamBanHangViewModel> list = new ArrayList<>();
            while (rs.next()) {
                list.add(new SanPhamBanHangViewModel(rs.getString("idctsp"), rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getDouble(11)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<SanPhamBanHangViewModel> getMau(String mau) {
        String sql = "SELECT dbo.SanPham.Ma, dbo.SanPham.Ten, dbo.MauSac.Ten AS Expr1, dbo.DongSP.Ten AS Expr2, dbo.OCung.DungLuong AS Expr3, dbo.Pin.DungLuong, dbo.CPU.Ten AS Expr4, dbo.Ram.DungLuong AS Expr5, dbo.HeDieuHanh.Ten AS Expr6, dbo.ChiTietSP.SoLuongTon, \n"
                + "             dbo.ChiTietSP.GiaBan\n"
                + "FROM   dbo.CPU INNER JOIN\n"
                + "             dbo.ChiTietSP ON dbo.CPU.Id = dbo.ChiTietSP.IdCPU INNER JOIN\n"
                + "             dbo.DongSP ON dbo.ChiTietSP.IdDongsp = dbo.DongSP.Id INNER JOIN\n"
                + "             dbo.HeDieuHanh ON dbo.ChiTietSP.IdHeDH = dbo.HeDieuHanh.Id INNER JOIN\n"
                + "             dbo.MauSac ON dbo.ChiTietSP.IdMauSac = dbo.MauSac.Id INNER JOIN\n"
                + "             dbo.OCung ON dbo.ChiTietSP.IdOCung = dbo.OCung.Id INNER JOIN\n"
                + "             dbo.Pin ON dbo.ChiTietSP.IdPin = dbo.Pin.Id INNER JOIN\n"
                + "             dbo.Ram ON dbo.ChiTietSP.IdRam = dbo.Ram.Id INNER JOIN\n"
                + "             dbo.SanPham ON dbo.ChiTietSP.IdSP = dbo.SanPham.Id where MauSac.Ten = ?";
        try (Connection con = JDBCUtil.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setString(1, mau);
            ResultSet rs = ps.executeQuery();
            List<SanPhamBanHangViewModel> list = new ArrayList<>();
            while (rs.next()) {
                list.add(new SanPhamBanHangViewModel("", rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getDouble(11)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<SanPhamBanHangViewModel> getDongSP(String dsp) {
        String sql = "SELECT dbo.SanPham.Ma, dbo.SanPham.Ten, dbo.MauSac.Ten AS Expr1, dbo.DongSP.Ten AS Expr2, dbo.OCung.DungLuong AS Expr3, dbo.Pin.DungLuong, dbo.CPU.Ten AS Expr4, dbo.Ram.DungLuong AS Expr5, dbo.HeDieuHanh.Ten AS Expr6, dbo.ChiTietSP.SoLuongTon, \n"
                + "             dbo.ChiTietSP.GiaBan\n"
                + "FROM   dbo.CPU INNER JOIN\n"
                + "             dbo.ChiTietSP ON dbo.CPU.Id = dbo.ChiTietSP.IdCPU INNER JOIN\n"
                + "             dbo.DongSP ON dbo.ChiTietSP.IdDongsp = dbo.DongSP.Id INNER JOIN\n"
                + "             dbo.HeDieuHanh ON dbo.ChiTietSP.IdHeDH = dbo.HeDieuHanh.Id INNER JOIN\n"
                + "             dbo.MauSac ON dbo.ChiTietSP.IdMauSac = dbo.MauSac.Id INNER JOIN\n"
                + "             dbo.OCung ON dbo.ChiTietSP.IdOCung = dbo.OCung.Id INNER JOIN\n"
                + "             dbo.Pin ON dbo.ChiTietSP.IdPin = dbo.Pin.Id INNER JOIN\n"
                + "             dbo.Ram ON dbo.ChiTietSP.IdRam = dbo.Ram.Id INNER JOIN\n"
                + "             dbo.SanPham ON dbo.ChiTietSP.IdSP = dbo.SanPham.Id where DongSP.Ten = ?";
        try (Connection con = JDBCUtil.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setString(1, dsp);
            ResultSet rs = ps.executeQuery();
            List<SanPhamBanHangViewModel> list = new ArrayList<>();
            while (rs.next()) {
                list.add(new SanPhamBanHangViewModel("", rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getDouble(11)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<SanPhamBanHangViewModel> getOCung(String oc) {
        String sql = "SELECT dbo.SanPham.Ma, dbo.SanPham.Ten, dbo.MauSac.Ten AS Expr1, dbo.DongSP.Ten AS Expr2, dbo.OCung.DungLuong AS Expr3, dbo.Pin.DungLuong, dbo.CPU.Ten AS Expr4, dbo.Ram.DungLuong AS Expr5, dbo.HeDieuHanh.Ten AS Expr6, dbo.ChiTietSP.SoLuongTon, \n"
                + "             dbo.ChiTietSP.GiaBan\n"
                + "FROM   dbo.CPU INNER JOIN\n"
                + "             dbo.ChiTietSP ON dbo.CPU.Id = dbo.ChiTietSP.IdCPU INNER JOIN\n"
                + "             dbo.DongSP ON dbo.ChiTietSP.IdDongsp = dbo.DongSP.Id INNER JOIN\n"
                + "             dbo.HeDieuHanh ON dbo.ChiTietSP.IdHeDH = dbo.HeDieuHanh.Id INNER JOIN\n"
                + "             dbo.MauSac ON dbo.ChiTietSP.IdMauSac = dbo.MauSac.Id INNER JOIN\n"
                + "             dbo.OCung ON dbo.ChiTietSP.IdOCung = dbo.OCung.Id INNER JOIN\n"
                + "             dbo.Pin ON dbo.ChiTietSP.IdPin = dbo.Pin.Id INNER JOIN\n"
                + "             dbo.Ram ON dbo.ChiTietSP.IdRam = dbo.Ram.Id INNER JOIN\n"
                + "             dbo.SanPham ON dbo.ChiTietSP.IdSP = dbo.SanPham.Id where OCung.DungLuong = ?";
        try (Connection con = JDBCUtil.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setString(1, oc);
            ResultSet rs = ps.executeQuery();
            List<SanPhamBanHangViewModel> list = new ArrayList<>();
            while (rs.next()) {
                list.add(new SanPhamBanHangViewModel("", rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getDouble(11)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<CTSPViewModel> getListCTSPViewModel() {
        ArrayList<CTSPViewModel> list = new ArrayList<>();
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "select ChiTietSP.Id as 'id', SanPham.Ma as 'masp', MauSac.Ten as 'mausac', DongSP.Ten as 'tendongsp',\n"
                    + "OCung.DungLuong as 'dungluong', CongKetNoi.Ten as 'tenckn', Pin.DungLuong as 'dlpin',\n"
                    + "ChiTietSP.GiaBan as 'giaban', ChiTietSP.SoLuongTon as 'slt', SanPham.SerialNumber as 'serial',\n"
                    + "HeDieuHanh.Ten as 'hdh', ChiTietSP.TrangThai as 'tt', CPU.Ten as 'cpu', Ram.DungLuong as 'dlram',\n"
                    + "CardManHinh.LoaiCard as 'cardmh' from ChiTietSP\n"
                    + "join MauSac on MauSac.Id = ChiTietSP.IdMauSac\n"
                    + "join DongSP on DongSP.Id = ChiTietSP.IdDongsp\n"
                    + "join OCung on OCung.Id = ChiTietSP.IdOCung\n"
                    + "join CongKetNoi on CongKetNoi.Id = ChiTietSP.IdCongKetNoi\n"
                    + "join Pin on Pin.Id = ChiTietSP.IdPin\n"
                    + "join CPU on CPU.Id = ChiTietSP.IdCPU\n"
                    + "join Ram on Ram.Id = ChiTietSP.IdRam\n"
                    + "join CardManHinh on CardManHinh.Id = ChiTietSP.IdCardMH\n"
                    + "join HeDieuHanh on HeDieuHanh.Id = ChiTietSP.IdHeDH\n"
                    + "join SanPham on SanPham.Id = ChiTietSP.IdSP";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("id");
                double gia = rs.getDouble("giaban");
                int sl = rs.getInt("slt");
                int tt = rs.getInt("tt");
                String ms = rs.getString("mausac");
                String dsp = rs.getString("tendongsp");
                String oc = rs.getString("dungluong");
                String ckn = rs.getString("tenckn");
                String pin = rs.getString("dlpin");
                String cpu = rs.getString("cpu");
                String ram = rs.getString("dlram");
                String card = rs.getString("cardmh");
                String hdh = rs.getString("hdh");
                String masp = rs.getString("masp");
                String serial = rs.getString("serial");
                CTSPViewModel ctsp = new CTSPViewModel(id, gia, sl, tt, ms, dsp, oc, ckn, pin, cpu, ram, card, hdh, masp, serial);
                list.add(ctsp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public void insert(ChiTietSP ctsp) {
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "insert into ChiTietSP(GiaBan,SoLuongTon,TrangThai,IdMauSac,IdDongsp,IdOCung,IdCongKetNoi,IdPin,IdCPU,IdRam,IdCardMH,IdHeDH,IdSP) "
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, ctsp.getGiaBan());
            ps.setInt(2, ctsp.getSoLuongTon());
            ps.setInt(3, ctsp.getTrangThai());
            ps.setString(4, ctsp.getIdMauSac());
            ps.setString(5, ctsp.getIdDongsp());
            ps.setString(6, ctsp.getIdOCung());
            ps.setString(7, ctsp.getIdCongKetNoi());
            ps.setString(8, ctsp.getIdPin());
            ps.setString(9, ctsp.getIdCPU());
            ps.setString(10, ctsp.getIdRam());
            ps.setString(11, ctsp.getIdCardMH());
            ps.setString(12, ctsp.getIdHeDH());
            ps.setString(13, ctsp.getIdSP());
            ps.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void update(ChiTietSP ctsp, String id) {
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "update ChiTietSP set GiaBan = ?,SoLuongTon = ?,TrangThai = ?,IdMauSac = ?,IdDongsp = ?,IdOCung = ?,IdCongKetNoi = ?,IdPin = ?,IdCPU = ?,IdRam = ?"
                    + ",IdCardMH = ?,IdHeDH = ?,IdSP = ? where Id = ? ";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, ctsp.getGiaBan());
            ps.setInt(2, ctsp.getSoLuongTon());
            ps.setInt(3, ctsp.getTrangThai());
            ps.setString(4, ctsp.getIdMauSac());
            ps.setString(5, ctsp.getIdDongsp());
            ps.setString(6, ctsp.getIdOCung());
            ps.setString(7, ctsp.getIdCongKetNoi());
            ps.setString(8, ctsp.getIdPin());
            ps.setString(9, ctsp.getIdCPU());
            ps.setString(10, ctsp.getIdRam());
            ps.setString(11, ctsp.getIdCardMH());
            ps.setString(12, ctsp.getIdHeDH());
            ps.setString(13, ctsp.getIdSP());
            ps.setString(14, id);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void delete(String id) {
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "delete from  ChiTietSP where Id = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public boolean updateSoLuong(ChiTietSP ct, String Id) {
        String sql = "UPDATE ChiTietSP SET SoLuongTon=? WHERE Id =?";
        int check = 0;
        try (Connection con = new JDBCUtil().getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, ct.getSoLuongTon());
            ps.setObject(2, Id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

}
