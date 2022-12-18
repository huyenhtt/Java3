/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import model.DongSP;
import repository.DongSPRepo;
import service.impl.DongSPInterface;

/**
 *
 * @author Admin
 */
public class DongSPService implements DongSPInterface{
    
    DongSPRepo repo = new DongSPRepo();

    @Override
    public ArrayList<DongSP> getAll() {
        
        return repo.getAll();
    }
    

    @Override
    public void insert(DongSP dsp) {
        repo.insert(dsp);
    }

    @Override
    public void update(DongSP dsp, String ma) {
        repo.update(dsp, ma);
    }

    @Override
    public void delete(String ma) {
        repo.delete(ma);
    }
    
}
