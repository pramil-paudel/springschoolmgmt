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
     STUDENT
  </div>
  <div class="card-body">
	<table id="customerstbl" class="table table-striped" cellspacing="0"
		width="100%">
		<thead>
			<tr>
				<th class="th-sm"> Name </th>
				<th class="th-sm"> Grade </th>
				<th class="th-sm"> Section </th>
				<th class="th-sm"> Gender </th>
				<th class="th-sm"> Date of Birth Nepali </th>
				<th class="th-sm"> Date of Birth English </th>
				<th class="th-sm"> Roll No. </th>
				<th class="th-sm"> Religion </th>
				<th class="th-sm"> Admission Date Nepali </th>
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
					"url" : "${pageContext.request.contextPath}/student/list",
					"type" : "GET"
				},
				"columns" : [ 
					{"data":"name", "defaultContent":""},
					{"data":"grade.name", "defaultContent":""},
					{"data":"section.name", "defaultContent":""},
					{"data":"gender", "defaultContent":""},
					{"data":"dobNepali", "defaultContent":""},
					{"data":"dobEnglish", "defaultContent":""},
					{"data":"rollNo", "defaultContent":""},
					{"data":"religion", "defaultContent":""},
					{"data":"admissionDatenp", "defaultContent":""},
					{"data":"Action",
						"orderable":false,
						"searchable":false,
						"render":function(data, type, row, meta){
							var a= '<a href="${pageContext.request.contextPath}/student/'+row.id+'">Edit</a>';
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