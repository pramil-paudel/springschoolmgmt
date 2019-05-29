<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<tags:meta />
<title>New Branch</title>
<tags:style />
</head>
<body>
	<tags:header />

	<form class="border border-light p-5">

		<div class="text-center">
			<p class="h4 mb-4">Branch</p>
			<div class="btn-group btn-group-sm" role="group">
				<button type="button" class="btn btn-primary btn-sm">Validate</button>
				<button type="reset" class="btn btn-warning btn-sm">Reset</button>
				<!-- step 0 -->
				<button type="button" class="btn btn-danger btn-sm" id="submitbtn">Save</button>
				
				<!-- STEP 3 -->
				<input type="hidden" id="id" value="${branch.id }">
			</div>
		</div>
		<br>
		<div class="row">
			<div class="col-md-4">
				<select class="mdb-select md-form" id="company">
					<option disabled selected>Select Company</option>
					<c:forEach items="${companies }" var="b">
						<option value="${b.id }">${b.name }</option>
					</c:forEach>

				</select>
			</div>
			<div class="col-md-4">
			<!-- STEP 2 value="${branch.code}"-->
				<label for="textInput">Branch Code</label> <input type="text"
					id="code" name="code" class="form-control mb-4" value="${branch.code }">
			</div>
			<div class="col-md-4">
				<label for="textInput">Address</label> <input type="text"
					id="address" name="address" class="form-control mb-4" value="${branch.address }">
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				<label for="textInput">E-mail</label> <input type="text" id="email"
					name="email" class="form-control mb-4" value="${branch.email }">
			</div>
			<div class="col-md-4">
				<label for="textInput">Name</label> <input type="text" id="name"
					name="name" class="form-control mb-4" value="${branch.name }">
			</div>
			<div class="col-md-4">
				<label for="textInput">Phone</label> <input type="text" id="phone"
					name="phone" class="form-control mb-4" value="${branch.phone }">
			</div>
		</div>
	</form>
	<tags:response />
	<tags:footer />
	<tags:script />
	<script>
		$("#submitbtn").click(function() {
			var data = {
					//step 4
				id : $("#id").val(),
				address : $("#address").val(),
				code : $("#code").val(),
				email : $("#email").val(),
				name : $("#name").val(),
				phone : $("#phone").val(),
				/* company : {
					id : parseInt($("#company").val())
				}, */
			};
			postJsonDataFromApi('/branch', data);
		});
	</script>
	<tags:formscript />
</body>
</html>