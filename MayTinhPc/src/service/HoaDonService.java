/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import ViewModel.HoaDonVM;
import java.util.List;
import model.HoaDon;
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
    public List<HoaDonVM> getListHD() {
        return repo.getListHDV();
    }

}
