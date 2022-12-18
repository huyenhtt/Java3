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
public class Pin {

    private String id;
    private String ma;
    private String dungLuong;

    public Pin() {
    }

    public Pin(String id, String ma, String dungLuong) {
        this.id = id;
        this.ma = ma;
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
