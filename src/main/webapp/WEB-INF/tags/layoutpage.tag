<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="title" fragment="true" %>
<%@attribute name="header" fragment="true" %>
<html>
	<head>
		<title><jsp:invoke fragment="title"/> eShopping</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="shortcut icon" type="image/png" href="../_res/imgs/logo.PNG" />
		<link href="../_res/css/bootstrap.min.css" rel="stylesheet" />
		<link href="../_res/css/Site.css" rel="stylesheet"/>
		<script src="../_res/js/jquery-latest.js"></script>
	</head>
  <body>
        <div class="container">
            <!-- STARTING OF HEADER LAYOUT -->
            <div class="row col-md-12 padding-top-5">
                <div class="col-md-4">
                    <a href="/eShopping/">
                        <img src="../_res/imgs/banner.PNG" alt="eShopping"/> 
                    </a>
                </div>
                
                <div class="col-md-8  padding-top-10 text-right">
                    <div class="col-md-6 text-right" style="margin-top:30px;">
						<a href="/eShopping/product/">Product</a> | 
						<a href="/eShopping/order/">Order</a> | 
						<a href="/eShopping/shipment/">Shipment</a> | 
						<a href="/eShopping/customer/">Customer</a> | 
						<a href="/eShopping/cart/">Cart</a>
                    </div>
                    <div class="col-md-6 text-right">
                        <div class="col-md-12 margin-bottom-15">
                            <a href="../user/logout.jsp"> 
                                Logout
                            </a>
                        </div>

                        <div class="col-md-12">
                            <a href="register.jsp"> 
                                Admin
                            </a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row col-md-12">
                <hr class="hr-decorated"/>
            </div>
            <!-- END OF HEADER LAYOUT -->
            
            <!--.................................................................-->
            
            <!-- BODY PART -->
            <div class="row col-md-12">
                <h2 class="text-center"><jsp:invoke fragment="header"/></h2>
                
                <div id="body">
			      <jsp:doBody/>
			    </div>
                
            </div>
            <!-- END OF BODY -->
            
            <!--.................................................................-->
            
            <!-- FOOTER -->
            <div class="row col-md-12 text-center">
                <hr/>
                &copy; 2018. eShopping.dev
            </div>
            <!-- END OF FOOTER -->
        </div>
  </body>
</html>
