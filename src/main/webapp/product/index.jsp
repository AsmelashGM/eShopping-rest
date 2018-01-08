<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layoutpage>
	<jsp:attribute name="title">
      Manage Products | 
    </jsp:attribute>
    
    <jsp:attribute name="header">
      <a href="add.jsp" class="btn btn-lg btn-success"> Add New Product</a>
    </jsp:attribute>
    
    <jsp:body>
    	<table class="table table-"> 
    		<thead>
				<tr> 
					<th> ID </th>
					<th> Name </th>
					<th> Description</th>
					<th> Type</th>
					<th> Measurement</th>
					<th> Unit Price</th>
					<th> Quantity</th>
					<th> Size</th>
					<th> Photo</th>
					<th> Action</th>
				</tr>   
			</thead>
			<tbody id="data">
			</tbody>
    	</table>
		<script>
			$.ajax({
		        url: "http://localhost:8080/eShopping/webapi/products",
		        dataType: "text",
		        success: function(data) {
		            var json = $.parseJSON(data);
		            for (var i=0;i<json.length;++i)
		            {
		            	var pr = '<tr>' + 
				    				'<td>' + json[i].id + '</td>'+
				    				'<td>' + json[i].name + '</td>'+
				    				'<td>' + json[i].description + '</td>'+
				    				'<td>' + json[i].type + '</td>'+
				    				'<td>' + json[i].measurement + '</td>'+
				    				'<td>' + json[i].unitprice + '</td>'+
				    				'<td>' + json[i].quantity + '</td>'+
				    				'<td>' + json[i].size + '</td>'+
				    				'<td>' + 
				    					'<img src="../_res/imgs/stuff/'+json[i].id+'.jpg" class="shopping-photo-sm" alt="' +json[i].name+ '"/>'+ 
				    				'</td>'+
				    				'<td>' + 
				    					'<a href="delete.jsp?pid='+json[i].id+'" class="btn btn-sm btn-danger"> '+
				    						'<span class="glyphicon glyphicon-remove"> </span> </a> &nbsp; &nbsp;' +
				    					'<a href="edit.jsp?pid='+json[i].id+'" class="btn btn-sm btn-warning">'+
				    						'<span class="glyphicon glyphicon-edit"> </span></a>' +
				    				'</td>'+
		    					'</tr>';	
		            	$('#data').append(pr);
		                
		            }
		        }
		    });
		</script> 
    </jsp:body>
</t:layoutpage>