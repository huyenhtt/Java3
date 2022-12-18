/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import ViewModel.CTSPViewModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.CPU;
import model.CardManHinh;
import model.ChiTietSP;
import model.CongKetNoi;
import model.DongSP;
import model.Hedieuhanh;
import model.MauSac;
import model.OCung;
import model.Pin;
import model.Ram;
import model.SanPham;
import service.CPUService;
import service.CardMHService;
import service.ChiTietSPService;
import service.CongKetNoiSer;
import service.DongSPService;
import service.HeDHServices;
import service.MauSacSer;
import service.OCungService;
import service.PinSer;
import service.RamService;
import service.SanPhamService;
import service.impl.CPUInterface;
import service.impl.CardMHinterFace;
import service.impl.ChiTietSPInteface;
import service.impl.DongSPInterface;
import service.impl.HeDHInterface;
import service.impl.ICongKetNoiS;
import service.impl.IMauSac;
import service.impl.IPinSer;
import service.impl.OCungInterface;
import service.impl.RamInterface;
import service.impl.SanPhamInterface;

/**
 *
 * @author Admin
 */
public class FrameQuanLySanPham extends javax.swing.JFrame {

    /**
     * Creates new form FrameQuanLySanPham
     */
    DefaultTableModel dftb = new DefaultTableModel();
    DefaultComboBoxModel dfcb = new DefaultComboBoxModel();
    ChiTietSPInteface qlctsp = new ChiTietSPService();
    DongSPInterface qldsp = new DongSPService();
    OCungInterface qloc = new OCungService();
    RamInterface qlram = new RamService();
    IMauSac qlms = new MauSacSer();
    IPinSer qlpin = new PinSer();
    SanPhamInterface qlsp = new SanPhamService();
    HeDHInterface qlhdh = new HeDHServices();
    ICongKetNoiS qlkn = new CongKetNoiSer();
    CPUInterface qlcpu = new CPUService();
    CardMHinterFace qlcard = new CardMHService();
    DefaultComboBoxModel dcbmSP;
    DefaultComboBoxModel dcbmMS;
    DefaultComboBoxModel dcbmDSP;
    DefaultComboBoxModel dcbmOC;
    DefaultComboBoxModel dcbmPin;
    DefaultComboBoxModel dcbmhDH;
    DefaultComboBoxModel dcbmCKN;
    DefaultComboBoxModel dcbmRAM;
    DefaultComboBoxModel dcbmCPU;
    DefaultComboBoxModel dcbmCard;
    List<CTSPViewModel> listCTSP;
    List<SanPham> listSP;
    List<MauSac> listMS;
    List<DongSP> listDSP;
    List<OCung> listOC;
    List<Pin> listPin;
    List<Hedieuhanh> listhdh;
    List<CongKetNoi> listckn;
    List<Ram> listram;
    List<CPU> listcpu;
    List<CardManHinh> listCr;

    public FrameQuanLySanPham() {
        initComponents();

        loadTable();

        listram = qlram.getAll();
        addCBRam();
        listDSP = qldsp.getAll();
        addCBDongSP();
        listOC = qloc.getAll();
        addCBOCung();
        listcpu = qlcpu.getAll();
        addCBCPU();
        listCr = qlcard.getAll();
        addCBCard();
        listMS = qlms.all();
        addCBMS();
        listPin = qlpin.getList();
        addCBPin();
        listhdh = qlhdh.getAll();
        addCBHDH();
        listckn = qlkn.getall();
        addCBKN();

        addLocOcung();
        addLocCongKN();
        addLocPin();
        addLocHDH();
        addLocCPU();
        addLocRam();
        addLocCard();
        addLocDSP();
        addLocMS();

    }

    void addCBCPU() {
        dcbmCPU = (DefaultComboBoxModel) cbCPU.getModel();
        dcbmCPU.removeAllElements();
        for (CPU cpu : qlcpu.getAll()) {
            dcbmCPU.addElement(cpu.getTen());
        }
    }

    void addCBCard() {
        dcbmCard = (DefaultComboBoxModel) cbCard.getModel();
        dcbmCard.removeAllElements();
        for (CardManHinh ca : qlcard.getAll()) {
            dcbmCard.addElement(ca.getLoaiCard());
        }
    }

