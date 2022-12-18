/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import JDBC.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Account;

/**
 *
 * @author PC
 */
public class DangNhapRepo {

    public Account account(String username, String password) {
        String sql = "select * from Account where UserName = ? and PassWord = ?";
        Connection conn = JDBCUtil.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            if (rs.next() == false) {
                return null;
            }
            String role = rs.getString("Role");
            Account a = new Account(username, password, role);
            return a;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
}
