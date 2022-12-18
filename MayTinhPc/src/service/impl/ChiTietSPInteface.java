/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import ViewModel.CTSPViewModel;
import ViewModel.SanPhamBanHangViewModel;
import java.util.ArrayList;
import java.util.List;
import model.ChiTietSP;

/**
 *
 * @author Admin
 */
public interface ChiTietSPInteface {

    List<SanPhamBanHangViewModel> getAllSPBH();

    ArrayList<ChiTietSP> getAll();

    List<SanPhamBanHangViewModel> searchTenSP(String ten);

    List<SanPhamBanHangViewModel> searchMa(String ma);

    void insert(ChiTietSP ctsp);

    void update(ChiTietSP ctsp, String id);

    void delete(String id);

    boolean updateSoLuong(ChiTietSP ctsp, String id);

    ArrayList<CTSPViewModel> getListCTSPViewModel();

    
    List<SanPhamBanHangViewModel> getMau(String mau);
    
    List<SanPhamBanHangViewModel> getDongSP(String mau);
    
    List<SanPhamBanHangViewModel> getOCung(String mau);
    
    List<SanPhamBanHangViewModel> getRam(String mau);
    
    List<SanPhamBanHangViewModel> getHDH(String mau);
    

}
