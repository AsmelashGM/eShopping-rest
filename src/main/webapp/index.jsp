<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
	<jsp:attribute name="title">
      Welcome to shop | 
    </jsp:attribute>
    
    <jsp:attribute name="header">
      Shop online!
    </jsp:attribute>
    <jsp:attribute name="cart">
    3
    </jsp:attribute>
    
    <jsp:body>
        <script>
			$.ajax({
		        url: "http://localhost:8080/eShopping/webapi/products",
		        dataType: "text",
		        success: function(data) {
		            var json = $.parseJSON(data);
		            for (var i=0;i<json.length;++i)
		            {
		            	var pr = '<div class="col-md-3 shopping-presentation">' +
						         '<a href="view.jsp?pid='+ json[i].id + '">'+
						             '<img src="_res/imgs/stuff/'+json[i].id+'.jpg" class="shopping-photo-md" alt="' +json[i].name+ '"/> <br/>' +
						         '</a>' +
						         '<span id="results">' +
						         	 json[i].description + '<br>' +
						             '<span class="float-left shopping-cost">' + json[i].unitprice + ' SEK </span>' +
						             '<a href="http://localhost:8080/eShopping/webapi/products/'+json[i].id+'" class="float-right btn btn-xs btn-success"> Buy </a>' +
						         '</span>'+ 
						     '</div>';	
		            	$('#body').append(pr);
		                
		            }
		        }
		    });
		</script>
    </jsp:body>
</t:genericpage>