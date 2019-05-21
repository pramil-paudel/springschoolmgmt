<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<tags:meta />
<title>Employee</title>
<tags:style />
</head>
<body>
	<tags:header />

	<form class="border border-light p-5" method="post" action="/employee">

		<div class="text-center">
			<p class="h4 mb-4">Employee</p>
			<div class="btn-group btn-group-sm" role="group"
				aria-label="Basic example">
				<button type="button" class="btn btn-primary btn-sm">Validate</button>
				<button type="reset" class="btn btn-warning btn-sm">Reset</button>
				<button type="button" class="btn btn-danger btn-sm" id="submitbtn">Save</button>
			</div>
		</div>
		<br>
		<div class="row">

			<div class="col-md-4">
				<label for="textInput"> Address </label> <input type="text"
					id="address" name="address" class="form-control mb-4">
			</div>
			<div class="col-md-4">
				<label for="textInput">Employee Code</label> <input type="text"
					id="code" name="code" class="form-control mb-4">
			</div>
			<div class="col-md-4">
				<select class="mdb-select md-form" id="branch">
					<option value="" disabled selected>Select Branch</option>
					<c:forEach items="${branches }" var="b">
						<option value="${b.id }">${b.name }</option>
					</c:forEach>

				</select>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				<label for="textInput">Date Of Birth</label> <input type="text"
					id="dob" name="dob" class="form-control mb-4">
			</div>
			<div class="col-md-4">
				<label for="textInput"> E-mail</label> <input type="text" id="email"
					name="email" class="form-control mb-4">
			</div>
			<div class="col-md-4">
				<label for="textInput"> Gender </label> <input type="text"
					id="gender" name="gender" class="form-control mb-4">
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				<label for="textInput">Join Date</label> <input type="text"
					id="joindate" name="joindate" class="form-control mb-4">
			</div>
			<div class="col-md-4">
				<label for="textInput"> Name </label> <input type="text" id="name"
					name="name" class="form-control mb-4">
			</div>
			<div class="col-md-4">
				<label for="textInput"> Status </label> <input type="text"
					id="status" name="status" class="form-control mb-4">
			</div>
		</div>

	</form>
	<tags:response />
	<tags:footer />
	<tags:script />
	<script>
	$("#submitbtn").click(function(){
		var data = {
				address: $("#addres").val(),
				code: $("#code").val(),
				dob: $("#dob").val(),
				email: $("#email").val(),
				gender: $("#gender").val(),
				joindate: $("#joindate").val(),
				name: $("#name").val(),
				status: $("#status").val(),
				gender: $("gender").val(),
				branch:{
					id: parseInt($("#branch").val())
				}
				};
		postJsonDataFromApi('/employee',data);
	});
	
	</script>
	<tags:formscript />
</body>
</html>