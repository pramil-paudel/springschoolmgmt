<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta http-equiv="x-ua-compatible" content="ie=edge">
  <title>ADBL DMS-PEEPALSOFT</title>
<!-- Font Awesome -->
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
  <!-- Bootstrap core CSS -->
  <link href="/webjars/mdbootstrap-bootstrap-material-design/4.5.3/css/bootstrap.min.css" rel="stylesheet">
  <!-- Material Design Bootstrap -->
  <link href="/css/mdb.min.css" rel="stylesheet">
  <!-- Your custom styles (optional) -->
  <link href="/webjars/mdbootstrap-bootstrap-material-design/4.5.3/css/style.css" rel="stylesheet">
  <style>
  
.nav-link[data-toggle].collapsed:after {
    content: " >>";
}
.nav-link[data-toggle]:not(.collapsed):after {
    content: " <<";
}
  </style>
  </head>

<body class="fixed-sn">

 <!--Main Navigation-->
<header>
<!-- Sidebar navigation -->
<div id="slide-out" class="side-nav fixed custom-scrollbar " >
<ul class="rgba-blue-grey-strong custom-scrollbar ">
  <!-- Logo -->
  <li>
    <div class="logo-wrapper sn-ad-avatar-wrapper">
      <a href="#"><img src="http://124.41.193.91/projectdatas/araniko/images/logo.jpg"
          class="rounded-circle"><span style="color:white">Welcome, Sahakari</span></a>
    </div>
  </li>
  <!--/. Logo -->
  <!-- Side navigation links -->
  <li>
    <ul class="collapsible collapsible-accordion">
        <li><a id="toggle" class="waves-effect" href="login-user.do">DASHBOARD</a>
        </li>
      <!--MEMBER-->
      <li class="nav-item ">
          <a class="nav-link collapsed" href="#member" data-toggle="collapse" data-target="#member">MEMBER</a>
          <div class="collapse" id="member" aria-expanded="false">
              <ul class="flex-column pl-2 nav">
              
                  <li class="nav-item"><a class="nav-link py-0" href="<c:url value="/customers"/>">New Member</a></li>
                  <li class="nav-item"><a class="nav-link py-0" href="<c:url value="/customers"/>">List Members</a></li>
                  <li class="nav-item"><a class="nav-link py-0" href="<c:url value="/customers/search"/>">Search Member</a></li>
                  <li class="nav-item"><a class="nav-link py-0" href="#">Authorize Member</a></li>
              </ul>
          </div>
      </li>
      <!--./MEMBER-->
    </ul>
  </li>
  <!--/. Side navigation links -->
</ul>
<div class="sidenav-bg  rgba-blue-grey-strong"></div>
</div>
<!--/. Sidebar navigation -->

<!--Navbar-->
<nav class="navbar fixed-top navbar-expand-md primary-color lighten-2 double-nav scrolling-navbar top-nav-collapse">
  <!-- SideNav slide-out button -->
  <div class="float-left">
      <a href="#" data-activates="slide-out" class="button-collapse"><i
        class="fas fa-bars"></i></a>
  </div>
  <ul class="nav navbar-nav nav-flex-icons ml-auto">
      <a type="button" class="btn btn-info btn-rounded btn-sm">Log Out <i class="fas fa-sign-in-alt ml-2"></i></a>
      </ul>
</nav>
<!--/.Navbar-->
</header>
<!--Main Navigation-->
<!--Main layout-->
<main>