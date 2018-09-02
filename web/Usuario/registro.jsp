<%-- 
    Document   : registro
    Created on : 01-09-2018, 19:11:14
    Author     : Patricio
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="dto.TipoUsuario"%>
<%@page import="java.util.List"%>
<%@page import="DAO.DAOUsuario"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <style>
            body{
                background-image: url(../Recursos/img/bgRegistar.jpg); 
                background-size: cover;
            }
        </style>
    </head>
    <body>

        <jsp:include page="../Menus/menu.jsp"></jsp:include>

            <!--inicio del contenido-->
            <div class="container">
                <div class="row justify-content-md-center">
                    <div class="col-sm-6">
                        <form action="../ProcesoUsuario" method="GET">
                            <div class="card" style="">
                                <div class="card-body">
                                    <h1 class="text-center">Registro de Usuarios</h1>
                                    <hr>
                                    <div class="form-group">
                                        <label>Nombre: </label>
                                        <input type="text" name="txtNombre" placeholder="Ej:Juan" minlength="4" class="form-control"/>
                                    </div>
                                    <div class="form-group">
                                        <label>Correo: </label>
                                        <input type="email" name="txtCorreo" placeholder="example@example.com" class="form-control"/>
                                    </div>
                                    <div class="form-group">
                                        <label>Contraseña: </label>
                                        <input type="password" name="txtPass" placeholder="***********" minlength="4" class="form-control"/>
                                    </div>
                                <jsp:useBean id="dao" class="DAO.DAOUsuario" scope="page" ></jsp:useBean>

                                <c:set var="list" value="${dao.listarTipo()}"/>

                                <div class="form-group">
                                    <label>Tipo: </label>
                                    <select class="form-control" name="ddlTipo">
                                        <option value="0">Tipo de Usuario</option>
                                        <c:forEach var="li" items="${list}">
                                            <option value="${li.getIdTipoUsuario()}"><c:out value="${li.getDescripcion()}"/></option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="form-group text-center">
                                    <button class="btn btn-primary btn-lg " type="submit"  name="btnAccion" value="Registar"><i class="far fa-fw fa-save"></i>Registar</button>
                                </div>
                            </div>
                        </div>
                    </form>
                    <c:if test="${mensaje!=null}" >
                        ${mensaje}
                    </c:if>
                    <c:remove var="mensaje" />
                </div>
            </div>
        </div>
        <!--fin del contenido-->
    </body>
</html>
