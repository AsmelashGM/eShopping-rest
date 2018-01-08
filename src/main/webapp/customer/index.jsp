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
					<th> Username </th>
					<th> Full name </th>
					<th> Email</th>
					<th> Address</th>
					<th> Creditcard info</th>
					<th> Shipping info</th>
					<th> Action</th>
				</tr>   
			</thead>
			<tbody id="data">
			</tbody>
    	</table>
		<script>
			$.ajax({
		        url: "http://localhost:8080/eShopping/webapi/customers",
		        dataType: "text",
		        success: function(data) {
		            var json = $.parseJSON(data);
		            for (var i=0;i<json.length;++i)
		            {
		            	var pr = '<tr>' + 
				    				'<td>' + json[i].username + '</td>'+
				    				'<td>' + json[i].name + '</td>'+
				    				'<td>' + json[i].email + '</td>'+
				    				'<td>' + json[i].address + '</td>'+
				    				'<td>' + json[i].creditcardinfo + '</td>'+
				    				'<td>' + json[i].shippinginfo + '</td>'+
				    				'<td>' + 
				    					'<a href="delete.jsp?pid='+json[i].username+'" class="btn btn-sm btn-danger"> '+
				    						'<span class="glyphicon glyphicon-remove"> </span> </a> &nbsp; &nbsp;' +
				    					'<a href="edit.jsp?pid='+json[i].username+'" class="btn btn-sm btn-warning">'+
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