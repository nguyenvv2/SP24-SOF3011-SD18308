package com.example.sd18308.repository;

import com.example.sd18308.connect.HibernateUtils;
import com.example.sd18308.model.DanhMuc;
import com.example.sd18308.model.SanPham;
import org.hibernate.Session;

import java.util.ArrayList;

public class SanPhamRepository {


    public ArrayList<SanPham> getList() {
        Session session = HibernateUtils.getFACTORY().openSession();
        // Truy van lay ra toan bo danh muc
        ArrayList<SanPham> list =
                (ArrayList<SanPham>) session.createQuery("FROM SanPham order by ngayTao asc ").list();
        session.close();
        return list;
    }
}
