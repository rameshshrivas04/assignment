customerApp.service('userService', [ "$http", function($http) {

	this.saveUser = function(user) {
		return $http({
			url : 'user/add/',
			method : "POST",
			headers : {
				'Content-Type' : 'application/json'
			},
			data : user
		});
	};
	this.findAllUsers = function() {
		return $http({
			url : 'user/findAll/',
			method : "GET",
			headers : {
				'Content-Type' : 'application/json'
			},
 		});
	};
} ]);