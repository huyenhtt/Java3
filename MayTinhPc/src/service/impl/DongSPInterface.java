/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import java.util.ArrayList;
import model.DongSP;

/**
 *
 * @author Admin
 */
public interface DongSPInterface {
     ArrayList<DongSP> getAll();
    
    void insert (DongSP dsp);
    
    void update(DongSP dsp, String ma);
    
    void delete(String ma);
}
