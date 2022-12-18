/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import model.CPU;
import repository.CPURepo;
import service.impl.CPUInterface;

/**
 *
 * @author DELL
 */
public class CPUService implements CPUInterface {

    CPURepo repo = new CPURepo();

    public CPUService() {
        this.repo = new CPURepo();
    }

    @Override
    public ArrayList<CPU> getAll() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return repo.getAll();
    }

    @Override
    public void insert(CPU cpu) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        repo.insert(cpu);
    }

    @Override
    public void update(CPU cpu, String id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        repo.update(cpu, id);
    }

    @Override
    public void delete(String id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        repo.delete(id);
    }

}
