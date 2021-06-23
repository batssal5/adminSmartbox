<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    response.setHeader("Pragma","no-cache");
    response.setHeader("Cache-Control","no-cache");
    response.addHeader("Cache-Control","no-store");
    response.setDateHeader("Expires",0);
%>
<!DOCTYPE html>
<html lang="en">
<head>
</head>
<body>

<h1>Spring Boot - Upload Status</h1>

<div >
    <h2 >${message}</h2>
</div>

</body>
</html>