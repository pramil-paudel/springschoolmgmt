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
     FATHER
  </div>
  <div class="card-body">
	<table id="customerstbl" class="table table-striped" cellspacing="0"
		width="100%">
		<thead>
			<tr>
				<th class="th-sm"> Full Name </th>
				<th class="th-sm"> Address </th>
				<th class="th-sm"> E-mail </th>
				<th class="th-sm"> E-phone </th>
				<th class="th-sm"> Office </th>
				<th class="th-sm"> Income </th>
				<th class="th-sm"> Position </th>
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
					"url" : "/father/list",
					"type" : "GET"
				},
				"columns" : [ 
					{"data":"fullname", "defaultContent":""},
					{"data":"address", "defaultContent":""},
					{"data":"email", "defaultContent":""},
					{"data":"ephone", "defaultContent":""},
					{"data":"office", "defaultContent":""},
					{"data":"income", "defaultContent":""},
					{"data":"position", "defaultContent":""},
					{"data":"Action",
						"orderable":false,
						"searchable":false,
						"render":function(data, type, row, meta){
							var a= '<a href="/father/'+row.id+'">Edit</a>';
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