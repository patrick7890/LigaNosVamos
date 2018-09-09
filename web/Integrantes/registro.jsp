<%-- 
    Document   : registro
    Created on : 01-09-2018, 19:49:16
    Author     : Lennon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Integrantes</title>
    </head>
    <body>
        <jsp:include page="../Menus/menu_Usuario.jsp"></jsp:include>
        
        
        <!--inicio del contenido-->
        <div class="container">
            <div class="row justify-content-md-center">
                <div class="col-sm-6">
                    <form action="" method="GET">
                        <div class="card" style="">
                            <div class="card-body">
                                <h1 class="text-center">Registro De Itengrantes</h1>
                                <hr>
                                <div class="form-group">
                                    <label>Rut: </label>
                                    <input type="text" name="txtRut" placeholder="Ej:xx.xxx.xxx-x" minlength="6" class="form-control"/>
                                </div>
                                <div class="form-group">
                                    <label>Nombre: </label>
                                    <input type="text" name="txtNombre" placeholder="Ej:Juan" minlength="4" class="form-control"/>
                                </div>

                                <div class="form-group">
                                    <label>Nick: </label>
                                    <input type="text" name="txtNick" placeholder="Ej:X_X" minlength="4" class="form-control"/>
                                </div>
                                <div class="form-group ">
                                    <label>Ingrese la Imagen de Jugador </label>
                                    <input class="btn btn-default" type="file" name="selec" value=""  />
                                </div>
                                <div class="form-group ">
                                    <button class="btn btn-primary" type="submit"  name="btnAccion" ><i class="far fa-fw fa-save"></i>Registar</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!--fin del contenido-->
    </body>
</html>
