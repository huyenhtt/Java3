/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewModel;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class HoaDonVM {

    private String id;
    private String maHD;
    private Date ngayTao;
    private String manv;
    private String tennv;
    private String makh;
    private String tenkh;
    private String sdt;
    private String trangThai;
    private double tongTien;

    public HoaDonVM() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public HoaDonVM(String maHD, Date ngayTao, String manv, String tennv, String makh, String tenkh, String sdt, String trangThai) {
        this.maHD = maHD;
        this.ngayTao = ngayTao;
        this.manv = manv;
        this.tennv = tennv;
        this.makh = makh;
        this.tenkh = tenkh;
        this.sdt = sdt;
        this.trangThai = trangThai;
    }

    public HoaDonVM(String maHD, Date ngayTao, String manv, String tennv, String makh, String tenkh, String sdt, String trangThai, double tongTien) {
        this.maHD = maHD;
        this.ngayTao = ngayTao;
        this.manv = manv;
        this.tennv = tennv;
        this.makh = makh;
        this.tenkh = tenkh;
        this.sdt = sdt;
        this.trangThai = trangThai;
        this.tongTien = tongTien;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public String getTenkh() {
        return tenkh;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    @Override
    public String toString() {
        return tennv;
    }

}
