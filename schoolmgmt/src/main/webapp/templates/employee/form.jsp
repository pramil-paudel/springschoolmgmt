<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<tags:meta />
<title>Employee</title>
<tags:style />
</head>
<body class="fixed-sn ">
	<tags:header />
	<form:form class="border border-light p-5" modelAttribute="employee">

		<div class="text-center">
			<p class="h4 mb-4">Employee</p>
			<div class="btn-group btn-group-sm" role="group"
				aria-label="Basic example">
				<button type="button" class="btn btn-primary btn-sm">Validate</button>
				<button type="reset" class="btn btn-warning btn-sm">Reset</button>
		<button type="button" class="btn btn-danger btn-sm" id="submitbtn">Save</button>
		<form:input type="hidden" path="id" id="id" value=""/>
			</div>
		</div>
		<br>
		<div class="row">

			<div class="col-md-4">
				<label for="textInput"> Address </label> <form:input type="text"
					id="address" path="address" class="form-control mb-4" />
			</div>
			<div class="col-md-4">
				<label for="textInput">Employee Code</label> <form:input type="text"
					id="code" path="code" class="form-control mb-4" value=""/>
			</div>
			<div class="col-md-4">
				<form:select class="mdb-select md-form" id="branchid" path="branch.id">
					<option value="" disabled selected>Select Branch</option>
					<c:forEach items="${branch }" var="b">
						<option value="${b.id }" >${b.name }</option>
					</c:forEach>
				</form:select>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				<label for="textInput">Date Of Birth</label> <form:input type="text"
					id="dob" path="dob" class="form-control mb-4" value=""/>
			</div>
			<div class="col-md-4">
				<label for="textInput"> E-mail</label> <form:input type="text" id="email"
					path="email" class="form-control mb-4" value=""/>
			</div>
			<div class="col-md-4">
				<label for="textInput"> Gender </label> <form:input type="text"
					id="gender" path="gender" class="form-control mb-4" value=""/>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				<label for="textInput">Join Date</label> <form:input type="text"
					id="joindate" path="joindate" class="form-control mb-4" value=""/>
			</div>
			<div class="col-md-4">
				<label for="textInput"> Name </label> <form:input type="text" id="name"
					path="name" class="form-control mb-4" value=""/>
			</div>
			<div class="col-md-4">
				<label for="textInput"> Status </label> <form:input type="text"
					id="status" path="status" class="form-control mb-4" value=""/>
			</div>
		</div>
</form:form>
<div class="card">
  <div class="card-header">
    EMPLOYEE
  </div>
  <div class="card-body">
	<table id="customerstbl" class="table table-striped" cellspacing="0"
		width="100%">
		<thead>
			<tr>
				<th class="th-sm"> Address </th>
				<th class="th-sm"> Code </th>
				<th class="th-sm"> Date of Birth </th>
				<th class="th-sm"> Email </th>
				<th class="th-sm"> Gender </th>
				<th class="th-sm"> Join Date </th>
				<th class="th-sm"> Name </th>
				<th class="th-sm"> Status </th>
				<th class="th-sm"> Branch </th>
				<th class="th-sm"> Action </th>
				</tr>
		</thead>
	</table>
	</div>
	</div>
	<tags:response />
	<tags:footer />
	<tags:script />
	<script>
	$("#submitbtn").click(function(){
		var data = {
				id: $("#id").val(),
				address: $("#address").val(),
				code: $("#code").val(),
				dob: $("#dob").val(),
				email: $("#email").val(),
				gender: $("#gender").val(),
				joindate: $("#joindate").val(),
				name: $("#name").val(),
				status: $("#status").val(),
				gender: $("#gender").val(),
				branch:{
					id: parseInt($("#branchid").val())
				}
				};
		postJsonDataFromApi('${pageContext.request.contextPath}/employee',data);
	});
	
	</script>
	<script>
		$(document).ready(function() {
			$('#customerstbl').DataTable({
				"scrollX" : true,
				"bProcessing" : true,
				"sAjaxDataProp" : "",
				"bServerSide" : false,
				"ajax" : {
					"url" : "${pageContext.request.contextPath}/employee/list",
					"type" : "GET"
				},
				"columns" : [ 
					{"data":"address","defaultContent":""},
					{"data":"code","defaultContent":""},
					{"data":"dob","defaultContent":""},
					{"data":"email","defaultContent":""},
					{"data":"gender","defaultContent":""},
					{"data":"joindate","defaultContent":""},
					{"data":"name","defaultContent":""},
					{"data":"status","defaultContent":""},
					{"data":"branch.name","defaultContent":""},
					{"data":"Action",
						"orderable":false,
						"searchable":false,
						"render":function(data, type, row, meta){
							var a= '<a href="${pageContext.request.contextPath}/employee/'+row.id+'">Edit</a>';
							return a;
						}
					}
				]

			});
		});
	</script>
	<tags:formscript />
</body>
</html>