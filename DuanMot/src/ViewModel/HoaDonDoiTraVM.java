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
public class HoaDonDoiTraVM {

    private String idHD;
    private String maHD;
    private String maHDDT;
    private String makh;
    private String tenKhachHang;
    private int soluong;
    private double gia;
    private Date ngayDoiTra;
    private String lidoDt;
    private Date ngayMua;
    private Date hanTra;
    private double tongTien;
    private String nguoiTao;
    private String idNV;

    public HoaDonDoiTraVM() {
    }

    public HoaDonDoiTraVM(String maHD, String makh, String tenKhachHang, int soluong, double gia, Date ngayDoiTra, String lidoDt, String nguoiTao) {
        this.maHD = maHD;
        this.makh = makh;
        this.tenKhachHang = tenKhachHang;
        this.soluong = soluong;
        this.gia = gia;
        this.ngayDoiTra = ngayDoiTra;
        this.lidoDt = lidoDt;
        this.nguoiTao = nguoiTao;
    }

    public HoaDonDoiTraVM(String idHD, String maHD, String makh, String tenKhachHang, int soluong, double gia, Date ngayDoiTra, String lidoDt, String nguoiTao) {
        this.idHD = idHD;
        this.maHD = maHD;
        this.makh = makh;
        this.tenKhachHang = tenKhachHang;
        this.soluong = soluong;
        this.gia = gia;
        this.ngayDoiTra = ngayDoiTra;
        this.lidoDt = lidoDt;
        this.nguoiTao = nguoiTao;
    }

    public HoaDonDoiTraVM(String idHD, String maHD, String maHDDT, String makh, String tenKhachHang, int soluong, double gia, Date ngayDoiTra, String lidoDt, String nguoiTao) {
        this.idHD = idHD;
        this.maHD = maHD;
        this.maHDDT = maHDDT;
        this.makh = makh;
        this.tenKhachHang = tenKhachHang;
        this.soluong = soluong;
        this.gia = gia;
        this.ngayDoiTra = ngayDoiTra;
        this.lidoDt = lidoDt;
        this.nguoiTao = nguoiTao;
    }

    public String getMaHDDT() {
        return maHDDT;
    }

    public void setMaHDDT(String maHDDT) {
        this.maHDDT = maHDDT;
    }

    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public Date getNgayDoiTra() {
        return ngayDoiTra;
    }

    public void setNgayDoiTra(Date ngayDoiTra) {
        this.ngayDoiTra = ngayDoiTra;
    }

    public String getLidoDt() {
        return lidoDt;
    }

    public void setLidoDt(String lidoDt) {
        this.lidoDt = lidoDt;
    }

    public HoaDonDoiTraVM(String idHD, String maHD, String tenKhachHang, Date ngayMua, Date hanTra, double tongTien, String nguoiTao, String idNV) {
        this.idHD = idHD;
        this.maHD = maHD;
        this.tenKhachHang = tenKhachHang;
        this.ngayMua = ngayMua;
        this.hanTra = hanTra;
        this.tongTien = tongTien;
        this.nguoiTao = nguoiTao;
        this.idNV = idNV;
    }

    public String getIdNV() {
        return idNV;
    }

    public void setIdNV(String idNV) {
        this.idNV = idNV;
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

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public Date getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(Date ngayMua) {
        this.ngayMua = ngayMua;
    }

    public Date getHanTra() {
        return hanTra;
    }

    public void setHanTra(Date hanTra) {
        this.hanTra = hanTra;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public String getNguoiTao() {
        return nguoiTao;
    }

    public void setNguoiTao(String nguoiTao) {
        this.nguoiTao = nguoiTao;
    }

}
