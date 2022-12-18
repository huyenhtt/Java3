/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManHinhChinh;

import ChucNang.BanHang;
import ChucNang.HoaDon;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import ChucNang.QuanLySanPham;
import ChucNang.TrangChu;

import view.HoaDonF1;

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
//        itempn.setBackground(new Color(96, 100, 191));
//        itempn.setBackground(new Color(96, 100, 191));
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
                    node = new BanHang();
                    break;
                case "SẢN PHẨM":
                    node = new QuanLySanPham();
                    break;
                case "HOÁ ĐƠN":
//                    HoaDonF1 hdf = new HoaDonF1();
//                    hdf.setResizable(true);
//                    node = (JPanel) hdf.getContentPane();
                    node = new HoaDon();

                    break;
                case "NHÂN VIÊN":
//                    node = new NhanVien();
                    break;
                case "KHÁCH HÀNG":
//                    node = new Hello();
                    break;
                case "THỐNG KÊ":
//                    node = new HH();
                    break;
                case "ĐĂNG XUẤT":

                    System.exit(0);
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
