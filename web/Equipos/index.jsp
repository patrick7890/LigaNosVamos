<%-- 
    Document   : index
    Created on : 08-09-2018, 14:40:41
    Author     : Patricio
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:choose>
            <c:when test="${sesUsu.getTipoUsuario().getIdTipoUsuario()>2}">
                <jsp:include page="../Menus/menu_Usuario.jsp"></jsp:include>
            </c:when>
            <c:when test="${sesUsu.getTipoUsuario().getIdTipoUsuario()<=2}">
                <jsp:include page="../Menus/menu_Admin.jsp"></jsp:include>
            </c:when>
        </c:choose>

        <div class="container">
            <jsp:useBean id="li" class="DAO.DAOEquipo" scope="page" ></jsp:useBean>
            <c:set  var="usu"  value="${sesUsu.getCorreoUsuario()}"/>
            <c:set  var="lista"  value="${li.listarEquipoUsuario(usu)}"/>
            <div class="row">
                <c:forEach var="list" items="${lista}">
                    <div class=" col-12 col-sm-12 col-md-6 col-xl-4 mt-2 " style="height: 100px" >

                        <div class="thumbnail group group-thumbnail"  style="height: 100px" >
                            <style>
                                .group-thumbnail{
                                    background-image: url('../Recursos/img/Dota.PNG');
                                    background-size: cover;
                                    width: 60%;
                                    height: 60%;
                                    content: "";
                                    position: absolute;
                                    background-position: 50%;
                                    z-index: 0;
                                }
                            </style>
                            <div class="thumbnail-title">
                                <a href="administar.jsp">    <h4 class="text-truncate" >${list.getNombreEquipo()}</h4></a>
                            </div>
                            <span>Liga actual 
                                <c:choose>
                                    <c:when test="${list.getLiga().getNombreLiga()!=null}">
                                        <a href="#"><c:out value="${list.getLiga().getNombreLiga()}"/></a>
                                    </c:when>
                                    <c:when test="${list.getLiga().getNombreLiga()==null}">
                                        <a href="#">Ninguna</a>
                                    </c:when>
                                </c:choose> 
                            </span>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </body>
</html>
