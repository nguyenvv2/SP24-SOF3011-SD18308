package com.example.sd18308.servlet;

import com.example.sd18308.model.SinhVien;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SinhVienServlet", value = "/sinh-vien/trang-chu")
public class SinhVienServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SinhVien sinhVien = new SinhVien("Ph12345", "Nguyen Van A", "HCM", 20);
        request.setAttribute("sinhVien", sinhVien);
        ArrayList<SinhVien> listSinhVien = new ArrayList<>();
        listSinhVien.add(sinhVien);
        listSinhVien.add(new SinhVien("123", "Tran thi B", "HN", 21));
        listSinhVien.add(new SinhVien("124", "Tran thi C", "HN", 21));
        request.setAttribute("listSinhVien", listSinhVien);
        request.getRequestDispatcher("/trang-chu.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Da chay vao post");
    }
}
