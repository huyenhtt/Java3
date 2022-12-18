/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import model.OCung;
import repository.OCungRepo;
import service.impl.OCungInterface;

/**
 *
 * @author Admin
 */
public class OCungService implements OCungInterface{
    
     OCungRepo orepo = new OCungRepo();

    @Override
    public ArrayList<OCung> getAll() {
        return orepo.getAll();
    }

    @Override
    public void insert(OCung oc) {
        orepo.insert(oc);
    }

    @Override
    public void update(OCung oc, String ma) {
        orepo.update(oc, ma);
    }

    @Override
    public void delete(String ma) {
        orepo.delete(ma);
    }
    
    
}
