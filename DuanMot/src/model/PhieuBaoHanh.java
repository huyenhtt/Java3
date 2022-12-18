/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author DELL
 */
public class PhieuBaoHanh {
    private String id;
    private String ma;
    private Date ngayMuaHang;
    private Date ngayBH;
    private int thoiGianBH;
    private String tenKH;
    private String IDhdct;

    public PhieuBaoHanh() {
    }

    public PhieuBaoHanh(String id, String ma, Date ngayMuaHang, Date ngayBH, int thoiGianBH, String tenKH, String IDhdct) {
        this.id = id;
        this.ma = ma;
        this.ngayMuaHang = ngayMuaHang;
        this.ngayBH = ngayBH;
        this.thoiGianBH = thoiGianBH;
        this.tenKH = tenKH;
        this.IDhdct = IDhdct;
    }

    public PhieuBaoHanh(String ma) {
        this.ma = ma;
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

    public Date getNgayMuaHang() {
        return ngayMuaHang;
    }

    public void setNgayMuaHang(Date ngayMuaHang) {
        this.ngayMuaHang = ngayMuaHang;
    }

    public Date getNgayBH() {
        return ngayBH;
    }

    public void setNgayBH(Date ngayBH) {
        this.ngayBH = ngayBH;
    }

    public int getThoiGianBH() {
        return thoiGianBH;
    }

    public void setThoiGianBH(int thoiGianBH) {
        this.thoiGianBH = thoiGianBH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getIDhdct() {
        return IDhdct;
    }

    public void setIDhdct(String IDhdct) {
        this.IDhdct = IDhdct;
    }

    
}
