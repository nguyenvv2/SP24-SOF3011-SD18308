package com.example.sd18308.repository;

import com.example.sd18308.connect.HibernateUtils;
import com.example.sd18308.model.DanhMuc;
import org.hibernate.Session;

import java.util.ArrayList;

public class DanhMucRepository {

    Session session;

    public ArrayList<DanhMuc> getList() {
        session = HibernateUtils.getFACTORY().openSession();
        // Truy van lay ra toan bo danh muc
        ArrayList<DanhMuc> list =
                (ArrayList<DanhMuc>) session.createQuery("FROM DanhMuc").list();
        session.close();
        return list;
    }

    public static void main(String[] args) {
        ArrayList<DanhMuc> list = new DanhMucRepository().getList();
        for (DanhMuc danhMuc : list) {
            System.out.println(danhMuc.toString());
        }
    }
}
