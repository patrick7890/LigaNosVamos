<%-- 
    Document   : menu
    Created on : 01-09-2018, 20:41:19
    Author     : Lennon
--%>

<script src="/LigaNosVamos/Recursos/js/jquery-3.2.0.min.js" type="text/javascript"></script>
<script src="/LigaNosVamos/Recursos/js/bootstrap.min.js" type="text/javascript"></script>
<link href="/LigaNosVamos/Recursos/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="/LigaNosVamos/Recursos/fontawesome/css/all.min.css" rel="stylesheet" type="text/css"/>



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
                <a class="nav-link" href="/LigaNosVamos/Usuario/registro.jsp">registro</a>
            </li>
            <li class="nav-item" >

                <a class="nav-link" href="/LigaNosVamos/Login.jsp" style="float: right"><i class="fas fa-sign-in-alt"></i>  login</a>
            </li>

        </ul>
    </div> 
</nav>
