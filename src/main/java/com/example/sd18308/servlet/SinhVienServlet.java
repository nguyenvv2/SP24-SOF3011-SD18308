package com.example.sd18308.servlet;

import com.example.sd18308.model.SinhVien;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SinhVienServlet", value = {"/sinh-vien/trang-chu",
        "/sinh-vien/add",// POST,
        "/sinh-vien/detail",
        "/sinh-vien/update", // POST
})
public class SinhVienServlet extends HttpServlet {
    ArrayList<SinhVien> listSinhVien;

    ArrayList<String> listTenLop;

    public SinhVienServlet() {
        listSinhVien = new ArrayList<>();
        listTenLop = new ArrayList<>();
        listTenLop.add("SD121");
        listTenLop.add("SD122");
        listTenLop.add("SD123");
        listTenLop.add("SD124");
        listSinhVien.add(new SinhVien("123", "Tran thi B", "HN", 21));
        listSinhVien.add(new SinhVien("124", "Tran thi C", "HN", 21));

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        System.out.println(uri);
        if (uri.equals("/sinh-vien/trang-chu")) {
            request.setAttribute("listSinhVien", listSinhVien);
            request.setAttribute("tenLop", listTenLop);
            request.getRequestDispatcher("/trang-chu.jsp").forward(request, response);
        } else if (uri.equals("/sinh-vien/detail")) {
            // mo trang detail
            String maSv = request.getParameter("maSinhVien");
            SinhVien sinhVienDetail = new SinhVien();
            for (SinhVien sinhVien : listSinhVien) {
                if (sinhVien.getMaSv().equals(maSv)) {
                    sinhVienDetail = sinhVien;
                }
            }
            request.setAttribute("sinhVienDetail", sinhVienDetail);
            request.getRequestDispatcher("/chi-tiet.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/sinh-vien/add")) {
            String maSinhVien = request.getParameter("maSinhVien");
            String hoTen = request.getParameter("tenSinhVien");
            String diaChi = request.getParameter("diaChi");
            Integer tuoi = Integer.parseInt(request.getParameter("tuoi"));
            String gioiTinh = request.getParameter("gioiTinh");
            System.out.println(gioiTinh);
            SinhVien sinhVien = new SinhVien(maSinhVien, hoTen, diaChi, tuoi);
            listSinhVien.add(sinhVien);

            response.sendRedirect("/sinh-vien/trang-chu");
        } else if (uri.equals("/sinh-vien/update")) {
            String maSinhVien = request.getParameter("maSinhVien");
            String hoTen = request.getParameter("tenSinhVien");
            String diaChi = request.getParameter("diaChi");
            Integer tuoi = Integer.parseInt(request.getParameter("tuoi"));
            String gioiTinh = request.getParameter("gioiTinh");
            for (SinhVien sinhVien : listSinhVien) {
                if (sinhVien.getMaSv().equals(maSinhVien)) {
                    sinhVien.setTuoi(tuoi);
                    sinhVien.setTenSv(hoTen);
                    sinhVien.setDiaChi(diaChi);
                }
            }
            response.sendRedirect("/sinh-vien/trang-chu");
        }
    }
}
