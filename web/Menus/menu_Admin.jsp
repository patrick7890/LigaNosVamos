<%-- 
    Document   : menu_Admin
    Created on : 01-09-2018, 20:27:46
    Author     : Lennon
--%>

<link href="/LigaNosVamos/Recursos/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="/LigaNosVamos/Recursos/fontawesome/css/all.min.css" rel="stylesheet" type="text/css"/>
<script src="/LigaNosVamos/Recursos/js/jquery-3.2.0.min.js" type="text/javascript"></script>
<script src="/LigaNosVamos/Recursos/js/bootstrap.min.js" type="text/javascript"></script>

<nav class="navbar navbar-expand-md bg-dark navbar-dark">
    <!-- Brand -->
    <a class="navbar-brand" href="/LigaNosVamos/Index.jsp">Home</a>
    <!-- Toggler/collapsibe Button -->
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>
    <!-- Navbar links -->
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <div class="btn-group">
                    <button class="btn btn-dark dropdown-toggle" type="busecondary droptton" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Usuarios
                    </button>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenuButton">
                        <a class="dropdown-item" href="/LigaNosVamos/Usuario/registro.jsp">Crear Usuario</a>
                        <a class="dropdown-item" href="/LigaNosVamos/Usuario/administrar.jsp">administar Usuario</a>
                    </div>
                </div>
            </li> 
            <li class="nav-item">
                <div class="btn-group">
                    <button class="btn btn-dark dropdown-toggle" type="busecondary droptton" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Equipos
                    </button>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenuButton">
                        <a class="dropdown-item" href="/LigaNosVamos/Ligas/crearLiga.jsp">Crear Liga</a>
                        <a class="dropdown-item" href="/LigaNosVamos/Ligas/administrar.jsp">administar Liga</a>
                    </div>
                </div>
            </li> 
            <li class="nav-item">
                <div class="btn-group">
                    <button class="btn btn-dark dropdown-toggle" type="busecondary droptton" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Ligas
                    </button>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenuButton">
                        <a class="dropdown-item" href="/LigaNosVamos/Ligas/crearLiga.jsp">Crear Liga</a>
                        <a class="dropdown-item" href="/LigaNosVamos/Ligas/administrar.jsp">administar Liga</a>
                    </div>
                </div>
            </li> 
            <li class="nav-item">
                <div class="btn-group">
                    <button class="btn btn-dark dropdown-toggle" type="busecondary droptton" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        ${sesUsu.getNombreUsuario()}
                    </button>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenuButton">
                        <form method="GET" action="/LigaNosVamos/ProcesoUsuario">
                            <button  type="submit" class="dropdown-item" name="btnAccion" value="Cerrar Sesion">Cerrar Sesion</button>
                        </form>
                    </div>
                </div>
            </li> 
        </ul>
    </div> 
</nav>
