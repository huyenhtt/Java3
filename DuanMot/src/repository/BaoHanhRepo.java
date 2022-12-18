/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import JDBC.JDBCUtil;
import model.PhieuBaoHanh;
import ViewModel.PhieuBaoHanhViewModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class BaoHanhRepo {

    public List<PhieuBaoHanhViewModel> getAll() {
        String sql = "SELECT [Id]\n"
                + "      ,[Ma]\n"
                + "      ,[NgayMua]\n"
                + "      ,[NgayBaoHanh]\n"
                + "      ,[ThoiGianBaoHanh]\n"
                + "      ,[HoTenKH]\n"
                + "      ,[IdHDCT]\n"
                + "  FROM [dbo].[PhieuBaoHanh]";
        try (Connection con = JDBCUtil.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            ResultSet rs = pstm.executeQuery();
            List<PhieuBaoHanhViewModel> listBH = new ArrayList<>();
            while (rs.next()) {
                PhieuBaoHanhViewModel bh = new PhieuBaoHanhViewModel(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getDate(4), rs.getInt(5), rs.getString(6), rs.getString(7));
                listBH.add(bh);
            }
            return listBH;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean add(PhieuBaoHanh bh) {
        int check = 0;
        String sql = "INSERT INTO [dbo].[PhieuBaoHanh]\n"
                + "           ([Ma]\n"
                + "           ,[NgayMua]\n"
                + "           ,[NgayBaoHanh]\n"
                + "           ,[ThoiGianBaoHanh]\n"
                + "           ,[HoTenKH]\n"
                + "           ,[IdHDCT])\n"
                + "     VALUES (?,?,?,?,?,?)";
        try (Connection con = JDBCUtil.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setObject(1, bh.getMa());
            pstm.setObject(2, bh.getNgayMuaHang());
            pstm.setObject(3, bh.getNgayBH());
            pstm.setObject(4, bh.getThoiGianBH());
            pstm.setObject(5, bh.getTenKH());
            pstm.setObject(6, bh.getIDhdct());

            check = pstm.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean update(PhieuBaoHanh bh, String id) {
        int check = 0;
        String sql = "UPDATE [dbo].[PhieuBaoHanh]\n"
                + "   SET [Ma] = ?\n"
                + "      ,[NgayMua] = ?\n"
                + "      ,[NgayBaoHanh] = ?\n"
                + "      ,[ThoiGianBaoHanh] = ?\n"
                + "      ,[HoTenKH] = ?\n"
                + "      ,[IdHDCT] = ?\n"
                + " WHERE  id = ?";
        try (Connection con = JDBCUtil.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setObject(1, bh.getMa());
            pstm.setObject(2, bh.getNgayMuaHang());
            pstm.setObject(3, bh.getNgayBH());
            pstm.setObject(4, bh.getThoiGianBH());
            pstm.setObject(5, bh.getTenKH());
            pstm.setObject(6, bh.getIDhdct());
            pstm.setObject(7, id);
            check = pstm.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean delete(String id) {
        String sql = "DELETE FROM PhieuBaoHanh WHERE Id =?";
        int check = 0;
        try (Connection con = new JDBCUtil().getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {

            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public PhieuBaoHanh checkTrung(String ma) {
        String sql = "SELECT Ma FROM PhieuBaoHanh WHERE Ma =?";
        try (Connection con = new JDBCUtil().getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PhieuBaoHanh bh = new PhieuBaoHanh(ma);
                return bh;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public PhieuBaoHanh getByMa(String ma) {
        String sql = "Select * from PhieuBaoHanh where ma = ?";
        try (Connection con = JDBCUtil.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, ma);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                PhieuBaoHanh bh = new PhieuBaoHanh(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getDate(4), rs.getInt(5), rs.getString(6), rs.getString(7));
                return bh;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public PhieuBaoHanh getByTen(String ten) {
        String sql = "Select * from PhieuBaoHanh where ten = ?";
        try (Connection con = JDBCUtil.getConnection(); PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, ten);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                PhieuBaoHanh bh = new PhieuBaoHanh(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getDate(4), rs.getInt(5), rs.getString(6), rs.getString(7));
                return bh;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new BaoHanhRepo().getAll());
    }

}
