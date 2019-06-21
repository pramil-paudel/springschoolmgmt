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
	<div class="card">
  <div class="card-header">
    EXAM
  </div>
  <div class="card-body">
	<table id="customerstbl" class="table table-striped" cellspacing="0"
		width="100%">
		<thead>
			<tr>
				<th class="th-sm"> Academic Date </th>
				<th class="th-sm"> Code </th>
				<th class="th-sm"> Name </th>
				<th class="th-sm"> Start Date </th>
				<th class="th-sm"> Start Date English </th>
				<th class="th-sm"> Exam Type ID </th>
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
					"url" : "/exam/list",
					"type" : "GET"
				},
				"columns" : [ 
					{"data":"academicdates.academicdate","defaultContent":""},
					{"data":"code","defaultContent":""},
					{"data":"name","defaultContent":""},
					{"data":"startdate","defaultContent":""},
					{"data":"startdateen","defaultContent":""},
					{"data":"examtype.name","defaultContent":""},
					{"data":"Action",
						"orderable":false,
						"searchable":false,
						"render":function(data, type, row, meta){
							var a= '<a href="/exam/'+row.id+'">Edit</a>';
							return a;
						}
					}
				]

			});
		});
	</script>
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