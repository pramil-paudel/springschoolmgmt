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
			</ul>

			<div class="tab-content card" id="myClassicTabContentShadow">
				<div class="tab-pane fade active show" id="profile-classic-shadow"
					role="tabpanel" aria-labelledby="profile-tab-classic-shadow">
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
				<div class="tab-pane fade" id="follow-classic-shadow"
					role="tabpanel" aria-labelledby="follow-tab-classic-shadow">
					<div class="row">
						<div class="col-md-4">
							<label for="textInput">Full Name </label>
							<form:input type="text" id="fullName" path="father.fullname"
								class="form-control mb-4" value="" />
						</div>
						<div class="col-md-4">
							<label for="textInput"> Address </label>
							<form:input type="text" id="address" path="father.address"
								class="form-control mb-4" value="" />
						</div>
						<div class="col-md-4">
							<label for="textInput">E-mail </label>
							<form:input type="text" id="email" path="father.email"
								class="form-control mb-4" value="" />
						</div>
					</div>
					<div class="row">
						<div class="col-md-4">
							<label for="textInput"> E-phone </label>
							<form:input type="text" id="ePhone" path="father.ephone"
								class="form-control mb-4" value="" />
						</div>
						<div class="col-md-4">
							<label for="textInput"> Office </label>
							<form:input type="text" id="office" path="father.office"
								class="form-control mb-4" value="" />
						</div>
						<div class="col-md-4">
							<label for="textInput"> Income </label>
							<form:input type="text" id="income" path="father.income"
								class="form-control mb-4" value="" />
						</div>
					</div>
					<div class="row">
						<div class="col-md-4">
							<label for="textInput"> Position </label>
							<form:input type="text" id="position" path="father.position"
								class="form-control mb-4" value="" />
						</div>
					</div>
				</div>
				<div class="tab-pane fade" id="contact-classic-shadow"
					role="tabpanel" aria-labelledby="contact-tab-classic-shadow">


					<div class="row">
						<div class="col-md-4">
							<label for="textInput">Full Name </label>
							<form:input type="text" id="mother_fullname"
								path="mother.fullname" class="form-control mb-4" value="" />
						</div>
						<div class="col-md-4">
							<label for="textInput"> Address </label>
							<form:input type="text" id="mother_address" 
							path="mother.address" class="form-control mb-4" value="" />
						</div>
						<div class="col-md-4">
							<label for="textInput">E-mail </label>
							<form:input type="text" id="mother_email" 
							path="mother.email" class="form-control mb-4" value="" />
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
							<form:input type="text" id="office" path="mother.office"
								class="form-control mb-4" value="" />
						</div>
						<div class="col-md-4">
							<label for="textInput"> Income </label>
							<form:input type="text" id="income" path="mother.income"
								class="form-control mb-4" value="" />
						</div>

						<div class="col-md-4">
							<label for="textInput"> Position </label>
							<form:input type="text" id="position" path="mother.position"
								class="form-control mb-4" value="" />
						</div>
					</div>
				</div>
				<div class="tab-pane fade" id="awesome-classic-shadow"
					role="tabpanel" aria-labelledby="awesome-tab-classic-shadow">
					<c:forEach items="${student.localGuardian}" var="l" varStatus="tagStatus">
 
					<div class="row">
						<div class="col-md-4">
							<label for="textInput"> Name </label>
							<form:input type="text" value="" id="name"
								path="localGuardian[${tagStatus.index}].name" class="form-control mb-4" />
						</div>
						
						<div class="col-md-4">
							<label for="textInput"> Address </label>
							<form:input type="text" value=""
								id="address" path="localGuardian[${tagStatus.index}].address" class="form-control mb-4" />
						</div>
						<div class="col-md-4">
							<label for="textInput"> Phone </label>
							<form:input type="text" value=""
								id="phone" path="localGuardian[${tagStatus.index}].phone" class="form-control mb-4" />
						</div>
					</div>
					<div class="row">
						<div class="col-md-4">
							<label for="textInput"> Mobile </label>
							<form:input type="text" value=""
								id="mobile" path="localGuardian[${tagStatus.index}].mobile" class="form-control mb-4" />
						</div>
					</div> 
					</c:forEach>
				</div>
			</div>
		</form:form>
	</div>
	<!-- Classic tabs -->
	<tags:response />
	<tags:footer />
	<tags:script />
	<tags:formscript />
</body>
</html>