 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- Font Awesome -->
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
  <!-- Bootstrap core CSS -->
  <link href=" <spring:url value="/css/bootstrap.min.css"/>" rel="stylesheet">
  <!-- Material Design Bootstrap -->
  <link href=" <spring:url value="/css/mdb.min.css"/>" rel="stylesheet">
  <!-- Your custom styles (optional) -->
  <link href=" <spring:url value="/css/style.css"/>" rel="stylesheet">
 <!-- Data tables -->
  <link href=" <spring:url value="/css/addons/datatables.min.css"/>" rel="stylesheet">
  <style>
  
.side-nav .nav-link[data-toggle].collapsed:after {
    content: " >>";
}
.side-nav .nav-link[data-toggle]:not(.collapsed):after {
    content: " <<";
}
  </style>