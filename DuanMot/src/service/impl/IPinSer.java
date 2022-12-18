/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import java.util.List;
import model.Pin;

/**
 *
 * @author Admin
 */
public interface IPinSer {

    List<Pin> getList();

    Integer insertPin(Pin pin);

    Integer deletePin(String ma);

    Integer updatePin(Pin pin,String ma);
}
