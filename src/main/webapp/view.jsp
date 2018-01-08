<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<jsp:include page="var.jsp" />
<t:genericpage>
	<jsp:attribute name="title">
      View a Product | 
    </jsp:attribute>
    
    <jsp:attribute name="header">
      View Product Details
    </jsp:attribute>
    <jsp:attribute name="cart">
    3
    </jsp:attribute>
    
    <jsp:body>
    	<br/>
        <script>
        	var pid = location.search.split('pid=')[1];
			$.ajax({
		        url: "http://localhost:8080/eShopping/webapi/products/"+pid,
		        dataType: "text",
		        success: function(data) {
		            var json = $.parseJSON(data);
		            var pr = '<div class="col-md-6 col-md-offset-2 shopping-presentation">' +
					             '<img src="_res/imgs/stuff/'+json.id+'.jpg" class="shopping-photo-lg" alt="' +json.name+ '"/> <br/>' +

						     '</div>' +
						     '<div class="col-md-4 well" style="background-color:transparent">' +
						     	'<Strong> Description: </Strong> ' + json.description + "<br/>" +
						     	'<Strong> Size: </Strong> ' + json.size + "<br/>" +
						     	'<Strong> Type: </Strong> ' + json.type + "<br/>" +
						     	'<Strong> Price: </Strong> ' + json.unitprice + " SEK <br/>" +
						     	'<Strong> Quantity: </Strong> ' + json.quantity + " available <br/><br/>" +
						     	'<form method="GET" action="cart.jsp?pid='+pid+'"> <button class="btn btn-success"> Buy </button> </form>' +
				     		  '</div>';
	            	$('#body').append(pr);
		        }
		    });
		</script>
    </jsp:body>
</t:genericpage>