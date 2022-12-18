/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import model.CardManHinh;
import repository.CardManHinhRepo;
import service.impl.CardMHinterFace;

/**
 *
 * @author DELL
 */
public class CardMHService implements CardMHinterFace{

    CardManHinhRepo CardRepo = new CardManHinhRepo();

    public CardMHService() {
        this.CardRepo= new CardManHinhRepo();
    }

    @Override
    public ArrayList<CardManHinh> getAll() {
        return CardRepo.getAll();
    }

    @Override
    public void insert(CardManHinh card) {
        CardRepo.insert(card);
    }

    @Override
    public void update(CardManHinh card, String id) {
        CardRepo.update(card, id);
    }

    @Override
    public void delete(String id) {
        CardRepo.delete(id);
    }

   
}
