angular.module('myApp', ['ui.router','ngAnimate','ui.bootstrap']).config(function($stateProvider,$urlRouterProvider) {

	$stateProvider.state('employers',{
		url : "/employers",
		templateUrl: "employers.html",
		controller: "employer"
	})
	
	.state('employers.employeePerEmployer',{
		url : "/employer/:employerId/employees",
		templateUrl: "employerEmployees.html",
		controller: "employer"
	})
	
	.state('employees',{
		url : "/employees",
		templateUrl: "employees.html",
		controller: "employee"
	})
	.state('about', {
            url:'/about',
            templateUrl: 'about.html',
            controller: 'aboutController'
     })
	.state('proposals', {
            url:'/proposals',
            templateUrl: 'proposal.html',
            controller: 'proposalController'
     })
	.state('proposals.savedProposals', {
            url:'/savedProposals',
            templateUrl: 'savedProposals.html',
            controller: 'proposalController'
     })
     .state('proposals.sharedProposals', {
            url:'/sharedProposals',
            templateUrl: 'sharedProposals.html',
            controller: 'proposalController'
     });
	$urlRouterProvider.otherwise("/employers");
	
});
