/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import model.Account;

/**
 *
 * @author PC
 */
public interface DangNhapInterface {

    Account account(String username, String password);
}
