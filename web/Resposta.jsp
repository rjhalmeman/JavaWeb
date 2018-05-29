<%-- 
    Document   : Resposta
    Created on : 12/02/2017, 17:33:20
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
        <h1>Resposta  - IMC Calculado</h1>
        <label> Peso = </label>
        <%=request.getAttribute("peso")%>
        <br>
        
        <label> Altura </label>
        <%=request.getAttribute("altura")%>
        <br>
        
        <label> IMC = </label>
        <%=request.getAttribute("imc")%>
        <br>
         <label> Situacao = </label>
        <%=request.getAttribute("situacao")%>
        <br>
        
        <br>
        <br>
         <form name="Envia" action="GUI.jsp" method="POST">
            <input type="submit" value="Voltar" name="enviar" />            
        </form> 
        
                
    </body>
</html>
