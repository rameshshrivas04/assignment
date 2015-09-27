// create the module and name it scotchApp
var customerApp = angular.module('customerApp', [ 'ngRoute' ]);

customerApp
		.config([
				'$compileProvider',
				'$routeProvider',
				function($compileProvider, $routeProvider) {
					// $compileProvider.aHrefSanitizationWhitelist(/^\s*(http?|ftp|mailto|chrome-extension):/);
					$compileProvider
							.imgSrcSanitizationWhitelist(/^\s*(http?|local|data|file|blob):/);
					$routeProvider.when('/addAssignment', {
						templateUrl : 'assignment/pages/addAssignment.html',
						controller : 'assignmentController'
					})
					.when('/registration', {
						templateUrl : 'assignment/pages/registration.html',
						controller : 'registrationController'
					})
					.when('/user', {
						templateUrl : 'assignment/pages/user.html',
						controller : 'userController'
					})
					.when('/viewDetails', {
						templateUrl : 'assignment/pages/view03.html',
						controller : 'assignmentController'
					});
				} ]);

// configure our routes
/*
 * customerApp.config(function($routeProvider) { $routeProvider // route for the
 * home page // .when('/', { // templateUrl : 'customer/pages/dashboard.html',
 * //// controller : 'customerHomeController' // }).when('/addNewCustomer', { //
 * templateUrl : 'customer/pages/addCustomer.html', // controller :
 * 'customerController' // }) .when('/addAssignment', { templateUrl :
 * 'assignment/pages/addAssignment.html', controller : 'assignmentController' })
 * .when('/assignmentDetails', { templateUrl :
 * 'assignment/pages/assignmentDetails.html', controller :
 * 'assignmentDetailsController' }); });
 * 
 */
