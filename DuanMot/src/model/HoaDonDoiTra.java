/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class HoaDonDoiTra {

    private String id;

    private String ma;
    private int soLuong;
    private Date ngayDoi;
    private Date ngayNhan;
    private String lido;
    private String ghichu;
    private String idhdct;
    private String idnv;

    public HoaDonDoiTra() {
    }

    public HoaDonDoiTra(String id, String ma, int soLuong, Date ngayDoi, String lido, String idhdct, String idnv) {
        this.id = id;
        this.ma = ma;
        this.soLuong = soLuong;
        this.ngayDoi = ngayDoi;
        this.lido = lido;
        this.idhdct = idhdct;
        this.idnv = idnv;
    }

    public String getLido() {
        return lido;
    }

    public void setLido(String lido) {
        this.lido = lido;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public String getIdhdct() {
        return idhdct;
    }

    public void setIdhdct(String idhdct) {
        this.idhdct = idhdct;
    }

    public String getIdnv() {
        return idnv;
    }

    public void setIdnv(String idnv) {
        this.idnv = idnv;
    }

    public HoaDonDoiTra(String id, String ma, Date ngayDoi, Date ngayNhan, int soLuong) {
        this.id = id;
        this.ma = ma;
        this.ngayDoi = ngayDoi;
        this.ngayNhan = ngayNhan;
        this.soLuong = soLuong;
    }

//    public HoaDonDoiTra(String id, NhanVien nv, String ma, Date ngayDoi, Date ngayNhan, int soLuong) {
//        this.id = id;
//        this.nv = nv;
//        this.ma = ma;
//        this.ngayDoi = ngayDoi;
//        this.ngayNhan = ngayNhan;
//        this.soLuong = soLuong;
//    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

//    public NhanVien getNv() {
//        return nv;
//    }
//
//    public void setNv(NhanVien nv) {
//        this.nv = nv;
//    }
    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public Date getNgayDoi() {
        return ngayDoi;
    }

    public void setNgayDoi(Date ngayDoi) {
        this.ngayDoi = ngayDoi;
    }

    public Date getNgayNhan() {
        return ngayNhan;
    }

    public void setNgayNhan(Date ngayNhan) {
        this.ngayNhan = ngayNhan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

}
