<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
<tags:meta />
<title> User </title>
<tags:style />
</head>
<body class="fixed-sn ">
	<tags:header />

	<form class="border border-light p-5">

		<div class="text-center">
			<p class="h4 mb-4"> User </p>
			<div class="btn-group btn-group-sm" role="group"
				aria-label="Basic example">
				<button type="button" class="btn btn-primary btn-sm">Validate</button>
				<button type="reset" class="btn btn-warning btn-sm">Reset</button>
			<button type="button" class="btn btn-danger btn-sm" id="submitbtn">Save</button>	
			<input type="hidden" id="id" name="id" value="${user.id}">	
					</div>
		</div>
		<br>
		<div class="row">
			<div class="col-md-4">
				<label for="textInput">User Name </label> <input type="text" 
				id="username" name="username"  class="form-control mb-4" value="${user.username}">
			</div>
			<div class="col-md-4">
				<label for="textInput"> Password </label> <input type="text"
					id="password" name="password" class="form-control mb-4" value="${user.password}">
			</div>
			<div class="col-md-4">
				 <select class="mdb-select md-form" id="employeeid">
  <option value="" disabled selected>Select Employee ID </option>
  <c:forEach items="${employees }" var="b">
   <option value="${b.id }" <c:if test="${user.employee.id eq b.id }">selected</c:if>>${b.name }</option>  </c:forEach>
 </select>
 
</div>
</div>
			
	</form>
	<div class="card">
  <div class="card-header">
    USERS
  </div>
  <div class="card-body">
	<table id="customerstbl" class="table table-striped" cellspacing="0"
		width="100%">
		<thead>
			<tr>
				<th class="th-sm">User name</th>
				<th class="th-sm">Employee Name</th>
				<th class="th-sm"> Action </th>
				
			</tr>
		</thead>
	</table>
	</div>
	</div>
	<tags:response/>
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
					"url" : "/user/list",
					"type" : "GET"
				},
				"columns" : [ 
					{"data":"username", "defaultContent":""},
					{"data":"employee.name", "defaultContent":""},
					{"data":"Action",
						"orderable":false,
						"searchable":false,
						"render":function(data, type, row, meta){
							var a= '<a href="/user/'+row.id+'">Edit</a>';
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
				id:$("#id").val(),
				username: $("#username").val(),
				password: $("#password").val(),
				employee:{
					id: parseInt($("#employeeid").val())
				}
			};
		postJsonDataFromApi('/user',data);
	});
	</script>
		<tags:formscript/>
</body>
</html>