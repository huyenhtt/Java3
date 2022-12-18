/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import ViewModel.HoaDonCTViewModel;
import ViewModel.HoaDonVM;
import ViewModel.HoaDonViewModel;
import ViewModel.SanPhamBanHangViewModel;
import ViewModel.TBGioHang;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.Normalizer;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.CPU;
import model.CardManHinh;
import model.CongKetNoi;
import model.DongSP;
import model.Hedieuhanh;
import model.HoaDon;
import model.HoaDonCT;
import model.KhachHang;
import model.MauSac;
import model.OCung;
import model.Pin;
import model.Ram;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import repository.BanHangRepo;
import service.CPUService;
import service.CardMHService;
import service.ChiTietSPService;
import service.CongKetNoiSer;
import service.DongSPService;
import service.HeDHServices;
import service.HoaDonCTSer;
import service.HoaDonService;
import service.KhachHangService;
import service.MauSacSer;
import service.OCungService;
import service.PinSer;
import service.RamService;
import service.impl.CPUInterface;
import service.impl.CardMHinterFace;
import service.impl.ChiTietSPInteface;
import service.impl.DongSPInterface;
import service.impl.HeDHInterface;
import service.impl.ICongKetNoiS;
import service.impl.IHoaDonCT;
import service.impl.IHoaDonS;
import service.impl.IMauSac;
import service.impl.IPinSer;
import service.impl.KhachHangInter;
import service.impl.OCungInterface;
import service.impl.RamInterface;

/**
 *
 * @author Administrator
 */
public class BanHang extends javax.swing.JFrame {

    DefaultTableModel dtmCTSP = new DefaultTableModel();
    List<SanPhamBanHangViewModel> listSPCT = new ArrayList<>();
    ChiTietSPInteface ctspSevices;
    private ArrayList<TBGioHang> lishGH = new ArrayList<>();
    private ArrayList<HoaDonCTViewModel> listHDC = new ArrayList<>();
    DefaultTableModel dtmHDCT = new DefaultTableModel();
    List<HoaDonCT> listHDCT = new ArrayList<>();
    IHoaDonCT hdctServices = new HoaDonCTSer();
    IHoaDonS qlhd = new HoaDonService();
    BanHangRepo qlbh = new BanHangRepo();
    DefaultComboBoxModel dfcb = new DefaultComboBoxModel();
    IMauSac qlms = new MauSacSer();
    DongSPInterface qldsp = new DongSPService();
    OCungInterface qloc = new OCungService();
    ChiTietSPInteface qlctsp = new ChiTietSPService();
    KhachHangInter qlkh = new KhachHangService();
    RamInterface qlram = new RamService();
    CPUInterface qlcpu = new CPUService();
    CardMHinterFace qlcard = new CardMHService();
    IPinSer qlpin = new PinSer();
    HeDHInterface qlhdh = new HeDHServices();
    ICongKetNoiS qlkn = new CongKetNoiSer();

    List<MauSac> listMS;
    List<DongSP> listDSP;
    List<OCung> listOC;
    List<Pin> listPin;
    List<Hedieuhanh> listhdh;
    List<CongKetNoi> listckn;
    List<Ram> listram;
    List<CPU> listcpu;
    List<CardManHinh> listCr;

    public BanHang() {

        initComponents();
        dtmCTSP = (DefaultTableModel) tblSP.getModel();
        ctspSevices = new ChiTietSPService();
        listSPCT = ctspSevices.getAllSPBH();
        loadDataSP();
        dtmHDCT = (DefaultTableModel) tblHDCT.getModel();
        listHDCT = hdctServices.getAll();
        loadTableHD(qlbh.getListHoaDon());
        addCbKh();
        cbTimKiem();
        this.setLocationRelativeTo(null);

        listram = qlram.getAll();
        listDSP = qldsp.getAll();
        listOC = qloc.getAll();
        listcpu = qlcpu.getAll();
        listCr = qlcard.getAll();
        listMS = qlms.all();
        listPin = qlpin.getList();
        listhdh = qlhdh.getAll();
        listckn = qlkn.getall();

        addLocOcung();
        addLocPin();
        addLocHDH();
        addLocCPU();
        addLocRam();
        addLocMS();
        addLocDSP();

    }

    void addLocOcung() {
        dfcb = (DefaultComboBoxModel) cbOCung.getModel();
        dfcb.removeAllElements();
        dfcb.addElement("");
        for (OCung oc : listOC) {
            dfcb.addElement(oc.getDungLuong());
        }
    }

