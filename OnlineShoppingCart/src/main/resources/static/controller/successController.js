microservice.controller('successController',function($scope,$location,$route, loginService,$cookieStore,successService,$rootScope) {
	
	$rootScope.isLogin = true;
	$rootScope.isLogout=true;
	
	$scope.logout=function(){
		
		$location.path("/logout");
		 $route.reload();
		 window.location.reload(); 
	};

	$scope.showSuccess = function() {
		   var jwtcookie =$cookieStore.get('cookiejwtToken');
		   if (jwtcookie != null) {
			  
			 
			   $scope.msg=jwtcookie;
			   
			   
		   }
		   else{
			   $location.path("/logout");
				 $route.reload();
				 window.location.reload(); 
			   
		   }
		   }
	$scope.cancel = function() {
		$location.path("/");
		 $route.reload();
		 window.location.reload(); 
	};
	
	

	
	$scope.order = function() {
		var jwtcookie =$cookieStore.get('cookiejwtToken');
		if (jwtcookie != null) {
			successService.saveOrder(jwtcookie, function(data) {
				if((data != null)){
					$location.path("/order");
					window.location.reload(); 
				}else {
							$location.path("/login");
							$scope.error = true;
						}
					});
		}
	}
	
	$scope.shipping = function() {
		var jwtcookie =$cookieStore.get('cookiejwtToken');
		if (jwtcookie != null) {
			successService.saveShipping(jwtcookie, function(data) {
				if((data != null)){
					
					$location.path("/shipping");
					window.location.reload(); 
				}else {
							$location.path("/login");
							$scope.error = true;
						}
					});
		}
	}


});
