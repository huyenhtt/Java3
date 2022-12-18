/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.HoaDonCT;
import repository.HoaDonCTRepo;
import service.impl.IHoaDonCT;

/**
 *
 * @author Admin
 */
public class HoaDonCTSer implements IHoaDonCT {

    private HoaDonCTRepo repo;

    public HoaDonCTSer() {
        repo = new HoaDonCTRepo();
    }

    @Override
    public List<HoaDonCT> getAll() {
        return repo.all();
    }

    @Override
    public Integer insertHDCT(HoaDonCT ct) {
        return repo.inserHDCTR(ct);
    }

    @Override
    public Integer updateHDCT(HoaDonCT ct, String id) {
        return repo.updateHDCTR(ct, id);
    }

    @Override
    public Integer deleteHDCT(String id) {
        return repo.deleteHDR(id);
    }

}
