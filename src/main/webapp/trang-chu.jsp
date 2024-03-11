<%--
  Created by IntelliJ IDEA.
  User: nguyenvv
  Date: 08/03/2024
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body class="container">
<h1>Day la trang chu</h1>
<h1>Ma sinh vien: ${sinhVien.maSv}</h1>
<h1>Ho ten sinh vien: ${sinhVien.getTenSv()}</h1>


<table class="table">
    <thead>
    <tr>
        <td>STT</td>
        <td>Ma sinh vien</td>
        <td>Ho ten</td>
        <td>Dia chi</td>
        <td>Tuoi</td>
        <td>Chuc nang</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listSinhVien}" var="sinhVien" varStatus="i">
        <tr>
            <td>${i.index}</td>
            <td>${sinhVien.maSv}</td>
            <td>${sinhVien.tenSv}</td>
            <td>${sinhVien.diaChi}</td>
            <td>${sinhVien.tuoi}</td>
            <td><button class="btn btn-info">Detail</button></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
