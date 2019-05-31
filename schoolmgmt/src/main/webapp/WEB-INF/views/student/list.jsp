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
				<th class="th-sm"> Legacy ID  </th>
				<th class="th-sm"> Name </th>
				<th class="th-sm"> Email </th>
				<th class="th-sm"> Date of Birth Nepali </th>
				<th class="th-sm"> Date of Birth English </th>
				<th class="th-sm">  District   </th>
				<th class="th-sm"> Roll No. </th>
				<th class="th-sm"> Municipality </th>
				<th class="th-sm"> Religion </th>
				<th class="th-sm"> Temporary Address </th>
				<th class="th-sm">  Ward No </th>
				<th class="th-sm"> Old school  </th>
				<th class="th-sm"> Reason of Leave </th>
				<th class="th-sm"> Admission Date Nepali </th>
				<th class="th-sm"> Birth Certificate Number </th>
				<th class="th-sm"> Issued By  </th>
				<th class="th-sm"> Father </th>
				<th class="th-sm"> Mother  </th>
				<th class="th-sm"> Local Guardian  </th>
				<th class="th-sm"> Mother Language </th>
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
					"url" : "student/list",
					"type" : "GET"
				},
				"columns" : [ 
					{"data":"legacyId", "defaultContent":""},
					{"data":"name", "defaultContent":""},
					{"data":"email", "defaultContent":""},
					{"data":"dobNepali", "defaultContent":""},
					{"data":"dobEnglish", "defaultContent":""},
					{"data":"district", "defaultContent":""},
					{"data":"rollNo", "defaultContent":""},
					{"data":"municipality", "defaultContent":""},
					{"data":"religion", "defaultContent":""},
					{"data":"temporaryAddress", "defaultContent":""},
					{"data":"wardNo", "defaultContent":""},
					{"data":"oldSchool", "defaultContent":""},
					{"data":"reasonLeave", "defaultContent":""},
					{"data":"admissionDatenp", "defaultContent":""},
					{"data":"birthCertificate_no", "defaultContent":""},
					{"data":"issuedBy", "defaultContent":""},
					{"data":"fatherid", "defaultContent":""},
					{"data":"motherid", "defaultContent":""},
					{"data":"localgurdainid", "defaultContent":""},
					{"data":"motherlanguageid", "defaultContent":""},
					{"data":"Action",
						"orderable":false,
						"searchable":false,
						"render":function(data, type, row, meta){
							var a= '<a href="/student/'+row.id+'">Edit</a>';
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