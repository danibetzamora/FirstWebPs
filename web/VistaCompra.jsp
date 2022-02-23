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
        <link href="styles/style.css" rel="stylesheet" type="text/css">
        <title>Purchase</title>   
    </head>
    <body bgcolor="paleturquoise">
        <div class="container">
            <h1>Resultado de la Compra</h1>
            <b>¡Muchas gracias por su compra!</b>
            <p>El importe total es: <b><%= request.getAttribute("precioTotal")%> €</b></p>
            <form action="index.jsp">
                <input type="submit" value="Volver al Catálogo" />
            </form>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
