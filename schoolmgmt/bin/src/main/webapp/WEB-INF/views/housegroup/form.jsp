<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<!DOCTYPE html>
<html>
<head>
<tags:meta />
<title> House Group </title>
<tags:style />
</head>
<body class="fixed-sn ">
	<tags:header />

	<form class="border border-light p-5" method="post" action="/housegroup">

		<div class="text-center">
			<p class="h4 mb-4"> House Group </p>
			<div class="btn-group btn-group-sm" role="group"
				aria-label="Basic example">
				<button type="button" class="btn btn-primary btn-sm">Validate</button>
				<button type="reset" class="btn btn-warning btn-sm">Reset</button>
					<button type="button" class="btn btn-danger btn-sm" onclick="postDataFromApi('/housegroup')">Save</button>
						<input type="hidden" id="id" name="id" value="${housegroup.id}">
			</div>
		</div>
		<br>
		<div class="row">
			<div class="col-md-4">
				<label for="textInput"> House Group Name </label> <input type="text"
					id="name" name="name" class="form-control mb-4" value="${housegroup.name}">
			</div>
			
		</div>
	</form>
	<tags:response/>
	<tags:footer />
	<tags:script />
	<tags:formscript/>
</body>
</html>