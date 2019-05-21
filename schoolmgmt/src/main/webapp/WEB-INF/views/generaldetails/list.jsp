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
					"url" : "generaldetails/list",
					"type" : "GET"
				},
				"columns" : [ 
					{"data":"address"},
					{"data":"code"},
					{"data":"email"},
					{"data":"name"},
					{"data":"phone"},
					{"data":"title"},
					{"data":"academicdatesid"}
				]

			});
		});
	</script>
	<tags:footer/>
</body>
</html>