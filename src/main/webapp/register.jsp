<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
	<jsp:attribute name="title">
      Customer Registration | 
    </jsp:attribute>
    
    <jsp:attribute name="header">
      Customer Registration form
    </jsp:attribute>
    <jsp:attribute name="cart">
    3
    </jsp:attribute>
    
    <jsp:body>
	    	<form class="">
    		<div class="clo-md-4 col-md-offset-4 input-group  form-inline">
    			<table class="table" style="border:none !important;">
    				<tr> 
    					<td> <label>Full name:  </label> </td>
    					<td> <input type="text" class="form-control" id="name" name="name"  required="required"/> </td>
    				</tr>
    				
    				<tr> 
    					<td> <label>Username: </label> </td>
    					<td> <input type="text" class="form-control" id="username" name="username"  required="required"/> </td>
    				</tr>
    				
    				<tr> 
    					<td> <label>Password: </label> </td>
    					<td> <input type="password" class="form-control" id="password" name="password"  required="required"/> </td>
    				</tr>
    				
    				<tr> 
    					<td>  <label>Repeat Password: </label> </td>
    					<td> <input type="password" class="form-control" id="confpass" name="confpass"  required="required"/> </td>
    				</tr>
    				
    				<tr> 
    					<td> <label>Email: </label> </td>
    					<td> <input type="email" class="form-control"id="email" name="email" required="required"/> </td>
    				</tr>
    				
    				<tr> 
    					<td> <label>Address: </label> </td>
    					<td> <input type="text" class="form-control" id="address" name="address" /> </td>
    				</tr>
    				
    				<tr> 
    					<td> <label>Credit Card Info: </label> </td>
    					<td> <input type="text" class="form-control" id="creditcardinfo" name="creditcardinfo"/> </td>
    				</tr>
    				
    				<tr> 
    					<td> <label>Shipping Info: </label> </td>
    					<td> <input type="text" class="form-control" id="shippinginfo" name="shippinginfo"/> </td>
    				</tr>
    				
    				<tr style="text-align:center"> 
    					<td> </td>
    					<td> <button class = "btn btn-success btn-lg">Register</button> </td>
    				</tr>
    			</table>
	    	</div>
    	</form>
    	<script>
        	var pid = location.search.split('pid=')[1];
        	$('button').click(function(){  
        		$.ajax({
		        url: "http://localhost:8080/eShopping/webapi/products/"+pid,
		        dataType: "text",
		        success: function(data) {
		            var json = $.parseJSON(data);
		            $('#name').val(json.name);  
		            $('#description').val(json.description);  
		            $('#type').val(json.type);  
		            $('#measurement').val(json.measurement);  
		            $('#unitprice').val(json.unitprice);  
		            $('#quantity').val(json.quantity);  
		            $('#size').val(json.size);  
		        }
		    });
        	}); 
		</script>
    </jsp:body>
</t:genericpage>