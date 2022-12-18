/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import model.KhachHang;
import repository.KhachHangRepo;
import service.impl.KhachHangInter;

/**
 *
 * @author PC
 */
public class KhachHangService implements KhachHangInter{
    KhachHangRepo khr = new KhachHangRepo();
    
    @Override
    public ArrayList<KhachHang> getList(){
        return khr.getList();
    }
    
    @Override
    public void insert(KhachHang kh){
        khr.insert(kh);
    }
    
    @Override
    public void delete(String ma){
        khr.delete(ma);
    }
    
    @Override
    public void update(String id, KhachHang kh){
        khr.update(id, kh);
    }
    
    @Override
    public KhachHang searchByMa(String ma){
        return khr.searchByMa(ma);
    }
    
    @Override
    public KhachHang searchByTen(String ten){
        return khr.searchByTen(ten);
    }
}
