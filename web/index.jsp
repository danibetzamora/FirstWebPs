<%-- 
    Document   : index
    Author     : Daniel BZ
--%>

<%@page import="model.CarritoCompra"%>
<%@page import="model.Catalogo"%>
<%@page import="model.Producto"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
        <head>
            <title>Catalogue</title>
            <link href="styles/style.css" rel="stylesheet" type="text/css">
        </head>
        <body bgcolor="paleturquoise">
            <div class="container">
                <center>
                    <jsp:include page = "header.jsp"/>
                    <%
                        Catalogo catalogo = Catalogo.getCatalogoInstance();
                        ArrayList<Producto> catalogoLibros = catalogo.getCatalogo();

                        CarritoCompra carrito = (CarritoCompra) session.getAttribute("CarritoCompra");

                        if(carrito == null) {
                            carrito = new CarritoCompra();
                            session.setAttribute("CarritoCompra", carrito);
                        }

                        int tamañoCarrito = 0;

                        for(Producto libro : carrito.getCarrito()) {
                            tamañoCarrito += libro.getCantidad();
                        }

                        if(tamañoCarrito == 0) { 
                    %>
                            <p><a href="/FirstWebPs/VistaCarrito.jsp">Ver carrito</a></p>
                    <%  } else {%>
                            <p><a href="/FirstWebPs/VistaCarrito.jsp">Ver carrito (<%=tamañoCarrito%>)</a></p>   
                    <%  }       %>

                    <table border="5" bgcolor="white" cellspacing="2">
                        <tr>
                            <th>Imagen Libro</th><th>Título</th><th>Autor</th>
                            <th>Páginas</th><th>Precio</th><th>Eliga Cantidad</th>
                        </tr>

                        <% for(Producto libro : catalogoLibros) { %>
                                <tr>
                                    <td align="center"><img src="<%=libro.getImagen()%>" width="100" height="150"/></td>
                                    <td align="center"><%=libro.getTitulo()%></td>
                                    <td align="center"><%=libro.getAutor()%></td>
                                    <td align="center"><%=libro.getPaginas()%></td>
                                    <td align="center"><%=libro.getPrecio()%> €</td>
                                    <td align="center">
                                        <form action="AddCarrito">
                                            <input type="hidden" name="imagenLibro" value="<%= libro.getImagen()%>" />
                                            <input type="hidden" name="tituloLibro" value="<%=libro.getTitulo()%>" />
                                            <input type="hidden" name="autorLibro" value="<%=libro.getAutor()%>" />
                                            <input type="hidden" name="paginasLibro" value="<%= libro.getPaginas()%>" />
                                            <input type="hidden" name="precioLibro" value="<%= libro.getPrecio()%>" />
                                                <select name="cantidadLibro">
                                                    <option value="1">1</option>
                                                    <option value="2">2</option>
                                                    <option value="3">3</option>
                                                    <option value="4">4</option>
                                                    <option value="5">5</option>
                                                </select>    
                                            <input type="submit" value="Añadir Producto" />
                                        </form>
                                    </td>
                                </tr>
                        <%  }  %>
                    </table>
                </center>
            </div>
            <jsp:include page="footer.jsp"/>
        </body>
    </center>               
</html>
