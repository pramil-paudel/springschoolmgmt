<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<!DOCTYPE html>
<html>
<head>
<tags:meta />
<title> Local Guardian </title>
<tags:style />
</head>
<body   class="fixed-sn">
	<tags:header />

	<form class="border border-light p-5" >

		<div class="text-center">
			<p class="h4 mb-4"> Local Guardian </p>
			<div class="btn-group btn-group-sm" role="group">
				<button type="button" class="btn btn-primary btn-sm">Validate</button>
				<button type="reset" class="btn btn-warning btn-sm">Reset</button>
				<button type="button" class="btn btn-danger btn-sm" onclick="postDataFromApi('/localguardain')">Save</button>
			<input type="hidden" name="id" id="id" value="${localguardian.id }">
			</div>
		</div>
		<br>
		<div class="row">
			<div class="col-md-4">
				<label for="textInput"> Name </label> <input type="text" value="${loacalguardian.name }"
				id="name" name="name"  class="form-control mb-4">
			</div>
			<div class="col-md-4">
				<label for="textInput"> Address </label> <input type="text" value="${loacalguardian.address }"
					id="address" name="address" class="form-control mb-4">
			</div>
			<div class="col-md-4">
				<label for="textInput"> Phone </label> <input type="text" value="${loacalguardian.phone }"
					id="phone" name="phone" class="form-control mb-4">
			</div>
			</div>
			<div class="row">
						<div class="col-md-4">
				<label for="textInput"> Mobile </label> <input type="text" value="${loacalguardian.mobile }"
					id="mobile" name="mobile" class="form-control mb-4">
			</div>
			</div>			
	</form>
	<tags:response/>
	<tags:footer />
	<tags:script />
	<tags:formscript/>
</body>
</html>