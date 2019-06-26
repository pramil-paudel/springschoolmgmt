<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
<tags:meta />
<title>General Details</title>
<tags:style />
</head>
<body class="fixed-sn ">
	<tags:header />

	<form class="border border-light p-5" method="post"
		action="/generaldetails">

		<div class="text-center">
			<p class="h4 mb-4">General Details</p>
			<div class="btn-group btn-group-sm" role="group">
				<button type="button" class="btn btn-primary btn-sm">Validate</button>
				<button type="reset" class="btn btn-warning btn-sm">Reset</button>
				<button type="button" class="btn btn-danger btn-sm" id="submitbtn">Save</button>
				<input type="hidden" id="id" name="id" value="1">

			</div>
		</div>
		<br>
		<div class="row">
			<div class="col-md-4">
				<label for="textInput">Address </label> <input type="text"
					id="address" name="address" class="form-control mb-4"
					value="${generaldetails.address}">
			</div>
			<div class="col-md-4">
				<label for="textInput"> School code</label> <input type="text"
					id="code" name="code" class="form-control mb-4"
					value="${generaldetails.code}">
			</div>
			<div class="col-md-4">
				<label for="textInput">Email </label> <input type="text" id="email"
					name="email" class="form-control mb-4"
					value="${generaldetails.email}">
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				<label for="textInput"> Name </label> <input type="text" id="name"
					name="name" class="form-control mb-4"
					value="${generaldetails.name}">
			</div>
			<div class="col-md-4">
				<label for="textInput"> Phone Number </label> <input type="text"
					id="phone" name="phone" class="form-control mb-4"
					value="${generaldetails.phone}">
			</div>
			<div class="col-md-4">
				<label for="textInput"> Title </label> <input type="text" id="title"
					name="title" class="form-control mb-4"
					value="${generaldetails.title}">
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				<select class="mdb-select md-form" id="academicdatesid"
					name="academicdates.id">
					<option value="" disabled selected>Select Academic Date</option>
					<c:forEach items="${academicdates }" var="b">
						<option value="${b.id }" <c:if test="${generaldetails.academicdates.id eq b.id }">selected</c:if>>${b.academicdate }(${b.academicdateen })</option>
					</c:forEach>

				</select>
			</div>
		</div>

	</form>
	<div class="card">
  <div class="card-header">
     GENERAL DETAILS
  </div>
  <div class="card-body">
	<table id="customerstbl" class="table table-striped" cellspacing="0"
		width="100%">
		<thead>
			<tr>
				<th class="th-sm"> Address </th>
				<th class="th-sm"> Code </th>
				<th class="th-sm"> Email </th>
				<th class="th-sm"> Name </th>
				<th class="th-sm"> Phone </th>
				<th class="th-sm"> Title </th>
				<th class="th-sm"> Academic Dates ID </th>
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
		$(document).ready(function() {
			$('#customerstbl').DataTable({
				"scrollX" : true,
				"bProcessing" : true,
				"sAjaxDataProp" : "",
				"bServerSide" : false,
				"ajax" : {
					"url" : "${pageContext.request.contextPath}/generaldetails/list",
					"type" : "GET"
				},
				"columns" : [ 
					{"data":"address", "defaultContent":""},
					{"data":"code", "defaultContent":""},
					{"data":"email", "defaultContent":""},
					{"data":"name", "defaultContent":""},
					{"data":"phone", "defaultContent":""},
					{"data":"title", "defaultContent":""},
					{"data":"academicdatesid", "defaultContent":""},
					{"data":"Action",
						"orderable":false,
						"searchable":false,
						"render":function(data, type, row, meta){
							var a= '<a href="${pageContext.request.contextPath}/generaldetails/'+row.id+'">Edit</a>';
							return a;
						}
					}
				]

			});
		});
	</script>
	<script>
	$("#submitbtn").click(function(){
		var data = {
				id: $("#id").val(),
				address: $("#address").val(),
				code: $("code").val(),
				email: $("email").val(),
				name: $("name").val,
				phone: $("phone").val(),
				title: $("title").val(),
				academicdates: {
					id: $("#academicdatesid").val()
				}
			};
		postJsonDataFromApi('${pageContext.request.contextPath}/generaldetails',data);
	});
	
	</script>
	<tags:formscript />
</body>
</html>