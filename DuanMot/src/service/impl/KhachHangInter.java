/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import java.util.ArrayList;
import model.KhachHang;

/**
 *
 * @author PC
 */
public interface KhachHangInter {
    
    ArrayList<KhachHang> getList();
    
    void insert(KhachHang kh);
    
    void delete(String ma);
    
    void update(String id, KhachHang kh);
    
    KhachHang searchByMa(String ma);
    
    KhachHang searchByTen(String ten);
}
