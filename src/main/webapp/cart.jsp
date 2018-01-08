<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
	<jsp:attribute name="title">
      Add to Carts | 
    </jsp:attribute>
    <jsp:attribute name="cart">
    3
    </jsp:attribute>
    
    <jsp:body>
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
</t:genericpage>