<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<tags:meta />
<title>Employee</title>
<tags:style />
</head>
<body class="fixed-sn ">
	<tags:header />
	<form class="border border-light p-5" method="post" action="/employee">

		<div class="text-center">
			<p class="h4 mb-4">Employee</p>
			<div class="btn-group btn-group-sm" role="group"
				aria-label="Basic example">
				<button type="button" class="btn btn-primary btn-sm">Validate</button>
				<button type="reset" class="btn btn-warning btn-sm">Reset</button>
		<button type="button" class="btn btn-danger btn-sm" id="submitbtn">Save</button>
		<input type="hidden" name="id" id="id" value="${employee.id }">
			</div>
		</div>
		<br>
		<div class="row">

			<div class="col-md-4">
				<label for="textInput"> Address </label> <input type="text"
					id="address" name="address" class="form-control mb-4" value="${employee.address }">
			</div>
			<div class="col-md-4">
				<label for="textInput">Employee Code</label> <input type="text"
					id="code" name="code" class="form-control mb-4" value="${employee.code }">
			</div>
			<div class="col-md-4">
				<select class="mdb-select md-form" id="branchid" name="branch.id">
					<option value="" disabled selected>Select Branch</option>
					<c:forEach items="${branches }" var="b">
						<option value="${b.id }" <c:if test="${employee.branch.id eq b.id }">selected</c:if>>${b.name } ${b.id }</option>
					</c:forEach>

				</select>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				<label for="textInput">Date Of Birth</label> <input type="text"
					id="dob" name="dob" class="form-control mb-4" value="${employee.dob }">
			</div>
			<div class="col-md-4">
				<label for="textInput"> E-mail</label> <input type="text" id="email"
					name="email" class="form-control mb-4" value="${employee.email }">
			</div>
			<div class="col-md-4">
				<label for="textInput"> Gender </label> <input type="text"
					id="gender" name="gender" class="form-control mb-4" value="${employee.gender }">
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				<label for="textInput">Join Date</label> <input type="text"
					id="joindate" name="joindate" class="form-control mb-4" value="${employee.joindate }">
			</div>
			<div class="col-md-4">
				<label for="textInput"> Name </label> <input type="text" id="name"
					name="name" class="form-control mb-4" value="${employee.name }">
			</div>
			<div class="col-md-4">
				<label for="textInput"> Status </label> <input type="text"
					id="status" name="status" class="form-control mb-4" value="${employee.status }">
			</div>
		</div>

	</form>
	<tags:response />
	<tags:footer />
	<tags:script />
	<script>
	$("#submitbtn").click(function(){
		var data = {
				id: $("#id").val(),
				address: $("#address").val(),
				code: $("#code").val(),
				dob: $("#dob").val(),
				email: $("#email").val(),
				gender: $("#gender").val(),
				joindate: $("#joindate").val(),
				name: $("#name").val(),
				status: $("#status").val(),
				gender: $("#gender").val(),
				branch:{
					id: parseInt($("#branchid").val())
				}
				};
		postJsonDataFromApi('/employee',data);
	});
	
	</script>
	<tags:formscript />
</body>
</html>