/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import ViewModel.HoaDonVM;
import ViewModel.TBGioHang;
import java.util.ArrayList;
import java.sql.Date;
import model.HoaDon;
import java.util.List;
import model.KhachHang;
import model.thongKe;

/**
 *
 * @author Admin
 */
public interface IHoaDonS {
 List<thongKe> getdoanhthu();
    
     List<thongKe> getSP();
     
     List<thongKe> getKH();
    List<HoaDon> getAll();

    List<HoaDon> searchHD(String ma);

    Integer insertHD(HoaDon hd);

    List<HoaDon> searchHDTT(String tinhTrang);

    List<HoaDon> searchThang(int thang);
//search ql hoá đơn

    List<HoaDonVM> searchThangVM(int thang);

    List<HoaDonVM> searchNamVM(int nam);

    List<KhachHang> getSDTvm();

    List<KhachHang> getHTenKH();

    List<HoaDonVM> searchSDTVM(String sdt);
///////////////////////
//seach theo khoang tien

    List<HoaDonVM> searchkhoangTien1();

    List<HoaDonVM> searchkhoangTien2();

    List<HoaDonVM> searchkhoangTien3();

    List<HoaDonVM> searchkhoangTien4();

    List<HoaDon> searchNam(int nam);
//lấy mã

    ArrayList<TBGioHang> getListHDCTVM(String mahd);
///search trạng thái

    List<HoaDonVM> SearchTrangThaiVM(String trangThai);
//search ma/ten sp 

    ArrayList<TBGioHang> SearchTenSPVm(String ten, String mahd);

    ArrayList<TBGioHang> SearchMaSPVm(String masp, String mahd);

    Integer updateHD(HoaDon hd, String ma);

    Integer deleteHD(String ma);

    List<HoaDonVM> getListHDA(Date ngayTao1, Date ngayTao2);

    List<HoaDonVM> getListHD();
}
