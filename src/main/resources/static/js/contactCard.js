angular.module('myApp').directive("contactCard", function() {
	return {
		restrict : 'AE',
		templateUrl: 'contactCard.html',
		controller : function($scope,$rootScope) {
			$scope.customer="asd";
		}
	}
})