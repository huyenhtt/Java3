/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import ViewModel.CTSPViewModel;
import model.SanPham;
import repository.SanPhamRepo;
import service.impl.SanPhamInterface;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class SanPhamService implements SanPhamInterface{
    
     SanPhamRepo spr = new SanPhamRepo();

    @Override
    public ArrayList<SanPham> getAll() {
        return spr.getAll();
    }

    @Override
    public void insert(SanPham sp) {
        spr.insert(sp);
    }

    @Override
    public void update(SanPham sp, String maSP) {
        spr.update(sp, maSP);
    }

    @Override
    public void delete(String maSP) {
        spr.delete(maSP);
    }

    @Override
    public String getIDSP(String ma) {
        return spr.getIDSP(ma);
    }

    


}
