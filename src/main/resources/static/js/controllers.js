
angular.module('myApp').controller('employer', function($scope, $http,$modal,$log,$state) {
	
	$scope.editTableData = {};
	$scope.addEmployer = false;
	$scope.init = function() {
		$http.get("/getEmployers").success(function(response) {
			$scope.employers = response;
			for(var j=0;j<$scope.employers.length;j++) {
				$scope.editTableData[j] = false;
			}
		});
	};
	
	
	
	$scope.addEmployerFunction = function() {
		$scope.addEmployer = false;
		$http.post("/addEmployer",$scope.newEmployer).success(function(data, status, headers, config) {
			$scope.employers.push(data);
			$scope.newEmployer.name="";
			$scope.newEmployer.city="";
			$scope.editTableData[data.id] = false;

		});
		
	};
	
	
	$scope.enableAddEmployer = function()  {
		$scope.addEmployer = true;
	};
	
	$scope.deleteEmployer = function(employer) {
		var modalInstance = $modal.open({
		      animation: $scope.animationsEnabled,
		      templateUrl: 'popUp.html',
		      controller: 'popupController',
		      resolve: {
		        employerData: function () {
		          return employer.name;
		        }
		      }
		    });
		
		modalInstance.result.then(function(result) {
			for(var i=0;i<$scope.employers.length;i++) {
				if($scope.employers[i].id == employer.id) {
					$http.get("/deleteEmployer?employerId="+employer.id).success(function() {
						$scope.employers.splice(employer.id,1);
					})
				}
			}
		});
		
	};
	
	$scope.editEmployer = function(employerId) {
		$scope.editTableData[employerId] = $scope.editTableData[employerId] == false ? true : false;
	};
	
	$scope.getEmployees = function(employerId) {
		var getUrl =  "/getEmployeesByEmployer/" + employerId;
		$http.get(getUrl).success(function(data, status, headers, config) {
			$scope.employees = data;
			$state.go("employers.employeePerEmployer",{"employerId" : employerId});
		});
	
	}
	
});

angular.module("myApp").filter(
		"ssn",
		function() {
			return function(value) {
				if (value) {
					if (value.length >= 9) {
						return value.substr(0, 3) + "-" + value.substr(3, 2)
								+ "-" + value.substr(5);
					} else if (value.length >= 5) {
						return value.substr(0, 3) + "-" + value.substr(3, 2)
								+ "-" + value.substr(5);
					} else if (value.length >= 3) {
						return value.substr(0, 3) + "-" + value.substr(3);
					}

				}
				return value;
			};
		});

angular.module("myApp").filter(
		"ssn",
		function() {
			return function(value) {
				if (value) {
					if (value.length >= 9) {
						return value.substr(0, 3) + "-" + value.substr(3, 2)
								+ "-" + value.substr(5);
					} else if (value.length >= 5) {
						return value.substr(0, 3) + "-" + value.substr(3, 2)
								+ "-" + value.substr(5);
					} else if (value.length >= 3) {
						return value.substr(0, 3) + "-" + value.substr(3);
					}

				}
				return value;
			};
		});

angular.module("myApp").directive("ssnDirective",function() {
	return { 
	link: function(scope, element, iAttrs) {
		var elementData = element.text();
		if (elementData.length >= 5) {
			element.text(elementData.substr(0, 3) + "-" + elementData.substr(3, 2)
					+ "-" + elementData.substr(5));
		} 
		
	}
	}
});


angular.module("myApp").controller('employee',function($http,$scope) {
	$http.get("/getAllEmployees").success(function(data, status, headers, config) {
		$scope.employees = data;
	})
});

angular.module('myApp').controller('popupController', function($scope,$log, $modalInstance,employerData) {
	
	
	$scope.employerId = employerData;
	$scope.ok = function(result) {
		$modalInstance.close(result);
	};
	
	$scope.cancel = function() {
			$modalInstance.dismiss('cancel');
	};
	
});
angular.module('myApp').controller('aboutController', function($scope) {
	$scope.contents = ['ANgularJS','Spring Boot','Spring Rest'];
});

angular.module('myApp').controller('proposalController',function($scope,$state){
	$scope.tabs = [ {
		heading : "Saved Proposals",
		route : "proposals.savedProposals",
		active : false
	}, {
		heading : "Shared Proposals",
		route : "proposals.sharedProposals",
		active : false
	}, {
		heading : "Broker Proposals",
		route : "proposals.sharedProposals",
		active : false
	} ];
	

	$scope.go = function(route){
		$state.go(route);
	};

	
	$scope.savedProposals = [{proposalId : "PROPOSAL-101",proposalName : "proposalSentInJan"},{proposalId : "PROPOSAL-102",proposalName:"proposalSentInFeb"}];
	$scope.sharedProposals = [{proposalId : "PROPOSAL-201",proposalName : "proposalSentInJan"},{proposalId : "PROPOSAL-202",proposalName:"proposalSentInFeb"}];

});