    void addLocPin() {
        dfcb = (DefaultComboBoxModel) cbPin.getModel();
        dfcb.removeAllElements();
        dfcb.addElement("");
        for (Pin pin : listPin) {
            dfcb.addElement(pin.getDungLuong());
        }
    }

    void addLocHDH() {
        dfcb = (DefaultComboBoxModel) cbHDH.getModel();
        dfcb.removeAllElements();
        dfcb.addElement("");
        for (Hedieuhanh hdh : listhdh) {
            dfcb.addElement(hdh.getTenHDH());
        }
    }

    void addLocCPU() {
        dfcb = (DefaultComboBoxModel) cbCPU.getModel();
        dfcb.removeAllElements();
        dfcb.addElement("");
        for (CPU cpu : listcpu) {
            dfcb.addElement(cpu.getTen());
        }
    }

    void addLocRam() {
        dfcb = (DefaultComboBoxModel) cbRam.getModel();
        dfcb.removeAllElements();
        dfcb.addElement("");
        for (Ram ram : listram) {
            dfcb.addElement(ram.getDungLuong());
        }
    }

    void addLocMS() {
        dfcb = (DefaultComboBoxModel) cbMau.getModel();
        dfcb.removeAllElements();
        dfcb.addElement("");
        for (MauSac ms : listMS) {
            dfcb.addElement(ms.getTen());
        }
    }

    void addLocDSP() {
        dfcb = (DefaultComboBoxModel) cbDSP.getModel();
        dfcb.removeAllElements();
        dfcb.addElement("");
        for (DongSP dsp : listDSP) {
            dfcb.addElement(dsp.getTen());
        }
    }

    void loadDataSP() {
        dtmCTSP = (DefaultTableModel) tblSP.getModel();
        dtmCTSP.setRowCount(0);
        for (SanPhamBanHangViewModel sp : qlctsp.getAllSPBH()) {
            dtmCTSP.addRow(sp.toDataRow());
        }
    }

    private void showData(List<SanPhamBanHangViewModel> litSp) {
        dtmCTSP.setRowCount(0);
        for (SanPhamBanHangViewModel s : litSp) {
            dtmCTSP.addRow(s.toDataRow());
        }
    }

    public void cbTimKiem() {
        cbKH.setEditable(true);
        AutoCompleteDecorator.decorate(cbKH);

    }

    void addCbKh() {
        dfcb = (DefaultComboBoxModel) cbKH.getModel();
        for (KhachHang kh : qlkh.getList()) {
            dfcb.addElement(kh);
        }
    }

    private void showDataMau() {
        String mau = cbMau.getSelectedItem().toString();
        dtmCTSP.setRowCount(0);
        for (SanPhamBanHangViewModel s : qlctsp.getMau(mau)) {
            dtmCTSP.addRow(s.toDataRow());
        }
    }

    private void showDataDSP() {
        String dsp = cbDSP.getSelectedItem().toString();
        dtmCTSP.setRowCount(0);
        for (SanPhamBanHangViewModel s : qlctsp.getDongSP(dsp)) {
            dtmCTSP.addRow(s.toDataRow());
        }
    }

