/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import model.NhanVien;
import repository.NhanVienRepo;
import service.impl.NhanVienInterface;
import java.util.ArrayList;


/**
 *
 * @author PC
 */
public class NhanVienService implements NhanVienInterface{
    NhanVienRepo nvr = new NhanVienRepo();
    
    @Override
    public ArrayList<NhanVien> getList(){
        return nvr.getList();
    }
    
    @Override
    public void insert(NhanVien nv){
        nvr.insert(nv);
    }
    
    @Override
    public void delete(String id){
        nvr.delele(id);
    }
    
    @Override
    public void update(String id, NhanVien nv){
        nvr.update(id, nv);
    }
    
    @Override
    public NhanVien searchByMa(String manv){
        return nvr.searchByMa(manv);
    }
    
    @Override
    public NhanVien searchByTen(String tennv){
        return nvr.searchByTen(tennv);
    }
}
