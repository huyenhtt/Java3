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
public class HoaDonViewModel {

    private String maHD;
    private Date ngayTao;
    private String maNV;
    private String trangThai;
    private String idHD;
    private double tongTien;

    public HoaDonViewModel() {
    }

    public HoaDonViewModel(String maHD, Date ngayTao, String maNV, String trangThai, String idHD) {
        this.maHD = maHD;
        this.ngayTao = ngayTao;
        this.maNV = maNV;
        this.trangThai = trangThai;
        this.idHD = idHD;
    }

    public HoaDonViewModel(String maHD, Date ngayTao, String maNV, String trangThai, String idHD, double tongTien) {
        this.maHD = maHD;
        this.ngayTao = ngayTao;
        this.maNV = maNV;
        this.trangThai = trangThai;
        this.idHD = idHD;
        this.tongTien = tongTien;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public String getIdHD() {
        return idHD;
    }

    public void setIdHD(String idHD) {
        this.idHD = idHD;
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

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

}
