<script>
	function postDataFromApi(url){
		var formData=$('form').serializeArray();
		var formObject={};
		$.each(formData, function(i,v){
			formObject[v.name]=v.value;
		});
		
		$.ajax({
			type:"POST",
			url:url,
			headers:{
				"Content-Type":"application/json",
				"Accept":"application/json"
			},
			data:JSON.stringify(formObject),
			success: function(data){
				$('form')[0].reset();
				$('#statusCode').html(data.statusCode);
				$('#msg').html(data.message);
				$('#response').modal('show');
			},
			error:function(jqXHR, textStatus, errorThrown){
				alert('error');
			}
		});
		
	}
	function postJsonDataFromApi(url, data){
		var jsondata = JSON.stringify(data);
		alert(jsondata);
		$.ajax({
			type:"POST",
			url:url,
			headers:{
				"Content-Type":"application/json",
				"Accept":"application/json"
			},
			data:jsondata,
			success: function(data){
				$('form')[0].reset();
				$('#statusCode').html(data.statusCode);
				$('#msg').html(data.message);
				$('#response').modal('show');
			},
			error:function(jqXHR, textStatus, errorThrown){
				
			}
		});
	}	
	</script>