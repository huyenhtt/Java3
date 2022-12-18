/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.Pin;
import repository.PinRepo;
import service.impl.IPinSer;

/**
 *
 * @author Admin
 */
public class PinSer implements IPinSer {

    private PinRepo repo;

    public PinSer() {
        repo = new PinRepo();
    }

    @Override
    public List<Pin> getList() {
        return repo.all();
    }

    @Override
    public Integer insertPin(Pin pin) {
        return repo.insertpin(pin);
    }

    @Override
    public Integer deletePin(String ma) {
        return repo.deletepin(ma);
    }

    @Override
    public Integer updatePin(Pin pin, String ma) {
        return repo.updatepin(pin, ma);
    }

}
