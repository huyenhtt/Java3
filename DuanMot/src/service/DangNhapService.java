/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import model.Account;
import repository.DangNhapRepo;
import service.impl.DangNhapInterface;

/**
 *
 * @author PC
 */
public class DangNhapService implements DangNhapInterface {

    private DangNhapRepo dnr = new DangNhapRepo();

    @Override
    public Account account(String username, String password) {
        return dnr.account(username, password);
    }
}
