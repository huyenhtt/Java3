/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import java.util.List;
import model.CongKetNoi;

/**
 *
 * @author Admin
 */
public interface ICongKetNoiS {

    List<CongKetNoi> getall();

    Integer insserrtCKN(CongKetNoi kn);

    Integer updateCKN(CongKetNoi kn, String ma);

    Integer deleteCKN(String ma);

    CongKetNoi searchCKN(String ma);
}
