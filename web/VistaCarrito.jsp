<%-- 
    Document   : VistaCarrito
    Author     : Daniel BZ
--%>

<%@page import="model.CarritoCompra"%>
<%@page import="model.Producto"%>
<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart</title>
        <link href="styles/style.css" rel="stylesheet" type="text/css">
    </head>
    <body bgcolor="lavender">
        <h1>Carrito de la Compra</h1>
        <%
            CarritoCompra carrito = (CarritoCompra) session.getAttribute("CarritoCompra");
        
            if(carrito == null) {
                carrito = new CarritoCompra();
                session.setAttribute("CarritoCompra", carrito);
            }
        
            if(carrito.getCarrito().size() == 0) { 
        %>
            <h2>El carrito de la compra está vacío</h2>    
        <% } else { %>
            <table border="5" bgcolor="white"> 
                <tr>
                    <th>Imagen</th><th>Título</th><th>Autor</th>
                    <th>Cantidad</th><th>Precio</th><th>Eliminar</th>
                </tr>

                <% 
                    ArrayList<Producto> carritoLibros = carrito.getCarrito();
                    for(int i=0; i < carritoLibros.size(); i++) { 
                %>

                        <tr>
                            <td align="center"><img src="<%=carritoLibros.get(i).getImagen()%>" width="100" height="150"/></td>
                            <td align="center"><%=carritoLibros.get(i).getTitulo()%></td>
                            <td align="center"><%=carritoLibros.get(i).getAutor()%></td>
                            <td align="center"><%=carritoLibros.get(i).getCantidad()%></td>
                            <td align="center"><%= carritoLibros.get(i).getPrecio()%> €</td>
                            <td align="center">
                                <form action="RemoveCarrito">
                                    <input type="hidden" name="indiceProducto" value="<%=i%>" />
                                    <input type="submit" value="Eliminar" /> 
                                </form>
                            </td>
                        </tr>

                <%  }  %>
            </table>
        <%  }  %>

        <p><a href="/FirstWebPs/index.jsp">Seguir comprando</a></p>
        
        <form action="RealizarCompra">
            <input type="submit" value="Realizar Compra" name="realizarCompra" /> 
        </form>
    </body>
</html>
