<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<!DOCTYPE html>
<html>
<head>
<tags:meta />
<title> Section </title>
<tags:style />
</head>
<body class="fixed-sn ">
	<tags:header />

	<form class="border border-light p-5" >

		<div class="text-center">
			<p class="h4 mb-4"> Section </p>
			<div class="btn-group btn-group-sm" role="group"
				aria-label="Basic example">
				<button type="button" class="btn btn-primary btn-sm">Validate</button>
				<button type="reset" class="btn btn-warning btn-sm">Reset</button>
				<button type="button" class="btn btn-danger btn-sm" onclick="postDataFromApi('/section')">Save</button>	
				<input type="hidden" id="id" name="id" value="${section.id}">
							</div>
		</div>
		<br>
		<div class="row">
			<div class="col-md-4">
				<label for="textInput"> Section </label> <input type="text"
					id="name" name="name" class="form-control mb-4" value="${section.name}">
			</div>
			
		</div>
	</form>
	<tags:response/>
	<tags:footer />
	<tags:script />
	<tags:formscript/>
</body>
</html>