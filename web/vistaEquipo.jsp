<%-- 
    Document   : vistaEquipo
    Created on : 10-09-2018, 18:34:05
    Author     : Lennon
--%>

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
                <jsp:include page="Menus/menu_Usuario.jsp"></jsp:include>
            </c:when>
            <c:when test="${sesUsu.getTipoUsuario().getIdTipoUsuario()<=2}">
                <jsp:include page="Menus/menu_Admin.jsp"></jsp:include>
            </c:when>
            <c:when test="${sesUsu==null}">
                <jsp:include page="Menus/menu.jsp"></jsp:include>
            </c:when>
        </c:choose>
        <div class="form-group" style="margin: 1%">
            <jsp:useBean id="li" class="DAO.DAOLiga" scope="page" ></jsp:useBean>
            <c:set  var="lista"  value="${li.listarTodo()}"/>
            <div class="row">
                <c:forEach var="list" items="${lista}">
                    <div class=" col-12 col-sm-12 col-md-6 col-xl-4 mt-2 " style="height: 100px" >
                        <form>
                            <a href="Ligas/listaEquipos.jsp?${list.getNombreLiga()}">
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
                                    <span class="">${list.getFechaTermino()}</span>
                                </div>
                            </a>
                        </form>
                    </div>
                </c:forEach>
            </div>
        </div>

        
        
        
    </body>
</html>
