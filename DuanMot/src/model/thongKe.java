/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Administrator
 */
public class thongKe {

    private double doanhThu;
    private String ngayThanhToan;
    private String tenSP;
    private String tenKH;
    private int soLuong;
    private int slhdct;

    public thongKe() {
    }

    public thongKe(double doanhThu, String ngayThanhToan) {
        this.doanhThu = doanhThu;
        this.ngayThanhToan = ngayThanhToan;
    }

    public thongKe(String tenSP, int soLuong) {
        this.tenSP = tenSP;
        this.soLuong = soLuong;
    }

    public thongKe(int slhdct, String tenKH) {
        this.tenKH = tenKH;
        this.slhdct = slhdct;
    }

    public int getSlhdct() {
        return slhdct;
    }

    public void setSlhdct(int slhdct) {
        this.slhdct = slhdct;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
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

    public double getDoanhThu() {
        return doanhThu;
    }

    public void setDoanhThu(double doanhThu) {
        this.doanhThu = doanhThu;
    }

    public String getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(String ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    @Override
    public String toString() {
        return "thongKe{" + "tenKH=" + tenKH + ", slhdct=" + slhdct + '}';
    }

}
