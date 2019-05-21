<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<!DOCTYPE html>
<html>
<head>
<tags:meta />
<title> Student </title>
<tags:style />
</head>
<body>
	<tags:header />

	<form class="border border-light p-5" method="post" action="/company">

		<div class="text-center">
			<p class="h4 mb-4"> Student </p>
			<div class="btn-group btn-group-sm" role="group"
				aria-label="Basic example">
				<button type="button" class="btn btn-primary btn-sm">Validate</button>
				<button type="reset" class="btn btn-warning btn-sm">Reset</button>
				<button type="submit" class="btn btn-danger btn-sm">Save</button>
			</div>
		</div>
		<br>
		<div class="row">
			<div class="col-md-4">
				<label for="textInput"> Admission Date</label> <input type="text" 
				id=" admission_datenp"  name=" admission_datenp" class="form-control mb-4">
			</div>
			<div class="col-md-4">
				<label for="textInput"> Birth Certificate Number </label> <input type="text"
					id=" birth_certificate_no" name=" birth_certificate_no" class="form-control mb-4">
			</div>
			<div class="col-md-4">
				<label for="textInput"> District </label> <input type="text"
					id="district" name="district" class="form-control mb-4">
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				<label for="textInput">Date of Birth (English)</label> <input type="text"
					id=" dob_english" name=" dob_english" class="form-control mb-4">
			</div>
			<div class="col-md-4">
				<label for="textInput">Date of Birth (Nepali)</label> <input type="text"
					id="dob_nepali" name="dob_nepali" class="form-control mb-4">
			</div>
			<div class="col-md-4">
				<label for="textInput"> Gender</label> <input type="text"
					id="gender" name="gender" class="form-control mb-4">
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				<label for="textInput">Hobby</label> <input type="text"
					id=" hobby" name=" hobby" class="form-control mb-4">
			</div>
			<div class="col-md-4">
				<label for="textInput">PDate of Birth (Nepali)</label> <input type="text"
					id="issued_by" name="dob_nepali" class="form-control mb-4">
			</div>
			<div class="col-md-4">
				<label for="textInput"> Gender</label> <input type="text"
					id="gender" name="gender" class="form-control mb-4">
			</div>
		</div>
	</form>
	<tags:response/>
	<tags:footer />
	<tags:script />
	
</body>
</html>