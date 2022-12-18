/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import java.util.List;
import model.MauSac;

/**
 *
 * @author Admin
 */
public interface IMauSac {

    List<MauSac> all();

    Integer insertMS(MauSac ms);

    Integer updateMS(MauSac ms, String ma);

    Integer deleteMS(String ma);
    
    MauSac searchMau(String ma);

}
