/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import ViewModel.HoaDonVM;
import ViewModel.TBGioHang;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import model.HoaDon;
import model.KhachHang;
import model.thongKe;
import repository.HoaDonRepo;
import service.impl.IHoaDonS;

/**
 *
 * @author Admin
 */
public class HoaDonService implements IHoaDonS {

    private HoaDonRepo repo;

    public HoaDonService() {
        repo = new HoaDonRepo();
    }

    @Override

    public List<HoaDon> getAll() {
        return this.repo.allH();
    }

    @Override
    public Integer insertHD(HoaDon hd) {
        return repo.insertHDR(hd);
    }

    @Override
    public Integer updateHD(HoaDon hd, String ma) {
        return repo.upadteHDR(hd, ma);
    }

    @Override
    public Integer deleteHD(String ma) {
        return repo.deleteHDR(ma);
    }

    @Override
    public List<HoaDon> searchHD(String ma) {
        return repo.searchHDon(ma);
    }

    @Override
    public List<HoaDon> searchHDTT(String trangThai) {
        return repo.searchHDonTrangThai(trangThai);
    }

    @Override
    public List<HoaDon> searchThang(int thang) {
        return repo.searchThang(thang);
    }

    @Override
    public List<HoaDon> searchNam(int nam) {
        return repo.searchNam(nam);
    }

    @Override
    public List<HoaDonVM> getListHDA(Date ngayTao1, Date ngayTao2) {

        return repo.getListHDVa(ngayTao1, ngayTao2);
    }

    @Override
    public List<HoaDonVM> searchThangVM(int thang) {
        return repo.searchThangV(thang);
    }

    @Override
    public List<HoaDonVM> searchNamVM(int nam) {
        return repo.searchNamV(nam);
    }

    @Override
    public List<KhachHang> getSDTvm() {
        return repo.getSDTVM();
    }

    @Override
    public List<HoaDonVM> searchSDTVM(String sdt) {
        return repo.searchSDT(sdt);
    }

    @Override
    public List<KhachHang> getHTenKH() {
        return repo.getHoTen();
    }

    @Override
    public List<HoaDonVM> searchkhoangTien1() {
        return repo.searchkhoangTien();
    }

    @Override
    public List<HoaDonVM> searchkhoangTien2() {
        return repo.searchkhoangTien2();
    }

    @Override
    public List<HoaDonVM> searchkhoangTien3() {
        return repo.searchkhoangTien3();
    }

    @Override
    public List<HoaDonVM> searchkhoangTien4() {
        return repo.searchkhoangTien4();
    }

    @Override
    public ArrayList<TBGioHang> getListHDCTVM(String mahd) {
        return repo.getListHDCT(mahd);
    }

    @Override
    public List<HoaDonVM> SearchTrangThaiVM(String trangThai) {
        return repo.SearchTrangThai(trangThai);
    }

    @Override
    public ArrayList<TBGioHang> SearchTenSPVm(String ten, String mahd) {
        return repo.SearchTenSP(ten, mahd);
    }

    @Override
    public ArrayList<TBGioHang> SearchMaSPVm(String masp, String mahd) {
        return repo.SearchMaSP(masp, mahd);
    }

    @Override
    public List<HoaDonVM> getListHD() {
        return repo.getListHDV();
    }

    @Override
    public List<thongKe> getdoanhthu() {
        return repo.getListTK();
    }

    @Override
    public List<thongKe> getSP() {
        return repo.getListSP();
    }

    @Override
    public List<thongKe> getKH() {
        return repo.getListKH();
    }

}
