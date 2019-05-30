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
	<tags:script/>
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
	<tags:footer/>
</body>
</html>