    void addCBDongSP() {
        dcbmDSP = (DefaultComboBoxModel) cbDongSP.getModel();
        dcbmDSP.removeAllElements();
        for (DongSP dsp : qldsp.getAll()) {
            dcbmDSP.addElement(dsp.getTen());
        }
    }

    void addCBOCung() {
        dcbmOC = (DefaultComboBoxModel) cbOCung.getModel();
        dcbmOC.removeAllElements();
        for (OCung oc : qloc.getAll()) {
            dcbmOC.addElement(oc.getDungLuong());
        }
    }

    void addCBRam() {
        dcbmRAM = (DefaultComboBoxModel) cbRam.getModel();
        dcbmRAM.removeAllElements();
        for (Ram ram : qlram.getAll()) {
            dcbmRAM.addElement(ram.getDungLuong());
        }
    }

    void addCBMS() {
        dcbmMS = (DefaultComboBoxModel) cbMauSac.getModel();
        dcbmMS.removeAllElements();
        for (MauSac ms : qlms.all()) {
            dcbmMS.addElement(ms.getTen());
        }
    }

    void addCBPin() {
        dcbmPin = (DefaultComboBoxModel) cbPin.getModel();
        for (Pin pin : qlpin.getList()) {
            dcbmPin.addElement(pin.getDungLuong());
        }
    }

    void addCBHDH() {
        dcbmhDH = (DefaultComboBoxModel) cbHDH.getModel();
        dcbmhDH.removeAllElements();
        for (Hedieuhanh hdh : qlhdh.getAll()) {
            dcbmhDH.addElement(hdh.getTenHDH());
        }
    }

    void addCBKN() {
        dcbmCKN = (DefaultComboBoxModel) cbCKN.getModel();
        dcbmCKN.removeAllElements();
        for (CongKetNoi kn : qlkn.getall()) {
            dcbmCKN.addElement(kn);
        }
    }

    void clearForm() {

        lbTrangThai.setText("-");
        txtGiaBan.setText("");
        txtSL.setText("");
        txtTimKiem.setText("");
        txtMa.setText("");
        txtTen.setText("");
        txtSerial.setText("");
        cbMauSac.setSelectedItem(0);
        cbDongSP.setSelectedItem(0);
        cbOCung.setSelectedItem(0);
        cbPin.setSelectedItem(0);
        cbHDH.setSelectedItem(0);
        cbCKN.setSelectedItem(0);
        cbRam.setSelectedItem(0);
        cbCPU.setSelectedItem(0);
        cbCard.setSelectedItem(0);

    }

    void loadTable() {
        dftb = (DefaultTableModel) tb.getModel();
        dftb.setRowCount(0);
        for (CTSPViewModel sp : qlctsp.getListCTSPViewModel()) {
            dftb.addRow(new Object[]{
                sp.getMaSP(), sp.getTen(), sp.getDongsp(), sp.getOCung(), sp.getCongKetNoi(), sp.getPin(), sp.getGiaBan(), sp.getSoLuongTon(),
                sp.getSerial(), sp.getHeDH(), sp.getTrangThai(), sp.getCPU(), sp.getRam(), sp.getCardMH(), sp.getMauSac()
            });
        }

    }

    void addLocOcung() {
        dfcb = (DefaultComboBoxModel) cbLocOC.getModel();
        dfcb.removeAllElements();
        dfcb.addElement("");
        for (OCung oc : listOC) {
            dfcb.addElement(oc.getDungLuong());
        }
    }

    void addLocCongKN() {
        dfcb = (DefaultComboBoxModel) cbLocCKN.getModel();
        dfcb.removeAllElements();
        dfcb.addElement("");
        for (CongKetNoi ckn : listckn) {
            dfcb.addElement(ckn.getTen());
        }
    }

    void addLocPin() {
        dfcb = (DefaultComboBoxModel) cbLocPin.getModel();
        dfcb.removeAllElements();
        dfcb.addElement("");
        for (Pin pin : listPin) {
            dfcb.addElement(pin.getDungLuong());
        }
    }

