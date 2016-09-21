<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="UpdateData" method="POST">
		<input type="hidden" value="${id}" name="id">
		username : <br>
		<input type="text" name="username" value="${username}"><br>
		nama : <br>
		<input type="text" name="nama" value="${nama}"><br>
		alamat : <br>
		<input type="text" name="alamat" value="${alamat}"><br>
		<input type="submit" name="kirim" value="kirim">
		<input type="submit" name="batal" value="batal">
	</form>
</body>
</html>