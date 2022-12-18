/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

import java.sql.Date;

/**
 *
 * @author Administrator
 */
public class PhieuBaoHanhViewModel {
      private String id;
    private String ma;
    private Date ngayMuaHang;
    private Date ngayBH;
    private int thoiGianBH;
    private String tenKH;
    private String IDhdct;

    public PhieuBaoHanhViewModel() {
    }

    public PhieuBaoHanhViewModel(String id, String ma, Date ngayMuaHang, Date ngayBH, int thoiGianBH, String tenKH, String IDhdct) {
        this.id = id;
        this.ma = ma;
        this.ngayMuaHang = ngayMuaHang;
        this.ngayBH = ngayBH;
        this.thoiGianBH = thoiGianBH;
        this.tenKH = tenKH;
        this.IDhdct = IDhdct;
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
    
    public Object[] toDataRow(){
        return new Object[]{id, ma, ngayMuaHang,  ngayBH, thoiGianBH,  tenKH, IDhdct};
    }
}
