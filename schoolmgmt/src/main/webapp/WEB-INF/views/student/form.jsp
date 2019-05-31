<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
<tags:meta />
<title> Student </title>
<tags:style />
</head>
<body class="fixed-sn ">
	<tags:header />

	<form class="border border-light p-5" method="post"
		action="/students">

		<div class="text-center">
			<p class="h4 mb-4"> Student</p>
			<div class="btn-group btn-group-sm" role="group">
				<button type="button" class="btn btn-primary btn-sm">Validate</button>
				<button type="reset" class="btn btn-warning btn-sm">Reset</button>
				<button type="button" class="btn btn-danger btn-sm" id="submitbtn">Save</button>
				<input type="hidden" id="id" name="id" value="${student.id }">

			</div>
		</div>
		<br>
		<div class="row">
			<div class="col-md-4">
				<label for="textInput">Legacy ID </label> <input type="text"
					id="legacyId" name="legacyId" class="form-control mb-4"
					value="${student.legacyId}">
			</div>
			<div class="col-md-4">
				<label for="textInput"> Name </label> <input type="text"
					id="name" name="name" class="form-control mb-4"
					value="${student.name}">
			</div>
			<div class="col-md-4">
				<label for="textInput">Email </label> <input type="text" id="email"
					name="email" class="form-control mb-4"
					value="${student.email}">
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				<label for="textInput"> Date of Birth Nepali </label> <input type="text" id="dobNepali"
					name="dobNepali" class="form-control mb-4"
					value="${student.dobNepali}">
			</div>
			<div class="col-md-4">
				<label for="textInput"> Date of Birth English </label> <input type="text"
					id="dobEnglish" name="dobEnglish" class="form-control mb-4"
					value="${student.dobEnglish}">
			</div>
			<div class="col-md-4">
				<label for="textInput"> District  </label> <input type="text" id="district"
					name="district" class="form-control mb-4"
					value="${student.district}">
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				<label for="textInput"> Roll No. </label> <input type="text" id="rollNo"
					name="rollNo" class="form-control mb-4"
					value="${student.rollNo}">
			</div>
			<div class="col-md-4">
				<label for="textInput"> Municipality </label> <input type="text"
					id="municipality" name="municipality" class="form-control mb-4"
					value="${student.municipality}">
			</div>
			<div class="col-md-4">
				<label for="textInput"> Religion  </label> <input type="text" id="religion"
					name="religion" class="form-control mb-4"
					value="${student.religion}">
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				<label for="textInput"> Temporary Address </label> <input type="text" id="temporaryAddress"
					name="temporaryAddress" class="form-control mb-4"
					value="${student.temporaryAddress}">
			</div>
			<div class="col-md-4">
				<label for="textInput"> Ward No </label> <input type="text"
					id="wardNo" name="wardNo" class="form-control mb-4"
					value="${student.wardNo}">
			</div>
			<div class="col-md-4">
				<label for="textInput"> Old school  </label> <input type="text" id="oldSchool"
					name="oldSchool" class="form-control mb-4"
					value="${student.oldSchool}">
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				<label for="textInput"> Reason of Leave </label> <input type="text" id="reasonLeave"
					name="reasonLeave" class="form-control mb-4"
					value="${student.reasonLeave}">
			</div>
			<div class="col-md-4">
				<label for="textInput"> Admission Date Nepali </label> <input type="text"
					id="admissionDatenp" name="admissionDatenp" class="form-control mb-4"
					value="${student.admissionDatenp}">
			</div>
			<div class="col-md-4">
				<label for="textInput"> Birth Certificate Number  </label> <input type="text" id="birthCertificate_no"
					name="birthCertificate_no" class="form-control mb-4"
					value="${student.birthCertificate_no}">
			</div>
		</div>
		<div class="row">
		<div class="col-md-4">
				<label for="textInput"> Issued By </label> <input type="text" id="issuedBy"
					name="issuedBy" class="form-control mb-4"
					value="${student.issuedBy}">
			</div>
		<div class="col-md-4">
				<select class="mdb-select md-form" id="fatherid">
					<option value="" disabled selected>Select Father </option>
					<c:forEach items="${father }" var="b">
						<option value="${b.id }" <c:if test="${student.father.id eq b.id }">selected</c:if>>${b.name }</option>  
					</c:forEach>
					</select>
			</div>		
			<div class="col-md-4">
				<select class="mdb-select md-form" id="motherid">
					<option value="" disabled selected>Select Mother </option>
					<c:forEach items="${mother }" var="b">
						<option value="${b.id }" <c:if test="${student.mother.id eq b.id }">selected</c:if>>${b.name }</option>  
					</c:forEach>
					</select>
			</div>		
			</div>
			<div class="row">
				<div class="col-md-4">
				<select class="mdb-select md-form" id="localguardainid">
					<option value="" disabled selected>Select Local Guardian </option>
					<c:forEach items="${localguardain}" var="b">
						<option value="${b.id }" <c:if test="${student.localguardain.id eq b.id }">selected</c:if>>${b.name }</option>  
					</c:forEach>
					</select>
			</div>		
			<div class="col-md-4">
				<select class="mdb-select md-form" id="motherLanguageid">
					<option value="" disabled selected>Select Mother Language </option>
					<c:forEach items="${motherLanguage }" var="b">
						<option value="${b.id }" <c:if test="${student.motherLanguage.id eq b.id }">selected</c:if>>${b.name }</option>  
					</c:forEach>
					</select>
			</div>		
			</div>

	</form>
	<tags:response />
	<tags:footer />
	<tags:script />
	<script>
	$("#submitbtn").click(function(){
		var data = {
				id: $("#id").val(),
				legacyId: $("#legacyId").val(),
				name: $("name").val(),
				email: $("email").val(),
				dobNepali: $("dobNepali").val,
				dobEnglish: $("dobEnglish").val(),
				rollNo: $("rollNo").val(),
				municipality: $("municipality").val(),
				temporaryAddress: $("temporaryAddress").val(),
				wardNo: $("wardNo").val(),
				oldSchool: $("oldSchool").val(),
				reasonLeave: $("reasonLeave").val(),
				admissionDatenp: $("admissionDatenp").val(),
				birthCertificate_no: $("birthCertificate_no").val(),
				issuedBy: $("issuedBy").val(),
				father: {
					id: $("#fatherid").val()}
		mother: {
			id: $("#motherid").val()}
		localguardain: {
			id: $("#localguardainid").val()}
		motherlanguage: {
			id: $("#motherlanguageid").val()}

			};
		postJsonDataFromApi('/student',data);
	});
	
	</script>
	<tags:formscript />
</body>
</html>