<%--
  Created by IntelliJ IDEA.
  User: nguyenvv
  Date: 08/03/2024
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Day la trang chu</h1>
<h1>Ma sinh vien: ${sinhVien.maSv}</h1>
<h1>Ho ten sinh vien: ${sinhVien.getTenSv()}</h1>
<c:forEach items="${listSinhVien}" var="sinhVien" varStatus="i">
    <p>${i.index}</p>
    <p>${sinhVien.tenSv}</p>
</c:forEach>
</body>
</html>
