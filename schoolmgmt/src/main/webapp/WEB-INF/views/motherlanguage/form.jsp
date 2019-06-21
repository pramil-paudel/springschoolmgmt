<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<!DOCTYPE html>
<html>
<head>
<tags:meta />
<title> Mother Language </title>
<tags:style />
</head>
<body class="fixed-sn ">
	<tags:header />

	<form class="border border-light p-5" method="post" action="/motherlanguage">

		<div class="text-center">
			<p class="h4 mb-4"> Mother Language </p>
			<div class="btn-group btn-group-sm" role="group"
				aria-label="Basic example">
				<button type="button" class="btn btn-primary btn-sm">Validate</button>
				<button type="reset" class="btn btn-warning btn-sm">Reset</button>
					<button type="button" class="btn btn-danger btn-sm" onclick="postDataFromApi('/motherlanguage')">Save</button>	
					<input type="hidden" id="id" name="id" value="${motherLanguage.id}">	
						</div>
		</div>
		<br>
		<div class="row">
			<div class="col-md-4">
				<label for="textInput"> Mother Language Name </label> <input type="text"
					id="name" name="name" class="form-control mb-4" value="${motherLanguage.name}">
			</div>
			
		</div>
	</form>
	<div class="card">
  <div class="card-header">
    MOTHER LANGUAGE
  </div>
  <div class="card-body">
	<table id="datatablee" class="table table-striped" cellspacing="0"
		width="100%">
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
			$('#datatablee').DataTable({
				"scrollX" : true,
				"bProcessing" : true,
				"sAjaxDataProp" : "",
				"bServerSide" : false,
				"ajax" : {
					"url" : "/motherlanguage/list",
					"type" : "GET"
				},
				"columns" : [ 
					{"data":"name", "defaultContent":""},
					{"data":"Action",
						"orderable":false,
						"searchable":false,
						"render":function(data, type, row, meta){
							var a= '<a href="/motherlanguage/'+row.id+'">Edit</a>';
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