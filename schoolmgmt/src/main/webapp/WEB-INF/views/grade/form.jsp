<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<!DOCTYPE html>
<html>
<head>
<tags:meta />
<title> Grade </title>
<tags:style />
</head>
<body>
	<tags:header />

	<form class="border border-light p-5" method="post" action="/grade">

		<div class="text-center">
			<p class="h4 mb-4"> Grade </p>
			<div class="btn-group btn-group-sm" role="group"
				aria-label="Basic example">
				<button type="button" class="btn btn-primary btn-sm">Validate</button>
				<button type="reset" class="btn btn-warning btn-sm">Reset</button>
				<button type="button" class="btn btn-danger btn-sm" onclick="postDataFromApi('/grade')">Save</button>		
				<input type="hidden" id="id" name="id" value="${grade.id }">	
					</div>
		</div>
		<br>
		<div class="row">
			<div class="col-md-4">
				<label for="textInput">  Grade </label> <input type="text"
					id="name" name="name" class="form-control mb-4" value="${grade.name }">
			</div>
			
		</div>
	</form>
	<tags:response/>
	<tags:footer />
	<tags:script />
	<tags:formscript/>
</body>
</html>