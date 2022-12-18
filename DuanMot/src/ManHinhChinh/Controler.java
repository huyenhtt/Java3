/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManHinhChinh;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import view.BanHang;
import view.FrameChiTietSanPham;
import view.FrameKhachHang;
import view.FrameNhanVien;
import view.FrameQuanLySanPham;
import view.JFrameThongKe;
import view.QLDoiTra;

import view.QLHoaDon;

/**
 *
 * @author Admin
 */
public class Controler {

    private JPanel root;
    private String kindSelect = "";
    private List<DanhMuc> listDMuc = null;

    public Controler() {
    }

    public Controler(JPanel root) {
        this.root = root;
    }

    public void setView(JPanel itempn, JLabel itemlbl) {
        kindSelect = "TRANG CHỦ";
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new TrangChu());
        root.validate();
        root.repaint();
    }

    public void setEvent(List<DanhMuc> list) {
        this.listDMuc = list;
        for (DanhMuc danhMuc : list) {
            danhMuc.getJlb().addMouseListener(new LableEvent(danhMuc.getKind(), danhMuc.getJpn(), danhMuc.getJlb()));
        }
    }

    class LableEvent implements MouseListener {

        private JPanel node;
        private String kind;
        private JPanel pnItem;
        private JLabel lblItem;

        public LableEvent(String kind, JPanel pnItem, JLabel lblItem) {
            this.kind = kind;
            this.pnItem = pnItem;
            this.lblItem = lblItem;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            switch (kind) {
                case "TRANG CHỦ":
                    node = new TrangChu();
                    break;
                case "BÁN HÀNG":
                    BanHang hbg = new BanHang();
                    hbg.setResizable(true);
                    node = (JPanel) hbg.getContentPane();
                    break;
                case "SẢN PHẨM":
                    FrameQuanLySanPham ct = new FrameQuanLySanPham();
                    node = (JPanel) ct.getContentPane();
                    break;
                case "HOÁ ĐƠN":
                    QLHoaDon hdf = new QLHoaDon();
                    hdf.setResizable(true);
                    node = (JPanel) hdf.getContentPane();
                    break;
                case "NHÂN VIÊN":
                    FrameNhanVien nv = new FrameNhanVien();
                    node = (JPanel) nv.getContentPane();
                    break;
                case "KHÁCH HÀNG":
                    FrameKhachHang hh = new FrameKhachHang();
                    node = (JPanel) hh.getContentPane();
                    break;
                case "THỐNG KÊ":
                    JFrameThongKe tk = new JFrameThongKe();
                    node = (JPanel) tk.getContentPane();
//                    node = new HH();
                    break;
                case "ĐỔI TRẢ":
                    QLDoiTra dtra = new QLDoiTra();
                    node = (JPanel) dtra.getContentPane();
//                    node = new HH();
                    break;
                case "ĐĂNG XUẤT":
                    ManHinh nh = new ManHinh();
                    int choice = JOptionPane.showConfirmDialog(nh, "Bạn có muốn thoát chương trình ?");
                    if (choice != JOptionPane.YES_OPTION) {
                        return;
                    } else {
                        System.exit(0);
                    }
                    break;
                default:
//                    node = new KhachHang();
                    break;
            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();//lặp lại vòng lặp
            setChangBackGroud(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelect = kind;
            pnItem.setBackground(new Color(51, 51, 51));
            lblItem.setBackground(new Color(51, 51, 51));
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            pnItem.setBackground(Color.MAGENTA);
            lblItem.setBackground(Color.MAGENTA);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (!kindSelect.equalsIgnoreCase(kind)) {
                pnItem.setBackground(new Color(51, 51, 51));
                lblItem.setBackground(new Color(51, 51, 51));
            }
        }

    }

    private void setChangBackGroud(String kind) {
        for (DanhMuc danhMuc : listDMuc) {
            if (danhMuc.getKind().equalsIgnoreCase(kind)) {
                danhMuc.getJpn().setBackground(new Color(51, 51, 51));
                danhMuc.getJlb().setBackground(new Color(51, 51, 51));
            } else {
                danhMuc.getJpn().setBackground(new Color(51, 51, 51));
                danhMuc.getJlb().setBackground(new Color(51, 51, 51));
            }
        }
    }
}
