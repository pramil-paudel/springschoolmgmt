<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<tags:meta />
<title>Exam</title>
<tags:style />
</head>
<body class="fixed-sn ">
	<tags:header />

	<form class="border border-light p-5">

		<div class="text-center">
			<p class="h4 mb-4">Exam</p>
			<div class="btn-group btn-group-sm" role="group"
				aria-label="Basic example">
				<button type="button" class="btn btn-primary btn-sm">Validate</button>
				<button type="reset" class="btn btn-warning btn-sm">Reset</button>
				<button type="button" class="btn btn-danger btn-sm" id="submitbtn">Save</button>
				<input type="hidden" id="id" name="id" value="${exam.id }">
			</div>
		</div>
		<br>
		<div class="row">
			<div class="col-md-4">
				<select class="mdb-select md-form" id="academicdatesid"
					name="academicdates.id">
					<option value="" disabled selected>Select Academic Date</option>
					<c:forEach items="${academicdates }" var="b">
						<option value="${b.id }" <c:if test="${exam.academicdates.id eq b.id }">selected</c:if>>${b.academicdate }(${b.academicdateen })</option>
					</c:forEach>

				</select>
			</div>
			<div class="col-md-4">
				<label for="textInput"> Code</label> <input type="text" id="code"
					name="code" class="form-control mb-4" value="${exam.code }">
			</div>
			<div class="col-md-4">
				<label for="textInput">Name </label> <input type="text" id="name"
					name="name" class="form-control mb-4" value="${exam.name }">
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				<label for="textInput"> Start Date </label> <input type="text"
					id="startdate" name="startdate" class="form-control mb-4"
					value="${exam.startdate }">
			</div>
			<div class="col-md-4">
				<label for="textInput"> Start Date English </label> <input
					type="text" id="startdateen" name="startdateen"
					class="form-control mb-4" value="${exam.startdateen }">
			</div>
			<div class="col-md-4">
				<select class="mdb-select md-form" id="examtypesid">
					<option value="" disabled selected>Select Exam Type</option>
					<c:forEach items="${examtypes }" var="b">
						<option value="${b.id }" <c:if test="${exam.examtype.id eq b.id }">selected</c:if>>${b.name }</option>  
					</c:forEach>

				</select>
			</div>
		</div>


	</form>
	<tags:response />
	<tags:footer />
	<tags:script />
	<script>
		$("#submitbtn").click(function() {
			var data = {
				id : $("#id").val(),
				code : $("#code").val(),
				name : $("#name").val(),
				startdate : $("#startdate").val(),
				startdateen : $("#startdateen").val(),
				academicdates : {
					id : parseInt($("#academicdatesid").val())
				},
				examtype : {
					id : parseInt($("#examtypesid").val())
				}
			};
			postJsonDataFromApi('/exam', data);
		});
	</script>
	<tags:formscript />
</body>
</html>