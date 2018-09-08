<%-- 
    Document   : listaEquipos
    Created on : 08-09-2018, 15:48:20
    Author     : Patricio
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript">
            var str = window.location.search;

            
        </script>
    </head>
    <body>

        <jsp:include page="../Menus/menu_Usuario.jsp"></jsp:include>
        <c:out value="${idLiga}"/>
        <jsp:useBean id="li" class="DAO.DAOEquipo" scope="page" ></jsp:useBean>
        <c:set  var="liga"  value="${li.listarEquipoLiga(1)}"/>
        <c:forEach var="l" items="${liga}">

        </c:forEach>
    </body>
</html>
