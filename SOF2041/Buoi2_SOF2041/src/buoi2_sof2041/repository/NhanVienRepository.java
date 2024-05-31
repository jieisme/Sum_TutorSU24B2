/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buoi2_sof2041.repository;

import buoi2_sof2041.entity.NhanVien;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author zudd4
 */
public class NhanVienRepository {

    private List<NhanVien> nhanVienLists;

    public List<NhanVien> getAll() throws SQLException {
        nhanVienLists = new ArrayList<>();
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM NhanVien";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            String maNV = rs.getString("MaNV");
            String hoVaTen = rs.getString("HoVaTen");
            String soDienThoai = rs.getString("SoDienThoai");
            int trangThai = rs.getInt("TrangThai");
            NhanVien nhanVien = new NhanVien(maNV, hoVaTen, soDienThoai, trangThai);
            nhanVienLists.add(nhanVien);
        }

        rs.close();
        st.close();
        conn.close();
        return nhanVienLists;
    }

    public NhanVien detail(String maNV) {
        NhanVien nhanVien = new NhanVien();

        for (NhanVien nv : nhanVienLists) {
            if (nv.getMa().equalsIgnoreCase(maNV.trim())) {
                nhanVien.setMa(nv.getMa());
                nhanVien.setTen(nv.getTen());
                nhanVien.setSdt(nv.getSdt());
                nhanVien.setTrangThai(nv.getTrangThai());
            }
        }

        return nhanVien;
    }

    public String update(NhanVien nhanVien) throws SQLException {
        Connection conn = DBConnect.getConnection();
        String sql = "UPDATE [dbo].[NhanVien]\n"
                + "   SET [HoVaTen] = ?\n"
                + "      ,[SoDienThoai] = ?\n"
                + "      ,[TrangThai] = ?\n"
                + " WHERE MaNV = ?";
        PreparedStatement preSt = conn.prepareStatement(sql);
        preSt.setString(1, nhanVien.getTen());
        preSt.setString(2, nhanVien.getSdt());
        preSt.setInt(3, nhanVien.getTrangThai());
        preSt.setString(4, nhanVien.getMa());
        preSt.executeUpdate();

        preSt.close();
        conn.close();
        return "Update thành công";
    }
}
