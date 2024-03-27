package com.example.sd18308.servlet;

import com.example.sd18308.model.DanhMuc;
import com.example.sd18308.repository.DanhMucRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "DanhMucServlet", value = {"/danh-muc/hien-thi",
        "/danh-muc/add",
})
public class DanhMucServlet extends HttpServlet {

    ArrayList<DanhMuc> list = new ArrayList<>();
    DanhMucRepository danhMucRepository = new DanhMucRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/danh-muc/hien-thi")) {
            this.hienThi(request, response);
        }
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        list = danhMucRepository.getList();
        request.setAttribute("list", list);
        request.getRequestDispatcher("/danh-muc/trang-chu.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/danh-muc/add")) {
            this.add(request, response);
        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma = request.getParameter("maDanhMuc");
        String ten = request.getParameter("tenDanhMuc");
        String trangThai = request.getParameter("trangThai");
        DanhMuc danhMuc = new DanhMuc();
        danhMuc.setMaDanhMuc(ma);
        danhMuc.setTenDanhMuc(ten);
        danhMuc.setTrangThai(trangThai);
        danhMuc.setNgayTao(new Date());
        danhMuc.setNgaySua(new Date());
        // goi sang repo
        danhMucRepository.add(danhMuc);
        response.sendRedirect("/danh-muc/hien-thi");
    }
}
