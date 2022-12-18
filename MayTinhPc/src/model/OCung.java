/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Admin
 */
public class OCung {
    
    private String id;
    private String ma;
    private String ten;
    private String dungLuong;

    public OCung() {
    }

    public OCung(String id, String ma, String ten, String dungLuong) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.dungLuong = dungLuong;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDungLuong() {
        return dungLuong;
    }

    public void setDungLuong(String dungLuong) {
        this.dungLuong = dungLuong;
    }

    @Override
    public String toString() {
        return dungLuong;
    }
    
    
    
    
}
