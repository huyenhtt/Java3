/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service.impl;

import java.util.List;
import model.Hedieuhanh;

/**
 *
 * @author Administrator
 */
public interface HeDHInterface {
    List<Hedieuhanh> getAll();
    
    String add(Hedieuhanh h);
    
    String update(Hedieuhanh h,String id);
    
    String delete(String id);
}
