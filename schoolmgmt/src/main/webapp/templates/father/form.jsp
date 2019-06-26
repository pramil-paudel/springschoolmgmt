<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<!DOCTYPE html>
<html>
<head>
<tags:meta />
<title> Father </title>
<tags:style />
</head>
<body  class="fixed-sn">
	<tags:header />

	<form class="border border-light p-5" >

		<div class="text-center">
			<p class="h4 mb-4"> Father </p>
			<div class="btn-group btn-group-sm" role="group">
				<button type="button" class="btn btn-primary btn-sm">Validate</button>
				<button type="reset" class="btn btn-warning btn-sm">Reset</button>
				<button type="button" class="btn btn-danger btn-sm" onclick="postDataFromApi('${pageContext.request.contextPath}/father')">Save</button>
				<input type="hidden" name="id" id="id" value="${father.id }">
			</div>
		</div>
		<br>
		<div class="row">
			<div class="col-md-4">
				<label for="textInput">Full Name </label> <input type="text" 
				id="fullName" name="fullname"  class="form-control mb-4"  value="${father.fullname}">
			</div>
			<div class="col-md-4">
				<label for="textInput"> Address </label> <input type="text"
					id="address" name="address" class="form-control mb-4"  value="${father.address}">
			</div>
			<div class="col-md-4">
				<label for="textInput">E-mail </label> <input type="text"
					id="email" name="email" class="form-control mb-4"   value="${father.email}" >
			</div>
			</div>
			<div class="row">
			<div class="col-md-4">
				<label for="textInput"> E-phone </label> <input type="text"
					id="ePhone" name="ephone" class="form-control mb-4"  value="${father.ephone}">
			</div>
			<div class="col-md-4">
				<label for="textInput"> Office </label> <input type="text"
					id="office" name="office" class="form-control mb-4" value="${father.office}">
			</div>
			<div class="col-md-4">
				<label for="textInput">  Income </label> <input type="text"
					id="income" name="income" class="form-control mb-4" value="${father.income}">
			</div>
			</div>
			<div class="row">
			<div class="col-md-4">
				<label for="textInput"> Position </label> <input type="text"
					id="position" name="position" class="form-control mb-4" value="${father.position}">
			</div>
			</div>
			
	</form>
	<tags:response/>
	<tags:footer />
	<tags:script />
	
	<tags:formscript/>
</body>
</html>