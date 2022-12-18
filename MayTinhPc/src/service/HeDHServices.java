/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.Hedieuhanh;
import repository.HeDHRepo;
import service.impl.HeDHInterface;

/**
 *
 * @author Administrator
 */
public class HeDHServices implements HeDHInterface {

    HeDHRepo hRepo = new HeDHRepo();

    @Override
    public List<Hedieuhanh> getAll() {
        return hRepo.all();
    }

    @Override
    public String add(Hedieuhanh h) {
        boolean add = hRepo.insert(h);
        if (add) {
            return "Add success";
        } else {
            return "Add error";
        }
    }

    @Override
    public String update(Hedieuhanh h, String id) {
        boolean up = hRepo.update(h, id);
        if (up) {
            return "Update success";
        } else {
            return "Update error";
        }
    }

    @Override
    public String delete(String id) {
        boolean dele = hRepo.deletep(id);
        if (dele) {
            return "Delete success";
        } else {
            return "Delete error";
        }
    }

}
