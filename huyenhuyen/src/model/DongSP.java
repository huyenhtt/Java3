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
public class DongSP {

    private String idD;
    private String maD;
    private String tenD;

    public DongSP() {
    }

    public DongSP(String idD, String maD, String tenD) {
        this.idD = idD;
        this.maD = maD;
        this.tenD = tenD;
    }

    public String getIdD() {
        return idD;
    }

    public void setIdD(String idD) {
        this.idD = idD;
    }

    public String getMaD() {
        return maD;
    }

    public void setMaD(String maD) {
        this.maD = maD;
    }

    public String getTenD() {
        return tenD;
    }

    public void setTenD(String tenD) {
        this.tenD = tenD;
    }

    @Override
    public String toString() {
        return "DongSP{" + "tenD=" + tenD + '}';
    }

}
