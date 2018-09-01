<%-- 
    Document   : registro
    Created on : 01-09-2018, 19:11:14
    Author     : Patricio
--%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="../Recursos/fontawesome/css/all.min.css" rel="stylesheet" type="text/css"/>
        <link href="../Recursos/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <!--inicio del contenido-->
        <div class="container">
            <div class="row justify-content-md-center">
                <div class="col-sm-6">
                    <form action="" method="GET">
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
                                <div class="form-group ">
                                    <button class="btn btn-primary" type="submit"  name="btnAccion" ><i class="far fa-fw fa-save">Registar</i></button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <!--fin del contenido-->
    </body>
</html>
