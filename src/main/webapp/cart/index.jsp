<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layoutpage>
	<jsp:attribute name="title">
      View Carts | 
    </jsp:attribute>
    
    <jsp:attribute name="header">
		List of Carts
    </jsp:attribute>
    
    <jsp:body>
    	<table class="table table-"> 
    		<thead>
				<tr> 
					<th> ID </th>
					<th> Date Added </th>
					<th> Product ID</th>
					<th> Quantity</th>
				</tr>   
			</thead>
			<tbody id="data">
			</tbody>
    	</table>
		<script>
			$.ajax({
		        url: "http://localhost:8080/eShopping/webapi/carts",
		        dataType: "text",
		        success: function(data) {
		            var json = $.parseJSON(data);
		            for (var i=0;i<json.length;++i)
		            {
		            	var pr = '<tr>' + 
				    				'<td>' + json[i].id + '</td>'+
				    				'<td>' + json[i].dateAdded + '</td>'+
				    				'<td>' + json[i].productId + '</td>'+
				    				'<td>' + json[i].quantity + '</td>'+
		    					'</tr>';	
		            	$('#data').append(pr);
		                
		            }
		        }
		    });
		</script> 
    </jsp:body>
</t:layoutpage>