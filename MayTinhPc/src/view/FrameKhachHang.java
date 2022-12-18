/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.KhachHang;
import service.KhachHangService;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class FrameKhachHang extends javax.swing.JFrame {

    KhachHangService khs = new KhachHangService();
    ButtonGroup buttonGroup = new ButtonGroup();
    DefaultTableModel defaultTableModel = new DefaultTableModel();
    private static final String P_EMAIL = "^\\w+@\\w+\\.\\w+.\\w+";

    public FrameKhachHang() {
        initComponents();
        gioiTinh();
        loadTable();
    }

    public void gioiTinh() {
        buttonGroup.add(rd_nu);
        buttonGroup.add(rd_nam);
    }

    public void loadTable() {
        defaultTableModel = (DefaultTableModel) tb_khachHang.getModel();
        defaultTableModel.setRowCount(0);
        for (KhachHang kh : khs.getList()) {
            defaultTableModel.addRow(new Object[]{
                kh.getId(), kh.getMa(), kh.getHoTen(), kh.getNgaySinh(), kh.getGioiTinh(), kh.getSdt(), kh.getEmail()
            });
        }
    }

    public boolean checkEmail() {
        Matcher matcher = Pattern.compile(P_EMAIL).matcher(txt_email.getText());
        if (!matcher.matches()) {
            JOptionPane.showMessageDialog(this, "Email sai định dạng");
            return false;
        }
        return true;
    }

    public boolean searchMa(String ma) {
        ArrayList<KhachHang> listKH = khs.getList();
        for (int i = 0; i < listKH.size(); i++) {
            if (listKH.get(i).getMa().equals(ma)) {
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_id = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_sdt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_ma = new javax.swing.JTextField();
        btn_new = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_khachHang = new javax.swing.JTable();
        txt_hoTen = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_ngaySinh = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        txt_search = new javax.swing.JTextField();
        btn_search = new javax.swing.JButton();
        rd_nam = new javax.swing.JRadioButton();
        rd_nu = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_id.setText("-");
        getContentPane().add(lb_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 123, 264, -1));

        jLabel11.setText("Sđt");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 273, -1, -1));

        jLabel5.setText("Email");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(582, 163, -1, -1));
        getContentPane().add(txt_sdt, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 270, 246, -1));

        jLabel6.setText("Họ và tên");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 204, -1, -1));
        getContentPane().add(txt_ma, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 163, 246, -1));

        btn_new.setText("New");
        btn_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_newActionPerformed(evt);
            }
        });
        getContentPane().add(btn_new, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 340, -1, -1));

        btn_save.setText("Save");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });
        getContentPane().add(btn_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 340, -1, -1));

        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });
        getContentPane().add(btn_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 340, -1, -1));

        btn_delete.setText("Delete");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });
        getContentPane().add(btn_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(426, 340, -1, -1));

        jLabel1.setText("Id");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 128, 32, -1));

        tb_khachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Mã khách hàng", "Họ và tên", "Ngày sinh", "Giới tính", "Sđt", "Email"
            }
        ));
        tb_khachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_khachHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_khachHang);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 409, 890, 197));
        getContentPane().add(txt_hoTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 201, 246, -1));

        jLabel4.setText("Mã khách hàng");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 166, -1, -1));

        jLabel8.setText("Ngày sinh");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 235, -1, -1));
        getContentPane().add(txt_ngaySinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 232, 246, -1));

        jLabel3.setText("Giới tính");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(568, 123, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 255));
        jLabel2.setText("Quản lý khách hàng");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(249, 46, -1, -1));
        getContentPane().add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(624, 160, 254, -1));
        getContentPane().add(txt_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(639, 56, 138, -1));

        btn_search.setText("Search");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });
        getContentPane().add(btn_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(813, 55, -1, -1));

        rd_nam.setText("Nam");
        getContentPane().add(rd_nam, new org.netbeans.lib.awtextra.AbsoluteConstraints(634, 119, -1, -1));

        rd_nu.setText("Nữ");
        getContentPane().add(rd_nu, new org.netbeans.lib.awtextra.AbsoluteConstraints(699, 119, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newActionPerformed
        clearForm();
    }//GEN-LAST:event_btn_newActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        if (searchMa(txt_ma.getText()) == true) {
            JOptionPane.showMessageDialog(this, "trùng mã");
            return;
        } else {
            if (checkEmail()) {
                KhachHang kh = this.addData();
                if (kh == null) {
                    return;
                }
                this.khs.insert(kh);
                this.loadTable();
            }
        }
    }//GEN-LAST:event_btn_saveActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        int row = tb_khachHang.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn dòng cần cập nhật");
            return;
        }
        KhachHang kh = this.addData();
        khs.update(kh.getId(), kh);
        loadTable();
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        int row = tb_khachHang.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn dòng cần xóa");
            return;
        }
        int con = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không");
        if (con != JOptionPane.YES_OPTION) {
            return;
        }
        String id = tb_khachHang.getValueAt(row, 0).toString();
        khs.delete(id);
        loadTable();
        clearForm();

    }//GEN-LAST:event_btn_deleteActionPerformed

    private void tb_khachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_khachHangMouseClicked
        int row = tb_khachHang.getSelectedRow();
        lb_id.setText(tb_khachHang.getValueAt(row, 0).toString());
        txt_ma.setText(tb_khachHang.getValueAt(row, 1).toString());
        txt_hoTen.setText(tb_khachHang.getValueAt(row, 2).toString());
        txt_ngaySinh.setText(tb_khachHang.getValueAt(row, 3).toString());
        txt_sdt.setText(tb_khachHang.getValueAt(row, 5).toString());
        txt_email.setText(tb_khachHang.getValueAt(row, 6).toString());

        if (tb_khachHang.getValueAt(row, 4).equals("Nam")) {
            rd_nam.setSelected(true);
        } else {
            rd_nu.setSelected(true);
        }
    }//GEN-LAST:event_tb_khachHangMouseClicked

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        String tim = txt_search.getText();
        KhachHang kh = khs.searchByMa(tim);
        KhachHang kha = khs.searchByTen(tim);
        if (kh != null) {
            System.out.println(tim);
            defaultTableModel = (DefaultTableModel) tb_khachHang.getModel();
            defaultTableModel.setRowCount(0);
            defaultTableModel.addRow(new Object[]{
                kh.getId(), kh.getMa(), kh.getHoTen(), kh.getNgaySinh(), kh.getGioiTinh(), kh.getSdt(), kh.getEmail()
            });
        } else if (kha != null) {
            defaultTableModel = (DefaultTableModel) tb_khachHang.getModel();
            defaultTableModel.setRowCount(0);
            defaultTableModel.addRow(new Object[]{
                kha.getId(), kha.getMa(), kha.getHoTen(), kha.getNgaySinh(), kha.getGioiTinh(), kha.getSdt(), kha.getEmail()
            });
        } else {
            JOptionPane.showMessageDialog(this, "Không tìm thấy khách hàng");
            loadTable();
        }
    }//GEN-LAST:event_btn_searchActionPerformed

    private KhachHang addData() {
        String id = lb_id.getText();
        String ma = txt_ma.getText();
        String hoTen = txt_hoTen.getText();
        String ngaySinh = txt_ngaySinh.getText();
        String sdt = txt_sdt.getText();
        String gioiTinh = "";
        String email = txt_email.getText();
        if (ma.length() == 0 || hoTen.length() == 0 || ngaySinh.length() == 0 || sdt.length() == 0 || email.length() == 0) {
            JOptionPane.showMessageDialog(this, "Không được để trống");
            return null;
        }
        Date date = null;
        try {
            date = Date.valueOf(ngaySinh);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi ngày sinh");
        }
        if (rd_nam.isSelected()) {
            gioiTinh = "Nam";
        } else {
            gioiTinh = "Nữ";
        }
        KhachHang kh = new KhachHang(id, ma, hoTen, date, gioiTinh, sdt, email);
        return kh;
    }

    private void clearForm() {
        lb_id.setText("");
        txt_ma.setText("");
        txt_hoTen.setText("");
        txt_ngaySinh.setText("");
        txt_search.setText("");
        txt_sdt.setText("");
        txt_email.setText("");
        buttonGroup.clearSelection();
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameKhachHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_new;
    private javax.swing.JButton btn_save;
    private javax.swing.JButton btn_search;
    private javax.swing.JButton btn_update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_id;
    private javax.swing.JRadioButton rd_nam;
    private javax.swing.JRadioButton rd_nu;
    private javax.swing.JTable tb_khachHang;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_hoTen;
    private javax.swing.JTextField txt_ma;
    private javax.swing.JTextField txt_ngaySinh;
    private javax.swing.JTextField txt_sdt;
    private javax.swing.JTextField txt_search;
    // End of variables declaration//GEN-END:variables
}
