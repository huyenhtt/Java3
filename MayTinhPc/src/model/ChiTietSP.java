/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Admin
 */
public class ChiTietSP {
    
    private String id;
    private double giaBan;
    private int soLuongTon;
    private int trangThai;
    private String idMauSac;
    private String IdDongsp;
    private String IdOCung;
    private String IdCongKetNoi;
    private String IdPin;
    private String IdCPU;
    private String IdRam;
    private String IdCardMH;
    private String IdHeDH;
    private String IdSP;

    public ChiTietSP() {
    }

    public ChiTietSP(String id, double giaBan, int soLuongTon, int trangThai, String idMauSac, String IdDongsp, String IdOCung, String IdCongKetNoi, String IdPin, String IdCPU, String IdRam, String IdCardMH, String IdHeDH, String IdSP) {
        this.id = id;
        this.giaBan = giaBan;
        this.soLuongTon = soLuongTon;
        this.trangThai = trangThai;
        this.idMauSac = idMauSac;
        this.IdDongsp = IdDongsp;
        this.IdOCung = IdOCung;
        this.IdCongKetNoi = IdCongKetNoi;
        this.IdPin = IdPin;
        this.IdCPU = IdCPU;
        this.IdRam = IdRam;
        this.IdCardMH = IdCardMH;
        this.IdHeDH = IdHeDH;
        this.IdSP = IdSP;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getGiaBan() {
        return giaBan;
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
        if (soLuongTon > 0) {
            trangThai = 1;
        }else{
            trangThai = 0;
        }
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getIdMauSac() {
        return idMauSac;
    }

    public void setIdMauSac(String idMauSac) {
        this.idMauSac = idMauSac;
    }

    public String getIdDongsp() {
        return IdDongsp;
    }

    public void setIdDongsp(String IdDongsp) {
        this.IdDongsp = IdDongsp;
    }

    public String getIdOCung() {
        return IdOCung;
    }

    public void setIdOCung(String IdOCung) {
        this.IdOCung = IdOCung;
    }

    public String getIdCongKetNoi() {
        return IdCongKetNoi;
    }

    public void setIdCongKetNoi(String IdCongKetNoi) {
        this.IdCongKetNoi = IdCongKetNoi;
    }

    public String getIdPin() {
        return IdPin;
    }

    public void setIdPin(String IdPin) {
        this.IdPin = IdPin;
    }

    public String getIdCPU() {
        return IdCPU;
    }

    public void setIdCPU(String IdCPU) {
        this.IdCPU = IdCPU;
    }

    public String getIdRam() {
        return IdRam;
    }

    public void setIdRam(String IdRam) {
        this.IdRam = IdRam;
    }

    public String getIdCardMH() {
        return IdCardMH;
    }

    public void setIdCardMH(String IdCardMH) {
        this.IdCardMH = IdCardMH;
    }

    public String getIdHeDH() {
        return IdHeDH;
    }

    public void setIdHeDH(String IdHeDH) {
        this.IdHeDH = IdHeDH;
    }

    public String getIdSP() {
        return IdSP;
    }

    public void setIdSP(String IdSP) {
        this.IdSP = IdSP;
    }
    
    
    
}
