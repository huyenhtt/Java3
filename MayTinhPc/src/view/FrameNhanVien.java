/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.NhanVien;
import service.NhanVienService;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class FrameNhanVien extends javax.swing.JFrame {

    ButtonGroup buttonGroup = new ButtonGroup();
    NhanVienService nvs = new NhanVienService();
    DefaultTableModel defaultTableModel = new DefaultTableModel();
    private static final String P_EMAIL = "^\\w+@\\w+\\.\\w+.\\w+";

    public FrameNhanVien() {
        initComponents();
        gioiTinh();
        setLocationRelativeTo(null);
        loadTable();
    }

    public void gioiTinh() {
        buttonGroup.add(rd_nam);
        buttonGroup.add(rd_nu);
    }

    public void loadTable() {
        defaultTableModel = (DefaultTableModel) tb_nhanVien.getModel();
        defaultTableModel.setRowCount(0);
        for (NhanVien nv : nvs.getList()) {
            defaultTableModel.addRow(new Object[]{
                nv.getId(), nv.getMa(), nv.getHoTen(), nv.getNgaySinh(), nv.getGioiTinh(), nv.getSdt(), nv.getEmail(), nv.getCmnd(), nv.getDiaChi(), nv.getMatKhau(), nv.getChucVu(), nv.getTrangThai() == 0 ? "Hoạt động" : "Không hoạt động"
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

    public boolean checkMa(String ma) {
        ArrayList<NhanVien> listNV = nvs.getList();
        for (int i = 0; i < listNV.size(); i++) {
            if (listNV.get(i).getMa().equals(ma)) {
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lb_idNV = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_ma = new javax.swing.JTextField();
        txt_ten = new javax.swing.JTextField();
        txt_ngaySinh = new javax.swing.JTextField();
        txt_cmnd = new javax.swing.JTextField();
        txt_diaChi = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_sdt = new javax.swing.JTextField();
        txt_matKhau = new javax.swing.JTextField();
        rd_nam = new javax.swing.JRadioButton();
        rd_nu = new javax.swing.JRadioButton();
        jLabel14 = new javax.swing.JLabel();
        bt_new = new javax.swing.JButton();
        bt_save = new javax.swing.JButton();
        bt_delete = new javax.swing.JButton();
        bt_update = new javax.swing.JButton();
        txt_search = new javax.swing.JTextField();
        bt_search = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_nhanVien = new javax.swing.JTable();
        txt_chucVu = new javax.swing.JTextField();
        cbx_trangThai = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Id nhân viên:");

        lb_idNV.setText("-");

        jLabel3.setText("Họ và tên:");

        jLabel4.setText("Ngày sinh:");

        jLabel5.setText("Giới tính:");

        jLabel6.setText("Cmnd:");

        jLabel7.setText("Trạng thái:");

        jLabel8.setText("Chức vụ:");

        jLabel9.setText("Mật khẩu:");

        jLabel10.setText("Địa chỉ:");

        jLabel11.setText("Email:");

        jLabel12.setText("Sđt:");

        jLabel13.setText("Mã nhân viên:");

        rd_nam.setText("Nam");

        rd_nu.setText("Nữ");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 255));
        jLabel14.setText("Quản lý nhân viên");

        bt_new.setText("New");
        bt_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_newActionPerformed(evt);
            }
        });

        bt_save.setText("Save");
        bt_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_saveActionPerformed(evt);
            }
        });

        bt_delete.setText("Delete");
        bt_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_deleteActionPerformed(evt);
            }
        });

        bt_update.setText("Update");
        bt_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_updateActionPerformed(evt);
            }
        });

        bt_search.setText("Search");
        bt_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_searchActionPerformed(evt);
            }
        });

        tb_nhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id NV", "Mã NV", "Họ và tên", "Ngày sinh", "Giới tính", "Cmnd", "Sđt", "Email", "Địa chỉ", "Mật khẩu", "Id chức vụ", "Trạng thái"
            }
        ));
        tb_nhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_nhanVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_nhanVien);

        cbx_trangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hoạt động ", "Không hoạt động" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jLabel14)
                        .addGap(155, 155, 155)
                        .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bt_search))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(bt_new)
                        .addGap(33, 33, 33)
                        .addComponent(bt_save)
                        .addGap(73, 73, 73)
                        .addComponent(bt_delete)
                        .addGap(39, 39, 39)
                        .addComponent(bt_update))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1030, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(112, 112, 112)
                            .addComponent(jLabel5)
                            .addGap(18, 18, 18)
                            .addComponent(rd_nam)
                            .addGap(66, 66, 66)
                            .addComponent(rd_nu)
                            .addGap(236, 236, 236)
                            .addComponent(jLabel8)
                            .addGap(46, 46, 46)
                            .addComponent(txt_chucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(lb_idNV, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(156, 156, 156)
                                        .addComponent(jLabel12)
                                        .addGap(70, 70, 70)
                                        .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addGap(18, 18, 18)
                                                .addComponent(txt_ten, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel13)
                                                .addGap(18, 18, 18)
                                                .addComponent(txt_ma, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(125, 125, 125)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel11)
                                                .addGap(62, 62, 62)
                                                .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel10)
                                                .addGap(54, 54, 54)
                                                .addComponent(txt_diaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_cmnd, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_ngaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(125, 125, 125)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(42, 42, 42)
                                        .addComponent(txt_matKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(37, 37, 37)
                                        .addComponent(cbx_trangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(bt_search)))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(lb_idNV)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel13))
                            .addComponent(txt_ma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel11))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel3))
                            .addComponent(txt_ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel10))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(txt_diaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel4))
                            .addComponent(txt_ngaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel9))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(txt_matKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel5))
                            .addComponent(rd_nam)
                            .addComponent(rd_nu)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel8))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(txt_chucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel6))
                    .addComponent(txt_cmnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(cbx_trangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_new)
                    .addComponent(bt_save)
                    .addComponent(bt_delete)
                    .addComponent(bt_update))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_newActionPerformed
        clearform();
    }//GEN-LAST:event_bt_newActionPerformed

    private void bt_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_saveActionPerformed
        if (checkMa(txt_ma.getText()) == true) {
            JOptionPane.showMessageDialog(this, "Trùng mã");
        } else {
            if (checkEmail()) {
                NhanVien nv = addData();
                if (nv == null) {
                    return;
                }
                nvs.insert(nv);
                loadTable();
            }
        }
    }//GEN-LAST:event_bt_saveActionPerformed

    private void bt_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_deleteActionPerformed
        int row = tb_nhanVien.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn dòng cần xóa");
            return;
        }
        int con = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không");
        if (con != JOptionPane.YES_OPTION) {
            return;
        }
        String id = tb_nhanVien.getValueAt(row, 0).toString();
        nvs.delete(id);
        loadTable();
        clearform();
    }//GEN-LAST:event_bt_deleteActionPerformed

    private void bt_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_updateActionPerformed
        int row = tb_nhanVien.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn dòng cần sửa");
            return;
        }
        NhanVien nv = this.addData();
        this.nvs.update(nv.getId(), nv);
        this.loadTable();
    }//GEN-LAST:event_bt_updateActionPerformed

    private void bt_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_searchActionPerformed
        String timKiem = txt_search.getText();
        NhanVien nv = nvs.searchByMa(timKiem);
        NhanVien nva = nvs.searchByTen(timKiem);
        if (nv != null) {
            defaultTableModel = (DefaultTableModel) tb_nhanVien.getModel();
            defaultTableModel.setRowCount(0);
            defaultTableModel.addRow(new Object[]{
                nv.getId(), nv.getMa(), nv.getHoTen(), nv.getNgaySinh(), nv.getGioiTinh(), nv.getSdt(), nv.getEmail(), nv.getCmnd(), nv.getDiaChi(), nv.getMatKhau(), nv.getChucVu(), nv.getTrangThai()==0? "Hoạt động":"Không hoạt động"
            });
        } else if (nva != null) {
            defaultTableModel = (DefaultTableModel) tb_nhanVien.getModel();
            defaultTableModel.setRowCount(0);
            defaultTableModel.addRow(new Object[]{
                nva.getId(), nva.getMa(), nva.getHoTen(), nva.getNgaySinh(), nva.getGioiTinh(), nva.getSdt(), nva.getEmail(), nva.getCmnd(), nva.getDiaChi(), nva.getMatKhau(), nva.getChucVu(), nva.getTrangThai()==0? "Hoạt động":"Không hoạt động"
            });
        } else {
            JOptionPane.showMessageDialog(this, "Không tìm được nhân viên");
            loadTable();
        }
    }//GEN-LAST:event_bt_searchActionPerformed

    private void tb_nhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_nhanVienMouseClicked
        int row = tb_nhanVien.getSelectedRow();
        lb_idNV.setText(tb_nhanVien.getValueAt(row, 0).toString());
        txt_ma.setText(tb_nhanVien.getValueAt(row, 1).toString());
        txt_ten.setText(tb_nhanVien.getValueAt(row, 2).toString());
        txt_ngaySinh.setText(tb_nhanVien.getValueAt(row, 3).toString());
        txt_sdt.setText(tb_nhanVien.getValueAt(row, 5).toString());
        txt_email.setText(tb_nhanVien.getValueAt(row, 6).toString());
        txt_cmnd.setText(tb_nhanVien.getValueAt(row, 7).toString());
        txt_diaChi.setText(tb_nhanVien.getValueAt(row, 8).toString());
        txt_matKhau.setText(tb_nhanVien.getValueAt(row, 9).toString());
        txt_chucVu.setText(tb_nhanVien.getValueAt(row, 10).toString());
