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
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">


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
					<li class="dropdown-toggle" data-toggle="dropdown">
					<a href="#">Dashboard</a></li>
					<li class="dropdown-toggle" data-toggle="dropdown">
					<a href="#addNewCustomer">Add New</a></li>
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

	<script src="js/jquery-1.js"></script>
	<script src="js/bootstrap.js"></script>
	<script src="js/bootswatch.js"></script>
	<script src="js/angular.min.js"></script>
	<script src="js/angular-route.js"></script>
	<script src="js/angular-cookies-1.2.3.js"></script>
	<script src="js/angular-resource-1.2.3.js"></script>

	<script src="app/customerApp.js"></script>
	<script src="customer/controller/customerController.js"></script>
	<script src="customer/service/customerService.js"></script>

</body>
</html>
