<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<!DOCTYPE html>
<html>
<head>
<tags:meta />
<title> Mother Language </title>
<tags:style />
</head>
<body>
	<tags:header />

	<form class="border border-light p-5" method="post" action="/motherlanguage">

		<div class="text-center">
			<p class="h4 mb-4"> Mother Language </p>
			<div class="btn-group btn-group-sm" role="group"
				aria-label="Basic example">
				<button type="button" class="btn btn-primary btn-sm">Validate</button>
				<button type="reset" class="btn btn-warning btn-sm">Reset</button>
					<button type="button" class="btn btn-danger btn-sm" onclick="postDataFromApi('/motherlanguage')">Save</button>	
					<input type="hidden" id="id" name="id" value="${motherLanguage.id}">	
						</div>
		</div>
		<br>
		<div class="row">
			<div class="col-md-4">
				<label for="textInput"> Mother Language Name </label> <input type="text"
					id="name" name="name" class="form-control mb-4" value="${motherLanguage.name}">
			</div>
			
		</div>
	</form>
	<tags:response/>
	<tags:footer />
	<tags:script />
	<tags:formscript/>
</body>
</html>