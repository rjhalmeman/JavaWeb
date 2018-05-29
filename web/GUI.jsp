<%-- 
    Document   : index
    Created on : 12/02/2017, 18:11:10
    Author     : radames
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>Cálculo do IMC</div>
        <form name="Envia" action="Calcular" method="POST">  
            <br>
            <label> Peso </label> 
            <input type="text" name="peso" value="0" size="10" />
            <br>
            <label> Altura </label>  <input type="text" name="altura" value="0" size="10" /> <br>
            <input type="submit" value="Enviar" name="enviar" />

        </form> 
    </body>
</html>
