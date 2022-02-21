<%-- 
    Document   : VistaCompra
    Author     : Daniel BZ
--%>

<%@page import="model.CarritoCompra"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Purchase</title>
        <link href="styles/styleTitle.css" rel="stylesheet" type="text/css">
    </head>
    <body bgcolor="paleturquoise">
        <h1>Resultado de la Compra</h1>
        <b>¡Muchas gracias por su compra!</b>
        <p>El importe total es: <b><%= request.getAttribute("precioTotal")%> €</b></p>
        <form action="index.jsp">
            <input type="submit" value="Volver al Catálogo" />
        </form>
    </body>
</html>
