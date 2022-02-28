<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx">
    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Anime Template">
        <meta name="keywords" content="Anime, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>${pageTitle}</title>

        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css2?family=Oswald:wght@300;400;500;600;700&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Mulish:wght@300;400;500;600;700;800;900&display=swap"
              rel="stylesheet">

        <!-- Css Styles -->
        <link rel="stylesheet" href="css/bootstrap.min.css" >
        <link rel="stylesheet" href="css/font-awesome.min.css" >
        <link rel="stylesheet" href="css/elegant-icons.css" >
        <link rel="stylesheet" href="css/plyr.css" >
        <link rel="stylesheet" href="css/nice-select.css">
        <link rel="stylesheet" href="css/owl.carousel.min.css" >
        <link rel="stylesheet" href="css/slicknav.min.css" >
        <link rel="stylesheet" href="css/style.css" >
        <link rel="stylesheet" href="css/pc-style.css" >
        <link rel="shortcut icon" type="image/png" href="img/potato.png" />

        <c:if test="${not empty adminCSSFiles}">
            <link rel="stylesheet" href="css/admin/${adminCSSFiles}" >
        </c:if>
    </head>

    <body>

        <!-- Page Preloder -->
        <div id="preloder">
            <div class="loader"></div>
        </div>

        <header class="header">
            <div class="container">
                <div class="row">
                    <div class="col-lg-2">
                        <div class="header__logo" style="padding: 5px 0;">
                            <a href="home">
                                <img src="img/logoPotato.png" alt="">
                            </a>
                        </div>
                    </div>
                    <div class="col-lg-8">
                        <div class="header__nav">
                            <nav class="header__menu mobile-menu">
                                <ul>
                                    <li><a>Type<span class="arrow_carrot-down"></span></a>
                                        <ul class="dropdown" style="overflow: auto; height: 300px ; width: 200px">                                      
                                            <c:forEach items="${listType}" var="o" >
                                                <li><a href="DoFilterControll?filter=Type&id=${o.idType}">${o.typeName}</a></li>                                                                                                                                
                                                </c:forEach> 
                                        </ul>
                                    </li>
                                    <li><a>Director<span class="arrow_carrot-down"></span></a>

                                        <ul class="dropdown" style="overflow: auto; height: 300px; width: 200px">  
                                            <c:forEach items="${listDirector}" var="o" >
                                                <li><a href="DoFilterControll?filter=Director&id=${o.idDirector}">${o.nameDirector}</a></li> 
                                                </c:forEach>
                                        </ul>

                                    </li>
                                    <li><a>Distributor<span class="arrow_carrot-down"></span></a>
                                        <ul class="dropdown" style="overflow: auto; height: 300px ; width: 200px">                                      
                                            <c:forEach items="${listDistributor}" var="o" >
                                                <li><a href="DoFilterControll?filter=Distributor&id=${o.idDistributor}">${o.nameDistributor}</a></li>                                                                                                                                
                                                </c:forEach> 
                                        </ul>
                                    </li>
                                    <c:if test="${sessionScope.User.isAdmin == false}">
                                        <li><a>Manager<span class="arrow_carrot-down"></span></a>
                                            <ul class="dropdown" style="width: 200px">
                                                <li><a href="profileload">Profile</a></li>
                                                <li><a href="changepasswordload">Change Password</a></li>
                                            </ul>
                                        </li> 
                                    </c:if>
                                    <c:if test="${sessionScope.User.isAdmin == true}"> 
                                        <li><a>Manager<span class="arrow_carrot-down"></span></a>
                                            <ul class="dropdown" style="width: 200px">
                                                <li><a href="managefilm">Quản lý Film</a></li>
                                                <li><a href="managefilmtype">Quản lý Thể loại</a></li>
                                                <li><a href="managedirector">Quản lý Đạo diễn</a></li>
                                                <li><a href="managedistributor">Quản lý Nhà sản xuất</a></li>
                                                <li><a href="manageuser">Quản lý User</a></li>
                                                <li><a href="profileload">Profile Admin</a></li>
                                                <li><a href="changepasswordload">Change Password</a></li>
                                            </ul>
                                        </li>
                                    </c:if>
                                    <c:if test="${sessionScope.User != null}">                                             
                                        <li><a>${sessionScope.User.getFullname()}</a></li> 
                                            </c:if>                          
                                </ul>
                            </nav>
                        </div>
                    </div>
                    <div class="col-lg-2">
                        <div class="header__right">
                            <a href="#" class="search-switch"><span class="icon_search"></span></a>
                                <c:if test="${sessionScope.User == null}">  
                                <a href="LoadLoginPage"><span class="icon_profile"></span></a>
                                </c:if>
                                <c:if test="${sessionScope.User != null}">                                             
                                <a href="LogoutControll"><img style="width: 35px;background: greenyellow;border-radius: 20px;" src="img/logoutlogo.png"></a>
                                </c:if>
                        </div>
                    </div>
                </div>

            </div>
        </header>
