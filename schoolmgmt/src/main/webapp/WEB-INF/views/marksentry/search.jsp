<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<tags:meta />
<title>Marks Entry</title>
<tags:style />
<style>
#markstbl input {
	border: 0.5px solid black;
}
</style>
</head>
<body class="fixed-sn">
	<tags:header />

	<form class="border border-light p-5" method="post"
		action="/marksentry">

		<div class="text-center">
			<p class="h4 mb-4">SEARCH MARKS</p>
			<div class="btn-group btn-group-sm" role="group">
				<button type="button" class="btn btn-primary btn-sm" id="validate">Validate</button>
				<button type="reset" class="btn btn-warning btn-sm">Reset</button>
				<button type="button" class="btn btn-primary btn-sm" id="loadbtn">Load</button>
			</div>
		</div>
		<br>
		<div class="row">
			<div class="col-md-4">
				<select class="mdb-select md-form" id="academicdatesid"
					name="academicdates.id">
					<option value="" disabled selected>Select Academic Date</option>
					<c:forEach items="${academicdates }" var="b">
						<option value="${b.id }">${b.academicdate }(${b.academicdateen })</option>
					</c:forEach>
				</select>
			</div>
			<div class="col-md-4">
				<select class="mdb-select md-form" id="gradeid" name="grade.id">
					<option value="" disabled selected>Select Grade</option>
					<c:forEach items="${grade}" var="b">
						<option value="${b.id}">${b.name}</option>
					</c:forEach>
				</select>
			</div>
			<div class="col-md-4">
				<select class="mdb-select md-form" id="sectionid" name="section.id">
					<option value="" disabled selected>Select Section</option>
					<c:forEach items="${section }" var="b">
						<option value="${b.id }"
							<c:if test="${marksentry.section.id eq b.id }">selected</c:if>>${b.name }</option>
					</c:forEach>
				</select>
			</div>


		</div>
		<div class="row">
			<div class="col-md-4">
				<select class="mdb-select md-form" id="examid" name="exam.id">
					<option value="" disabled selected>Select Exam</option>

				</select>
			</div>
			<div class="col-md-4">
				<select class="mdb-select md-form" id="studentid" name="student.id" searchable="search here...">
					<option value="" disabled selected>Select Student</option>

				</select>
			</div>
		</div>

	</form>
	<div class="card border-success mb-3" >
		<div class="card-header">MARKS DETAIL</div>
		<div class="card-body">
			<table id="markstbl" class="table table-hover text-monospace">
				<thead>
					<tr>
						<td scope="col">Subject Name</td>
						<td scope="col">Pr Marks (Full)</td>
						<td scope="col">Pr Marks (Pass)</td>
						<td scope="col">Th Marks (Full)</td>
						<td scope="col">Th Marks (Pass)</td>
						<td scope="col">Obt. Pr Marks</td>
						<td scope="col">Obt. Th Marks</td>
						<td scope="col">p/a/l</td>
					</tr>
				</thead>
			</table>
		</div>
	</div>

	<tags:response />
	<tags:footer />
	<tags:script />
	<script>
		$("#academicdatesid").change(
				function() {
					var id = $(this).val();
					var url = "/exam/academicdates/" + id;
					$.getJSON(url, function(data) {
						$('#examid').find('option').remove().end();
						$('#examid').material_select('destroy');
						$.each(data, function(i, obj) {
							$('#examid').append(
									$('<option>').text(obj.name).attr('value',
											obj.id));
						});
						$('#examid').material_select();
					});

				});
		$("#sectionid, #gradeid").change(
				function() {

					var gradeid = $("#gradeid").val();
					var sectionid = $("#sectionid").val();
					var url = "/student/grade/" + gradeid + "/section/"
							+ sectionid;
					4
					$('#studentid').find('option').remove().end();
					$('#studentid').material_select('destroy');
					$.getJSON(url, function(data) {

						$.each(data, function(i, obj) {
							$('#studentid').append(
									$('<option>').text(
											obj.rollNo + "-" + obj.name).attr(
											'value', obj.id));
						});
						$('#studentid').material_select();
					});

				});
		$("#loadbtn").click(function() {
			loaddata();
		});
		function loaddata() {
			var examid = $("#examid").val();
			var studentid = $("#studentid").val();
			var url = "/marks/exam/" + examid + "/student/" + studentid + "";
			$('#markstbl').DataTable({
				"scrollX" : true,
				"bProcessing" : true,
				"sAjaxDataProp" : "",
				"bServerSide" : false,
				"ajax" : {
					"url" : url,
					"type" : "GET"
				},
				"columns" : [ {
					"data" : "subjects.name",
					"defaultContent" : ""
				}, {
					"data" : "subjects.fullmarks_th",
					"defaultContent" : ""
				}, {
					"data" : "subjects.passmarks_th",
					"defaultContent" : ""
				}, {
					"data" : "subjects.fullmarks_pr",
					"defaultContent" : ""
				}, {
					"data" : "subjects.passmarks_th",
					"defaultContent" : ""
				}, {
					"data" : "prmarks",
					"defaultContent" : ""
				}, {
					"data" : "thmarks",
					"defaultContent" : ""
				}, {
					"data" : "pal",
					"defaultContent" : ""
				}, ],
				"bDestroy" : true

			});
		}
	</script>
</body>
</html>