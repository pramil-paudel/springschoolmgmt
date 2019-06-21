<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<!DOCTYPE html>
<html>
<head>
<tags:meta />
<title> Faculty</title>
<tags:style />
</head>
<body class="fixed-sn ">
	<tags:header />

	<form class="border border-light p-5" method="post" action="/faculty">

		<div class="text-center">
			<p class="h4 mb-4"> Faculty </p>
			<div class="btn-group btn-group-sm" role="group">
				<button type="button" class="btn btn-primary btn-sm">Validate</button>
				<button type="reset" class="btn btn-warning btn-sm">Reset</button>
				<button type="button" class="btn btn-danger btn-sm" onclick="postDataFromApi('/faculty')">Save</button>
					<input type="hidden" id="id" name="id" value="${faculty.id }">
			</div>
		</div>
		<br>
		<div class="row">
			<div class="col-md-4">
				<label for="textInput"> Name </label> <input type="text"
					id="name" name="name" class="form-control mb-4" value="${faculty.name }">
			</div>
			
		</div>
	</form>
	<div class="card">
  <div class="card-header">
     FACULTY
  </div>
  <div class="card-body">
	<table id="datatablee" class="table table-striped" cellspacing="0"
		width="100%">
		<thead>
			<tr>
				<th class="th-sm"> Faculty </th>
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
					"url" : "/faculty/list",
					"type" : "GET"
				},
				"columns" : [ 
					{"data":"name", "defaultContent":""},
					{"data":"Action",
						"orderable":false,
						"searchable":false,
						"render":function(data, type, row, meta){
							var a= '<a href="/faculty/'+row.id+'">Edit</a>';
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