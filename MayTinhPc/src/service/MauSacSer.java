/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.MauSac;
import repository.MauSacRepo;
import service.impl.IMauSac;

/**
 *
 * @author Admin
 */
public class MauSacSer implements IMauSac {

    private MauSacRepo repo;

    public MauSacSer() {
        repo = new MauSacRepo();
    }

    @Override
    public List<MauSac> all() {
        return repo.getList();
    }

    @Override
    public Integer insertMS(MauSac ms) {
        return repo.inssertMS(ms);
    }

    @Override
    public Integer updateMS(MauSac ms, String ma) {
        return repo.updateMS(ms, ma);
    }

    @Override
    public Integer deleteMS(String ma) {
        return repo.deleteMS(ma);
    }

    @Override
    public MauSac searchMau(String ma) {
        return repo.searchMau(ma);
    }

}
