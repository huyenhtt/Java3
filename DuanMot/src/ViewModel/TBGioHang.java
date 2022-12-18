/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewModel;

/**
 *
 * @author Admin
 */
public class TBGioHang {

    private String id;
    private String maSP;
    private String tenSP;
    private int soLuong;
    private double donGia;
    private double tongTien;
    private String idHD;
    private String idCTSP;

    public TBGioHang() {
    }

    public TBGioHang(String id, String maSP, String tenSP, int soLuong, double donGia, double tongTien, String idHD, String idCTSP) {
        this.id = id;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.tongTien = tongTien;
        this.idHD = idHD;
        this.idCTSP = idCTSP;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdHD() {
        return idHD;
    }

    public void setIdHD(String idHD) {
        this.idHD = idHD;
    }

    public String getIdCTSP() {
        return idCTSP;
    }

    public void setIdCTSP(String idCTSP) {
        this.idCTSP = idCTSP;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public double getTongTien() {
        return soLuong * donGia;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    @Override
    public String toString() {
        return "{\n Hoá đơn chi tiết : " + "\n Mã sản phẩm : " + maSP + ", \n Tên sản phẩm : " + tenSP + ",\n Số lượng = " + soLuong + ",\n Giá = " + String.format("%.0f", donGia) + ",\n Thành tiền = " + String.format("%.0f", tongTien) + "\n}";
    }

}
