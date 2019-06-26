<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<!DOCTYPE html>
<html>
<head>
<tags:meta/>
<title>Academic Dates</title>
<tags:style/>
</head>
<body class="fixed-sn ">
<tags:header/>
<form class="border border-light p-5" >
    <div class="text-center">
        <p class="h4 mb-4">New/Update Academic Date</p>
        <div class="btn-group btn-group-sm" role="group" >
  <button type="button" class="btn btn-primary btn-sm">Validate</button>
  <button type="reset" class="btn btn-warning btn-sm">Reset</button>
  <button type="button" class="btn btn-danger btn-sm" onclick="postDataFromApi('${pageContext.request.contextPath}/academicdates')">Save</button>
  <input type="hidden" name="id" value="${academicdates.id }">
</div>
    </div>
   
<div class="row">
	<div class="col-md-4">
	 <label for="textInput">Academic Date (B.S)</label>
    <input type="text" id="academicdate" name="academicdate" class="form-control mb-4" value="${academicdates.academicdate }" >
	</div>
	
</div>
<div class="row">
<div class="col-md-4">
	<label for="textInput">Academic Date (A.D)</label>
    <input type="text" id="academicdaten" name="academicdateen" class="form-control mb-4" value="${academicdates.academicdateen }">
	</div>
</div>
</form>
<div class="card">
  <div class="card-header">
    ACADEMIC DATES
  </div>
  <div class="card-body">
	<table id="customerstbl" class="table table-striped" cellspacing="0"
		width="100%">
		<thead>
			<tr>
				<th class="th-sm"> Academic Date </th>
				<th class="th-sm"> Academic Date English </th>
				<th class="th-sm"> Action </th>
				</tr>
		</thead>
	</table>
	</div>
	</div>
	
    

    
<tags:footer/>
<tags:response/>
<tags:script/>
<script>
		$(document).ready(function() {
			$('#customerstbl').DataTable({
				"scrollX" : true,
				"bProcessing" : true,
				"sAjaxDataProp" : "",
				"bServerSide" : false,
				"ajax" : {
					"url" : "${pageContext.request.contextPath}/academicdates/list",
					"type" : "GET"
				},
				"columns" : [ 
					{"data":"academicdate", "defaultContent":""},
					{"data":"academicdateen","defaultContent":""},
					{"data":"Action",
						"orderable":false,
						"searchable":false,
						"render":function(data, type, row, meta){
							var a= '<a href="${pageContext.request.contextPath}/academicdates/'+row.id+'">Edit</a>';
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