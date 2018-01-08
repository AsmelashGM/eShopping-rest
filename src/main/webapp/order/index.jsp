<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layoutpage>
	<jsp:attribute name="title">
     List of Orders | 
    </jsp:attribute>
    
    <jsp:attribute name="header">
    	List of Orders
    </jsp:attribute>
    
    <jsp:body>
    	<table class="table table-"> 
    		<thead>
				<tr> 
					<th> ID </th>
					<th> Customer ID </th>
					<th> Product ID</th>
					<th> Quantity</th>
					<th> Shipping ID</th>
					<th> Date Created</th>
					<th> Date Shipped</th>
					<th> Total Cost</th>
					<th> Status</th>
					<th> Action</th>
				</tr>   
			</thead>
			<tbody id="data">
			</tbody>
    	</table>
		<script>
			$.ajax({
		        url: "http://localhost:8080/eShopping/webapi/orders",
		        dataType: "text",
		        success: function(data) {
		            var json = $.parseJSON(data);
		            for (var i=0;i<json.length;++i)
		            {
		            	var pr = '<tr>' + 
				    				'<td>' + json[i].id + '</td>'+
				    				'<td>' + json[i].customerid + '</td>'+
				    				'<td>' + json[i].productid + '</td>'+
				    				'<td>' + json[i].quantity + '</td>'+
				    				'<td>' + json[i].shippingid + '</td>'+
				    				'<td>' + json[i].datecreated + '</td>'+
				    				'<td>' + json[i].dateshipped + '</td>'+
				    				'<td>' + json[i].totalcost + '</td>'+
				    				'<td>' + json[i].status + '</td>'+
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