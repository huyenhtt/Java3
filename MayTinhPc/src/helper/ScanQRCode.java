/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.Dimension;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Pin;
import service.PinSer;
import service.impl.IPinSer;

/**
 *
 * @author Admin
 */
public class ScanQRCode extends javax.swing.JFrame implements Runnable, ThreadFactory {

    private WebcamPanel panel = null;
    private Webcam webcam = null;
    private Executor executor = Executors.newSingleThreadExecutor(this);
    private DefaultTableModel defaultTableModel;
    private IPinSer ser;

    /**
     * Creates new form ScanQRCode
     */
    public ScanQRCode() {
        initComponents();
        intitWebCam();
        defaultTableModel = new DefaultTableModel();
        ser = new PinSer();
    }

    private void intitWebCam() {
        java.awt.Dimension site = WebcamResolution.QVGA.getSize();
        webcam = Webcam.getWebcams().get(0);
        webcam.setViewSize(site);

        panel = new WebcamPanel(webcam);
        panel.setPreferredSize(site);
        panel.setFPSDisplayed(true);

        pnQuet.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 300));
        executor.execute(this);
    }

    @Override
    public void run() {
        do {
            try {
                Thread.sleep(100);

            } catch (InterruptedException ex) {
                Logger.getLogger(ScanQRCode.class.getName()).log(Level.SEVERE, null, ex);
            }
            Result result = null;
            BufferedImage image = null;
            if (webcam.isOpen()) {
                if ((image = webcam.getImage()) == null) {
                    continue;
                }
            }
            LuminanceSource source = null;
            try {
                source = new BufferedImageLuminanceSource(image);
            } catch (Exception e) {
            }
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
            try {
                result = new MultiFormatReader().decode(bitmap);
            } catch (NotFoundException notFoundException) {
            }
            if (result != null) {
                txtResult.setText(result.getText());

                List<Pin> list = ser.searchList(result.getText());
                if (list==null) {
//                    JOptionPane.showMessageDialog(this, "Không tìm thấy Pin");
                    txtResult.setText(result.getText());
                    return;
                }
                defaultTableModel = new DefaultTableModel();
                defaultTableModel = (DefaultTableModel) tbPin.getModel();
                defaultTableModel.setRowCount(0);
                for (Pin pin : list) {
                    defaultTableModel.addRow(new Object[]{
                        pin.getId(), pin.getMa(), pin.getDungLuong()
                    });
                }
            }

        } while (true);
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "My Thread");
        t.setDaemon(true);
        return t;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnCodeQR = new javax.swing.JPanel();
        pnQuet = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtResult = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPin = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnCodeQR.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnQuet.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnQuet.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pnCodeQR.add(pnQuet, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 19, 380, 260));

        jLabel1.setText("Result");
        pnCodeQR.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 291, -1, -1));

        txtResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtResultActionPerformed(evt);
            }
        });
        pnCodeQR.add(txtResult, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 323, 267, -1));

        getContentPane().add(pnCodeQR, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 393));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 40, 180, -1));
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, 180, -1));

        tbPin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Mã", "Tên"
            }
        ));
        jScrollPane1.setViewportView(tbPin);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 120, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtResultActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtResultActionPerformed

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
            java.util.logging.Logger.getLogger(ScanQRCode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ScanQRCode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ScanQRCode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ScanQRCode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ScanQRCode().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JPanel pnCodeQR;
    private javax.swing.JPanel pnQuet;
    private javax.swing.JTable tbPin;
    private javax.swing.JTextField txtResult;
    // End of variables declaration//GEN-END:variables
}
