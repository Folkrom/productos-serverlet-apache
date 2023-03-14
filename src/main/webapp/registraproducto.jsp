<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<H1>Registra producto</H1>

<form action="producto" method="post">
<p>
	NombreProducto: <input type="text" name="nombre" id="nombre">
</p>
<p>
	Descripcion: <input type="text" name="descripcion" id="descripcion">
</p>
<p>
	Cantidad: <input type="number" name="cantidad" id="cantidad">
</p>
<p>
	Precio: <input type="number" name="precio" id="precio">
</p>
	<input type="submit" value="Regristra Producto" >
</form>

</head>
<body>

</body>
</html>