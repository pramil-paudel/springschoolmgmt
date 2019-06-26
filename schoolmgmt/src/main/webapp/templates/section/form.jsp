<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<!DOCTYPE html>
<html>
<head>
<tags:meta />
<title> Section </title>
<tags:style />
</head>
<body class="fixed-sn ">
	<tags:header />

	<form class="border border-light p-5" >

		<div class="text-center">
			<p class="h4 mb-4"> Section </p>
			<div class="btn-group btn-group-sm" role="group"
				aria-label="Basic example">
				<button type="button" class="btn btn-primary btn-sm">Validate</button>
				<button type="reset" class="btn btn-warning btn-sm">Reset</button>
				<button type="button" class="btn btn-danger btn-sm" onclick="postDataFromApi('${pageContext.request.contextPath}/section')">Save</button>	
				<input type="hidden" id="id" name="id" value="${section.id}">
							</div>
		</div>
		<br>
		<div class="row">
			<div class="col-md-4">
				<label for="textInput"> Section </label> <input type="text"
					id="name" name="name" class="form-control mb-4" value="${section.name}">
			</div>
			
		</div>
	</form>
	<div class="card">
  <div class="card-header">
    SECTION
  </div>
  <div class="card-body">
	<table id="customerstbl" class="table table-striped" cellspacing="0"
		width="50%">
		<thead>
			<tr>
				<th class="th-sm"> name </th>
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
					"url" : "${pageContext.request.contextPath}/section/list",
					"type" : "GET"
				},
				"columns" : [ 
					{"data":"name", "defaultContent":""},
					{"data":"Action",
						"orderable":false,
						"searchable":false,
						"render":function(data, type, row, meta){
							var a= '<a href="${pageContext.request.contextPath}/section/'+row.id+'">Edit</a>';
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