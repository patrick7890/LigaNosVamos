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
                                <span class="text-center" >${list.getFechaInicio()}</span>
                            </div>
                        </a>
                    </div>
                </c:forEach>
            </div>
        </div>
        <div class="row justify-content-md-center">
            <div class="container">
                <form method="GET" action="ProcesoUsuario">
                    <button type="submit" value="Listar" name="btnAccion" class="btn btn-success">Listar</button>
                </form>

                <table class="table table-hover">
                    <c:forEach var="list" items="${listaUsu}">
                        <tr>
                        <form method="GET" action="ProcesoUsuario">
                            <td>Nombre: <c:out value="${list.getNombreUsuario()}"/></td>
                            <td>Tipo: <c:out value="${list.getTipoUsuario().getDescripcion()}"/></td>
                            <td>Correo <c:out value="${list.getCorreoUsuario()}"/></td>
                            <input type="hidden" name="idUsu" value="${list.getIdUsuario()}"/>
                            <td><button type="submit" class="btn btn-danger" name="btnAccion" value="Eliminar">Eliminar</button></td>
                        </form>

                        </tr>
                    </c:forEach>
                </table>
                <table class="table table-hover">
                    <c:forEach var="list" items="${listaUsu}">
                        <tr>
                        <form method="GET" action="ProcesoUsuario">
                            <td>Nombre: <input type="text" class="form-control" name="txtUsuario" value="${list.getNombreUsuario()}"/></td>
                            <td>password: <input type="password" class="form-control" name="txtUsuario" value="${list.getPassUsuario()}"/></td>
                            <td>Tipo: <input type="text" class="form-control" name="txtUsuario" value="${list.getTipoUsuario().getDescripcion()}"/></td>
                            <td>Correo <input type="text" class="form-control" name="txtUsuario" value="${list.getCorreoUsuario()}"/></td>
                            <input type="hidden" name="idUsu" value="${list.getIdUsuario()}"/>
                            <td><button type="submit" class="btn btn-primary" name="btnAccion" value="Actualizar">Actualizar</button></td>
                        </form>

                        </tr>
                    </c:forEach>
                </table>

                <c:if test="${mensaje!=null}" >
                    ${mensaje}
                </c:if>
                <c:remove var="mensaje" />
            </div>
        </div>
    </body>
</html>
