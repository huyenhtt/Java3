/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import ViewModel.HoaDonVM;
import ViewModel.TBGioHang;
import com.raven.datechooser.DateBetween;
import com.raven.datechooser.DateChooser;
import com.raven.datechooser.listener.DateChooserAction;
import com.raven.datechooser.listener.DateChooserAdapter;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.KhachHang;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import repository.BanHangRepo;
import service.ChiTietSPService;
import service.HoaDonCTSer;
import service.HoaDonService;
import service.KhachHangService;
import service.impl.ChiTietSPInteface;
import service.impl.IHoaDonCT;
import service.impl.IHoaDonS;
import service.impl.KhachHangInter;

/**
 *
 * @author Admin
 */
public class QLHoaDon extends javax.swing.JFrame {

    private DefaultTableModel defaultTableModel;
    private DefaultComboBoxModel defaultComboBoxModel;
    private IHoaDonS serr;
    private IHoaDonCT serCT;
    private ChiTietSPInteface serchi;
    private DefaultComboBoxModel cbb;
    private BanHangRepo qlbh = new BanHangRepo();
    private KhachHangInter qlkh = new KhachHangService();
    private DateChooser chDate = new DateChooser();

    /**
     * Creates new form QlHoaDon
     */
    public QLHoaDon() {
        initComponents();
        serr = new HoaDonService();
        serCT = new HoaDonCTSer();
        serchi = new ChiTietSPService();
        defaultComboBoxModel = new DefaultComboBoxModel();
        defaultTableModel = new DefaultTableModel();
        loadCBSDT();
        cbTimKiem();
        loadCBtongtien();
        loadCBTrangThai();
        loadTable(serr.getListHD());
        chDate.setTextField(txtDate);

        chDate.setDateSelectionMode(DateChooser.DateSelectionMode.BETWEEN_DATE_SELECTED);
        chDate.setLabelCurrentDayVisible(false);
        chDate.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        chDate.addActionDateChooserListener(new DateChooserAdapter() {

            @Override
            public void dateBetweenChanged(DateBetween date, DateChooserAction action) {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String dateFrom = df.format(date.getFromDate());
                String toDate = df.format(date.getToDate());

                loadTable(serr.getListHDA(java.sql.Date.valueOf(dateFrom), java.sql.Date.valueOf(toDate)));
            }
        });

    }

    public void loadTable(List<HoaDonVM> lisst) {
        defaultTableModel = (DefaultTableModel) tbHD.getModel();
        defaultTableModel.setRowCount(0);
        for (HoaDonVM hoaDon : lisst) {

            defaultTableModel.addRow(new Object[]{
                hoaDon.getMaHD(),
                hoaDon.getNgayTao(),
                hoaDon.getManv(),
                hoaDon.getTennv(),
                hoaDon.getMakh(),
                hoaDon.getTenkh(),
                hoaDon.getSdt(),
                hoaDon.getTrangThai(),
                String.format("%.0f", hoaDon.getTongTien())
            }
            );
        }
    }

    public void loadCBtongtien() {
        DefaultComboBoxModel ttcb = (DefaultComboBoxModel) cbTongTien.getModel();
        ttcb.addElement(null);
        ttcb.addElement("<10000000");
        ttcb.addElement("Từ 10000000-50000000");
        ttcb.addElement("Từ 50000000- 100000000");
        ttcb.addElement(">100000000");
    }

    public void loadCBTrangThai() {
        DefaultComboBoxModel decbtt = (DefaultComboBoxModel) cbTrangThai.getModel();
        decbtt.addElement("");
        decbtt.addElement("Đã thanh toán");
        decbtt.addElement("Chờ thanh toán");
    }

    public void loadCBSDT() {

        DefaultComboBoxModel dcb = (DefaultComboBoxModel) cbSD.getModel();
        for (KhachHang hdon : serr.getSDTvm()) {
            dcb.addElement(hdon);
        }
    }