    void addLocHDH() {
        dfcb = (DefaultComboBoxModel) cbLocHDH.getModel();
        dfcb.removeAllElements();
        dfcb.addElement("");
        for (Hedieuhanh hdh : listhdh) {
            dfcb.addElement(hdh);
        }
    }

    void addLocCPU() {
        dfcb = (DefaultComboBoxModel) cbLocCPU.getModel();
        dfcb.removeAllElements();
        dfcb.addElement("");
        for (CPU cpu : listcpu) {
            dfcb.addElement(cpu.getTen());
        }
    }

    void addLocRam() {
        dfcb = (DefaultComboBoxModel) cbLocRam.getModel();
        dfcb.removeAllElements();
        dfcb.addElement("");
        for (Ram ram : listram) {
            dfcb.addElement(ram.getDungLuong());
        }
    }

    void addLocCard() {
        dfcb = (DefaultComboBoxModel) cbLocCard.getModel();
        dfcb.removeAllElements();
        dfcb.addElement("");
        for (CardManHinh card : listCr) {
            dfcb.addElement(card.getLoaiCard());
        }
    }

    void addLocMS() {
        dfcb = (DefaultComboBoxModel) cbLocMS.getModel();
        dfcb.removeAllElements();
        dfcb.addElement("");
        for (MauSac ms : listMS) {
            dfcb.addElement(ms.getTen());
        }
    }

