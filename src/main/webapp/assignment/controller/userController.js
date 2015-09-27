customerApp.controller('userController', [ '$scope', 'userService',

function($scope, userService) {
	$scope.userList = [];

	$scope.init = function(scope, element, attrs) {
		userService.findAllUsers().success(function(data) {
			$scope.userList = data;
		}).error(function() {
			alert("Error : fetching error");

		});

	};
	$scope.saveUser = function(user) {

		if (user.password == user.retypePassword) {
			user.password = atob(user.password);
			userService.saveUser(user).success(function(data) {
				if (user.id) {
					angular.forEach($scope.userList, function(userFromList) {
						if (userFromList.id === data.id) {
							userFromList.fullName = data.fullName;
							userFromList.username = data.username;
							userFromList.password = data.password;
							userFromList.retypePassword = data.retypePassword;
							userFromList.role = data.role;
							userFromList.isActive = data.isActive;
						}

					});
				} else {
					$scope.userList.push(user);
				}
				$scope.user = {};
			}).error(function() {
				alert("Error : not able to save data now.");
			});
			$scope.areaStatus = true;
			 $(".alert-success").fadeTo(2000, 500).slideUp(500, function(){
		         $(".alert-success").alert('close');
		          });
		}else{
			 $scope.areaStatus = false;
			 $(".alert-danger").fadeTo(2000, 500).slideUp(500, function(){
		         $(".alert-danger").alert('close');
		          });
		}

		// var a = atob(user.fullName);
		// console.log((a));
		// console.log((btoa(a)));

	};
	$scope.editUser = function(user) {
		$scope.user = angular.copy(user);
	};
	$scope.resetUser = function(user) {
		$scope.user = {};
	};
	 
} ]);
