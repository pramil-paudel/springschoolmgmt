<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<!DOCTYPE html>
<html>
<head>
<tags:meta/>
<title> Login Page </title>
<tags:style/>
</head>
<body class="fixed-sn ">

<main>
<!-- Default form login -->
<form class="text-center border border-light p-5">

  <p class="h4 mb-4">Sign in</p>

  <!-- Email -->
  <input type="email" id="defaultLoginFormEmail" class="form-control mb-4" placeholder="E-mail">

  <!-- Password -->
  <input type="password" id="defaultLoginFormPassword" class="form-control mb-4" placeholder="Password">

  <div class="d-flex justify-content-around">
    <div>
      <!-- Remember me -->
      <mdb-checkbox [default]="true">Remember me</mdb-checkbox>
    </div>
    <div>
      <!-- Forgot password -->
      <a href="">Forgot password?</a>
    </div>
  </div>

  <!-- Sign in button -->
  <button mdbBtn color="info" block="true" class="my-4" type="submit">Sign in</button>

  <!-- Register -->
  <p>Not a member?
    <a href="">Register</a>
  </p>

  <!-- Social login -->
  <p>or sign in with:</p>

  <a type="button" class="light-blue-text mx-2">
    <!-- <i class="fab fa-facebook-f"></i> -->
    <mdb-icon fab icon="facebook"></mdb-icon>
  </a>
  <a type="button" class="light-blue-text mx-2">
    <!-- <i class="fab fa-twitter"></i> -->
    <mdb-icon fab icon="twitter"></mdb-icon>
  </a>
  <a type="button" class="light-blue-text mx-2">
    <!-- <i class="fab fa-linkedin-in"></i> -->
    <mdb-icon fab icon="linkedin"></mdb-icon>
    
  </a>
  <a type="button" class="light-blue-text mx-2">
    <!-- <i class="fab fa-github"></i> -->
    <mdb-icon fab icon="heart"></mdb-icon>
  </a>

</form>
<!-- Default form login -->
<tags:footer/>
<tags:response/>
<tags:script/>

</body>
</html>