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
    SUBJECTS
  </div>
  <div class="card-body">
	<table id="customerstbl" class="table table-striped" cellspacing="0"
		width="100%">
		<thead>
			<tr>
				<th class="th-sm">Code</th>
				<th class="th-sm"> Full Marks Practical </th>
				<th class="th-sm"> Full Marks Theory </th>
				<th class="th-sm"> Name </th>
				<th class="th-sm"> Pass Marks Practical </th>
				<th class="th-sm"> Pass Marks Theory </th>
				<th class="th-sm"> Subject Type </th>
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
					"url" : "subjects/list",
					"type" : "GET"
				},
				"columns" : [ 
					{"data":"code", "defaultContent":""},
					{"data":"fullmarks_pr", "defaultContent":""},
					{"data":"fullmarks_th", "defaultContent":""},
					{"data":"passmarks_pr", "defaultContent":""},
					{"data":"passmarks_th", "defaultContent":""},
					{"data":"name", "defaultContent":""},
					{"data":"subjecttype", "defaultContent":""},
					{"data":"Action",
						"orderable":false,
						"searchable":false,
						"render":function(data, type, row, meta){
							var a= '<a href="/subjects/'+row.id+'">Edit</a>';
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