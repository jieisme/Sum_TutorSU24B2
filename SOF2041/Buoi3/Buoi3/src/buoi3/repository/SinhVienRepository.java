/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buoi3.repository;

import buoi3.entity.SinhVien;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author zudd4
 */
public class SinhVienRepository {

    private List<SinhVien> sinhVienLists;

    public List<SinhVien> getAll() throws SQLException {
        sinhVienLists = new ArrayList<>();
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM SINHVIEN";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            String maSV = rs.getString("Ma");
            String tenSV = rs.getString("Ten");
            boolean gioiTinh = rs.getBoolean("GioiTinh");
            int namSinh = rs.getInt("namSinh");

            SinhVien sinhVien = new SinhVien(maSV, tenSV, gioiTinh, namSinh);
            sinhVienLists.add(sinhVien);
        }

        rs.close();
        st.close();
        conn.close();
        return sinhVienLists;
    }

    public String add(SinhVien sinhVien) throws SQLException {
        Connection conn = DBConnect.getConnection();
        String sql = "INSERT INTO [dbo].[SinhVien]\n"
                + "           ([Ma]\n"
                + "           ,[Ten]\n"
                + "           ,[GioiTinh]\n"
                + "           ,[NamSinh])\n"
                + "     VALUES\n"
                + "           (?, ?, ?, ?)";
        PreparedStatement preSt = conn.prepareCall(sql);
        preSt.setString(1, sinhVien.getMaSV());
        preSt.setString(2, sinhVien.getTenSV());
        preSt.setBoolean(3, sinhVien.isGioiTinh());
        preSt.setInt(4, sinhVien.getTuoi());
        preSt.executeUpdate();
        return "Add thành công";
    }
    
    public List<SinhVien> searchByMa(String ma) throws SQLException {
        sinhVienLists = new ArrayList<>();
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM SINHVIEN WHERE MA = '" + ma + "'";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            String maSV = rs.getString("Ma");
            String tenSV = rs.getString("Ten");
            boolean gioiTinh = rs.getBoolean("GioiTinh");
            int namSinh = rs.getInt("namSinh");

            SinhVien sinhVien = new SinhVien(maSV, tenSV, gioiTinh, namSinh);
            sinhVienLists.add(sinhVien);
        }

        rs.close();
        st.close();
        conn.close();
        return sinhVienLists;
    }

}
