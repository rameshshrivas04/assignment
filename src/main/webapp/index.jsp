<!DOCTYPE html>
<html lang="en" ng-app="customerApp">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>Test App</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/jquery-ui.css">
<link rel="stylesheet" href="css/bootstrap.css" media="screen">
<link rel="stylesheet" href="css/bootswatch.css">
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">

<link rel="stylesheet" href="css/customaizedcss.css">
<link
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel='stylesheet'>
	

</head>
<!-- define angular controller -->
<body>
	<div class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<a href="#" class="navbar-brand">CRM</a>
				<button class="navbar-toggle" type="button" data-toggle="collapse"
					data-target="#navbar-main">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
			</div>
			<div class="navbar-collapse collapse" id="navbar-main">
				<ul class="nav navbar-nav">
					<li class="#" data-toggle="dropdown"><a href="#">Dashboard</a></li>
					<li class="dropdown-toggle" data-toggle="dropdown"><a
						href="#viewDetails">View</a></li>
					<li class="dropdown-toggle" data-toggle="dropdown"><a
						href="#addAssignment">Assignment</a></li>

					<li class="dropdown-toggle" data-toggle="dropdown"><a
						href="#user">User</a></li>
				</ul>
				<!-- <ul class="nav navbar-nav navbar-right">
					<li><a href=" ">Built With Bootstrap</a></li>
					<li><a href="index1.html">WrapBootstrap</a></li>
				</ul>
 -->
			</div>
		</div>
	</div>

	<div id="main">
		<div class="container">
			<!-- angular templating -->
			<!-- this is where content will be injected -->
			<div ng-view></div>
		</div>
	</div>
	<!-- api js -->
	<script src="js/myScript.js"></script>
	<script src="js/jquery-1.js"></script>
	<script src="js/bootstrap.js"></script>
	<script src="js/bootswatch.js"></script>
	<script src="js/angular.min.js"></script>
	<script src="js/angular-route.js"></script>
	<script src="https://code.angularjs.org/1.3.0-rc.2/angular-messages.js"></script>
	<!-- Angular Route Provide and Module -->
	<script src="app/customerApp.js"></script>

	<!-- Angular Controller -->
	<script src="customer/controller/customerController.js"></script>
	<script src="assignment/controller/assignmentController.js"></script>
	<script src="assignment/controller/registrationController.js"></script>
	<script src="assignment/controller/userController.js"></script>
	
	<script src="assignment/pages/script.js" type="text/javascript"></script>

	<!-- Angular Service -->

	<script src="customer/service/customerService.js"></script>
	<script src="assignment/service/assignmentService.js"></script>
	<script src="assignment/service/userService.js"></script>

	<script src="assignment/validator/messageService.js"></script>

</body>
</html>
