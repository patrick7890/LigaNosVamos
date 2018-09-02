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
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="Menus/menu.jsp"></jsp:include>



            <div class="form-group">


            <jsp:useBean id="li" class="DAO.DAOLiga" scope="page" ></jsp:useBean>

            <c:set  var="lista"  value="${li.listarTodo()}"/>

                <div class="row">

            <c:forEach var="list" items="${lista}">




                    <div class=" col-12 col-sm-12 col-md-6 col-xl-2 mt-2 " style="height: 100px" >
                        <a href="http://www.dota2.com/international/overview/">
                            <div class="thumbnail group group-thumbnail-108"  style="height: 100px" >
                                <style>
                                    
                                    
                                    .group-thumbnail-108{
                                        opacity: 0.5;
                                        background-size: 100%;
                                        background-image: url('Recursos/img/Dota.PNG');
                                    }
                                </style>
                                <div class="thumbnail-title">
                                    <h4 class="text-truncate" title="Last Heaven Fansub" ><c:out value="${list.getNombreLiga()}"/></h4>
                                </div>
                                <span class="followers"><i class="fas fa-users fa-fw"></i><span><c:out value="${list.getFechaInicio()}"/></span></span>
                                <span class="book-type badge badge-scanlation" >${list.getFechaInicio()}</span>
                            </div>
                        </a>
                    </div>





            </c:forEach>

                </div>

        </div>








    </body>
</html>
