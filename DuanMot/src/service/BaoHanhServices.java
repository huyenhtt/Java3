/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import ViewModel.PhieuBaoHanhViewModel;
import java.util.List;
import model.PhieuBaoHanh;
import repository.BaoHanhRepo;
import service.impl.BaoHanhInterface;

/**
 *
 * @author Administrator
 */
public class BaoHanhServices implements BaoHanhInterface {

    private final BaoHanhRepo bhRepo = new BaoHanhRepo();

    @Override
    public List<PhieuBaoHanhViewModel> getAll() {
        return bhRepo.getAll();
    }

    @Override
    public PhieuBaoHanh getByMa(String ma) {
        return bhRepo.getByMa(ma);
    }

    @Override
    public PhieuBaoHanh getByTen(String ten) {
        return bhRepo.getByTen(ten);
    }

    @Override
    public String add(PhieuBaoHanh bh) {
        boolean addBH = bhRepo.add(bh);
        if (addBH) {
            return "Add success";
        } else {
            return "Add error";
        }
    }

    @Override
    public String update(PhieuBaoHanh bh, String id) {
        boolean upBH = bhRepo.update(bh, id);
        if (upBH) {
            return "Update success";
        } else {
            return "Update error";
        }
    }

    @Override
    public String delete(String id) {
        boolean deleBH = bhRepo.delete(id);
        if (deleBH) {
            return "Delete success";
        } else {
            return "Delete error";
        }
    }

}
