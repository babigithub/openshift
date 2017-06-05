microservice.service("loginService", function($http,__env) {
alert("in service"+__env.authserviceUrl);
	var responsePromise =null;
	var jwttoken = {};
	this.setJwttoken = function(Jwttokendata) {
		jwttoken = Jwttokendata;
	}

	this.getJwttoken = function() {
		return jwttoken;
	}


	var  isLogin ={}
	this.setIsUserLogin  =function(isUserloggedin){
		isLogin  = this.isUserloggedin;
	}
	
	this.getIsUserLogin  =function(){
		return isLogin;
	}
	
	this.authenticate = function(username, password, callback) {
		var user = {
				"username" : username,
				"password" : password
			};

		

		var responsePromise = $http({
			url :  __env.catalogueserviceUrl+"/catalogueService/login",
			method : "POST",
			data : user,
			headers : {
				'Content-Type' : 'application/json',
				'jwtToken' : jwttoken

			}
		});

		responsePromise.success(function(data, status, headers, config) {
			alert("Inside CatalogueService with jwt token::: " + data);
			callback(data);

		});
		responsePromise.error(function(data, status, headers, config) {
			alert("AJAX failed! because no webservice is attached yet");
		});

	}

	this.generateJwtToken = function(username, password, callback) {
		var user = {
			"username" : username,
			"password" : password
		};
if((username=="admin")&&(password=="admin")){
	
		responsePromise = $http({
			url : __env.authserviceUrl+"/loginService/generateToken",
			method : "POST",
			data : user,
			headers : {
				'Content-Type' : 'application/json'
			}
		});

}
else{
	
	alert("UserName or Password is wrong");
}
responsePromise.success(function(data, status, headers, config) {
			alert("Inside loginService jwtToken generation Sucess::: " + data);
			callback(data);

		});
		responsePromise.error(function(data, status, headers, config) {
			alert("AJAX failed! because no webservice is attached yet");
		});

	}

});
