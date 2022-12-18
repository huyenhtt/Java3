/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;


import java.util.List;
import model.DongSP;
import repository.DongSPRepo;
import service.impl.IDongSPSer;

/**
 *
 * @author Admin
 */
public class DongSPSer implements IDongSPSer {

    private final DongSPRepo repo;

    public DongSPSer() {
        this.repo = new DongSPRepo();
    }

    @Override
    public List<DongSP> getList() {
        return this.repo.all();
    }

    @Override
    public void insertDs(DongSP co) {
        this.repo.insertDSP(co);
    }

    @Override
    public void updateDs(String ma, DongSP bb) {
        this.repo.updateDSP(ma, bb);
    }

    @Override
    public void deleteDs(String ma) {
        this.repo.deleteDSP(ma);
    }

    @Override
    public String checkMADS(String ma) {
        return this.repo.checkMaDSP(ma);
    }

}
