<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<tags:meta />
<title>Marks Entry </title>
<tags:style />
</head>
<body   class="fixed-sn">
	<tags:header />

	<form class="border border-light p-5" method="post" action="/marksentry">

		<div class="text-center">
			<p class="h4 mb-4"> Marks Entry  </p>
			<div class="btn-group btn-group-sm" role="group">
				<button type="button" class="btn btn-primary btn-sm">Validate</button>
				<button type="reset" class="btn btn-warning btn-sm">Reset</button>
				<button type="button" class="btn btn-success btn-sm" id="submitbtn">Save</button>
				<input type="hidden" name="id" id="id" value="${marksentry.id }">
			</div>
		</div>
		<br>
		<div class="row">
			<div class="col-md-4">
				<select class="mdb-select md-form" id="academicdatesid"
					name="academicdates.id">
					<option value="" disabled selected>Select Academic Date</option>
					<c:forEach items="${academicdates }" var="b">
						<option value="${b.id }" <c:if test="${marksentry.academicdates.id eq b.id }">selected</c:if>>${b.academicdate }(${b.academicdateen })</option>
					</c:forEach>
					</select>
			</div>
			<div class="col-md-4">
				<select class="mdb-select md-form" id="gradeid" name="grade.id">
					<option value="" disabled selected>Select Grade </option>
					<c:forEach items="${garde }" var="b">
						<option value="${b.id }" <c:if test="${marksentry.grade.id eq b.id }">selected</c:if>>${b.name }</option>  
					</c:forEach>
					</select>
			</div>
			<div class="col-md-4">
				<select class="mdb-select md-form" id="sectionid" name="section.id">
					<option value="" disabled selected>Select Section </option>
					<c:forEach items="${section }" var="b">
						<option value="${b.id }" <c:if test="${marksentry.section.id eq b.id }">selected</c:if>>${b.name }</option>  
					</c:forEach>
					</select>
			</div>
			
			
			</div>			
	</form>
	<tags:response/>
	<tags:footer />
	<tags:script />
	<script>
		$("#submitbtn").click(function() {
			var data = {
				academicdates : {
					id : parseInt($("#academicdatesid").val())
				},
				garde : {
					id : parseInt($("#gradeid").val())
				},
				section : {
					id : parseInt($("#sectionid").val())
				}
			};
			postJsonDataFromApi('/marksentry', data);
		});
	</script>
	<tags:formscript/>
</body>
</html>