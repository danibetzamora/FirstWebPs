<%-- 
    Document   : Error
    Author     : Daniel BZ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="styles/style.css" rel="stylesheet" type="text/css">
        <title>Error</title>
    </head>
    <body bgcolor="lightpink">
        <div class="container">
            <h1>¡Error!</h1>
            <h3>No puedes realizar una compra con el carrito vacío...</h3>
            <br>
            <form action="index.jsp">
                <input type="submit" value="Volver al Catálogo" />
            </form>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
