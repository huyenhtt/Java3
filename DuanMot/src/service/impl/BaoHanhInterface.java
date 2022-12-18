/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service.impl;

import ViewModel.PhieuBaoHanhViewModel;
import java.util.List;
import model.PhieuBaoHanh;

/**
 *
 * @author Administrator
 */
public interface BaoHanhInterface {
    List<PhieuBaoHanhViewModel> getAll();
    
    PhieuBaoHanh getByMa(String ma);
    
    PhieuBaoHanh getByTen(String ten);
    
    String add(PhieuBaoHanh bh );
    
    String update(PhieuBaoHanh bh, String id);
    
    String delete(String id);
}
