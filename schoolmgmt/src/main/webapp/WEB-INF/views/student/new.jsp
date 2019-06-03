<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<tags:meta />
<title>Student</title>
<tags:style />
</head>
<body class="fixed-sn ">
	<tags:header />
	<!-- Classic tabs -->
	<div class="classic-tabs">

		<ul class="nav tabs-cyan" id="myClassicTab" role="tablist">
			<li class="nav-item"><a
				class="nav-link  waves-light active show" id="profile-tab-classic"
				data-toggle="tab" href="#student-classic" role="tab"
				aria-controls="profile-classic" aria-selected="true">STUDENT</a></li>
			<li class="nav-item"><a class="nav-link waves-light"
				id="follow-tab-classic" data-toggle="tab" href="#father-classic"
				role="tab" aria-controls="follow-classic" aria-selected="false">FATHER</a>
			</li>
			<li class="nav-item"><a class="nav-link waves-light"
				id="contact-tab-classic" data-toggle="tab" href="#mother-classic"
				role="tab" aria-controls="contact-classic" aria-selected="false">MOTHER</a>
			</li>
			<li class="nav-item"><a class="nav-link waves-light"
				id="awesome-tab-classic" data-toggle="tab"
				href="#localguardian-classic" role="tab"
				aria-controls="awesome-classic" aria-selected="false">LOCAL
					GUARDIAN</a></li>
		</ul>
		<form:form  modelAttribute="student">
			<div
				class="tab-content border-right border-bottom border-left rounded-bottom"
				id="myClassicTabContent">

				<div class="tab-pane fade active show" id="student-classic"
					role="tabpanel" aria-labelledby="profile-tab-classic">



					<div class="text-center">
						<p class="h4 mb-4">Student</p>
						<div class="btn-group btn-group-sm" role="group">
							<button type="button" class="btn btn-primary btn-sm">Validate</button>
							<button type="reset" class="btn btn-warning btn-sm">Reset</button>
							<button type="button" class="btn btn-danger btn-sm"
								onclick="f('/student')">Save</button>
							<form:input type="hidden" id="id" path="id" value="" />
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-md-4">
							<label for="textInput">Legacy ID </label>
							<form:input type="text" id="legacyId" path="legacyId"
								class="form-control mb-4" value="" />
						</div>
						<div class="col-md-4">
							<label for="textInput"> Name </label>
							<form:input type="text" id="name" path="name"
								class="form-control mb-4" value="" />
						</div>
						<div class="col-md-4">
							<label for="textInput">Gender </label>
							<form:input type="text" id="gender" path="gender"
								class="form-control mb-4" value="" />
						</div>
					</div>
					<div class="row">
						<div class="col-md-4">
							<label for="textInput"> Date of Birth Nepali </label>
							<form:input type="text" id="dobNepali" path="dobNepali"
								class="form-control mb-4" value="" />
						</div>
						<div class="col-md-4">
							<label for="textInput"> Date of Birth English </label>
							<form:input type="text" id="dobEnglish" path="dobEnglish"
								class="form-control mb-4" value="" />
						</div>
						<div class="col-md-4">
							<label for="textInput"> District </label>
							<form:input type="text" id="district" path="district"
								class="form-control mb-4" value="" />
						</div>
					</div>
					<div class="row">
						<div class="col-md-4">
							<label for="textInput"> Hobby </label>
							<form:input type="text" id="hobby" path="hobby"
								class="form-control mb-4" value="" />
						</div>

						<div class="col-md-4">
							<label for="textInput"> Roll No. </label>
							<form:input type="text" id="rollNo" path="rollNo"
								class="form-control mb-4" value="" />
						</div>
						<div class="col-md-4">
							<label for="textInput"> Municipality </label>
							<form:input type="text" id="municipality" path="municipality"
								class="form-control mb-4" value="" />
						</div>

					</div>
					<div class="row">
						<div class="col-md-4">
							<label for="textInput"> Religion </label>
							<form:input type="text" id="religion" path="religion"
								class="form-control mb-4" value="" />
						</div>
						<div class="col-md-4">
							<label for="textInput"> Temporary Address </label>
							<form:input type="text" id="temporaryAddress"
								path="temporaryAddress" class="form-control mb-4" value="" />
						</div>
						<div class="col-md-4">
							<label for="textInput"> Ward No </label>
							<form:input type="text" id="wardNo" path="wardNo"
								class="form-control mb-4" value="" />
						</div>
					</div>
					<div class="row">
						<div class="col-md-4">
							<label for="textInput"> Old school </label>
							<form:input type="text" id="oldSchool" path="oldSchool"
								class="form-control mb-4" value="" />
						</div>
						<div class="col-md-4">
							<label for="textInput"> Reason of Leave </label>
							<form:input type="text" id="reasonLeave" path="reasonLeave"
								class="form-control mb-4" value="" />
						</div>
						<div class="col-md-4">
							<label for="textInput"> Admission Date Nepali </label>
							<form:input type="text" id="admissionDatenp"
								path="admissionDatenp" class="form-control mb-4" value="" />
						</div>
					</div>
					<div class="row">
						<div class="col-md-4">
							<label for="textInput"> Birth Certificate Number </label>
							<form:input type="text" id="birthCertificateNo"
								path="birthCertificateNo" class="form-control mb-4" value="" />
						</div>
						<div class="col-md-4">
							<label for="textInput"> Issued By </label>
							<form:input type="text" id="issuedBy" path="issuedBy"
								class="form-control mb-4" value="" />
						</div>
					</div>

				</div>
				<div class="tab-pane fade" id="father-classic" role="tabpanel"
					aria-labelledby="follow-tab-classic">
					<div class="row">
						<div class="col-md-4">
							<label for="textInput">Full Name </label>
							<form:input type="text" id="fullName" path="father.fullname"
								class="form-control mb-4" value="${father.fullname}" />
						</div>
						<div class="col-md-4">
							<label for="textInput"> Address </label>
							<form:input type="text" id="address" path="address"
								class="form-control mb-4" value="${father.address}" />
						</div>
						<div class="col-md-4">
							<label for="textInput">E-mail </label>
							<form:input type="text" id="email" path="email"
								class="form-control mb-4" value="${father.email}" />
						</div>
					</div>
					<div class="row">
						<div class="col-md-4">
							<label for="textInput"> E-phone </label>
							<form:input type="text" id="ePhone" path="ephone"
								class="form-control mb-4" value="${father.ephone}" />
						</div>
						<div class="col-md-4">
							<label for="textInput"> Office </label>
							<form:input type="text" id="office" path="office"
								class="form-control mb-4" value="${father.office}" />
						</div>
						<div class="col-md-4">
							<label for="textInput"> Income </label>
							<form:input type="text" id="income" path="income"
								class="form-control mb-4" value="${father.income}" />
						</div>
					</div>
					<div class="row">
						<div class="col-md-4">
							<label for="textInput"> Position </label>
							<form:input type="text" id="position" path="position"
								class="form-control mb-4" value="${father.position}" />
						</div>
					</div>

				</div>

				<div class="tab-pane fade" id="mother-classic" role="tabpanel"
					aria-labelledby="contact-tab-classic">


					<div class="text-center">
						<p class="h4 mb-4">Mother</p>
						<form:input type="hidden" path="mother.id" id="motherid" value="" />
					</div>
					<br>
					<div class="row">
						<div class="col-md-4">
							<label for="textInput">Full Name </label>
							<form:input type="text" id="mother_fullname"
								path="mother.fullname" class="form-control mb-4"
								value="${mother.fullname}" />
						</div>
						<div class="col-md-4">
							<label for="textInput"> Address </label>
							<form:input type="text" id="mother_address" path="mother.address"
								class="form-control mb-4" value="${mother.address}" />
						</div>
						<div class="col-md-4">
							<label for="textInput">E-mail </label>
							<form:input type="text" id="mother_email" path="mother.email"
								class="form-control mb-4" value="${mother.email}" />
						</div>
					</div>
					<div class="row">
						<div class="col-md-4">
							<label for="textInput"> Telephone </label>
							<form:input type="text" id="mother_telephone"
								path="mother.telephone" class="form-control mb-4"
								value="${mother.telephone}" />
						</div>
						<div class="col-md-4">
							<label for="textInput"> Mobile </label>
							<form:input type="text" id="mother_mobile" path="mother.mobile"
								class="form-control mb-4" value="${mother.mobile}" />
						</div>
						<div class="col-md-4">
							<label for="textInput"> E-phone </label>
							<form:input type="text" id="mother_ephone" path="mother.ephone"
								class="form-control mb-4" value="${mother.ephone}" />
						</div>


					</div>
					<div class="row">
						<div class="col-md-4">
							<label for="textInput"> Office </label>
							<form:input type="text" id="office" path="office"
								class="form-control mb-4" value="${mother.office}" />
						</div>
						<div class="col-md-4">
							<label for="textInput"> Income </label>
							<form:input type="text" id="income" path="income"
								class="form-control mb-4" value="${mother.income}" />
						</div>

						<div class="col-md-4">
							<label for="textInput"> Position </label>
							<form:input type="text" id="position" path="position"
								class="form-control mb-4" value="${mother.position}" />
						</div>
					</div>
				</div>
				<div class="tab-pane fade" id="localguardian-classic"
					role="tabpanel" aria-labelledby="awesome-tab-classic">

					<p class="h4 mb-4">Local Guardian</p>
					<div class="row">
						<div class="col-md-4">
							<label for="textInput"> Name </label>
							<form:input type="text" value="${localGuardian.name}" id="name"
								path="name" class="form-control mb-4" />
						</div>
						<div class="col-md-4">
							<label for="textInput"> Address </label>
							<form:input type="text" value="${localGuardian.address }"
								id="address" path="address" class="form-control mb-4" />
						</div>
						<div class="col-md-4">
							<label for="textInput"> Phone </label>
							<form:input type="text" value="${localGuardian.phone }"
								id="phone" path="phone" class="form-control mb-4" />
						</div>
					</div>
					<div class="row">
						<div class="col-md-4">
							<label for="textInput"> Mobile </label>
							<form:input type="text" value="${localGuardian.mobile }"
								id="mobile" path="mobile" class="form-control mb-4" />
						</div>
					</div>
				</div>

			</div>
		</form:form>
	</div>
	<!-- Classic tabs -->

	<tags:response />
	<tags:footer />
	<tags:script />
	<script>
		$("#submitbtn").click(function() {
			var data = {
				id : $("#id").val(),
				
				//other student details
				 father : {
					id : parseInt($("#father_id").val()),
					//other father details
				}, 
				mother:{
					id : parseInt($("#mother_id").val()),
					email: $("#mother_email").val(),
					ephone: $("#mother_ephone")
					//other mother details},
				localguardian:{
					id : parseInt($("#locanguardian_id").val()),
					//other localguardian details
				}
			};
			postJsonDataFromApi('/student', data);
		});
	</script>
	<tags:formscript />
</body>
</html>