customerApp.controller('assignmentController', [ '$scope', 'assignmentService',

                                                 function($scope, assignmentService) {
	$scope.filelist = [];
	$scope.files;
	
	$scope.init = function(scope, element, attrs) {

	};

	$scope.reset = function() {
		alert("reset run");
		$scope.assignment = {};
		$scope.filelist = {};

	};
	
	$('#assignmentFile').change(function(event) {
		$scope.files = event.target.files;
		angular.forEach(event.target.files, function(value, key) {
			console.log("File Url : "+URL.createObjectURL(value)+"    File Name : "+value.name);
			$scope.filelist.push({
				"filePath" : URL.createObjectURL(value),
				"file" : value,
			});

		});
	});
 
	$scope.removeAttachment = function(filePath){
		angular.forEach($scope.filelist, function(file, key) {
			if(file.filePath == filePath){
				$scope.filelist.splice($scope.filelist.indexOf(file), 1);
			}
		});
	};
	$scope.init = function(scope, element, attrs) {
		$scope.findAll($scope);
	};
	$scope.findAll = function($scope){
		var response = assignmentService.findAll($scope);
    	 response.success(function(data){
    	 $scope.assignments = data;
    	 
	});
	}

	$scope.saveAssignment = function(assignment) {
		$scope.assignment = assignment;
		var response = assignmentService.saveAssignment($scope);
		response.success(function(data) {
			
			angular.forEach($scope.files, function(file, key) {
				//$scope.assignment.screenshots = $scope.filelist; //file.replace(/^.*[\\\/]/, '');
				var formData = new FormData();
				formData.append("id", data.id);
				formData.append("file", file);
				alert("-------");
				var uploadResponse = assignmentService.uploadAssignment($scope, formData);
				uploadResponse.success(function(){
					console.log("File Upload Success");
				}).error(function(){
					console.log("File Upload Error!");
				});
			});
		}).error(function() {
			alert("Error");
		});
	};

} ]);


customerApp.directive('myMaxlength', [
                                      '$compile',
                                      '$log',
                                      function($compile, $log) {
                                    	  return {
                                    		  restrict : 'A',
                                    		  require : 'ngModel',
                                    		  link : function(scope, elem, attrs, ctrl) {
                                    			  attrs.$set("ngTrim", "false");
                                    			  var maxlength = parseInt(attrs.myMaxlength, 10);
                                    			  ctrl.$parsers
                                    			  .push(function(value) {
                                    				  if (value.length > maxlength) {
                                    					  value = value.substr(0, maxlength);
                                    					  ctrl.$setViewValue(value);
                                    					  ctrl.$render();

                                    				  }
                                    				  return value;
                                    			  });
                                    		  }
                                    	  };
                                      } ]);



