microservice.service("successService", function($http, $location, loginService) {

	

	this.saveOrder = function(jwttoken,callback) {
		
		var responsePromise = $http({
			url : __env.orderserviceUrl+"/orders/createOrder",
			method : "POST",
			
			headers : {
				'Content-Type' : 'application/json',
				"jwttoken" : jwttoken
			}
		});

		responsePromise.success(function(data, status, headers, config) {
			alert("Inside Order service with jwt token");
	
			callback(data);

		});
		responsePromise.error(function(data, status, headers, config) {
			alert("AJAX failed! because no webservice is attached yet");
		});

	}
	
	
	
	
this.saveShipping = function(jwttoken,callback) {
		
		var responsePromise = $http({
			url :  __env.shippingserviceUrl+"/shipping/newShipping",
			method : "POST",
			
			headers : {
				'Content-Type' : 'application/json',
				"jwttoken" : jwttoken
			}
		});

		responsePromise.success(function(data, status, headers, config) {
			alert("Inside Shipping service with jwt token");
			callback(data);

		});
		responsePromise.error(function(data, status, headers, config) {
			alert("AJAX failed! because no webservice is attached yet");
		});

	}
	
	

});
