<%-- 
    Document   : error.jsp
    Created on : Apr 5, 2024, 12:01:50 AM
    Author     : vinio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
    <jsp:include page="head.jsp"></jsp:include>
    <body>
        <jsp:include page="navbar.jsp"></jsp:include>
        <div class="container">
            <h1 class="text-danger">Error.</h1>
            <h2 class="text-danger">${message}</h2>
            
            <a href="/Projeto_CalculaOnda" class="btn btn-danger mt-3">
                Voltar para a tela Inicial
            </a>
        </div>
    </body>
</html>
