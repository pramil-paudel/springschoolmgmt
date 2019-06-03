<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<tags:meta />
<title>New Branch</title>
<tags:style />
</head>
<body class="fixed-sn ">
	<tags:header />
	<form:form class="border border-light p-5" modelAttribute="branch">
		<div class="text-center">
			<p class="h4 mb-4">Branch</p>
			<div class="btn-group btn-group-sm" role="group">
				<button type="button" class="btn btn-primary btn-sm">Validate</button>
				<button type="reset" class="btn btn-warning btn-sm">Reset</button>
				<!-- step 0 -->
				<button type="button" class="btn btn-danger btn-sm" id="submitbtn">Save</button>

				<!-- STEP 3 -->
				<form:input type="hidden" id="id" path="id" value="" />
			</div>
		</div>
		<br>
		<div class="row">
			<div class="col-md-4">
				<form:select path="company.id" class="mdb-select md-form"
					id="companyid">
					<option disabled selected>Select Company</option>
					<form:options items="${companies}" itemValue="id" itemLabel="name" />
				</form:select>

			</div>
			<div class="col-md-4">
				<!-- STEP 2 value="${branch.code}"-->
				<label for="textInput">Branch Code</label>
				<form:input type="text" id="code" path="code"
					class="form-control mb-4" value="" />
			</div>
			<div class="col-md-4">
				<label for="textInput">Address</label>
				<form:input type="text" id="address" path="address"
					class="form-control mb-4" value="" />
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				<label for="textInput">E-mail</label>
				<form:input type="text" id="email" path="email"
					class="form-control mb-4" value="" />
			</div>
			<div class="col-md-4">
				<label for="textInput">Name</label>
				<form:input type="text" id="name" path="name"
					class="form-control mb-4" value="" />
			</div>
			<div class="col-md-4">
				<label for="textInput">Phone</label>
				<form:input type="text" id="phone" path="phone"
					class="form-control mb-4" value="" />
			</div>
		</div>
	</form:form>
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
				company : {
					id : parseInt($("#companyid").val())
				},
			};
			postJsonDataFromApi('/branch', data);
		});
	</script>
	<tags:formscript />
</body>
</html>