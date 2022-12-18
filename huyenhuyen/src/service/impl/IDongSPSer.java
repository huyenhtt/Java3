/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import java.util.List;
import model.DongSP;

/**
 *
 * @author Admin
 */
public interface IDongSPSer {

    List<DongSP> getList();

    void insertDs(DongSP dong);

    void updateDs(String ma, DongSP dsp);

    void deleteDs(String ma);

    String checkMADS(String ma);
}
