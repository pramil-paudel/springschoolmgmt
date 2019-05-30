<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<!DOCTYPE html>
<html>
<head>
<tags:meta />
<title> General Details </title>
<tags:style />
</head>
<body>
	<tags:header />

	<form class="border border-light p-5" method="post" action="/generaldetails">

		<div class="text-center">
			<p class="h4 mb-4"> General Details </p>
			<div class="btn-group btn-group-sm" role="group">
				<button type="button" class="btn btn-primary btn-sm">Validate</button>
				<button type="reset" class="btn btn-warning btn-sm">Reset</button>
				<button type="button" class="btn btn-danger btn-sm" onclick="postDataFromApi('/generaldetails')">Save</button>
			</div>
		</div>
		<br>
		<div class="row">
			<div class="col-md-4">
				<label for="textInput">Address </label> <input type="text" 
				id="address" name="address"  class="form-control mb-4">
			</div>
			<div class="col-md-4">
				<label for="textInput"> School code</label> <input type="text"
					id="code" name="code" class="form-control mb-4">
			</div>
			<div class="col-md-4">
				<label for="textInput">Email </label> <input type="text"
					id="email" name="email" class="form-control mb-4">
			</div>
			</div>
			<div class="row">
			<div class="col-md-4">
				<label for="textInput"> Name </label> <input type="text"
					id="name" name="name" class="form-control mb-4">
			</div>
			<div class="col-md-4">
				<label for="textInput"> Phone Number </label> <input type="text"
					id="phone" name="phone" class="form-control mb-4">
			</div>
			<div class="col-md-4">
				<label for="textInput"> Title </label> <input type="text"
					id="title" name="title" class="form-control mb-4">
			</div>
			</div>
			<div class="row">
			<div class="col-md-4">
				<label for="textInput"> Academic Dates ID </label> <input type="text"
					id="academicdates_id" name="academicdates_id" class="form-control mb-4">
			</div>
			</div>
			
	</form>
	<tags:response/>
	<tags:footer />
	<tags:script />
	<tags:formscript/>
</body>
</html>