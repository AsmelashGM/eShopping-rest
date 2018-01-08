<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layoutpage>
	<jsp:attribute name="title">
      Update a Product | 
    </jsp:attribute>
    
    <jsp:attribute name="header">
      Update a Product | <a href="./"> &lt;&lt; back</a>
    </jsp:attribute>
    
    <jsp:body>
    	<hr/>
        <form class="">
    		<div class="clo-md-4 col-md-offset-4 input-group  form-inline">
    			<table class="table" style="border:none !important;">
    				<tr> 
    					<td> <label>Product name:  </label> </td>
    					<td> <input type="text" class="form-control" id="name" name="name"  required="required"/> </td>
    				</tr>
    				
    				<tr> 
    					<td> <label>Description: </label> </td>
    					<td> <input type="text" class="form-control" id="description" name="description"  required="required"/> </td>
    				</tr>
    				
    				<tr> 
    					<td> <label>Type: </label> </td>
    					<td> <input type="text" value="Shoe" class="form-control" id="type" name="type"  required="required"/> </td>
    				</tr>
    				
    				<tr> 
    					<td>  <label>Measurement unit: </label> </td>
    					<td> <input type="text" value="number" class="form-control" id="measurement" name="measurement"  required="required"/> </td>
    				</tr>
    				
    				<tr> 
    					<td> <label>Unit Price: </label> </td>
    					<td> <input type="text" class="form-control"id="unitprice" name="unitprice" required="required"/> </td>
    				</tr>
    				
    				<tr> 
    					<td> <label>Quantity: </label> </td>
    					<td> <input type="text" class="form-control" id="quantity" name="quantity" /> </td>
    				</tr>
    				
    				<tr> 
    					<td> <label>Size: </label> </td>
    					<td> <input type="text" class="form-control" id="size" name="size"/> </td>
    				</tr>
    				
    				<tr style="text-align:center"> 
    					<td> </td>
    					<td> <button class = "btn btn-warning btn-lg">Update Product</button> </td>
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
</t:layoutpage>