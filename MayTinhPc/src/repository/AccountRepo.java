/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import JDBC.JDBCUtil;
import model.Account;
import ViewModel.AccountViewModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class AccountRepo {

    public List<AccountViewModel> getAll() {
        String sql = " SELECT [UserName],[PassWord],[Role] FROM [dbo].[Account]  ";
        try ( Connection con = JDBCUtil.getConnection();  PreparedStatement pstm = con.prepareStatement(sql);) {
            ResultSet rs = pstm.executeQuery();
            List<AccountViewModel> listAcc = new ArrayList<>();
            while (rs.next()) {
                AccountViewModel ac = new AccountViewModel(rs.getString(1), rs.getString(2), rs.getString(3));
                listAcc.add(ac);

            }
            return listAcc;

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(Account ac) {
        int check = 0;
        String SQL = " INSERT INTO [dbo].[Account]\n"
                + "           ([UserName]\n"
                + "           ,[PassWord]\n"
                + "           ,[Role])\n"
                + "     VALUES (?,?,?)";
        try ( Connection con = JDBCUtil.getConnection();  PreparedStatement pstm = con.prepareStatement(SQL)) {
            pstm.setObject(1, ac.getUsername());
            pstm.setObject(2, ac.getPassword());
            pstm.setObject(3, ac.getRole());
            check = pstm.executeUpdate();
            //nếu câu query thành công thì check = 1;
            // Trả ra 1 khi thành công va 0 khi thất bại
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        // Nếu thành công thì check > 1
        // return 1> 0 ; return true;
        // Nếu thất bại thì check 0=0
        //return 0 > 0 ; return false;
        return check > 0;

    }

    public boolean update(Account ac, String UserName) {
        int check = 0;
        String sql = "UPDATE [dbo].[Account]\n"
                + "   SET [PassWord] = ?\n"
                + "      ,[Role] = ?\n"
                + " WHERE  UserName = ?";
        try ( Connection con = JDBCUtil.getConnection();  PreparedStatement pstm = con.prepareStatement(sql)) {

            pstm.setObject(1, ac.getPassword());
            pstm.setObject(2, ac.getRole());
            pstm.setObject(3, UserName);
            check = pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String UserName) {
        int check = 0;
        String sql = "DELETE FROM [dbo].[Account]\n"
                + "      WHERE UserName = ?";
        try ( Connection con = JDBCUtil.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, UserName);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

}
