/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import java.util.List;
import model.HoaDonCT;

/**
 *
 * @author Admin
 */
public interface IHoaDonCT {

    List<HoaDonCT> getAll();

    Integer insertHDCT(HoaDonCT ct);

    Integer updateHDCT(HoaDonCT ct, String id);

    Integer deleteHDCT(String id);

}
