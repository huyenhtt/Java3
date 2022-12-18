/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import JDBC.JDBCUtil;
import model.HoaDonDoiTra;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
                hdv.setNgayDoi(ngayDt);
                hdv.setNgayNhan(ngayNhan);
                hdv.setSoLuong(sl);
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
            ps.setDate(2, hdt.getNgayDoi());
            ps.setDate(3, hdt.getNgayNhan());
            ps.setInt(4, hdt.getSoLuong());
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
            ps.setDate(1, hdt.getNgayDoi());
            ps.setDate(2, hdt.getNgayNhan());
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
}
