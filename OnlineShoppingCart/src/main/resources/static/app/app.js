
var env = {};

//Import variables if present (from env.js)
if(window){  
Object.assign(env, window.__env);
}

var microservice = angular.module('microservice', ['ngRoute', 'ngCookies']);


//Define AngularJS application


//Register environment in AngularJS as constant
microservice.constant('__env', env);

function disableLogging($logProvider, __env){  
	  $logProvider.debugEnabled(__env.enableDebug);
	}

	// Inject dependencies
	disableLogging.$inject = ['$logProvider', '__env'];

	microservice.config(disableLogging);  




microservice.config(['$routeProvider', function($routeProvider) {
	
	$routeProvider

	.when('/', {

		templateUrl : 'views/home.html',
		controller : 'homeController'
	})

	
	.when('/home', {

		templateUrl : 'views/home.html',
		controller : 'homeController'
	})

	

	.when('/login', {
		templateUrl : 'views/login.html',
		controller : "loginController"

	})
	
.when('/success', {
		templateUrl : 'views/success.html',
		controller : "successController"

	})
	.when('/order', {
		templateUrl : 'views/order.html',
		controller : "orderController"

	})
	
	.when('/shipping', {
		templateUrl : 'views/shipping.html',
		controller : "shippingController"

	})
	

	

	
	
	.when('/logout', {
		templateUrl : 'views/home.html',
		controller : "homeController"

	})
	
	
	

	.otherwise({
		redirectTo : '/'

	});
	
	
	
}

]);

