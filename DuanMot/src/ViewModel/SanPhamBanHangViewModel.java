/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

/**
 *
 * @author Administrator
 */
public class SanPhamBanHangViewModel {

    private String idCTSP;
    private String ma;
    private String teSP;
    private String tenMauSac;
    private String tenDongsp;
    private String tenOCung;
    private String Pin;
    private String CPU;
    private String Ram;
    private String HeDH;
    private int soLuong;
    private double giaBan;

    public SanPhamBanHangViewModel() {
    }

    public SanPhamBanHangViewModel(String idCTSP, String ma, String teSP, String tenMauSac, String tenDongsp, String tenOCung, String Pin, String CPU, String Ram, String HeDH, int soLuong, double giaBan) {
        this.idCTSP = idCTSP;
        this.ma = ma;
        this.teSP = teSP;
        this.tenMauSac = tenMauSac;
        this.tenDongsp = tenDongsp;
        this.tenOCung = tenOCung;
        this.Pin = Pin;
        this.CPU = CPU;
        this.Ram = Ram;
        this.HeDH = HeDH;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
    }

    public String getIdCTSP() {
        return idCTSP;
    }

    public void setIdCTSP(String idCTSP) {
        this.idCTSP = idCTSP;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTeSP() {
        return teSP;
    }

    public void setTeSP(String teSP) {
        this.teSP = teSP;
    }

    public String getTenMauSac() {
        return tenMauSac;
    }

    public void setTenMauSac(String tenMauSac) {
        this.tenMauSac = tenMauSac;
    }

    public String getTenDongsp() {
        return tenDongsp;
    }

    public void setTenDongsp(String tenDongsp) {
        this.tenDongsp = tenDongsp;
    }

    public String getTenOCung() {
        return tenOCung;
    }

    public void setTenOCung(String tenOCung) {
        this.tenOCung = tenOCung;
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

    public String getHeDH() {
        return HeDH;
    }

    public void setHeDH(String HeDH) {
        this.HeDH = HeDH;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    @Override
    public String toString() {
        return idCTSP;
    }

    public Object[] toDataRow() {
        return new Object[]{ma, teSP, tenMauSac, tenDongsp, tenOCung, Pin, CPU, Ram, HeDH, soLuong, String.format("%.0f", giaBan)};
    }

}
