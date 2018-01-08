<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
	<jsp:attribute name="title">
      Login | 
    </jsp:attribute>
    
    <jsp:attribute name="header">
      Login form
    </jsp:attribute>
    <jsp:attribute name="cart">
    3
    </jsp:attribute>
    
    <jsp:body>
	    <div class="clo-md-4 col-md-offset-4 form-inline">
	    	<form class="form-inline" method="post" action="login.jsp"> <br/>
	    		Username: <input type="text" class="form-control" placeholder="Username" id="username" name="username"/> <br/> <br/>
	    		Password: <input type="password" class="form-control" placeholder="Password" id="username" name="username"/> <br/><br/>
	    		&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp; <button class = "btn btn-success btn-lg">Login</button>
	    	</form>
	    </div>
	    
    	<script>
        	var pid = location.search.split('pid=')[1];
        	$('button').click(function(){  
        		$.ajax({
		        url: "http://localhost:8080/eShopping/webapi/products/"+pid,
		        dataType: "text",
		        success: function(data) {
		            var json = $.parseJSON(data);
		        }
		    });
            location.href = "/eShopping/product/";
        	}); 
        	
		</script>
    </jsp:body>
</t:genericpage>