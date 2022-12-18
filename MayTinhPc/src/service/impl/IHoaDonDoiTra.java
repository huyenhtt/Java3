/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import model.HoaDonDoiTra;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IHoaDonDoiTra {

    List<HoaDonDoiTra> getAll();

    Integer insertHD(HoaDonDoiTra hd);

    Integer updateHD(HoaDonDoiTra hd, String id);

    Integer deleteHD(String ma);
}
