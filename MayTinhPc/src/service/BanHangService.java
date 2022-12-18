/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import ViewModel.HoaDonViewModel;
import ViewModel.SanPhamBanHangViewModel;
import ViewModel.TBGioHang;
import java.util.ArrayList;
import java.util.List;
import model.KhachHang;
import repository.BanHangRepo;
import service.impl.BanHangInterface;

/**
 *
 * @author Admin
 */
public class BanHangService implements BanHangInterface{
    
    BanHangRepo repo;

   

    @Override
    public ArrayList<HoaDonViewModel> getListHoaDon() {
        return repo.getListHoaDon();
    }

    @Override
    public TBGioHang updateGH(ArrayList<TBGioHang> list, String ma) {
        return repo.updateGH(list, ma);
    }

    public BanHangService() {
        repo = new BanHangRepo();
    }

    @Override
    public KhachHang getListSDT(String sdt) {
        return repo.getListSDT(sdt);
    }

    @Override
    public List<SanPhamBanHangViewModel> searchMa(String ma) {
        return repo.searchMa(ma);
    }

    @Override
    public List<SanPhamBanHangViewModel> searchTen(String ten) {
        return repo.searchTen(ten);
    }

    @Override
    public ArrayList<TBGioHang> getListGioHang(String idHD) {
        return repo.getListGioHang(idHD);
    }
    
    
    
}
