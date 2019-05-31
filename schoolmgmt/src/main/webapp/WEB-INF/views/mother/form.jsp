<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<!DOCTYPE html>
<html>
<head>
<tags:meta />
<title> Mother </title>
<tags:style />
</head>
<body   class="fixed-sn">
	<tags:header />

	<form class="border border-light p-5" method="post" action="/mother">

		<div class="text-center">
			<p class="h4 mb-4"> Mother </p>
			<div class="btn-group btn-group-sm" role="group">
				<button type="button" class="btn btn-primary btn-sm">Validate</button>
				<button type="reset" class="btn btn-warning btn-sm">Reset</button>
				<button type="button" class="btn btn-danger btn-sm" onclick="postDataFromApi('/mother')">Save</button>
			</div>
		</div>
		<br>
		<div class="row">
			<div class="col-md-4">
				<label for="textInput">Full Name </label> <input type="text" 
				id="fullName" name="fullName"  class="form-control mb-4">
			</div>
			<div class="col-md-4">
				<label for="textInput"> Address </label> <input type="text"
					id="address" name="address" class="form-control mb-4">
			</div>
			<div class="col-md-4">
				<label for="textInput">E-mail </label> <input type="text"
					id="email" name="email" class="form-control mb-4">
			</div>
			</div>
			<div class="row">
			<div class="col-md-4">
				<label for="textInput"> Telephone </label> <input type="text"
					id="telephone" name="telephone" class="form-control mb-4">
			</div>
			<div class="col-md-4">
				<label for="textInput"> Mobile </label> <input type="text"
					id="mobile" name="mobile" class="form-control mb-4">
			</div>
			<div class="col-md-4">
				<label for="textInput"> E-phone </label> <input type="text"
					id="ePhone" name="ePhone" class="form-control mb-4">
			</div>
			
			
			</div>
			<div class="row">
			<div class="col-md-4">
				<label for="textInput"> Office </label> <input type="text"
					id="office" name="office" class="form-control mb-4">
			</div>
			<div class="col-md-4">
				<label for="textInput">  Income </label> <input type="text"
					id="income" name="income" class="form-control mb-4">
			</div>
			
			<div class="col-md-4">
				<label for="textInput"> Position </label> <input type="text"
					id="position" name="position" class="form-control mb-4">
			</div>
			</div>			
	</form>
	<tags:response/>
	<tags:footer />
	<tags:script />
	<tags:formscript/>
</body>
</html>