<!DOCTYPE HTML>

<%@page import="com.bank.TransactionDetails"%>
<%@page import="java.util.ArrayList"%>
<html lang="zxx">
<head>
<title>Online Banking</title>
<!-- Meta tag Keywords -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Online Banking" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--// Meta tag Keywords -->
<!-- css files -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" /> <!-- Bootstrap-Core-CSS -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" /> <!-- Style-CSS --> 
<link rel="stylesheet" href="css/font-awesome.css"> <!-- Font-Awesome-Icons-CSS -->
<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="all" /> <!-- Banner-Slider-CSS -->
<!-- //css files -->
<link rel="stylesheet" type="text/css" href="css/demo.css"/>
<!-- online-fonts -->

<!-- //online-fonts -->
</head>
<body>

<div class="nav-links">	
		<div class="header-w3l">
			<div class="container">
				<a class="navbar-brand" href="#"><h1><span>Online</span> Banking</h1></a>
				<div class="call-w3l">
					<a class="navbar-brand" href="#"  style="padding-left: 120px;"><button type="button" class="btn btn-info" onclick="location.href='index.html';">Logout</button></a>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		<nav class="navbar navbar-inverse">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>                        
				</button>
			</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<div class="w3l-nav">
				<ul class="nav navbar-nav link-effect">
					<li class="active"><a href="#" id="aSum">Account Summary</a></li>
					<li><a href="#funds" class="scroll" id="traFund">Transfer Funds</a></li>
					<!-- <li><a href="#services" class="scroll">Update Address</a> -->
					<li class="dropdown">
				      <a data-toggle="dropdown" class="dropdown-toggle" href="#" id="update">Update Info 
						<b class="caret"></b>
						</a>
						<ul class="dropdown-menu">
						<li><a href="#" data-toggle="modal" data-target="#addModal">Update Address</a></li>
						<li><a href="#" data-toggle="modal" data-target="#logModal">Update Login Password</a></li>
						<li><a href="#" data-toggle="modal" data-target="#transModal">Update Transaction Password</a></li>
						</ul>
				      </li>
					<li><a href="#activity" class="scroll" id="activity">Account Activities</a></li>
				</ul>
			</div>
		</div>
	</nav>
	</div>
			<div class="clearfix"></div>
			
<%int bal = (Integer)request.getAttribute("balance");
	String name = (String)request.getAttribute("name");
	String type = (String)request.getAttribute("type");
	int accNo = (Integer)request.getAttribute("account");
	//TransactionDetails td = new TransactionDetails();
	ArrayList<TransactionDetails> tList = (ArrayList<TransactionDetails>) request.getAttribute("transDetails");
	
	
	int count = (Integer)request.getAttribute("count");
 %>		
 <%int msg = (Integer)request.getAttribute("MSG"); %>
 <%if(msg==1){ %>
 <div class="alert alert-success fade in alert-dismissable">
  <strong>Success!</strong> Transaction Successful.
</div>
 	<%} else if(msg==0){ %>
 	<div class="alert alert-danger fade in alert-dismissable">
  <strong>Danger!</strong> Transaction Unsuccessful due to insufficient balance or incorrect Transaction Password.
</div>
<%} else if(msg==3){ %>
 	<div class="alert alert-success fade in alert-dismissable">
  <strong>Success!</strong> Address Updated Successfully.
</div>
<%} else if(msg==4){ %>
 	<div class="alert alert-success fade in alert-dismissable">
  <strong>Success!</strong> Login Password Updated Successfully.
</div>
<%} else if(msg==5){ %>
 	<div class="alert alert-danger fade in alert-dismissable">
  <strong>Danger</strong>Error in Updating in Login Password.
</div>
<%} else if(msg==6){ %>
 	<div class="alert alert-success fade in alert-dismissable">
  <strong>Success</strong>Transaction Password Updated Successfully.
</div>
<%} else if(msg==7){ %>
 	<div class="alert alert-danger fade in alert-dismissable">
  <strong>Danger</strong>Error in Updating in Transaction Password.
</div>
<%} else { %>
<div style="visibility: hidden"></div>
<%} %>
<div class="container" style="padding-top: 150px; padding-bottom: 150px;" id="accSum">
<div class="card w-75">
  <div class="card-block">
    <h3 class="card-title">Account Information</h3>
    <p class="card-text" style="padding-top: 30px;">
    	Name:<%= name %>
    </p>
    <p class="card-text">
    	Account Number:<%= accNo %>
    </p>
    <p class="card-text">
    	Account Type:<%= type %>
    </p>
    <p class="card-text">
    	Account Balance:<%= bal %>
    </p>
  </div>