    public void loadTBHDCT() {

        int row = tbHD.getSelectedRow();
        if (row == -1) {
            return;
        }
        DefaultTableModel dftb = new DefaultTableModel();
        dftb = (DefaultTableModel) tbHDCT.getModel();

        ArrayList<TBGioHang> list = serr.getListHDCTVM(tbHD.getValueAt(row, 0).toString());
        if (list != null) {

            dftb.setRowCount(0);
            for (TBGioHang gh : list) {
                dftb.addRow(new Object[]{
                    gh.getMaSP(), gh.getTenSP(), gh.getSoLuong(), String.format("%.0f", gh.getDonGia()), String.format("%.0f", gh.getTongTien())
                });
            }
        } else {
            dftb.setRowCount(0);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        txtDate = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cbSD = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cbTrangThai = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbTongTien = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbHD = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbHDCT = new javax.swing.JTable();
        txtTimKiem = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "HOÁ ĐƠN", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm Theo Khoảng Ngày"));

        jLabel4.setText("(* chọn khoảng ngày muốn tìm kiếm)");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4))
        );

        jLabel1.setText("SĐT Khách Hàng");

        cbSD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSDActionPerformed(evt);
            }
        });

        jLabel2.setText("Trạng thái ");

        cbTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTrangThaiActionPerformed(evt);
            }
        });

        jLabel3.setText("Tổng tiền");

        cbTongTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTongTienActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel1)
                        .addGap(97, 97, 97)
                        .addComponent(jLabel2)
                        .addGap(16, 16, 16))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(cbSD, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel3))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbSD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        tbHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Hoá Đơn", "Ngày Tạo", "Mã Nhân Viên", "Tên Nhân Viên", "Mã Khách Hàng", "Tên Khách Hàng", "SDT Khách Hàng", "Trạng Thái", "Tổng Tiền"
            }
        ));
        tbHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbHDMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbHD);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 885, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 11, -1, 350));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "HOÁ ĐƠN CHI TIẾT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        tbHDCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã Sản Phẩm", "Tên Sản Phẩm", "Số Lượng", "Đơn Giá", "Thành Tiền"
            }
        ));
        tbHDCT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbHDCTMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbHDCT);

        btnSearch.setText("Tìm Kiếm");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(btnSearch))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 879, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, -1, 280));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        //tìm kiếm theo tên hoặc mã sp
        int rowhdct = tbHDCT.getSelectedRow();
        int rowhd = tbHD.getSelectedRow();
        List<TBGioHang> listHCDT = serr.SearchMaSPVm(txtTimKiem.getText().trim(), tbHD.getValueAt(rowhd, 0).toString());
        List<TBGioHang> listHCDTw = serr.SearchTenSPVm(txtTimKiem.getText().trim(), tbHD.getValueAt(rowhd, 0).toString());
        if (txtTimKiem.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "Nhập để tìm kiếm");

            return;
        }
        if (!listHCDT.isEmpty()) {
            JOptionPane.showMessageDialog(this, listHCDT);
        } else if (!listHCDTw.isEmpty()) {
            JOptionPane.showMessageDialog(this, listHCDTw);
        } else {
            JOptionPane.showMessageDialog(this, "Không tìm thấy sản phẩm");
            return;
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void tbHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHDMouseClicked
        // TODO add your handling code here:

        loadTBHDCT();
    }//GEN-LAST:event_tbHDMouseClicked


    private void tbHDCTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHDCTMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbHDCTMouseClicked

    private void cbSDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSDActionPerformed
        // TODO add your handling code here:
        String sdt = cbSD.getSelectedItem().toString();
        List<HoaDonVM> listvm = serr.searchSDTVM(sdt);
        if (listvm.isEmpty()) {
            loadTable(listvm);
        } else {
            loadTable(listvm);
        }

    }//GEN-LAST:event_cbSDActionPerformed
    public void cbTimKiem() {
        cbSD.setEditable(true);
        AutoCompleteDecorator.decorate(cbSD);

    }
    private void cbTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTrangThaiActionPerformed
        // TODO add your handling code here:
        String trangthai = cbTrangThai.getSelectedItem().toString();
        List<HoaDonVM> listN = serr.SearchTrangThaiVM(trangthai);
        if (listN.isEmpty()) {
            if (cbTrangThai.getSelectedIndex() == 0) {
                loadTable(serr.getListHD());
                return;
            }
//            JOptionPane.showMessageDialog(this, "Không có thông tin");
            loadTable(listN);
            cbTrangThai.setSelectedItem(null);
        } else {

            loadTable(listN);
        }
    }//GEN-LAST:event_cbTrangThaiActionPerformed

    private void cbTongTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTongTienActionPerformed
        // TODO add your handling code here:
        if (cbTongTien.getSelectedIndex() == 1) {
            List<HoaDonVM> listVm = serr.searchkhoangTien1();
            if (listVm.isEmpty()) {
                loadTable(listVm);
                cbTongTien.setSelectedItem(null);
            } else {
                loadTable(listVm);
            }

        } else if (cbTongTien.getSelectedIndex() == 2) {
            List<HoaDonVM> listVm2 = serr.searchkhoangTien2();
            if (listVm2.isEmpty()) {
                loadTable(listVm2);
                cbTongTien.setSelectedItem(null);

            } else {
                loadTable(listVm2);
            }
        } else if (cbTongTien.getSelectedIndex() == 3) {
            List<HoaDonVM> listVm3 = serr.searchkhoangTien3();
            if (listVm3.isEmpty()) {
                loadTable(listVm3);
                cbTongTien.setSelectedItem(null);

            } else {
                loadTable(listVm3);
            }

        } else if (cbTongTien.getSelectedIndex() == 4) {
            List<HoaDonVM> listVm4 = serr.searchkhoangTien4();
            if (listVm4.isEmpty()) {
                loadTable(listVm4);
                cbTongTien.setSelectedItem(null);
            } else {
                loadTable(listVm4);
            }
        } else {

            cbTongTien.setSelectedItem(null);
            loadTable(serr.getListHD());

        }

    }//GEN-LAST:event_cbTongTienActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(QLHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLHoaDon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cbSD;
    private javax.swing.JComboBox<String> cbTongTien;
    private javax.swing.JComboBox<String> cbTrangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbHD;
    private javax.swing.JTable tbHDCT;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
