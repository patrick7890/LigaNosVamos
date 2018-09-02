<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : crearLiga
    Created on : 01-09-2018, 23:12:48
    Author     : Lennon
--%>

<%@page import="dto.TipoLiga"%>
<%@page import="java.util.List"%>
<%@page import="DAO.DAOLiga"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>


        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
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
                                    <label>Nombre De La Liga: </label>
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
                                <div class="form-group">
                                    <label>Tipo Liga: </label>

                                    <jsp:useBean id="li" class="DAO.DAOLiga" scope="page" ></jsp:useBean>
                                    <%
                                        List<TipoLiga> lista = li.ListarTipo();
                                    %>
                                    <select class="form-control" name="ddlTipo">

                                        <option>Elige Una Opcion</option>
                                       
                                        <c:forEach var="l" items="lista">
                                            <option value="" >l.getDescripcion</option>
                                        
                                        </c:forEach>
                                        
                                    </select>
                                </div>
                                <div class="form-group ">
                                    <button class="btn btn-primary" type="submit"  name="btnAccion" value="Registar"><i class="far fa-fw fa-save"></i>Registar</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="alert">
                ${mensaje}
            </div>
        </div>
        <!--fin del contenido-->






    </body>
</html>
