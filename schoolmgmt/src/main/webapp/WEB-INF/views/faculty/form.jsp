<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<!DOCTYPE html>
<html>
<head>
<tags:meta />
<title> Faculty</title>
<tags:style />
</head>
<body>
	<tags:header />

	<form class="border border-light p-5" method="post" action="/faculty">

		<div class="text-center">
			<p class="h4 mb-4"> Faculty </p>
			<div class="btn-group btn-group-sm" role="group">
				<button type="button" class="btn btn-primary btn-sm">Validate</button>
				<button type="reset" class="btn btn-warning btn-sm">Reset</button>
				<button type="button" class="btn btn-danger btn-sm" onclick="postDataFromApi('/faculty')">Save</button>
					<input type="hidden" id="id" name="id" value="${faculty.id }">
			</div>
		</div>
		<br>
		<div class="row">
			<div class="col-md-4">
				<label for="textInput"> Name </label> <input type="text"
					id="name" name="name" class="form-control mb-4" value="${faculty.name }">
			</div>
			
		</div>
	</form>
	<tags:response/>
	<tags:footer />
	<tags:script />
		<tags:formscript/>
</body>
</html>