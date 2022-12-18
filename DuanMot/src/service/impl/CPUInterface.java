/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import java.util.ArrayList;
import model.CPU;

/**
 *
 * @author DELL
 */
public interface CPUInterface {

    ArrayList<CPU> getAll();

    void insert(CPU cpu);

    void update(CPU cpu, String id);

    void delete(String id);
}