</div>
</div>

<!-- Update Address Modal -->
<div class="modal fade" id="addModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Update Address Form</h4>
        </div>
        <div class="modal-body">
          <form action="AddressServlet" role="form" method="post">
  			<div class="form-group">
		   	<label for="street">Enter Street Name:</label>
		    <input type="text" class="form-control" name="street" placeholder="Please Enter your Street Name" required>
		  	</div>
		  	<div class="form-group">
		    <label for="state">Enter State:</label>
		    <input type="text" class="form-control" name="state" placeholder="Please Enter your State" required>
		  	</div>
		  	<div class="form-group">
		    <label for="city">Enter City:</label>
		    <input type="text" class="form-control" name="city" placeholder="Please Enter your City" required>
		  	</div>
		  	<div class="form-group">
		    <label for="pin">Enter PIN Number:</label>
		    <input type="number" class="form-control" name="pin" placeholder="Please Enter your PIN number" required>
		  	</div>
		  		<div class="form-group" style="padding-left:250px;">
		  	<button type="submit" class="btn btn-info">Update</button>
		  	</div>
			</form>
        	</div>
      </div>
      
    </div>
  </div>

<!-- Update Login Modal -->  
<div class="modal fade" id="logModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Update Login Password Form</h4>
        </div>
        <div class="modal-body">
          <form action="LoginPassServlet" method="post" role="form">
  			<div class="form-group">
		   	<label for="lpwd">Enter Current Login Password:</label>
		    <input type="password" class="form-control" id="lpwd" name="lpwd" placeholder="Please Enter your Current Login Password" required>
		  	</div>
		  	<div class="form-group">
		    <label for="npwd">Enter New Login Password:</label>
		    <input type="password" class="form-control" id="npwd" name="npwd" placeholder="Please Enter your New Login Password" required>
		  	</div>
        	<div class="form-group">
          	<button type="submit" class="btn btn-info">Update</button>
        	</div>
        </form>
      </div>
      </div>
    </div>
  </div>

<!-- Update Transaction Modal -->
<div class="modal fade" id="transModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Update Transaction Password Form</h4>
        </div>
        <div class="modal-body">
          <form action="TransPwdServlet" method="post" role="form">
          
  			<div class="form-group">
		   	<label for="tpwd">Enter Current Transaction Password:</label>
		    <input type="password" class="form-control" id="tpwd" name="tpwd" placeholder="Please Enter your Current Transaction Password" required>
		  	</div>
		  	<div class="form-group">
		    <label for="ntpwd">Enter New Transaction Password:</label>
		    <input type="password" class="form-control" id="ntpwd" name="ntpwd" placeholder="Please Enter your New Transaction Password" required>
		  	</div>
        <div class="form-group">
          <button type="submit" class="btn btn-info">Update</button>
        </div>
        </form>
        </div>
      </div>
      
    </div>
  </div>  

<!-- Transfer Fund Div -->
<div class="container" style="padding-top: 150px; padding-bottom: 150px;" id="tfund">
	 <form action="TransferServlet" method="post" role="form">
		<div class="form-group">
	   	<label for="benAcc">Enter Beneficiary Account Number:</label>
	    <input type="number" class="form-control" name="benAcc" placeholder="Please Enter the Beneficiary Account Number">
	  	</div>
	  	<div class="form-group">
	    <label for="amt">Enter Amount to Transfer:</label>
	    <input type="number" class="form-control" name="amt" placeholder="Please Enter Amount">
	  	</div>
	  	<div class="form-group">
	    <label for="tpwd">Enter Transaction Password:</label>
	    <input type="password" class="form-control" name="tpwd" placeholder="Please Enter Transaction Password">
	  	</div>
	  	<button type="submit" class="btn btn-default">Submit</button>
	  	
	</form>
