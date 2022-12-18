/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.CongKetNoi;
import repository.CongKetNoiRepo;
import service.impl.ICongKetNoiS;

/**
 *
 * @author Admin
 */
public class CongKetNoiSer implements ICongKetNoiS {

    private CongKetNoiRepo repo;

    public CongKetNoiSer() {
        repo = new CongKetNoiRepo();
    }

    @Override
    public List<CongKetNoi> getall() {
        return repo.getList();
    }

    @Override
    public Integer insserrtCKN(CongKetNoi kn) {
        return repo.inssertKNS(kn);
    }

    @Override
    public Integer updateCKN(CongKetNoi kn, String ma) {
        return repo.updateKN(kn, ma);
    }

    @Override
    public Integer deleteCKN(String ma) {
        return repo.deleteMS(ma);
    }

    @Override
    public CongKetNoi searchCKN(String ma) {
        return repo.searchKN(ma);
    }

}
