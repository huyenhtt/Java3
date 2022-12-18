/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Administrator
 */
public class Hedieuhanh {
    private String id;
    private String ma;
    private String tenHDH;

    public Hedieuhanh() {
    }

    public Hedieuhanh(String id, String ma, String tenHDH) {
        this.id = id;
        this.ma = ma;
        this.tenHDH = tenHDH;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTenHDH() {
        return tenHDH;
    }

    public void setTenHDH(String tenHDH) {
        this.tenHDH = tenHDH;
    }
    
          public Object[] toDataRow(){
              return new Object[]{id,ma,tenHDH};
          } 

    @Override
    public String toString() {
        return tenHDH;
    }

          
          
}
