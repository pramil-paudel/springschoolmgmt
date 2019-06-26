<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<!DOCTYPE html>
<html>
<head>
<tags:meta />
<title>New Company</title>
<tags:style />
</head>
<body class="fixed-sn ">
	<tags:header />

	<form class="border border-light p-5">

		<div class="text-center">
			<p class="h4 mb-4"> Company</p>
			<div class="btn-group btn-group-sm" role="group"
				aria-label="Basic example">
				<button type="button" class="btn btn-primary btn-sm">Validate</button>
				<button type="reset" class="btn btn-warning btn-sm">Reset</button>
				<button type="button" class="btn btn-danger btn-sm" onclick="postDataFromApi('/company')">Save</button>
				
				<input type="hidden" id="id" name="id" value="${company.id }">
			</div>
		</div>
		<br>
		<div class="row">
			<div class="col-md-4">
				<label for="textInput">Company Name</label> <input type="text" id="name" 
					class="form-control mb-4" name="name" value="${company.name}">
			</div>
			<div class="col-md-4">
				<label for="textInput"> Address </label> <input type="text"
					id="address" name="address" class="form-control mb-4" value="${company.address}">
			</div>
			<div class="col-md-4">
				<label for="textInput">Company Code</label> <input type="text"
					id="code" name="code" class="form-control mb-4" value="${company.code}">
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				<label for="textInput">E- mail</label> <input type="text"
					id="email" name="email" class="form-control mb-4" value="${company.email}">
			</div>
			<div class="col-md-4">
				<label for="textInput">Phone Number</label> <input type="text"
					id="phonenumber" name="phonenumber" class="form-control mb-4" value="${company.phonenumber}">
			</div>
			<div class="col-md-4">
				<label for="textInput">Vat Pan</label> <input type="text"
					id="vatpan" name="vatpan" class="form-control mb-4" value="${company.vatpan}">
			</div>
		</div>
	</form>
	<div class="card">
  <div class="card-header">
    COMPANY
  </div>
  <div class="card-body">
	<table id="customerstbl" class="table table-striped" cellspacing="0"
		width="100%">
		<thead>
			<tr>
				<th class="th-sm"> Address </th>
				<th class="th-sm"> Code </th>
				<th class="th-sm"> Email </th>
				<th class="th-sm"> Phone Number </th>
				<th class="th-sm"> Vat Pan </th>
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
					"url" : "/company/list",
					"type" : "GET"
				},
				"columns" : [ 
					{"data":"address", "defaultContent":""},
					{"data":"code", "defaultContent":""},
					{"data":"email", "defaultContent":""},
					{"data":"phonenumber", "defaultContent":""},
					{"data":"vatpan", "defaultContent":""},
					{"data":"Action",
						"orderable":false,
						"searchable":false,
						"render":function(data, type, row, meta){
							var a= '<a href="/company/'+row.id+'">Edit</a>';
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