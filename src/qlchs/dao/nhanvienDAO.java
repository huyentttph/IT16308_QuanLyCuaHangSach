/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlchs.dao;

import EduSys.entity.NhanVien;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import qlchs.utils.JDBCHelper;


/**
 *
 * @author tachi
 */
public class nhanvienDAO extends QLNSDAO<NhanVien, String> {

    final String INSERT_SQL = "INSERT INTO NHANVIEN(MaNV,MatKhau,HovaTen,NgaySinh,SDT,VaiTro,TinhTrang) values (?,?,?,?,?,?,1)";
    final String UPDATE_SQL = " UPDATE NHANVIEN set MatKhau=?, HovaTen=?, NgaySinh=?,SDT=?,VaiTro=? WHERE MaNV=?";
    final String DELETE_SQL = "DELETE FROM NHANVIEN WHERE MaNV=?";
    final String SELECT_ALL_SQL = "SELECT * FROM NHANVIEN";
    final String SELECT_BY_ID_SQL = "SELECT * FROM NHANVIEN WHERE MaNV= ?";
    String xoaTamThoi = "update NHANVIEN set TinhTrang=? where MaNV=?";
    String selectTinhTrang = "SELECT*FROM NHANVIEN where TinhTrang=?";

    public void xoaTamThoi(String idlist, String manv) {
        JDBCHelper.update(xoaTamThoi, idlist, manv);
    }

    public List<NhanVien> selectIdList(String id) {
        return this.selectBySql(selectTinhTrang, id);
    }
    @Override
    public void insert(NhanVien entity) {
        JDBCHelper.update(INSERT_SQL, entity.getMaNV(), entity.getMatKhau(), entity.getHoTen(), entity.getNgaySinh(), entity.getSDT(), entity.isVaiTro());
    }

    @Override
    public void update(NhanVien entity) {
        JDBCHelper.update(UPDATE_SQL, entity.getMatKhau(), entity.getHoTen(), entity.getNgaySinh(), entity.getSDT(), entity.isVaiTro(), entity.getMaNV());
    }

    @Override
    public void delete(String id) {
       JDBCHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<NhanVien> selectAll() {
       return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public NhanVien selectById(String id) {
       List<NhanVien> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<NhanVien> selectBySql(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {                
                NhanVien entity = new NhanVien();
                entity.setMaNV(rs.getString("MaNV"));
                entity.setMatKhau(rs.getString("MatKhau"));
                entity.setHoTen(rs.getString("HoVaTen"));
                entity.setNgaySinh(rs.getDate("NgaySinh"));
                entity.setSDT(rs.getString("SDT"));
                entity.setVaiTro(rs.getBoolean("VaiTro"));
                entity.setTinhTrang(rs.getBoolean("TinhTrang"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            
        } catch (Exception e) {
           e.printStackTrace();
        }
       return list;
    }

}
