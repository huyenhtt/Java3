/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import model.Ram;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface RamInterface {

    ArrayList<Ram> getAll();

    void insert(Ram ram);

    void update(Ram ram, String id);

    void delete(String id);

    List<Ram> searchRam(String id);

}
