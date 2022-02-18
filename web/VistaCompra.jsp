<%-- 
    Document   : VistaCompra
    Created on : 18 feb. 2022, 0:25:00
    Author     : Usuario
--%>

<%@page import="model.CarritoCompra"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Purchase</title>
    </head>
    <body>
        <% HttpSession sessionFinal = request.getSession();
        
        CarritoCompra carrito = (CarritoCompra) sessionFinal.getAttribute("CarritoCompra");
        
        if(carrito == null) {
            
            carrito = new CarritoCompra();
            session.setAttribute("CarritoCompra", carrito);
            
        }
            carrito.getCarrito().clear();
            sessionFinal.setAttribute("CarritoCompra", carrito);
        %>
        <h1>Resultado de la Compra</h1>
        <p>¡Muchas gracias por su compra!</p>
        <p>El importe total es: <b><%= request.getAttribute("precioTotal")%></b></p>
        <form action="index.jsp">
            <input type="submit" value="Volver al Catálogo" />
        </form>
    </body>
</html>
