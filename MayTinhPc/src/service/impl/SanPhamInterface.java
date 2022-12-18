/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import ViewModel.CTSPViewModel;
import model.SanPham;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface SanPhamInterface {

    ArrayList<SanPham> getAll();

    ArrayList<SanPham> searchSerial(String seri);

    void insert(SanPham sp);

    void update(SanPham sp, String maSP);

    void delete(String maSP);

}
