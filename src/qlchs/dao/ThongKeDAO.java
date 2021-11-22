/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlchs.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import qlchs.utils.JDBCHelper;

/**
 *
 * @author Admin
 */
public class ThongKeDAO {
    private List<Object[]> getList(String sql,String cols[] ,Object... args) throws SQLException{
        List<Object[]> list = new ArrayList<>();
        ResultSet rs = JDBCHelper.query(sql, args);
        while (rs.next()) {            
            Object[] vals = new Object[cols.length];
            // vals = {null,null,null,null} => tùy vào độ dài của thằng cột
            for(int i = 0 ; i < vals.length;i++){
                vals[i] = rs.getObject(cols[i]);
                            //get giá trị của cột                                          
            }
            list.add(vals);
        }
        return  list;
    }
     public List<Object[]> getBangDoanhThu(int year) throws SQLException{
             return null;
     }
     public List<Object[]> getBangDoanhSo(int year) throws SQLException{
         return null;
     }
}
