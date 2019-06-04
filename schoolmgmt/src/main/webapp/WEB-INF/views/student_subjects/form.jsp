<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<tags:meta />
<title> Student_Subjects </title>
<tags:style />
</head>
<body class="fixed-sn ">
	<tags:header />

	<form:form class="border border-light p-5" modelAttribute="student">

		<div class="text-center">
			<p class="h4 mb-4"> Assign Subjects </p>
			<div class="btn-group btn-group-sm" role="group"
				aria-label="Basic example">
				<button type="button" class="btn btn-primary btn-sm">Validate</button>
				<button type="reset" class="btn btn-warning btn-sm">Reset</button>
					<button type="button" class="btn btn-success btn-sm" id="submitbtn" >Save</button>
			</div>
		</div>
		<br>
		<div class="row">
			<div class="col-md-4">
				<form:select class="mdb-select md-form" id="id" path="id">
					<option value="" disabled >Select Student</option>
					<c:forEach items="${students }" var="s">
					<option value="${s.id }">${s.name }</option>
					 </c:forEach>
					
				</form:select>
			</div>
			<div class="col-md-4">
				<form:select class="mdb-select md-form" id="subjects_id" path="subjects">
					<option value="" disabled >Select Subjects</option>
					<c:forEach items="${subjects }" var="s">
					<option value="${s.id }">${s.code } - ${s.name }</option>
					 </c:forEach>
					
				</form:select>
			</div>
			
		</div>
	</form:form>
	<tags:response/>
	<tags:footer />
	<tags:script />
	<script>
	$("#submitbtn").click(function() {
		var selected="";
		function multi(){
		$("#subjects_id option").each(function(){
		    selected += "id"+":"+ $(this).val()+",";
		});
		return selected;
		}
		
		/* var selections=[];
		var $el=$("#subjects_id");
		$el.find('option:selected').each(function(){
		    selections.push({id:$(this).val()});
		});
		var selectionjson=JSON.stringify(selections); */
		
		var data={
				id:$("#id").val(),
				subjects: //values from multiselect
		};
		postJsonDataFromApi('/student', data);
	});
	</script>
	<tags:formscript/>
</body>
</html>