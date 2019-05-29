<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
<tags:meta />
<title> User </title>
<tags:style />
</head>
<body>
	<tags:header />

	<form class="border border-light p-5">

		<div class="text-center">
			<p class="h4 mb-4"> User </p>
			<div class="btn-group btn-group-sm" role="group"
				aria-label="Basic example">
				<button type="button" class="btn btn-primary btn-sm">Validate</button>
				<button type="reset" class="btn btn-warning btn-sm">Reset</button>
			<button type="button" class="btn btn-danger btn-sm" onclick="postDataFromApi('/user')">Save</button>	
					</div>
		</div>
		<br>
		<div class="row">
			<div class="col-md-4">
				<label for="textInput">User Name </label> <input type="text" 
				id="username" name="username"  class="form-control mb-4">
			</div>
			<div class="col-md-4">
				<label for="textInput"> Password </label> <input type="text"
					id="password" name="password" class="form-control mb-4">
			</div>
			<div class="col-md-4">
				 <select class="mdb-select md-form" id="employee">
  <option value="" disabled selected>Select Employee ID </option>
  <c:forEach items="${employees }" var="b">
   <option value="${b.id }">(${b.code }) ${b.name } </option>
  </c:forEach>
 
</select>
 

			</div>
			</div>
			
	</form>
	<tags:response/>
	<tags:footer />
	<tags:script />
	<script>
	$("#submitbtn").click(function(){
		var data = {
				username: $("#username").val(),
				password: $("#password").val(),
				employee:{
					id: parseInt($("#employee").val())
				}
			};
		postJsonDataFromApi('/user',data);
	});
	</script>
		<tags:formscript/>
</body>
</html>