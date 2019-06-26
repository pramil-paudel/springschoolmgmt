<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<!DOCTYPE html>
<html>
<head>
<tags:meta />
<title> Grade Sheet </title>
<tags:style />
</head>
<body class="fixed-sn ">
	<tags:header />

	<form class="border border-light p-5" >

		<div class="text-center">
			<p class="h4 mb-4"> Grade Sheet </p>
			<div class="btn-group btn-group-sm" role="group"
				aria-label="Basic example">
				<button type="button" class="btn btn-primary btn-sm">Validate</button>
				<button type="reset" class="btn btn-warning btn-sm">Reset</button>
				<button type="button" class="btn btn-danger btn-sm" onclick="postDataFromApi('${pageContext.request.contextPath}/gradesheet')">Save</button>		
				<input type="hidden" id="id" name="id" value="${gradesheet.id }">	
					</div>
		</div>
		<br>
		<div class="row">
			<div class="col-md-4">
				<label for="textInput">  Minimum </label> <input type="text"
					id="low" name="low" class="form-control mb-4" value="${gradesheet.low }">
			</div>
			<div class="col-md-4">
				<label for="textInput">  Maximum </label> <input type="text"
					id="high" name="high" class="form-control mb-4" value="${gradesheet.high }">
			</div>
			<div class="col-md-4">
				<label for="textInput">  Grade </label> <input type="text"
					id="grade" name="grade" class="form-control mb-4" value="${gradesheet.grade }">
			</div>
			
		</div>
	</form>
	<div class="card">
  <div class="card-header">
     GRADE SHEET
  </div>
  <div class="card-body">
	<table id="datatablee" class="table table-striped" cellspacing="0"
		width="50%">
		<thead>
			<tr>
				<th class="th-sm"> Maximum </th>
				<th class="th-sm"> Minimum </th>
				<th class="th-sm"> Grade </th>
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
			$('#datatablee').DataTable({
				"scrollX" : true,
				"bProcessing" : true,
				"sAjaxDataProp" : "",
				"bServerSide" : false,
				"ajax" : {
					"url" : "${pageContext.request.contextPath}/gradesheet/list",
					"type" : "GET"
				},
				"columns" : [ 
					{"data":"low", "defaultContent":""},
					{"data":"high", "defaultContent":""},
					{"data":"grade", "defaultContent":""},
					{"data":"Action",
						"orderable":false,
						"searchable":false,
						"render":function(data, type, row, meta){
							var a= '<a href="${pageContext.request.contextPath}/gradesheet/'+row.id+'">Edit</a>';
							return a;
						}
					}
					
				]

			});
		});
	</script>
	<tags:formscript/>
</body>
</html>