<%-- 
    Document   : Index
    Created on : 01-09-2018, 19:11:58
    Author     : Patricio
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
    </head>
    <body>
        <jsp:include page="Menus/menu.jsp"></jsp:include>
            <div class="form-group">
            <jsp:useBean id="li" class="DAO.DAOLiga" scope="page" ></jsp:useBean>
            <c:set  var="lista"  value="${li.listarTodo()}"/>
            <div class="row">
                <c:forEach var="list" items="${lista}">
                    <div class=" col-12 col-sm-12 col-md-6 col-xl-4 mt-2 " style="height: 100px" >
                        <a href="http://www.dota2.com/international/overview/">
                            <div class="thumbnail group group-thumbnail"  style="height: 100px" >
                                <style>
                                    .group-thumbnail{
                                        background-image: url('Recursos/img/Dota.PNG');
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
                                    <h4 class="text-truncate" title="${list.getNombreLiga()}" ><c:out value="${list.getNombreLiga()}"/></h4>
                                </div>
                                <span class="">${list.getFechaInicio()}</span>
                                <span class="text-center" >${list.getFechaTermino()}</span>
                            </div>
                        </a>
                    </div>
                </c:forEach>
            </div>
        </div>
       
    </body>
</html>