    private void showDataOCung() {
        String oc = cbOCung.getSelectedItem().toString();
        dtmCTSP.setRowCount(0);
        for (SanPhamBanHangViewModel s : qlctsp.getOCung(oc)) {
            dtmCTSP.addRow(s.toDataRow());
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSP = new javax.swing.JTable();
        btnTimKiem = new javax.swing.JButton();
        cbMau = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cbDSP = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cbOCung = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        cbPin = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        cbCPU = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        cbRam = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        cbHDH = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHDCT = new javax.swing.JTable();
        btnCapNhatSP = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnThanhToan = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtTienKhachDua = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtGiamGia = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        lbTienThua = new javax.swing.JLabel();
        lbNhanVien = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        cbKH = new javax.swing.JComboBox<>();
        txtKhachhang = new javax.swing.JTextField();
        btnHuyHD = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        lbMaHD = new javax.swing.JLabel();
        lbTongTien = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lbTienPhaiTra = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbHD = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Sản phẩm"));

        tblSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã sp", "Tên sp", "Màu sắc", "Dòng sp", "Ô cứng", "Pin", "CPU", "Ram", "HeDH", "Số lượng tồn", "Giá bán"
            }
        ));
        tblSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSPMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSP);

        btnTimKiem.setText("Tìm Kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        cbMau.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));
        cbMau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbMauMouseClicked(evt);
            }
        });
        cbMau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMauActionPerformed(evt);
            }
        });
        cbMau.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cbMauPropertyChange(evt);
            }
        });

        jLabel8.setText("Màu sắc");

        cbDSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));
        cbDSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDSPActionPerformed(evt);
            }
        });

        jLabel10.setText("Dòng SP");

        cbOCung.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));
        cbOCung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbOCungActionPerformed(evt);
            }
        });

        jLabel11.setText("Ổ cứng");

        cbPin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbPin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPinActionPerformed(evt);
            }
        });

        jLabel12.setText("Pin");

        cbCPU.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbCPU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCPUActionPerformed(evt);
            }
        });

        jLabel13.setText("CPU");

        cbRam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbRam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRamActionPerformed(evt);
            }
        });

        jLabel15.setText("Ram");

        cbHDH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbHDH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbHDHActionPerformed(evt);
            }
        });

        jLabel16.setText("HDH");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbMau, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbDSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbOCung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbPin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbCPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbRam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbHDH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnTimKiem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTimKiem)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbMau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbDSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbOCung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbPin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbRam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbHDH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Giỏ hàng"));

        tblHDCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sp", "Tên sp", "Giá", "Số lương", "Tổng tiền"
            }
        ));
        tblHDCT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHDCTMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblHDCT);

        btnCapNhatSP.setText("Cập nhật số lượng");
        btnCapNhatSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatSPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCapNhatSP)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCapNhatSP)))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Khách hàng :");

        jLabel3.setText("Nhân viên");

        btnThanhToan.setText("In HD + thanh toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        jLabel6.setText("Tiền khách đưa : ");

        txtTienKhachDua.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTienKhachDuaCaretUpdate(evt);
            }
        });
        txtTienKhachDua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTienKhachDuaActionPerformed(evt);
            }
        });

        jLabel7.setText("Tổng tiền hàng :");

        jLabel4.setText("Tiền thừa");

        jLabel5.setText("SĐT KH");

        jButton2.setText("Lưu HD");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel9.setText("Giảm giá");

        txtGiamGia.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtGiamGiaCaretUpdate(evt);
            }
        });

        jButton3.setText("ClearForm");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        lbTienThua.setText("0");

        lbNhanVien.setText("-");

        jButton5.setText("Add KH mới");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        cbKH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0" }));
        cbKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbKHActionPerformed(evt);
            }
        });

        btnHuyHD.setText("Hủy HD");
        btnHuyHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyHDActionPerformed(evt);
            }
        });

        jButton1.setText("Tạo Hóa Đơn");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel14.setText("Mã HD");

        lbMaHD.setText("-");

        lbTongTien.setText("0");

        jLabel17.setText("Tiền phải trả");

        lbTienPhaiTra.setText("0");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lbNhanVien))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbKH, 0, 154, Short.MAX_VALUE)
                                    .addComponent(txtKhachhang))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5)
                        .addContainerGap())
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(btnThanhToan)
                                .addGap(41, 41, 41)
                                .addComponent(jButton2)))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel14))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbMaHD)
                                            .addComponent(lbTienThua))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton3))))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(0, 3, Short.MAX_VALUE)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel17))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbTienPhaiTra)
                                    .addComponent(lbTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(56, 56, 56)))
                        .addContainerGap())
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnHuyHD)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtKhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jButton5)
                    .addComponent(cbKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNhanVien)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lbTongTien))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(lbTienPhaiTra))
                .addGap(21, 21, 21)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lbTienThua))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(lbMaHD))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThanhToan)
                    .addComponent(jButton2)
                    .addComponent(btnHuyHD))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(34, 34, 34))
        );

        tbHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã HD", "Ngày tạo", "Mã NV", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbHDMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbHD);

        jTabbedPane1.addTab("Hóa Đơn Chờ", jScrollPane3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(634, 634, 634)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblHDCTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHDCTMouseClicked


    }//GEN-LAST:event_tblHDCTMouseClicked

    private void tblSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSPMouseClicked
        try {
            int row = tblSP.getSelectedRow();
            int rowhd = tbHD.getSelectedRow();
            SanPhamBanHangViewModel sp = listSPCT.get(row);
            HoaDonViewModel hd = qlbh.getListHoaDon().get(rowhd);
            String txtSoLuong = JOptionPane.showInputDialog("nhập số lượng");
            int soLuong = Integer.valueOf(txtSoLuong);
            int slton = Integer.parseInt(tblSP.getValueAt(row, 9).toString());
            if (soLuong > slton) {
                JOptionPane.showMessageDialog(this, "không đủ sản phẩm");
                return;
            }
            if (soLuong == 0) {
                JOptionPane.showMessageDialog(this, "số lượng phải lớn hơn 0");
                return;
            }
            int count = tblHDCT.getRowCount();
            for (int i = 0; i < count; i++) {
                if (tblSP.getValueAt(row, 0).toString().equals(tblHDCT.getValueAt(i, 0))) {
                    JOptionPane.showMessageDialog(this, "sản phẩm đã có trên giỏ hàng, vui lòng cập nhật số lượng");
                    return;
                }
            }

            String idCTSP = sp.getIdCTSP();
            String idHD = hd.getIdHD();
            double gia = sp.getGiaBan();
            HoaDonCTViewModel hdct = new HoaDonCTViewModel("", soLuong, gia, soLuong * gia, idHD, idCTSP);
            listHDC.add(hdct);
            TBGioHang tbgh = new TBGioHang("", sp.getMa(), sp.getTeSP(), soLuong, sp.getGiaBan(), 0, hd.getIdHD(), sp.getIdCTSP());
            dtmHDCT = (DefaultTableModel) tblHDCT.getModel();
            dtmHDCT.addRow(new Object[]{
                tbgh.getMaSP(), tbgh.getTenSP(), String.format("%.0f", tbgh.getDonGia()), tbgh.getSoLuong(), String.format("%.0f", tbgh.getTongTien())
            });

            tblSP.setValueAt(slton - soLuong, row, 9);
        } catch (Exception e) {
        }
        getTongTien();
