<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="Productos" value="${requestScope['listaProductos']}"/>
	<table>
	<thead>
		<tr><td>Nombre</td><td>Descripcion</td><td>Cantidad</td><td>Precio</td></tr>
	</thead>

	<c:forEach items="${Productos}" var="p">
	<tr>
		<td><c:out value="${p.nombre}"></c:out></td>
		<td><c:out value="${p.descripcion}"></c:out></td>
		<td><c:out value="${p.cantidad}"></c:out></td>
		<td><c:out value="${p.precio}"></c:out></td>
	</tr>
	</c:forEach>
	</table>

</body>
</html>