<%-- 
    Document   : index
    Created on : 17 feb. 2022, 11:40:56
    Author     : Daniel BZ
--%>

<%@page import="model.CarritoCompra"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="model.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Catalogo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Catalogue</title>
    </head>
    <body>
        <h1>¡Bienvenido al Carrito de la Compra!</h1>
        
        <h3>Catálogo</h3>
        
        <%Catalogo catalogo = new Catalogo();
          ArrayList<Producto> productos = catalogo.getCatalogo();
          CarritoCompra carrito = (CarritoCompra) session.getAttribute("CarritoCompra");
        
        if(carrito == null) {
            carrito = new CarritoCompra();
            session.setAttribute("CarritoCompra", carrito);
        }
        
        int tamañoCarrito = 0;
        
        for(Producto a : carrito.getCarrito()) {
            tamañoCarrito += a.getCantidad();
        }

        if(tamañoCarrito == 0) { %>
        <p><a href="/FirstWebPs/VistaCarrito.jsp">Ver carrito</a></p>
            
        <%} else {%>
        <p><a href="/FirstWebPs/VistaCarrito.jsp">Ver carrito (<%=tamañoCarrito%>)</a></p>   
            
        <%}%>
            
            <table border="3">
            <tr><th>Nombre</th><!--th>Cantidad</th--><th>Precio</th></tr>
        <% for(Producto a : productos){ 
               String addProductoURL = "/FirstWebPs/AddCarrito?"+
            "nombreProducto="+URLEncoder.encode(a.getNombreProducto())+
            "&cantidadProducto="+URLEncoder.encode(Integer.toString(a.getCantidad()))+
            "&precioProducto="+URLEncoder.encode(Double.toString(a.getPrecio()));
        %>
              <tr>
              <td><%=a.getNombreProducto()%></td>
              <!--input type="hidden" name="nombreProducto" value=<!--%=a.getNombreProducto()%> /-->
              <!--td><select name="cantidad">
                        <option value="0">0</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                    </select></td-->
              <td><%=a.getPrecio()%></td> 
              <!--input type="hidden" name="precioProducto" value=<!--%=a.getPrecio()%> /-->
              <td><form action="AddCarrito">
                      <input type="hidden" name="nombreProducto" value="<%=a.getNombreProducto()%>" />
                      <input type="hidden" name="precioProducto" value="<%= a.getPrecio()%>" />
                      <select name="cantidadProducto">
                          <option value="1">1</option>
                          <option value="2">2</option>
                          <option value="3">3</option>
                          <option value="4">4</option>
                          <option value="5">5</option>
                      </select>    
                      <input type="submit" value="Añadir Producto" />
                  </form></td>
              </tr>
          <% } %>
           
            </table>
    </body>
</html>