</div>
<div class="container" style="padding-top: 100px; padding-bottom: 100px;" id="accAct">
	<h3>Transaction Details</h3>
	 <table class="table table-hover">
     <thead>
      <tr>
        <th>Transaction Id</th>
        <th>Reference Number</th>
        <th>Account Number</th>
        <th>Transaction Type</th>
        <th>Transaction Date</th>
        <th>Amount Transfered</th>
      </tr>
    </thead>
    <tbody><%for(TransactionDetails td: tList) { %>
      <tr>
        <td><%= td.getTranscId() %></td>
        <td><%= td.getReferenceNo() %></td>
        <td><%= td.getAccNo() %></td>
        <td><%= td.getTranscType() %></td>
        <td><%= td.getTranscDateTime() %></td>
        <td><%= td.getTransferAmount() %></td>
      </tr>
      <%}%>
    </tbody>
  </table>
</div>
<!-- footer -->
<div class="footer-bot">
	<div class="container">
		<div class="logo2">
			<h2><a href="index.html"><span>Online</span> Banking</a></h2>
		</div>
		<div class="clearfix"></div>
	</div>
</div>
<div class="copy-right">
	<div class="agileinfo_social_icons">
		<ul class="agileits_social_list">
			<li><a href="#" class="w3_agile_facebook"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
			<li><a href="#" class="agile_twitter"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
			<li><a href="#" class="w3_agile_dribble"><i class="fa fa-instagram" aria-hidden="true"></i></a></li>
			<li><a href="#" class="w3_agile_google"><i class="fa fa-google-plus" aria-hidden="true"></i></a></li>
		</ul>
	</div>
	<div class="container">
		<p> &copy; 2017 Online Banking. All Rights Reserved</p>
	</div>
</div>
<!-- //footer -->
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script> <!-- Necessary-JavaScript-File-For-Bootstrap --> 
<!-- //js -->
<!-- js for banner -->
<!-- responsiveslider -->
	<script src="js/responsiveslides.min.js"></script>
		<script>
			// You can also use "$(window).load(function() {"
			$(function () {
			  // Slideshow 4
			  $("#slider3").responsiveSlides({
				auto: true,
				pager:true,
				nav:false,
				speed: 500,
				namespace: "callbacks",
				before: function () {
				  $('.events').append("<li>before event fired.</li>");
				},
				after: function () {
				  $('.events').append("<li>after event fired.</li>");
				}
			  });
		
			});
		 </script>
	<!-- //responsiveslider -->
	<!-- stats -->
<script type="text/javascript" src="js/numscroller-1.0.js"></script>
<!-- //stats -->
<!-- /js for banner -->
<!-- start-smoth-scrolling -->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event){		
			event.preventDefault();
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
		});
	});
</script>
<!-- start-smoth-scrolling -->
<!-- smooth scrolling -->
<script src="js/SmoothScroll.min.js"></script>
<!-- //smooth scrolling -->
<!-- smooth-scrolling-of-move-up -->
<script type="text/javascript">
	$(document).ready(function() {
		/*
		var defaults = {
			containerID: 'toTop', // fading element id
			containerHoverID: 'toTopHover', // fading element hover id
			scrollSpeed: 1200,
			easingType: 'linear' 
		};
		*/
		
		$().UItoTop({ easingType: 'easeOutQuart' });
		
	});

	$(document).ready(function(){
		$("#accSum").show();
        $("#tfund").hide();
        $("#accAct").hide()
    $("#traFund").hover(function(){
        $("#accSum").hide();
        $("#tfund").show();
        $("#accAct").hide();
    });
    $("#aSum").hover(function(){
        $("#accSum").show();
        $("#tfund").hide();
        $("#accAct").hide();
    });
    $("#activity").hover(function(){
        $("#accSum").hide();
        $("#tfund").hide();
        $("#accAct").show();
    });
    $("#update").hover(function(){
        $("#accSum").show();
        $("#tfund").hide();
        $("#accAct").hide();
    });
});
</script>
<!-- //smooth-scrolling-of-move-up -->  
<!-- video-js -->
<script src="js/jquery.vide.min.js"></script>
<!-- //video-js -->
<!--gallery-js -->
<script src="js/jquery.picEyes.js"></script>
				<script>
					$(function(){
						//picturesEyes($('.demo li'));
						$('.demo li').picEyes();
					});
				</script>
</body>
</html>