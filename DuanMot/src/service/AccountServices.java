/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import model.Account;
import repository.AccountRepo;
import service.impl.AccountInterface;
import ViewModel.AccountViewModel;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class AccountServices implements AccountInterface{
        private final AccountRepo account = new AccountRepo();
    @Override
    public List<AccountViewModel> getAll() {
         return account.getAll();
    }

    @Override
    public String add(Account ac) {
        boolean addAccount = account.add(ac);
        if (addAccount){
            return "Them thanh cong";
        }else{
            return "Them error";
        }
    }

    @Override
    public String update( Account ac,String UserName) {
       boolean updaAccount = account.update(ac, UserName);
        if (updaAccount){
            return "Sua thanh cong";
        }else{
            return "Sua error";
        }
    }

    @Override
    public String delete(String UserName) {
       boolean deleAccount = account.delete(UserName);
        if (deleAccount){
            return "Xoa thanh cong";
        }else{
            return "Xoa error";
        }   
    }
    
}