    void addLocDSP() {
        dfcb = (DefaultComboBoxModel) cbLocDSP.getModel();
        dfcb.removeAllElements();
        dfcb.addElement("");
        for (DongSP dsp : listDSP) {
            dfcb.addElement(dsp.getTen());
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbDongSP = new javax.swing.JComboBox<>();
        cbOCung = new javax.swing.JComboBox<>();
        btnDSP = new javax.swing.JButton();
        btnOC = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtGiaBan = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtSL = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cbMauSac = new javax.swing.JComboBox<>();
        cbPin = new javax.swing.JComboBox<>();
        cbHDH = new javax.swing.JComboBox<>();
        btnMS = new javax.swing.JButton();
        btnPin = new javax.swing.JButton();
        btnhdh = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        cbRam = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        cbCPU = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        cbCard = new javax.swing.JComboBox<>();
        lbTrangThai = new javax.swing.JLabel();
        cbCKN = new javax.swing.JComboBox<>();
        btnCKN = new javax.swing.JButton();
        btnCra = new javax.swing.JButton();
        btnRam = new javax.swing.JButton();
        btnCPu = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnTimKiem = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        btnReLoad = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        txtSerial = new javax.swing.JTextField();
        cbLocDSP = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        cbLocOC = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        cbLocCKN = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        cbLocPin = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        cbLocHDH = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        cbLocCPU = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        cbLocRam = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        cbLocCard = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        cbLocMS = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Quản Lý Sản Phẩm");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 11, -1, -1));

        jLabel2.setText("Mã SP");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 54, -1, -1));
        getContentPane().add(txtMa, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 51, 140, -1));

        jLabel3.setText("Dòng SP");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 117, -1, -1));

        jLabel4.setText("Ổ cứng");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        getContentPane().add(cbDongSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 114, 141, -1));

        getContentPane().add(cbOCung, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 138, -1));

        btnDSP.setText("+");
        btnDSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDSPActionPerformed(evt);
            }
        });
        getContentPane().add(btnDSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 113, -1, -1));

        btnOC.setText("+");
        btnOC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOCActionPerformed(evt);
            }
        });
        getContentPane().add(btnOC, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, -1, -1));

        jLabel25.setText("Tên SP");
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 85, -1, -1));
        getContentPane().add(txtTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 82, 140, -1));

        jLabel5.setText("Màu sắc");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 170, -1, -1));

        jLabel6.setText("Pin");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(337, 55, -1, -1));

        jLabel7.setText("Giá bán");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 83, -1, -1));
        getContentPane().add(txtGiaBan, new org.netbeans.lib.awtextra.AbsoluteConstraints(369, 80, 134, -1));

        jLabel9.setText("HDH");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 115, -1, -1));
        getContentPane().add(txtSL, new org.netbeans.lib.awtextra.AbsoluteConstraints(369, 140, 134, -1));

        jLabel10.setText("Sl tồn");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(324, 143, -1, -1));

        getContentPane().add(cbMauSac, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, 134, -1));

        getContentPane().add(cbPin, new org.netbeans.lib.awtextra.AbsoluteConstraints(369, 52, 134, -1));

        getContentPane().add(cbHDH, new org.netbeans.lib.awtextra.AbsoluteConstraints(369, 112, 134, -1));

        btnMS.setText("+");
        btnMS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMSActionPerformed(evt);
            }
        });
        getContentPane().add(btnMS, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 170, -1, -1));

        btnPin.setText("+");
        btnPin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPinActionPerformed(evt);
            }
        });
        getContentPane().add(btnPin, new org.netbeans.lib.awtextra.AbsoluteConstraints(509, 51, -1, -1));

        btnhdh.setText("+");
        btnhdh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhdhActionPerformed(evt);
            }
        });
        getContentPane().add(btnhdh, new org.netbeans.lib.awtextra.AbsoluteConstraints(509, 111, -1, -1));

        jLabel8.setText("Cổng kết nối");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(742, 55, -1, -1));

        jLabel13.setText("Trạng thái");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(753, 167, -1, -1));

        jLabel17.setText("Ram");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(781, 89, -1, -1));

        getContentPane().add(cbRam, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 81, 135, -1));

        jLabel18.setText("CPU");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(782, 113, -1, -1));

        getContentPane().add(cbCPU, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 110, 135, -1));

        jLabel19.setText("Card màn hình");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(733, 142, -1, -1));

        getContentPane().add(cbCard, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 139, 135, -1));

        lbTrangThai.setText("-");
        getContentPane().add(lbTrangThai, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 167, -1, -1));

        getContentPane().add(cbCKN, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 52, 135, -1));

        btnCKN.setText("+");
        btnCKN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCKNActionPerformed(evt);
            }
        });
        getContentPane().add(btnCKN, new org.netbeans.lib.awtextra.AbsoluteConstraints(961, 51, -1, -1));

        btnCra.setText("+");
        btnCra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCraActionPerformed(evt);
            }
        });
        getContentPane().add(btnCra, new org.netbeans.lib.awtextra.AbsoluteConstraints(961, 138, -1, -1));

        btnRam.setText("+");
        btnRam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRamActionPerformed(evt);
            }
        });
        getContentPane().add(btnRam, new org.netbeans.lib.awtextra.AbsoluteConstraints(961, 80, -1, -1));

        btnCPu.setText("+");
        btnCPu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCPuActionPerformed(evt);
            }
        });
        getContentPane().add(btnCPu, new org.netbeans.lib.awtextra.AbsoluteConstraints(961, 109, -1, -1));

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        getContentPane().add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 226, -1, -1));

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        getContentPane().add(btnSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 226, -1, -1));

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        getContentPane().add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(174, 226, -1, -1));

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        getContentPane().add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 226, -1, -1));

        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });
        getContentPane().add(btnTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(594, 226, -1, -1));
        getContentPane().add(txtTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(685, 227, 178, -1));

        btnReLoad.setText("Reload");
        btnReLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReLoadActionPerformed(evt);
            }
        });
        getContentPane().add(btnReLoad, new org.netbeans.lib.awtextra.AbsoluteConstraints(881, 226, -1, -1));

        tb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã SP", "Tên SP", "Dòng SP", "Ổ cứng", "Cổng kết nối", "Pin", "Giá bán", "Số lượng", "Serial", "Hệ điều hành", "Trạng thái", "CPU", "Ram", "Card MH", "Màu Sắc"
            }
        ));
        tb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 1080, 300));

        jLabel11.setText("Serial");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 191, -1, -1));
        getContentPane().add(txtSerial, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 188, 138, -1));

        cbLocDSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbLocDSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLocDSPActionPerformed(evt);
            }
        });
        getContentPane().add(cbLocDSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 284, 70, -1));

        jLabel12.setText("Dòng SP");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 264, 60, -1));

        cbLocOC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbLocOC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLocOCActionPerformed(evt);
            }
        });
        getContentPane().add(cbLocOC, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 284, 70, -1));

        jLabel14.setText("Ổ cứng");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 264, -1, -1));

        cbLocCKN.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbLocCKN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLocCKNActionPerformed(evt);
            }
        });
        getContentPane().add(cbLocCKN, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 284, 80, -1));

        jLabel15.setText("Cổng KN");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 264, 60, -1));

        cbLocPin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbLocPin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLocPinActionPerformed(evt);
            }
        });
        getContentPane().add(cbLocPin, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 284, 90, -1));

        jLabel16.setText("Pin");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 264, 50, -1));

        cbLocHDH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbLocHDH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLocHDHActionPerformed(evt);
            }
        });
        getContentPane().add(cbLocHDH, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 284, 80, -1));

        jLabel20.setText("HDH");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 264, 50, -1));

        cbLocCPU.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbLocCPU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLocCPUActionPerformed(evt);
            }
        });
        getContentPane().add(cbLocCPU, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 284, 90, -1));

        jLabel21.setText("CPU");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 264, -1, -1));

        cbLocRam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbLocRam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLocRamActionPerformed(evt);
            }
        });
        getContentPane().add(cbLocRam, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 284, 80, -1));

        jLabel22.setText("Ram");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 264, 50, -1));

        cbLocCard.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbLocCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLocCardActionPerformed(evt);
            }
        });
        getContentPane().add(cbLocCard, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 284, 90, -1));

        jLabel23.setText("Card");
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 264, -1, -1));

        cbLocMS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbLocMS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLocMSActionPerformed(evt);
            }
        });
        getContentPane().add(cbLocMS, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 284, 100, -1));

        jLabel24.setText("Màu Sắc");
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 264, 80, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDSPActionPerformed
        FrameDongSP dsp = new FrameDongSP();
        dsp.setVisible(true);
        dsp.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        addCBDongSP();
    }//GEN-LAST:event_btnDSPActionPerformed

    private void btnOCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOCActionPerformed
        FrameOCung oc = new FrameOCung();
        oc.setVisible(true);
        oc.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        addCBDongSP();
    }//GEN-LAST:event_btnOCActionPerformed

    private void btnMSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMSActionPerformed
        MauSacForm ms = new MauSacForm();
        ms.setVisible(true);
        ms.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        addCBMS();
    }//GEN-LAST:event_btnMSActionPerformed

    private void btnPinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPinActionPerformed
        PinForm pin = new PinForm();
        pin.setVisible(true);
        pin.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        addCBPin();
    }//GEN-LAST:event_btnPinActionPerformed

    private void btnhdhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhdhActionPerformed
        HeDHFrame hdh = new HeDHFrame();
        hdh.setVisible(true);
        hdh.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        addCBHDH();
    }//GEN-LAST:event_btnhdhActionPerformed

    private void btnCKNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCKNActionPerformed
        CongKetNoiFrame ckn = new CongKetNoiFrame();
        ckn.setVisible(true);
        ckn.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        addCBKN();
    }//GEN-LAST:event_btnCKNActionPerformed

    private void btnCraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCraActionPerformed
        JFrameCard cr = new JFrameCard();
        cr.setVisible(true);
        cr.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        addCBCard();
    }//GEN-LAST:event_btnCraActionPerformed

    private void btnRamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRamActionPerformed
        JFrameRam ram = new JFrameRam();
        ram.setVisible(true);
        ram.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        addCBRam();
    }//GEN-LAST:event_btnRamActionPerformed

    private void btnCPuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCPuActionPerformed
        // TODO add your handling code here:
        JFrameCPU cpu = new JFrameCPU();
        cpu.setVisible(true);
        cpu.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_btnCPuActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:

        String giaban = txtGiaBan.getText();
        String sluong = txtSL.getText();
        String maSP = txtMa.getText();
        String ten = txtTen.getText();
        String serial = txtSerial.getText();
        int indexCKN = cbCKN.getSelectedIndex();
        CongKetNoi ckn = listckn.get(indexCKN);
        int indexCPU = cbCPU.getSelectedIndex();
        CPU cpu = listcpu.get(indexCPU);
        int indexCr = cbCard.getSelectedIndex();
        CardManHinh cr = listCr.get(indexCr);
        int indexDSP = cbDongSP.getSelectedIndex();
        DongSP dsp = listDSP.get(indexDSP);
        int indexHDH = cbHDH.getSelectedIndex();
        Hedieuhanh hdh = listhdh.get(indexHDH);
        int indexMS = cbMauSac.getSelectedIndex();
        MauSac ms = listMS.get(indexMS);
        int indexOC = cbOCung.getSelectedIndex();
        OCung oc = listOC.get(indexOC);
        int indexPin = cbPin.getSelectedIndex();
        Pin pin = listPin.get(indexPin);
        int indexRam = cbRam.getSelectedIndex();
        Ram ram = listram.get(indexRam);

        String idms = ms.getId();
        String iddsp = dsp.getId();
        String idoc = oc.getId();
        String idkn = ckn.getId();
        String idpin = pin.getId();
        String idcpu = cpu.getId();
        String idram = ram.getId();
        String idcard = cr.getId();
        String idhdh = hdh.getId();

        SanPham sp = new SanPham("", maSP, ten, serial);

        qlsp.insert(sp);

        String idSP = qlsp.getIDSP(maSP);
        ChiTietSP ctsp = new ChiTietSP("", Double.parseDouble(giaban), Integer.parseInt(sluong), 0, idms, iddsp, idoc, idkn, idpin, idcpu, idram, idcard, idhdh, idSP);

        qlctsp.insert(ctsp);

        loadTable();
        clearForm();
        JOptionPane.showMessageDialog(this, "thêm thành công");
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        int row = tb.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "chọn bản ghi cập nhật");
            return;
        }

        String giaban = txtGiaBan.getText();
        String sluong = txtSL.getText();
        String maSP = txtMa.getText();
        String ten = txtTen.getText();
        String serial = txtSerial.getText();
        int indexCKN = cbCKN.getSelectedIndex();
        CongKetNoi ckn = listckn.get(indexCKN);
        int indexCPU = cbCPU.getSelectedIndex();
        CPU cpu = listcpu.get(indexCPU);
        int indexCr = cbCard.getSelectedIndex();
        CardManHinh cr = listCr.get(indexCr);
        int indexDSP = cbDongSP.getSelectedIndex();
        DongSP dsp = listDSP.get(indexDSP);
        int indexHDH = cbHDH.getSelectedIndex();
        Hedieuhanh hdh = listhdh.get(indexHDH);
        int indexMS = cbMauSac.getSelectedIndex();
        MauSac ms = listMS.get(indexMS);
        int indexOC = cbOCung.getSelectedIndex();
        OCung oc = listOC.get(indexOC);
        int indexPin = cbPin.getSelectedIndex();
        Pin pin = listPin.get(indexPin);
        int indexRam = cbRam.getSelectedIndex();
        Ram ram = listram.get(indexRam);

        String idms = ms.getId();
        String iddsp = dsp.getId();
        String idoc = oc.getId();
        String idkn = ckn.getId();
        String idpin = pin.getId();
        String idcpu = cpu.getId();
        String idram = ram.getId();
        String idcard = cr.getId();
        String idhdh = hdh.getId();

        SanPham sp = new SanPham("", maSP, ten, serial);

        String idSP = qlsp.getIDSP(maSP);
        ChiTietSP ctsp = new ChiTietSP("", Double.parseDouble(giaban), Integer.parseInt(sluong), 0, idms, iddsp, idoc, idkn, idpin, idcpu, idram, idcard, idhdh, idSP);

        qlsp.update(sp, maSP);
        qlctsp.sua(ctsp, idSP);
        loadTable();
        clearForm();
        JOptionPane.showMessageDialog(this, "sửa thành công");
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        int row = tb.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "chọn bản ghi xóa");
            return;
        }

        String ma = tb.getValueAt(row, 0).toString();
        String idSP = qlsp.getIDSP(ma);
        qlctsp.xoa(idSP);
        qlsp.delete(ma);
        loadTable();
        clearForm();
        JOptionPane.showMessageDialog(this, "xóa thành công");


    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        clearForm();
        loadTable();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
        String timKiem = txtTimKiem.getText();
        if (timKiem.equals("")) {
            JOptionPane.showMessageDialog(this, "nhập mã hoặc tên sản phẩm");
            return;
        }
        ArrayList<CTSPViewModel> listByTen = qlctsp.searchTen(timKiem);
        ArrayList<CTSPViewModel> listByMa = qlctsp.searchMa(timKiem);
        if (!listByTen.isEmpty()) {
            dftb = (DefaultTableModel) tb.getModel();
            dftb.setRowCount(0);
            for (CTSPViewModel sp : listByTen) {
                dftb.addRow(new Object[]{
                    sp.getMaSP(), sp.getTen(), sp.getDongsp(), sp.getOCung(), sp.getCongKetNoi(), sp.getPin(), sp.getGiaBan(), sp.getSoLuongTon(),
                    sp.getSerial(), sp.getHeDH(), sp.getTrangThai(), sp.getCPU(), sp.getRam(), sp.getCardMH(), sp.getMauSac()
                });
            }
        } 
        else if (!listByMa.isEmpty()) {
            dftb = (DefaultTableModel) tb.getModel();
            dftb.setRowCount(0);
            for (CTSPViewModel sp : listByMa) {
                dftb.addRow(new Object[]{
                    sp.getMaSP(), sp.getTen(), sp.getDongsp(), sp.getOCung(), sp.getCongKetNoi(), sp.getPin(), sp.getGiaBan(), sp.getSoLuongTon(),
                    sp.getSerial(), sp.getHeDH(), sp.getTrangThai(), sp.getCPU(), sp.getRam(), sp.getCardMH(), sp.getMauSac()
                });
            }
        } 
        else {
            JOptionPane.showMessageDialog(this, "không tìm thấy sản phẩm");
            txtTimKiem.setText("");
            loadTable();
        }

    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnReLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReLoadActionPerformed
        // TODO add your handling code here:
        addCBRam();
        addCBDongSP();
        addCBOCung();
        addCBCPU();
        addCBCard();
        addCBMS();
        addCBPin();
        addCBHDH();
        addCBKN();

    }//GEN-LAST:event_btnReLoadActionPerformed

    private void tbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMouseClicked
        // TODO add your handling code here:

        int row = tb.getSelectedRow();

        txtGiaBan.setText(tb.getValueAt(row, 6).toString());
        txtSL.setText(tb.getValueAt(row, 7).toString());
        txtTen.setText(tb.getValueAt(row, 1).toString());
        txtSerial.setText(tb.getValueAt(row, 8).toString());
        cbCKN.setSelectedItem(tb.getValueAt(row, 4));
        cbCPU.setSelectedItem(tb.getValueAt(row, 11));
        cbCard.setSelectedItem(tb.getValueAt(row, 13));
        cbDongSP.setSelectedItem(tb.getValueAt(row, 2));
        cbHDH.setSelectedItem(tb.getValueAt(row, 9));
        txtMa.setText(tb.getValueAt(row, 0).toString());
        cbMauSac.setSelectedItem(tb.getValueAt(row, 14));
        cbOCung.setSelectedItem(tb.getValueAt(row, 3));
        cbPin.setSelectedItem(tb.getValueAt(row, 5));
        cbRam.setSelectedItem(tb.getValueAt(row, 12));
        if (Integer.parseInt(txtSL.getText()) == 0) {
            lbTrangThai.setText("Hết hàng");
        } else {

            lbTrangThai.setText("Còn hàng");
        }
    }//GEN-LAST:event_tbMouseClicked

    private void cbLocDSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLocDSPActionPerformed
        // TODO add your handling code here:
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(((DefaultTableModel) tb.getModel()));
        sorter.setRowFilter(RowFilter.regexFilter(String.valueOf(cbLocDSP.getSelectedItem())));
        tb.setRowSorter(sorter);
    }//GEN-LAST:event_cbLocDSPActionPerformed

    private void cbLocOCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLocOCActionPerformed
        // TODO add your handling code here:
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(((DefaultTableModel) tb.getModel()));
        sorter.setRowFilter(RowFilter.regexFilter(String.valueOf(cbLocOC.getSelectedItem())));
        tb.setRowSorter(sorter);
    }//GEN-LAST:event_cbLocOCActionPerformed

    private void cbLocCKNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLocCKNActionPerformed
        // TODO add your handling code here:
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(((DefaultTableModel) tb.getModel()));
        sorter.setRowFilter(RowFilter.regexFilter(String.valueOf(cbLocCKN.getSelectedItem())));
        tb.setRowSorter(sorter);
    }//GEN-LAST:event_cbLocCKNActionPerformed

    private void cbLocPinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLocPinActionPerformed
        // TODO add your handling code here:
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(((DefaultTableModel) tb.getModel()));
        sorter.setRowFilter(RowFilter.regexFilter(String.valueOf(cbLocPin.getSelectedItem())));
        tb.setRowSorter(sorter);
    }//GEN-LAST:event_cbLocPinActionPerformed

    private void cbLocHDHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLocHDHActionPerformed
        // TODO add your handling code here:
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(((DefaultTableModel) tb.getModel()));
        sorter.setRowFilter(RowFilter.regexFilter(String.valueOf(cbLocHDH.getSelectedItem())));
        tb.setRowSorter(sorter);
    }//GEN-LAST:event_cbLocHDHActionPerformed

    private void cbLocCPUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLocCPUActionPerformed
        // TODO add your handling code here:
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(((DefaultTableModel) tb.getModel()));
        sorter.setRowFilter(RowFilter.regexFilter(String.valueOf(cbLocCPU.getSelectedItem())));
        tb.setRowSorter(sorter);
    }//GEN-LAST:event_cbLocCPUActionPerformed

    private void cbLocRamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLocRamActionPerformed
        // TODO add your handling code here:
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(((DefaultTableModel) tb.getModel()));
        sorter.setRowFilter(RowFilter.regexFilter(String.valueOf(cbLocRam.getSelectedItem())));
        tb.setRowSorter(sorter);
    }//GEN-LAST:event_cbLocRamActionPerformed

    private void cbLocCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLocCardActionPerformed
        // TODO add your handling code here:
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(((DefaultTableModel) tb.getModel()));
        sorter.setRowFilter(RowFilter.regexFilter(String.valueOf(cbLocCard.getSelectedItem())));
        tb.setRowSorter(sorter);
    }//GEN-LAST:event_cbLocCardActionPerformed

    private void cbLocMSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLocMSActionPerformed
        // TODO add your handling code here:
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(((DefaultTableModel) tb.getModel()));
        sorter.setRowFilter(RowFilter.regexFilter(String.valueOf(cbLocMS.getSelectedItem())));
        tb.setRowSorter(sorter);
    }//GEN-LAST:event_cbLocMSActionPerformed

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
            java.util.logging.Logger.getLogger(FrameQuanLySanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameQuanLySanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameQuanLySanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameQuanLySanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameQuanLySanPham().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCKN;
    private javax.swing.JButton btnCPu;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnCra;
    private javax.swing.JButton btnDSP;
    private javax.swing.JButton btnMS;
    private javax.swing.JButton btnOC;
    private javax.swing.JButton btnPin;
    private javax.swing.JButton btnRam;
    private javax.swing.JButton btnReLoad;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnhdh;
    private javax.swing.JComboBox<String> cbCKN;
    private javax.swing.JComboBox<String> cbCPU;
    private javax.swing.JComboBox<String> cbCard;
    private javax.swing.JComboBox<String> cbDongSP;
    private javax.swing.JComboBox<String> cbHDH;
    private javax.swing.JComboBox<String> cbLocCKN;
    private javax.swing.JComboBox<String> cbLocCPU;
    private javax.swing.JComboBox<String> cbLocCard;
    private javax.swing.JComboBox<String> cbLocDSP;
    private javax.swing.JComboBox<String> cbLocHDH;
    private javax.swing.JComboBox<String> cbLocMS;
    private javax.swing.JComboBox<String> cbLocOC;
    private javax.swing.JComboBox<String> cbLocPin;
    private javax.swing.JComboBox<String> cbLocRam;
    private javax.swing.JComboBox<String> cbMauSac;
    private javax.swing.JComboBox<String> cbOCung;
    private javax.swing.JComboBox<String> cbPin;
    private javax.swing.JComboBox<String> cbRam;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbTrangThai;
    private javax.swing.JTable tb;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtSL;
    private javax.swing.JTextField txtSerial;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables

}
