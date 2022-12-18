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
public class CTSPViewModel {
    
    private String id;
    private double giaBan;
    private int soLuongTon;
    private int trangThai;
    private String MauSac;
    private String Dongsp;
    private String OCung;
    private String CongKetNoi;
    private String Pin;
    private String CPU;
    private String Ram;
    private String CardMH;
    private String HeDH;
    private String maSP;
    private String serial;
    private String ten;

    public CTSPViewModel() {
    }

    public CTSPViewModel(String id, double giaBan, int soLuongTon, int trangThai, String MauSac, String Dongsp, String OCung, String CongKetNoi, String Pin, String CPU, String Ram, String CardMH, String HeDH, String maSP, String serial, String ten) {
        this.id = id;
        this.giaBan = giaBan;
        this.soLuongTon = soLuongTon;
        this.trangThai = trangThai;
        this.MauSac = MauSac;
        this.Dongsp = Dongsp;
        this.OCung = OCung;
        this.CongKetNoi = CongKetNoi;
        this.Pin = Pin;
        this.CPU = CPU;
        this.Ram = Ram;
        this.CardMH = CardMH;
        this.HeDH = HeDH;
        this.maSP = maSP;
        this.serial = serial;
        this.ten = ten;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getGiaBan() {
        return Double.parseDouble(String.format("%.0f", giaBan));
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getMauSac() {
        return MauSac;
    }

    public void setMauSac(String MauSac) {
        this.MauSac = MauSac;
    }

    public String getDongsp() {
        return Dongsp;
    }

    public void setDongsp(String Dongsp) {
        this.Dongsp = Dongsp;
    }

    public String getOCung() {
        return OCung;
    }

    public void setOCung(String OCung) {
        this.OCung = OCung;
    }

    public String getCongKetNoi() {
        return CongKetNoi;
    }

    public void setCongKetNoi(String CongKetNoi) {
        this.CongKetNoi = CongKetNoi;
    }

    public String getPin() {
        return Pin;
    }

    public void setPin(String Pin) {
        this.Pin = Pin;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public String getRam() {
        return Ram;
    }

    public void setRam(String Ram) {
        this.Ram = Ram;
    }

    public String getCardMH() {
        return CardMH;
    }

    public void setCardMH(String CardMH) {
        this.CardMH = CardMH;
    }

    public String getHeDH() {
        return HeDH;
    }

    public void setHeDH(String HeDH) {
        this.HeDH = HeDH;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    @Override
    public String toString() {
        return id;
    }
    
    
    
}
