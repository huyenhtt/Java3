/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import ViewModel.HoaDonVM;
import model.HoaDon;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IHoaDonS {

    List<HoaDon> getAll();

    List<HoaDon> searchHD(String ma);

    Integer insertHD(HoaDon hd);

    List<HoaDon> searchHDTT(String tinhTrang);

    List<HoaDon> searchThang(int thang);

    List<HoaDon> searchNam(int nam);

    Integer updateHD(HoaDon hd, String ma);

    Integer deleteHD(String ma);
    
    List<HoaDonVM> getListHD();
}
