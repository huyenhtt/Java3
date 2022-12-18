/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author DELL
 */
public class CardManHinh {

    private String id;
    private String ma;
    private String loaiCard;

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

    public String getLoaiCard() {
        return loaiCard;
    }

    public void setLoaiCard(String loaiCard) {
        this.loaiCard = loaiCard;
    }

    public CardManHinh() {
    }

    public CardManHinh(String id, String ma, String loaiCard) {
        this.id = id;
        this.ma = ma;
        this.loaiCard = loaiCard;
    }

    @Override
    public String toString() {
        return loaiCard;
    }
    
    

    
}
