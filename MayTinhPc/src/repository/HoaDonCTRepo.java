/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import JDBC.JDBCUtil;
import ViewModel.HoaDonCTViewModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.ChiTietSP;
import model.HoaDon;
import model.HoaDonCT;

/**
 *
 * @author Admin
 */
public class HoaDonCTRepo {
     public List<HoaDonCT> all() {
        List<HoaDonCT> listHd = new ArrayList<>();
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "select * from HoaDonChiTiet";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String idCTSP = rs.getString("IdCTSP");
                String idHD = rs.getString("IdHD");
                int sl = rs.getInt("SoLuong");
                double dgia = rs.getDouble("DonGia");
                double thanhTien=rs.getDouble("ThanhTien");
                HoaDonCT hd = new HoaDonCT("", sl, dgia, thanhTien, idHD, idCTSP);
                listHd.add(hd);
            }
            return listHd;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
     
     public static void main(String[] args) {
        new HoaDonCTRepo().all();
    }
//
    public Integer inserHDCTR(HoaDonCT hdct) {
        Integer kq = -1;
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "Insert into HoaDonChiTiet " + "(IdHD,IdCTSP,SoLuong,DonGia)" + " Values(?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
          
           
            ps.setString(1, hdct.getIdHD());
            ps.setString(2, hdct.getIdCTSP());
            ps.setInt(3, hdct.getSoLuong());
            ps.setDouble(4, hdct.getGia());
            kq = ps.executeUpdate();
            return kq;
        } catch (Exception e) {
            e.printStackTrace(System.out);

        }
        return null;

    }

    public Integer updateHDCTR(HoaDonCT hdct, String id) {
        Integer kq = -1;
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "update HoaDonChiTiet set SoLuong=?,DonGia=? Where Id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, hdct.getSoLuong());
            ps.setDouble(2, hdct.getGia());
            ps.setString(3, id);
            kq = ps.executeUpdate();
            return kq;
        } catch (Exception e) {
            e.printStackTrace(System.out);

        }
        return null;

    }

    public Integer deleteHDR(String id) {
        Integer kq = -1;
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "Delete From HoaDonChiTiet Where Id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);

            kq = ps.executeUpdate();
            return kq;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }
}
