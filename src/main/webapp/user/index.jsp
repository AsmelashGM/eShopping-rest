<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layoutpage>
	<jsp:attribute name="title">
      Manage Users | 
    </jsp:attribute>
    
    <jsp:attribute name="header">
      <a href="register.jsp" class="btn btn-lg btn-success"> Add New User</a>
    </jsp:attribute>
    
    <jsp:body>
    	<table class="table"> 
    		<thead>
				<tr> 
					<th> Username </th>
					<th> Name</th>
					<th> Email</th>
					<th> Address</th>
					<th> Credit Card Info</th>
					<th> Shipping Info</th>
					<th> Action</th>
				</tr>   
			</thead>
			<tbody id="data">
			</tbody>
    	</table>
		<script>
			$.ajax({
		        url: "http://localhost:8080/eShopping/webapi/users",
		        dataType: "text",
		        success: function(data) {
		            var json = $.parseJSON(data);
		            for (var i=0;i<json.length;++i)
		            {
		            	var pr = '<tr>' + 
				    				'<td>' + json[i].username + '</td>'+
				    				'<td>' + json[i].name + '</td>'+
				    				'<td>' + json[i].email + '</td>'+
				    				'<td>' + json[i].creditcardinfo + '</td>'+
				    				'<td>' + json[i].shippinginfo + '</td>'+
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