//        if (tb_nhanVien.getValueAt(row, 11).equals(0)) {
//            cbx_trangThai.setSelectedIndex(1);
//        } else {
//            cbx_trangThai.setSelectedIndex(0);
//        }
        cbx_trangThai.setSelectedItem(tb_nhanVien.getValueAt(row, 11).toString());
        if (tb_nhanVien.getValueAt(row, 4).equals("Nam")) {
            rd_nam.setSelected(true);
        } else {
            rd_nu.setSelected(true);
        }
    }//GEN-LAST:event_tb_nhanVienMouseClicked

    private NhanVien addData() {
        String id = lb_idNV.getText();
        String ma = txt_ma.getText();
        String hoTen = txt_ten.getText();
        String ngaySinh = txt_ngaySinh.getText();
        String gioiTinh = "";
        String cmnd = txt_cmnd.getText();
        String sdt = txt_sdt.getText();
        String email = txt_email.getText();
        String diaChi = txt_diaChi.getText();
        String matKhau = txt_matKhau.getText();
        String chucVu = txt_chucVu.getText();
        int trangThai = cbx_trangThai.getSelectedIndex();
        if (ma.length() == 0 || hoTen.length() == 0 || ngaySinh.length() == 0 || cmnd.length() == 0 || sdt.length() == 0 || email.length() == 0 || diaChi.length() == 0 || matKhau.length() == 0 || chucVu.length() == 0) {
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
//        if (cbx_trangThai.getSelectedItem().equals("Hoạt động")) {
//            trangThai = 1;
//        } else {
//            trangThai = 0;
//        }
        NhanVien nv = new NhanVien(id, ma, hoTen, date, gioiTinh, sdt, email, cmnd, diaChi, matKhau, chucVu, trangThai);
        return nv;
    }

    private void clearform() {
        lb_idNV.setText("-");
        txt_cmnd.setText("");
        txt_ma.setText("");
        txt_email.setText("");
        txt_matKhau.setText("");
        txt_ngaySinh.setText("");
        txt_search.setText("");
        txt_sdt.setText("");
        txt_ten.setText("");
        cbx_trangThai.setSelectedIndex(0);
        txt_diaChi.setText("");
        txt_chucVu.setText("");
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
            java.util.logging.Logger.getLogger(FrameNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameNhanVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_delete;
    private javax.swing.JButton bt_new;
    private javax.swing.JButton bt_save;
    private javax.swing.JButton bt_search;
    private javax.swing.JButton bt_update;
    private javax.swing.JComboBox<String> cbx_trangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_idNV;
    private javax.swing.JRadioButton rd_nam;
    private javax.swing.JRadioButton rd_nu;
    private javax.swing.JTable tb_nhanVien;
    private javax.swing.JTextField txt_chucVu;
    private javax.swing.JTextField txt_cmnd;
    private javax.swing.JTextField txt_diaChi;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_ma;
    private javax.swing.JTextField txt_matKhau;
    private javax.swing.JTextField txt_ngaySinh;
    private javax.swing.JTextField txt_sdt;
    private javax.swing.JTextField txt_search;
    private javax.swing.JTextField txt_ten;
    // End of variables declaration//GEN-END:variables
}
