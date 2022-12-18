/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import model.HoaDonDoiTra;
import repository.HoaDonDTRepo;
import java.util.List;
import service.impl.IHoaDonDoiTra;

/**
 *
 * @author Admin
 */
public class HoaDonDoiTraSerVice implements IHoaDonDoiTra {

    private HoaDonDTRepo repo;

    public HoaDonDoiTraSerVice() {
        repo = new HoaDonDTRepo();
    }

    @Override
    public List<HoaDonDoiTra> getAll() {
        return this.repo.allDT();
    }

    @Override
    public Integer deleteHD(String ma) {
        return this.repo.deleteHDDTR(ma);
    }

    @Override
    public Integer insertHD(HoaDonDoiTra hd) {
        return this.repo.insertHDDTR(hd);
    }

    @Override
    public Integer updateHD(HoaDonDoiTra hd, String id) {
        return this.repo.updateHDDTR(hd, id);
    }

}
