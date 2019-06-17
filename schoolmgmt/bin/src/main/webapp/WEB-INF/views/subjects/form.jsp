<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<!DOCTYPE html>
<html>
<head>
<tags:meta />
<title> Subjects </title>
<tags:style />
</head>
<body class="fixed-sn ">
	<tags:header />

	<form class="border border-light p-5" method="post" action="/subjects">

		<div class="text-center">
			<p class="h4 mb-4"> Subjects </p>
			<div class="btn-group btn-group-sm" role="group"
				aria-label="Basic example">
				<button type="button" class="btn btn-primary btn-sm">Validate</button>
				<button type="reset" class="btn btn-warning btn-sm">Reset</button>
				<button type="button" class="btn btn-danger btn-sm" onclick="postDataFromApi('/subjects')">Save</button>
				<input type="hidden" id="id" name="id" value="${subjects.id}">	
			</div>
		</div>
		<br>
		<div class="row">
			<div class="col-md-4">
				<label for="textInput">Subject Code </label> <input type="text" 
				id="code" name="code"  class="form-control mb-4" value="${subjects.code}">
			</div>
			<div class="col-md-4">
				<label for="textInput"> Full marks Practical </label> <input type="text"
					id="fullmarks_pr" name="fullmarks_pr" class="form-control mb-4" value="${subjects.fullmarks_pr}">
			</div>
			<div class="col-md-4">
				<label for="textInput">Full marks Theory </label> <input type="text"
					id="fullmarks_th" name="fullmarks_th" class="form-control mb-4" value="${subjects.fullmarks_th}">
			</div>
			</div>
			<div class="row">
			<div class="col-md-4">
				<label for="textInput"> Name </label> <input type="text"
					id="name" name="name" class="form-control mb-4" value="${subjects.name}">
			</div>
			<div class="col-md-4">
				<label for="textInput"> Pass marks Practical  </label> <input type="text"
					id="passmarks_pr" name="passmarks_pr" class="form-control mb-4" value="${subjects.passmarks_pr}">
			</div>
			<div class="col-md-4">
				<label for="textInput"> Pass marks Theory  </label> <input type="text"
					id="passmarks_th" name="passmarks_th" class="form-control mb-4" value="${subjects.passmarks_th}">
			</div>
			</div>
			<div class="row">
			<div class="col-md-4">
				<label for="textInput"> Subject Type </label> <input type="text"
					id="subjecttype" name="subjecttype" class="form-control mb-4" value="${subjects.subjecttype}">
			</div>
			</div>
			
	</form>
	<tags:response/>
	<tags:footer />
	<tags:script />
		<tags:formscript/>
</body>
</html>