/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EduSys.entity;

import java.util.Date;


/**
 *
 * @author Đức Toàn
 */
public class HoaDon {
    private int MaHD;
    private String MaNV;
    private int MaKH;
    private Date NgayXuat;
    private float TongTien;


    public int getMaHD() {
        return MaHD;
    }

    public void setMaHD(int MaHD) {
        this.MaHD = MaHD;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public int getMaKH() {
        return MaKH;
    }

    public void setMaKH(int MaKH) {
        this.MaKH = MaKH;
    }

    public Date getNgayXuat() {
        return NgayXuat;
    }
    public int getNamXuat(){
        return  Integer.valueOf(String.valueOf(NgayXuat).substring(0, String.valueOf(NgayXuat).indexOf("-")));
                
    }
    public void setNgayXuat(Date NgayXuat) {
        this.NgayXuat = NgayXuat;
    }

    public double getTongTien() {
        return TongTien;
    }

    public void setTongTien(Float TongTien) {
        this.TongTien = TongTien;
    }

    public HoaDon(int MaHD, String MaNV, int MaKH, Date NgayXuat, Float TongTien) {
        this.MaHD = MaHD;
        this.MaNV = MaNV;
        this.MaKH = MaKH;
        this.NgayXuat = NgayXuat;
        this.TongTien = TongTien;
    }

    public HoaDon() {
    }

    @Override
    public String toString() {
        return "HoaDon{" + "MaHD=" + MaHD + ", NgayXuat=" + NgayXuat + '}';
    }

   
}
