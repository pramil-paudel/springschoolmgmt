<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<html>
<head>
<tags:meta/>
<tags:style/>
</head>
<body class="fixed-sn">
<tags:header/>
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
	<tags:script/>
	<script>
		$(document).ready(function() {
			$('#customerstbl').DataTable({
				"scrollX" : true,
				"bProcessing" : true,
				"sAjaxDataProp" : "",
				"bServerSide" : false,
				"ajax" : {
					"url" : "/employee/list",
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
							var a= '<a href="/employee/'+row.id+'">Edit</a>';
							return a;
						}
					}
				]

			});
		});
	</script>
	<tags:footer/>
</body>
</html>