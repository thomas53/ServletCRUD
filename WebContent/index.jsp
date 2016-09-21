<%@page import="com.DAO.DaoUser"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.data.DataUser"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="SimpanData" method="POST">
		Username :<br>
		<input type="text" name="username"><br>
		Nama :<br>
		<input type="text" name="nama"><br>
		Alamat :<br>
		<input type="text" name="alamat"><br>
		<input type="submit" value="kirim">
	</form>
	<table>
		<thead>
			<tr>
				<th>Username</th>
				<th>Nama</th>
				<th>Alamat</th>
				<th>Aksi</th>
			</tr>
		</thead>
		<tbody>
			<% 
				List<DataUser> users = new ArrayList<DataUser>();
				users = new DaoUser().getDataUser();
				
				for(DataUser user : users){
					out.print("<tr>");
					out.print("<td>"+user.getUsername() + "</td><td>" + user.getNama() + "</td><td>" + user.getAlamat()+"</td>");
					out.print("<td><a href='UpdateData?id="+user.getId()+"'>edit</a></td>");
					out.print("<td><a href='HapusData?id="+user.getId()+"'>delete</a></td>");
					out.print("</tr>");
				}
			%>
		</tbody>
	</table>
	
</body>
</html>