<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<!DOCTYPE html>
<html>
<head>
<tags:meta/>
<title>Academic Dates</title>
<tags:style/>
</head>
<body>
<tags:header/>
<form class="border border-light p-5" >
    <div class="text-center">
        <p class="h4 mb-4">New Academic Date</p>
        <div class="btn-group btn-group-sm" role="group" >
  <button type="button" class="btn btn-primary btn-sm">Validate</button>
  <button type="reset" class="btn btn-warning btn-sm">Reset</button>
  <button type="button" class="btn btn-danger btn-sm" onclick="postDataFromApi('/academicdates')">Save</button>
</div>
    </div>
   
<div class="row">
	<div class="col-md-4">
	 <label for="textInput">Academic Date (B.S)</label>
    <input type="text" id="academicdate" name="academicdate" class="form-control mb-4" >
	</div>
	
</div>
<div class="row">
<div class="col-md-4">
	<label for="textInput">Academic Date (A.D)</label>
    <input type="text" id="academicdaten" name="academicdateen" class="form-control mb-4" >
	</div>
</div>
</form>
    

    
<tags:footer/>
<tags:response/>
<tags:script/>
<tags:formscript/>
</body>
</html>