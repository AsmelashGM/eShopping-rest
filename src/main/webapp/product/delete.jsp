<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layoutpage>
	<jsp:attribute name="title">
      Delete a Product | 
    </jsp:attribute>
    
    <jsp:attribute name="header">
      Delete a Product
    </jsp:attribute>
    
    <jsp:body>
    	<h3 style="color: red; text-align:center">Are you sure you want to delete? | <a href="./"> &lt;&lt; back</a></h3>
    	<hr/>
    	<div id="fir"></div>
        <script>
        	var pid = location.search.split('pid=')[1];
			$.ajax({
		        url: "http://localhost:8080/eShopping/webapi/products/"+pid,
		        dataType: "text",
		        success: function(data) {
		            var json = $.parseJSON(data);
		            var pr = '<div class="col-md-6 col-md-offset-2 shopping-presentation">' +
					             '<img src="../_res/imgs/stuff/'+json.id+'.jpg" class="shopping-photo-lg" alt="' +json.name+ '"/> <br/>' +

						     '</div>' +
						     '<div class="col-md-4 well" style="background-color:transparent">' +
						     	'<Strong> Description: </Strong> ' + json.description + "<br/>" +
						     	'<Strong> Size: </Strong> ' + json.size + "<br/>" +
						     	'<Strong> Type: </Strong> ' + json.type + "<br/>" +
						     	'<Strong> Price: </Strong> ' + json.unitprice + " SEK <br/>" +
						     	'<Strong> Quantity: </Strong> ' + json.quantity + " available <br/><br/>" +
						     	'<form action="delete.jsp" method="post">'+
						     		'<button id="delete" class="btn btn-danger"> Delete </button> </form>' +
				     		  '</div>';
	            	$('#body').append(pr);
		        }
		    });
			
			
			$(function () {
			    $('#delete').on('click', function () {
			    	$.ajax({
						url: "http://localhost:8080/eShopping/webapi/products/"+pid,
					    type: 'DELETE',
					    success: function(result) {
					    	location.href = "/eShopping/product/";
					    }
					});
			    });
			});

		</script>
    </jsp:body>
</t:layoutpage>