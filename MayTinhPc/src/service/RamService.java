/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import model.Ram;
import repository.RamRepository;
import service.impl.RamInterface;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class RamService implements RamInterface{
    
    RamRepository repo = new RamRepository();

    public RamService() {
        this.repo= new RamRepository();
    }

    @Override
    public ArrayList<Ram> getAll() {
        return repo.getAll();
    }

    @Override
    public void insert(Ram ram) {
        repo.insert(ram);
    }

    @Override
    public void update(Ram ram, String id) {
        repo.update(ram, id);
    }

    @Override
    public void delete(String id) {
        repo.delete(id);
    }

    @Override
    public List<Ram> searchRam(String ma) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return repo.searchRAM(ma);
    }
    
    
    
}
