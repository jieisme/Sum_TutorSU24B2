/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buoi2_sof2041.entity;

/**
 *
 * @author zudd4
 */
public class NhanVien {
    
    private String ma;
    
    private String ten;
    
    private String sdt;
    
    private int trangThai;

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public NhanVien() {
    }

    public NhanVien(String ma, String ten, String sdt, int trangThai) {
        this.ma = ma;
        this.ten = ten;
        this.sdt = sdt;
        this.trangThai = trangThai;
    }
    
}
