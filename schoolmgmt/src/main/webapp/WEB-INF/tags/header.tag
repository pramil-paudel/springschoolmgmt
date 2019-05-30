<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
 
  <title>ADBL DMS-PEEPALSOFT</title>

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
      <a href="#"><img src=""
          class="rounded-circle"><span style="color:white">Welcome, User</span></a>
    </div>
  </li>
  <!--/. Logo -->
  <!-- Side navigation links -->
  <li>
    <ul class="collapsible collapsible-accordion">
        <li><a id="toggle" class="waves-effect" href="login-user.do">DASHBOARD</a>
        </li>
    
       <!--STUDENT-->
      <li class="nav-item ">
          <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#student">STUDENT</a>
          <div class="collapse" id="student" aria-expanded="false">
              <ul class="flex-column pl-2 nav">
                  <li class="nav-item"><a class="nav-link py-0" href="">New Member</a></li>
                  <li class="nav-item"><a class="nav-link py-0" href="">List Members</a></li>
              </ul>
          </div>
      </li>
      <!--./STUDENT-->
       <!--EMPLOYEE-->
      <li class="nav-item ">
          <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#employee">EMPLOYEE</a>
          <div class="collapse" id="employee" aria-expanded="false">
              <ul class="flex-column pl-2 nav">
              
                  <li class="nav-item"><a class="nav-link py-0" href="<c:url value="/employee/new"/>"> New Employee</a></li>
                  <li class="nav-item"><a class="nav-link py-0" href="<c:url value="/employee"/>">List Employee</a></li>
              </ul>
          </div>
      </li>
      <!--./EMPLOYEE-->
       <!--ACADEMIC DATES-->
      <li class="nav-item ">
          <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#academicdates">ACADEMIC DATES</a>
          <div class="collapse" id="academicdates" aria-expanded="false">
              <ul class="flex-column pl-2 nav">
              
                 <li class="nav-item"><a class="nav-link py-0" href="<c:url value="/academicdates/new"/>"> New Academic Dates</a></li>
                  <li class="nav-item"><a class="nav-link py-0" href="<c:url value="/academicdates"/>">List Academic Dates</a></li>
              </ul>
          </div>
      </li>
      <!--./ACADEMIC DATES-->
       <!--BRANCH-->
      <li class="nav-item ">
          <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#branch"> BRANCH </a>
          <div class="collapse" id="branch" aria-expanded="false">
              <ul class="flex-column pl-2 nav">
              
                 <li class="nav-item"><a class="nav-link py-0" href="<c:url value="/branch/new"/>"> New Branch </a></li>
                  <li class="nav-item"><a class="nav-link py-0" href="<c:url value="/branch"/>">List Branch </a></li>
              </ul>
          </div>
      </li>
      <!--./ BRANCH-->
         <!--COMPANY -->
      <li class="nav-item ">
          <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#company"> COMPANY</a>
          <div class="collapse" id="company" aria-expanded="false">
              <ul class="flex-column pl-2 nav">
              
                 <li class="nav-item"><a class="nav-link py-0" href="<c:url value="/company/new"/>"> New Company</a></li>
                  <li class="nav-item"><a class="nav-link py-0" href="<c:url value="/company"/>">List Company </a></li>
              </ul>
          </div>
      </li>
      <!--./COMPANY -->
      <!--DIFFERENTLY ABLE -->
      <li class="nav-item ">
          <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#differentlyable"> DIFFERENTLY ABLE</a>
          <div class="collapse" id="differentlyable" aria-expanded="false">
              <ul class="flex-column pl-2 nav">
              
                 <li class="nav-item"><a class="nav-link py-0" href="<c:url value="/differentlyable/new"/>"> New Differently Able</a></li>
                  <li class="nav-item"><a class="nav-link py-0" href="<c:url value="/differentlyable"/>">List Differently Able </a></li>
              </ul>
          </div>
      </li>
      <!--./DIFFERENTLY ABLE -->
   <!--ETHNIC GROUP -->
      <li class="nav-item ">
          <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#ethnicgroup"> ETHNIC GROUP</a>
          <div class="collapse" id="ethnicgroup" aria-expanded="false">
              <ul class="flex-column pl-2 nav">
              
                 <li class="nav-item"><a class="nav-link py-0" href="<c:url value="/ethnicgroup/new"/>"> New Ethnic Group</a></li>
                  <li class="nav-item"><a class="nav-link py-0" href="<c:url value="/ethnicgroup"/>">List Ethnic Group </a></li>
              </ul>
          </div>
      </li>
      <!--./ETHNIC GROUP -->
      <!--EXAM -->
      <li class="nav-item ">
          <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#exam"> EXAM</a>
          <div class="collapse" id="exam" aria-expanded="false">
              <ul class="flex-column pl-2 nav">
              
                 <li class="nav-item"><a class="nav-link py-0" href="<c:url value="/exam/new"/>"> New Exam </a></li>
                  <li class="nav-item"><a class="nav-link py-0" href="<c:url value="/exam"/>">List Exam  </a></li>
              </ul>
          </div>
      </li>
      <!--./EXAM  -->
            <!--EXAM TYPE-->
      <li class="nav-item ">
          <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#examtype"> EXAM TYPE</a>
          <div class="collapse" id="examtype" aria-expanded="false">
              <ul class="flex-column pl-2 nav">
              
                 <li class="nav-item"><a class="nav-link py-0" href="<c:url value="/examtype/new"/>"> New Exam Type </a></li>
                  <li class="nav-item"><a class="nav-link py-0" href="<c:url value="/examtype"/>">List Exam Type </a></li>
              </ul>
          </div>
      </li>
      <!--./EXAM TYPE -->
      <!--FACULTY-->
      <li class="nav-item ">
          <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#faculty"> FACULTY </a>
          <div class="collapse" id="faculty" aria-expanded="false">
              <ul class="flex-column pl-2 nav">
              
                 <li class="nav-item"><a class="nav-link py-0" href="<c:url value="/faculty/new"/>"> New Faculty  </a></li>
                  <li class="nav-item"><a class="nav-link py-0" href="<c:url value="/faculty"/>">List Faculty  </a></li>
              </ul>
          </div>
      </li>
      <!--./FACULTY -->
      <!--GENERAL DETAILS-->
      <li class="nav-item ">
          <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#generaldetails"> GENERAL DETAILS </a>
          <div class="collapse" id="generaldetails" aria-expanded="false">
              <ul class="flex-column pl-2 nav">
              
                 <li class="nav-item"><a class="nav-link py-0" href="<c:url value="/generaldetails/new"/>"> New General Details  </a></li>
                  <li class="nav-item"><a class="nav-link py-0" href="<c:url value="/generaldetails"/>">List General Details  </a></li>
              </ul>
          </div>
      </li>
      <!--./GENERAL DETAILS -->
       <!--GRADE-->
      <li class="nav-item ">
          <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#grade"> GRADE </a>
          <div class="collapse" id="grade" aria-expanded="false">
              <ul class="flex-column pl-2 nav">
              
                 <li class="nav-item"><a class="nav-link py-0" href="<c:url value="/grade/new"/>"> New Grade   </a></li>
                  <li class="nav-item"><a class="nav-link py-0" href="<c:url value="/grade"/>">List Grade   </a></li>
              </ul>
          </div>
      </li>
      <!--./GRADE  -->
       <!--HOUSE GROUP-->
      <li class="nav-item ">
          <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#housegroup"> HOUSE GROUP </a>
          <div class="collapse" id="housegroup" aria-expanded="false">
              <ul class="flex-column pl-2 nav">
              
                 <li class="nav-item"><a class="nav-link py-0" href="<c:url value="/housegroup/new"/>"> New House Group   </a></li>
                  <li class="nav-item"><a class="nav-link py-0" href="<c:url value="/housegroup"/>">List House Group   </a></li>
              </ul>
          </div>
      </li>
      <!--./HOUSE GROUP  -->
      <!--MOTHER LANGUAGE-->
      <li class="nav-item ">
          <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#motherlanguage"> MOTHER LANGUAGE </a>
          <div class="collapse" id="motherlanguage" aria-expanded="false">
              <ul class="flex-column pl-2 nav">
              
                 <li class="nav-item"><a class="nav-link py-0" href="<c:url value="/motherlanguage/new"/>"> New Mother Language   </a></li>
                  <li class="nav-item"><a class="nav-link py-0" href="<c:url value="/motherlanguage"/>">List Mother Language   </a></li>
              </ul>
          </div>
      </li>
      <!--./MOTHER LANGUAGE  -->
       <!--SECTION-->
      <li class="nav-item ">
          <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#section"> SECTION </a>
          <div class="collapse" id="section" aria-expanded="false">
              <ul class="flex-column pl-2 nav">
              
                 <li class="nav-item"><a class="nav-link py-0" href="<c:url value="/section/new"/>"> New  Section   </a></li>
                  <li class="nav-item"><a class="nav-link py-0" href="<c:url value="/section"/>">List Section    </a></li>
              </ul>
          </div>
      </li>
      <!--./SECTION  -->
      <!--SUBJECTS-->
      <li class="nav-item ">
          <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#subjects"> SUBJECTS </a>
          <div class="collapse" id="subjects" aria-expanded="false">
              <ul class="flex-column pl-2 nav">
              
                 <li class="nav-item"><a class="nav-link py-0" href="<c:url value="/subjects/new"/>"> New  Subjects   </a></li>
                  <li class="nav-item"><a class="nav-link py-0" href="<c:url value="/subjects"/>">List Subjects    </a></li>
              </ul>
          </div>
      </li>
      <!--./SUBJECTS  -->
       <!--USER-->
      <li class="nav-item ">
          <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#user"> USER </a>
          <div class="collapse" id="user" aria-expanded="false">
              <ul class="flex-column pl-2 nav">
              
                 <li class="nav-item"><a class="nav-link py-0" href="<c:url value="/user/new"/>"> New  User   </a></li>
                  <li class="nav-item"><a class="nav-link py-0" href="<c:url value="/user"/>">List User    </a></li>
              </ul>
          </div>
      </li>
      <!--./USER  -->
      
    
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