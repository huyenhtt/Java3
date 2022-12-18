/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import java.util.ArrayList;
import model.CardManHinh;

/**
 *
 * @author DELL
 */
public interface CardMHinterFace {
    ArrayList<CardManHinh> getAll();

    void insert(CardManHinh card);

    void update(CardManHinh card, String id);

    void delete(String id);
    
}