//        qlbh.saveHDCT(hdct);
//        qlbh.updateCTSP(slton - soLuong, idCTSP);
//        loadTableGiohang();
//        loadDataSP();
    }//GEN-LAST:event_tblSPMouseClicked

    void loadTableGiohang() {
        int row = tbHD.getSelectedRow();
        if (row == -1) {
            return;
        }
        DefaultTableModel dftb = new DefaultTableModel();
        dftb = (DefaultTableModel) tblHDCT.getModel();
        HoaDonViewModel hd = qlbh.getListHoaDon().get(row);
        ArrayList<TBGioHang> list = qlbh.getListGioHang(hd.getIdHD());
        if (list != null) {

            dftb.setRowCount(0);
            for (TBGioHang gh : list) {
                dftb.addRow(new Object[]{
                    gh.getMaSP(), gh.getTenSP(), String.format("%.0f", gh.getDonGia()), gh.getSoLuong(), String.format("%.0f", gh.getTongTien())
                });
            }
        } else {
            dftb.setRowCount(0);
        }
    }

    void clearForm() {
        txtKhachhang.setText("");
        cbKH.setSelectedIndex(0);
        lbNhanVien.setText("");
        lbTongTien.setText("-");
        txtTienKhachDua.setText("");
        lbTienThua.setText("-");
        lbMaHD.setText("-");
        txtGiamGia.setText("");
    }

    void getTongTien() {
        double tongTien = 0;
        int count = tblHDCT.getRowCount();
        for (int i = 0; i < count; i++) {
            tongTien += Double.parseDouble(tblHDCT.getValueAt(i, 4).toString());
        }
        lbTongTien.setText(String.format("%.0f", tongTien));
        lbTienPhaiTra.setText(String.format("%.0f", tongTien));
    }

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        // TODO add your handling code here:
        int rowhd = tbHD.getSelectedRow();
        HoaDonViewModel hdv = qlbh.getListHoaDon().get(rowhd);
        String idHD = hdv.getIdHD();

        HoaDon hd = new HoaDon();
        long millis = System.currentTimeMillis();
        Date ngayThanhToan = new Date(millis);
        String idNV = qlbh.getIdNV(tbHD.getValueAt(rowhd, 2).toString());
        String sdt = cbKH.getSelectedItem().toString();
        String idKh = qlbh.getIdKH(sdt);

        hd.setNgayThanhToan(ngayThanhToan);
        hd.setNgayNhan(ngayThanhToan);
        hd.setSdt(cbKH.getSelectedItem().toString());
        hd.setThanhTien(Double.parseDouble(lbTongTien.getText()));
        hd.setIdNV(idNV);
        hd.setIdkh(idKh);

        for (HoaDonCTViewModel hdct : listHDC) {
            qlbh.saveHDCT(hdct);
        }
        qlbh.ThanhToan(hd, idHD);
        loadDataSP();
        dtmHDCT = (DefaultTableModel) tblHDCT.getModel();

        int choice = JOptionPane.showConfirmDialog(this, "Bạn có muốn in hoá đơn không ?");
        if (choice == JOptionPane.YES_OPTION) {
            String path = tbHD.getValueAt(rowhd, 0).toString();
            JFileChooser j = new JFileChooser();
            j.setFileSelectionMode(JFileChooser.APPROVE_OPTION);
            int x = j.showSaveDialog(tblHDCT);
//            if (x == JFileChooser.APPROVE_OPTION) {
//                path = j.getSelectedFile().getPath();
//
//            }
            Document doc = new Document(PageSize.A4, 50, 50, 50, 50);

            try {
                FileOutputStream fos = new FileOutputStream(path + ".pdf");
                PdfWriter.getInstance(doc, fos);
                doc.open();
                Paragraph pss = new Paragraph("DESTINY PC",
                        FontFactory.getFont(FontFactory.HELVETICA, 18));
                pss.setAlignment(Element.ALIGN_CENTER);
                doc.add(pss);
                Paragraph poo = new Paragraph("DC :S0 9 Trinh Van Bo, Nam Tu Niem, Ha Noi");
                poo.setAlignment(Element.ALIGN_CENTER);
                doc.add(poo);
                Paragraph po1 = new Paragraph("SDT : 0386.873.612");
                po1.setAlignment(Element.ALIGN_CENTER);
                doc.add(po1);

                doc.add(new Paragraph(" "));

                Paragraph p = new Paragraph("HOA DON BAN HANG",
                        FontFactory.getFont(FontFactory.HELVETICA, 26));
                p.setAlignment(Element.ALIGN_CENTER);
                doc.add(p);
                Paragraph ppw = new Paragraph("--------------------------------------------------------------------------------------");
                ppw.setAlignment(Element.ALIGN_CENTER);
                doc.add(ppw);
                doc.add(new Paragraph(" "));

//            long millis = System.currentTimeMillis();
//            java.util.Date date = new java.util.Date(millis);
                java.util.Date datetg = new java.util.Date();
                DateFormat dateFormata = null;
                dateFormata = new SimpleDateFormat("HH:mm:ss a");

                Paragraph pag = new Paragraph("Thoi Gian : " + dateFormata.format(datetg));
                pag.setAlignment(Element.ALIGN_RIGHT);
                doc.add(pag);
                HoaDonVM vm = (HoaDonVM) qlhd.getListHD().get(rowhd);
                //chuyển đổi tiếng việt
                String temp = Normalizer.normalize(vm.getTennv(), Normalizer.Form.NFD);
                Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
                pattern.matcher(temp).replaceAll("");
                Paragraph pad = new Paragraph("Nguoi Lap : " + temp);
                pad.setAlignment(Element.ALIGN_RIGHT);
                doc.add(pad);
                java.util.Date date = new java.util.Date();
                DateFormat dateFormat = null;
                dateFormat = new SimpleDateFormat("dd/MM/yyyy");

                Paragraph pa = new Paragraph("Ngay Lap             : " + dateFormat.format(date));

                doc.add(pa);
                //chuyển đổi tiếng việt
                String temp2 = Normalizer.normalize(txtKhachhang.getText().trim(), Normalizer.Form.NFD);
                Pattern pattern2 = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
                pattern2.matcher(temp2).replaceAll("");
                Paragraph a = new Paragraph("Ho Ten Khach Hang : " + temp2);
                doc.add(a);
                String sdtkh = cbKH.getSelectedItem().toString();
                Paragraph ad = new Paragraph("Sdt KH            : " + sdtkh);
                doc.add(ad);
                Paragraph pas = new Paragraph("Ma Hoa Don       : " + lbMaHD.getText().trim());
                doc.add(pas);

                doc.add(new Paragraph(""));
                doc.add(new Paragraph(" "));
                PdfPTable tab = new PdfPTable(5);
                tab.addCell("Ma San Pham");
                tab.addCell("Ten San Pham");
                tab.addCell("So Luong");
                tab.addCell("Don Gia");
                tab.addCell("Thanh Tien");
                for (int i = 0; i < tblHDCT.getRowCount(); i++) {
                    String ma = tblHDCT.getValueAt(i, 0).toString();
                    String tensp = tblHDCT.getValueAt(i, 1).toString();
                    String soluong = tblHDCT.getValueAt(i, 3).toString();
                    String gia = tblHDCT.getValueAt(i, 2).toString();
                    String tongtien = tblHDCT.getValueAt(i, 4).toString();

                    tab.addCell(ma);
                    tab.addCell(tensp);
                    tab.addCell(soluong);
                    tab.addCell(gia);
                    tab.addCell(tongtien);
                }

                doc.add(tab);
                doc.add(new Paragraph(" "));
                doc.add(new Paragraph(" "));
                Paragraph prs = new Paragraph();
                prs.add("Tien Khach Tra :      " + txtTienKhachDua.getText().trim());
                prs.setAlignment(Element.ALIGN_RIGHT);
                doc.add(prs);
                Paragraph pr = new Paragraph();
                pr.add("Giam Gia :        " + txtGiamGia.getText().trim());
                pr.setAlignment(Element.ALIGN_RIGHT);
                doc.add(pr);
                Paragraph ppo = new Paragraph("Tong Tien :    " + lbTongTien.getText());
                ppo.setAlignment(Element.ALIGN_RIGHT);
                doc.add(ppo);
                Paragraph ppt = new Paragraph("Tien Thua :    " + lbTienThua.getText());
                ppt.setAlignment(Element.ALIGN_RIGHT);
                doc.add(ppt);
                Paragraph ppe = new Paragraph("----------------------------------------------------------------------------------------------------------");
                ppe.setAlignment(Element.ALIGN_CENTER);
                doc.add(ppe);

                Paragraph pi = new Paragraph("CAM ON QUY KHACH !");
                pi.setAlignment(Element.ALIGN_CENTER);
                doc.add(pi);

            } catch (FileNotFoundException ex) {

            } catch (IOException ex) {
                Logger.getLogger(BanHang.class.getName()).log(Level.SEVERE, null, ex);
            } catch (DocumentException ex) {
                Logger.getLogger(BanHang.class.getName()).log(Level.SEVERE, null, ex);
            }
            dtmHDCT.setRowCount(0);
            loadTableHD(qlbh.getListHoaDon());
            clearForm();
            doc.close();
            JOptionPane.showMessageDialog(this, "Đã thanh toán và in hoá đơn thành công");
        } else {
            JOptionPane.showMessageDialog(this, "Thanh toán thành công");
            dtmHDCT.setRowCount(0);
            loadTableHD(qlbh.getListHoaDon());
            clearForm();
        }


    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void txtTienKhachDuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTienKhachDuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTienKhachDuaActionPerformed


    private void cbMauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbMauMouseClicked
        // TODO add your handling code here:


    }//GEN-LAST:event_cbMauMouseClicked

    private void cbMauPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cbMauPropertyChange
        // TODO add your handling code here:

    }//GEN-LAST:event_cbMauPropertyChange

    private void cbMauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMauActionPerformed
        // TODO add your handling code here:
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(((DefaultTableModel) tblSP.getModel()));
        sorter.setRowFilter(RowFilter.regexFilter(String.valueOf(cbMau.getSelectedItem())));
        tblSP.setRowSorter(sorter);

    }//GEN-LAST:event_cbMauActionPerformed

    private void btnCapNhatSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatSPActionPerformed
        // TODO add your handling code here:
        int count = tblSP.getRowCount();
        int row = tblHDCT.getSelectedRow();
        int rowhd = tbHD.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "chọn sản phẩm cần cập nhật");
            return;
        }
        HoaDonViewModel hd = qlbh.getListHoaDon().get(rowhd);
        TBGioHang gh = qlbh.getListGioHang(hd.getIdHD()).get(row);

        String sl = JOptionPane.showInputDialog("nhập số lượng sản phẩm");
        int slUpdate;
        try {
            slUpdate = Integer.parseInt(sl);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "nhập số");
            return;
        }
        for (int i = 0; i < count; i++) {
            if (tblHDCT.getValueAt(row, 0).toString().equals(tblSP.getValueAt(i, 0))) {
                int slton = Integer.parseInt(tblSP.getValueAt(i, 9).toString());
                if (slUpdate > slton) {
                    JOptionPane.showMessageDialog(this, "không đủ số lượng sản phẩm");
                    return;
                }
            }
        }
        qlbh.updateHDCT(slUpdate, gh.getId());
        loadTableGiohang();
        if (Integer.parseInt(tblHDCT.getValueAt(row, 3).toString()) == 0) {
            qlbh.xoaHDCT(gh.getId());
            loadTableGiohang();
        }
        loadDataSP();
    }//GEN-LAST:event_btnCapNhatSPActionPerformed

    private void cbKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbKHActionPerformed
        // TODO add your handling code here:
        String sdt = cbKH.getSelectedItem().toString();
        KhachHang kh = qlbh.getListSDT(sdt);
        if (kh != null) {
            txtKhachhang.setText(kh.getHoTen());
        } else {
            txtKhachhang.setText("");
        }
    }//GEN-LAST:event_cbKHActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        Random rd = new Random();
        String sdt = cbKH.getSelectedItem().toString();
        String ten = txtKhachhang.getText();
        String ma = "KH" + rd.nextInt(1000);
        KhachHang kh = new KhachHang();
        kh.setMa(ma);
        kh.setHoTen(ten);
        kh.setSdt(sdt);
        qlkh.insert(kh);
        addCbKh();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        clearForm();


    }//GEN-LAST:event_jButton3ActionPerformed

    private void cbDSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDSPActionPerformed
        // TODO add your handling code here:
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(((DefaultTableModel) tblSP.getModel()));
        sorter.setRowFilter(RowFilter.regexFilter(String.valueOf(cbDSP.getSelectedItem())));
        tblSP.setRowSorter(sorter);

    }//GEN-LAST:event_cbDSPActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
        if (txtSearch.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Nhập mã hoặc tên để tìm kiếm");
            showData(listSPCT);
            return;
        } else {
            ArrayList<SanPhamBanHangViewModel> listctsp = (ArrayList<SanPhamBanHangViewModel>) qlbh.searchMa(txtSearch.getText().trim());
            ArrayList<SanPhamBanHangViewModel> listct = (ArrayList<SanPhamBanHangViewModel>) qlbh.searchTen(txtSearch.getText().trim());
            if (!listctsp.isEmpty()) {
                showData(listctsp);
            } else if (!listct.isEmpty()) {
                showData(listct);
            } else {
                showData(listSPCT);
            }

        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void tbHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHDMouseClicked
        // TODO add your handling code here:
        loadTableGiohang();
        int row = tbHD.getSelectedRow();
        lbNhanVien.setText(tbHD.getValueAt(row, 2).toString());
        lbMaHD.setText(tbHD.getValueAt(row, 0).toString());
        getTongTien();
    }//GEN-LAST:event_tbHDMouseClicked

    private void btnHuyHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyHDActionPerformed
        // TODO add your handling code here:
        int choice = JOptionPane.showConfirmDialog(this, "xác nhận hủy xóa đơn ?", "hủy", JOptionPane.YES_OPTION);
        if (choice != JOptionPane.YES_OPTION) {
            return;
        }
        int rowhd = tbHD.getSelectedRow();

        HoaDonViewModel hd = qlbh.getListHoaDon().get(rowhd);
        qlbh.huyHDCT(hd.getIdHD());
        qlbh.huyHD(hd.getIdHD());
        JOptionPane.showMessageDialog(this, "hủy hóa đơn thành công");
        loadTableHD(qlbh.getListHoaDon());
        loadTableGiohang();
        dtmHDCT = (DefaultTableModel) tblHDCT.getModel();
        dtmHDCT.setRowCount(0);
        loadDataSP();
        clearForm();
    }//GEN-LAST:event_btnHuyHDActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int count = tbHD.getRowCount();
        if (count > 4) {
            JOptionPane.showMessageDialog(this, "tối đa 5 hóa đơn chờ");
            return;
        }
        Random rd = new Random();
        String maHD = "HD" + rd.nextInt(1000);
        long millis = System.currentTimeMillis();
        Date ngayTao = new Date(millis);
        HoaDonViewModel hd = new HoaDonViewModel();
        hd.setMaHD(maHD);
        hd.setNgayTao(ngayTao);
        hd.setTrangThai("Chờ thanh toán");
        qlbh.insertHDR(hd);
        loadTableHD(qlbh.getListHoaDon());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        for (HoaDonCTViewModel hdct : listHDC) {
            qlbh.saveHDCT(hdct);
        }
        listHDC.removeAll(listHDC);
        JOptionPane.showMessageDialog(this, "Lưu hóa đơn thành công");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtTienKhachDuaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTienKhachDuaCaretUpdate
        // TODO add your handling code here:
        if (txtTienKhachDua.getText().trim().length() == 0) {
            lbTienThua.setText("0");
        }
        double tienDua = 0;
        try {
            tienDua = Double.parseDouble(txtTienKhachDua.getText());
        } catch (Exception e) {
        }

        double tienPhaiTra = Double.parseDouble(lbTienPhaiTra.getText());
        double tienThua = tienDua - tienPhaiTra;
        lbTienThua.setText(String.format("%.0f", tienThua));
        if (tienThua < 0) {
            btnThanhToan.setEnabled(false);
        } else {
            btnThanhToan.setEnabled(true);
        }

    }//GEN-LAST:event_txtTienKhachDuaCaretUpdate

    private void cbOCungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbOCungActionPerformed
        // TODO add your handling code here:
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(((DefaultTableModel) tblSP.getModel()));
        sorter.setRowFilter(RowFilter.regexFilter(String.valueOf(cbOCung.getSelectedItem())));
        tblSP.setRowSorter(sorter);

    }//GEN-LAST:event_cbOCungActionPerformed

    private void cbPinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPinActionPerformed
        // TODO add your handling code here:
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(((DefaultTableModel) tblSP.getModel()));
        sorter.setRowFilter(RowFilter.regexFilter(String.valueOf(cbPin.getSelectedItem())));
        tblSP.setRowSorter(sorter);
    }//GEN-LAST:event_cbPinActionPerformed

    private void cbCPUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCPUActionPerformed
        // TODO add your handling code here:
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(((DefaultTableModel) tblSP.getModel()));
        sorter.setRowFilter(RowFilter.regexFilter(String.valueOf(cbCPU.getSelectedItem())));
        tblSP.setRowSorter(sorter);
    }//GEN-LAST:event_cbCPUActionPerformed

    private void cbRamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRamActionPerformed
        // TODO add your handling code here:
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(((DefaultTableModel) tblSP.getModel()));
        sorter.setRowFilter(RowFilter.regexFilter(String.valueOf(cbRam.getSelectedItem())));
        tblSP.setRowSorter(sorter);
    }//GEN-LAST:event_cbRamActionPerformed

    private void cbHDHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbHDHActionPerformed
        // TODO add your handling code here:
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(((DefaultTableModel) tblSP.getModel()));
        sorter.setRowFilter(RowFilter.regexFilter(String.valueOf(cbHDH.getSelectedItem())));
        tblSP.setRowSorter(sorter);
    }//GEN-LAST:event_cbHDHActionPerformed

    private void txtGiamGiaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtGiamGiaCaretUpdate
        // TODO add your handling code here:
        double tongTien = 0;
        try {
            tongTien = Double.parseDouble(lbTongTien.getText());
        } catch (NumberFormatException numberFormatException) {
        }
        double giamGia = 0;
        try {
            giamGia = Double.parseDouble(txtGiamGia.getText());
        } catch (NumberFormatException numberFormatException) {
        }
        double tienPhaiTra = tongTien - giamGia;
        lbTienPhaiTra.setText(String.format("%.0f", tienPhaiTra));
    }//GEN-LAST:event_txtGiamGiaCaretUpdate

    void loadTableHD(ArrayList<HoaDonViewModel> list) {
        DefaultTableModel dftb = new DefaultTableModel();
        dftb = (DefaultTableModel) tbHD.getModel();
        dftb.setRowCount(0);
        for (HoaDonViewModel hd : list) {
            dftb.addRow(new Object[]{
                hd.getMaHD(), hd.getNgayTao(), hd.getMaNV(), hd.getTrangThai()
            });
        }
    }

    public String maTuSinh() {
        String ma = null;
        int ren = ThreadLocalRandom.current().nextInt();
        List<HoaDon> list = qlhd.getAll();
        for (int i = 0; i < list.size(); i++) {
            ma = "HD0" + ren;
        }
        return ma;
    }

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
            java.util.logging.Logger.getLogger(BanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BanHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhatSP;
    private javax.swing.JButton btnHuyHD;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbCPU;
    private javax.swing.JComboBox<String> cbDSP;
    private javax.swing.JComboBox<String> cbHDH;
    private javax.swing.JComboBox<String> cbKH;
    private javax.swing.JComboBox<String> cbMau;
    private javax.swing.JComboBox<String> cbOCung;
    private javax.swing.JComboBox<String> cbPin;
    private javax.swing.JComboBox<String> cbRam;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbMaHD;
    private javax.swing.JLabel lbNhanVien;
    private javax.swing.JLabel lbTienPhaiTra;
    private javax.swing.JLabel lbTienThua;
    private javax.swing.JLabel lbTongTien;
    private javax.swing.JTable tbHD;
    private javax.swing.JTable tblHDCT;
    private javax.swing.JTable tblSP;
    private javax.swing.JTextField txtGiamGia;
    private javax.swing.JTextField txtKhachhang;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTienKhachDua;
    // End of variables declaration//GEN-END:variables

}
