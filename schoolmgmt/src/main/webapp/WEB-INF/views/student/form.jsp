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

	<div class="text-center">
		<p class="h4 mb-4">Student</p>
		<div class="btn-group btn-group-sm" role="group">
			<button type="button" class="btn btn-primary btn-sm">Validate</button>
			<button type="reset" class="btn btn-warning btn-sm">Reset</button>
			<button type="button" class="btn btn-success btn-sm" id="submitbtn">Save</button>
		</div>
	</div>
	<br>

	<!-- Classic tabs -->
	<div class="classic-tabs mx-2">
		<form:form modelAttribute="student">

			<ul class="nav tabs-cyan" id="myClassicTabShadow" role="tablist">
				<li class="nav-item"><a
					class="nav-link  waves-light active show"
					id="profile-tab-classic-shadow" data-toggle="tab"
					href="#profile-classic-shadow" role="tab"
					aria-controls="profile-classic-shadow" aria-selected="true">STUDENT</a>
				</li>
				<li class="nav-item"><a class="nav-link waves-light"
					id="follow-tab-classic-shadow" data-toggle="tab"
					href="#follow-classic-shadow" role="tab"
					aria-controls="follow-classic-shadow" aria-selected="false">FATHER</a>
				</li>
				<li class="nav-item"><a class="nav-link waves-light"
					id="contact-tab-classic-shadow" data-toggle="tab"
					href="#contact-classic-shadow" role="tab"
					aria-controls="contact-classic-shadow" aria-selected="false">MOTHER</a>
				</li>
				<li class="nav-item"><a class="nav-link waves-light"
					id="awesome-tab-classic-shadow" data-toggle="tab"
					href="#awesome-classic-shadow" role="tab"
					aria-controls="awesome-classic-shadow" aria-selected="false">LOCALGUARDIAN</a>
				</li>
				<li class="nav-item"><a class="nav-link waves-light"
					id="subjects-tab-classic-shadow" data-toggle="tab"
					href="#subjects-classic-shadow" role="tab"
					aria-controls="subjects-classic-shadow" aria-selected="false">SUBJECTS</a>
				</li>
			</ul>

			<div class="tab-content card" id="myClassicTabContentShadow">
				<div class="tab-pane fade active show" id="profile-classic-shadow"
					role="tabpanel" aria-labelledby="profile-tab-classic-shadow">
					<div class="row">
						<div class="col-md-4">
							<form:input type="hidden" id="id" path="id" value="" />
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
							<form:select class="mdb-select md-form" id="gender" path="gender">
								<option value="" disabled>Select Gender</option>
								<option value="male">Male</option>
								<option value="female">Female</option>
								<option value="other">Other</option>
							</form:select>
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
							<form:select class="mdb-select md-form" id="religion"
								path="religion">
								<option value="" disabled>Select Religion</option>
								<option value="hinduism">Hinduism</option>
								<option value="buddhism">Buddhism</option>
								<option value="muslim">Muslim</option>
								<option value="christianity">Christianity</option>
							</form:select>
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
						<div class="col-md-4">
							<form:select class="mdb-select md-form" id="motherlanguageid"
								path="motherLanguage.id">
								<option value="" disabled>Select Mother Language</option>
								<c:forEach items="${motherlanguage }" var="b">
									<option value="${b.id }">${b.name }</option>
								</c:forEach>
							</form:select>
						</div>
					</div>
				</div>
				<div class="tab-pane fade" id="follow-classic-shadow"
					role="tabpanel" aria-labelledby="follow-tab-classic-shadow">
					<div class="row">
						<div class="col-md-4">
							<form:input type="hidden" id="father_id" path="father.id"
								value="" />
							<label for="textInput">Full Name </label>
							<form:input type="text" id="father_fullName"
								path="father.fullname" class="form-control mb-4" value="" />
						</div>
						<div class="col-md-4">
							<label for="textInput"> Address </label>
							<form:input type="text" id="father_address" path="father.address"
								class="form-control mb-4" value="" />
						</div>
						<div class="col-md-4">
							<label for="textInput">E-mail </label>
							<form:input type="text" id="father_email" path="father.email"
								class="form-control mb-4" value="" />
						</div>
					</div>
					<div class="row">
						<div class="col-md-4">
							<label for="textInput"> E-phone </label>
							<form:input type="text" id="father_ePhone" path="father.ephone"
								class="form-control mb-4" value="" />
						</div>
						<div class="col-md-4">
							<label for="textInput"> Office </label>
							<form:input type="text" id="father_office" path="father.office"
								class="form-control mb-4" value="" />
						</div>
						<div class="col-md-4">
							<label for="textInput"> Income </label>
							<form:input type="text" id="father_income" path="father.income"
								class="form-control mb-4" value="" />
						</div>
					</div>
					<div class="row">
						<div class="col-md-4">
							<label for="textInput"> Position </label>
							<form:input type="text" id="father_position"
								path="father.position" class="form-control mb-4" value="" />
						</div>
					</div>
				</div>
				<div class="tab-pane fade" id="contact-classic-shadow"
					role="tabpanel" aria-labelledby="contact-tab-classic-shadow">


					<div class="row">
						<div class="col-md-4">
							<form:input type="hidden" id="mother_id" path="mother.id"
								value="" />
							<label for="textInput">Full Name </label>
							<form:input type="text" id="mother_fullname"
								path="mother.fullname" class="form-control mb-4" value="" />
						</div>
						<div class="col-md-4">
							<label for="textInput"> Address </label>
							<form:input type="text" id="mother_address" path="mother.address"
								class="form-control mb-4" value="" />
						</div>
						<div class="col-md-4">
							<label for="textInput">E-mail </label>
							<form:input type="text" id="mother_email" path="mother.email"
								class="form-control mb-4" value="" />
						</div>
					</div>
					<div class="row">
						<div class="col-md-4">
							<label for="textInput"> Telephone </label>
							<form:input type="text" id="mother_telephone"
								path="mother.telephone" class="form-control mb-4" value="" />
						</div>
						<div class="col-md-4">
							<label for="textInput"> Mobile </label>
							<form:input type="text" id="mother_mobile" path="mother.mobile"
								class="form-control mb-4" value="" />
						</div>
						<div class="col-md-4">
							<label for="textInput"> E-phone </label>
							<form:input type="text" id="mother_ephone" path="mother.ephone"
								class="form-control mb-4" value="" />
						</div>


					</div>
					<div class="row">
						<div class="col-md-4">
							<label for="textInput"> Office </label>
							<form:input type="text" id="mother_office" path="mother.office"
								class="form-control mb-4" value="" />
						</div>
						<div class="col-md-4">
							<label for="textInput"> Income </label>
							<form:input type="text" id="mother_income" path="mother.income"
								class="form-control mb-4" value="" />
						</div>

						<div class="col-md-4">
							<label for="textInput"> Position </label>
							<form:input type="text" id="mother_position"
								path="mother.position" class="form-control mb-4" value="" />
						</div>
					</div>
				</div>
				<div class="tab-pane fade" id="awesome-classic-shadow"
					role="tabpanel" aria-labelledby="awesome-tab-classic-shadow">
					<div class="row">
						<div class="col-md-4">
							<form:input type="hidden" id="localGuardain_id"
								path="localGuardian.id" value="" />
							<label for="textInput"> Name </label>
							<form:input type="text" value="" id="localGuardian_name"
								path="localGuardian.name" class="form-control mb-4" />
						</div>

						<div class="col-md-4">
							<label for="textInput"> Address </label>
							<form:input type="text" value="" id="localGuardian_address"
								path="localGuardian.address" class="form-control mb-4" />
						</div>
						<div class="col-md-4">
							<label for="textInput"> Phone </label>
							<form:input type="text" value="" id="localGuardian_phone"
								path="localGuardian.phone" class="form-control mb-4" />
						</div>
					</div>
					<div class="row">
						<div class="col-md-4">
							<label for="textInput"> Mobile </label>
							<form:input type="text" value="" id="localGuardian_mobile"
								path="localGuardian.mobile" class="form-control mb-4" />
						</div>
					</div>
				</div>
				<div class="tab-pane fade" id="subjects-classic-shadow"
					role="tabpanel" aria-labelledby="subjects-tab-classic-shadow">
					<div class="row">
						<div class="col-md-4">
						</div>
					</div>
					<div class="row">
						<div class="col-md-4">
							<table id="subjectstbl" class="table table-striped"
								cellspacing="0" width="100%">
								<thead>
									<tr>
										<th class="th-sm">Code</th>
										<th class="th-sm">Name</th>
									</tr>
								</thead>
							</table>
						</div>
					</div>

				</div>
			</div>
		</form:form>
	</div>
	<p id="p"></p>
	<!-- Classic tabs -->

	<tags:response />
	<tags:footer />
	<tags:script />
	<script>
	$(document).ready(function() {
		$('#subjectstbl').DataTable({
			"bFilter": false,
			 "paging":   false,
		        "ordering": false,
		        "info":     false,
			"scrollX" : true,
			"bProcessing" : true,
			"sAjaxDataProp" : "",
			"bServerSide" : false,
			"ajax" : {
				"url" : "/studentsubjects/"+$("#id").val(),
				"type" : "GET"
			},
			"columns" : [ 
				{"data":"code", "defaultContent":""},
				{"data":"name", "defaultContent":""}
			]

		});
	});
		$("#submitbtn").click(function() {
			var data = {
				id : $("#id").val(),
				legacyId : $("#legacyId").val(),
				name : $("#name").val(),
				gender : $("#gender").val(),
				dobNepali : $("#dobNepali").val(),
				dobEnglish : $("#dobEnglish").val(),
				district : $("#district").val(),
				hobby : $("#hobby").val(),
				rollNo : $("#rollNo").val(),
				municipality : $("#municipality").val(),
				religion : $("#religion").val(),
				temporaryAddress : $("#temporaryAddress").val(),
				wardNo : $("#wardNo").val(),
				oldSchool : $("#oldSchool").val(),
				reasonLeave : $("#reasonLeave").val(),
				admissionDatenp : $("#admissionDatenp").val(),
				birthCertificateNo : $("#birthCertificateNo").val(),
				issuedBy : $("#issuedBy").val(),
				motherlanguage : {
					id : parseInt($("#motherlanguageid").val())
				},
				father : {
					id : $("#father_id").val(),
					fullname : $("#father_fullName").val(),
					address : $("#father_address").val(),
					email : $("#father_email").val(),
					ephone : $("#father_ePhone").val(),
					office : $("#father_office").val(),
					income : $("#father_income").val(),
					position : $("#father_position").val(),
				},
				mother : {
					id : $("#mother_id").val(),
					fullname : $("#mother_fullname").val(),
					address : $("#mother_address").val(),
					email : $("#mother_email").val(),
					telephone : $("#mother_telephone").val(),
					mobile : $("#mother_mobile").val(),
					ephone : $("#mother_ephone").val(),
					office : $("#mother_office").val(),
					income : $("#mother_income").val(),
					position : $("#mother_position").val(),
				},
				localGuardian : {
					id : $("#localGuardain_id").val(),
					name : $("#localGuardian_name").val(),
					address : $("#localGuardian_address").val(),
					phone : $("#localGuardian_phone").val(),
					mobile : $("#localGuardian_mobile").val(),
				},
			};
			
			postJsonDataFromApi('/student', data);
		});
	</script>
	<tags:formscript />
</body>
</html>