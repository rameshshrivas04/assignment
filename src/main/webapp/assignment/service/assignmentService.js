customerApp.service('assignmentService', [ "$http", function($http) {
	this.findAll = function($scope) {
		return $http({
			url : 'assignment/findAll',
			method : "GET",
			headers : {
				'Content-Type' : 'application/json'
			},

		});
	};

	this.saveAssignment = function($scope) {
		return $http({
			url : 'assignment/add',
			method : "POST",
			headers : {
				'Content-Type' : 'application/json'
			},
			data : angular.toJson($scope.assignment)
		});
	};

	this.uploadAssignment = function($scope, formData) {
		// formData.append("assignment", angular.toJson($scope.assignment));

		return $http({
			url : 'assignment/uploadFile',
			method : "POST",
			headers : {
				'Content-Type' : undefined
			},
			data : formData,
			transformRequest : function(data, headersGetterFunction) {
				return data;
			}
		});
	};

} ]);