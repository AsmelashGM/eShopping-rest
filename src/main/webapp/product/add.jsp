<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layoutpage>
	<jsp:attribute name="title">
      Add New Product | 
    </jsp:attribute>
    
    <jsp:attribute name="header">
      Add New Product | <a href="./"> &lt;&lt; back</a>
    </jsp:attribute>
    
    <jsp:body>
    	<form method="post" action="add.jsp">
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
    					<td> <button class = "btn btn-success btn-lg">Add Product</button> </td>
    				</tr>
    			</table>
	    	</div>
    	</form>
   		<script type="text/javascript">
			 $('button').click(function(){  
				 var name = document.getElementById("name").value;
				 var description = document.getElementById("description").value;
				 var type = document.getElementById("type").value;
				 var measurement = document.getElementById("measurement").value;
				 var unitprice = document.getElementById("unitprice").value;
				 var quantity = document.getElementById("quantity").value;
				 var size = document.getElementById("size").value;
				 var id = 11;
				 var img = "12.jpg";
				 var JSONObj = '{'+'id':id, 'name':name,'description':description, 'type':type, 'measurement':measurement,'unitprice':unitprice, 'quantity':quantity, 'size':size, 'img':img +'}';

				 
			     $.ajax({  
			         url:'http://localhost:8080/eShopping/webapi/products',  
			         type:'post',  
			         dataType: 'JSON',
			         contentType: "application/json",
			         data: JSON.stringify(JSONObj),
			         success: function(data) { 
						 alert("I am an alert box!");
			         }
			     error(){
			    	  window.location='thank-you.html';
			     }
			     }); 
		     });  
		</script>  
    </jsp:body>
</t:layoutpage>