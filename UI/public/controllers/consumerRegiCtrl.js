var  consumerRegApp= angular.module("MyApp");

consumerRegApp.controller("consumerRegiCtrl", ['$scope', '$http', function($scope, $http) {

	$scope.consumers = [];

	$scope.consumerSubmit= function(){

			var headers = {
				'Content-Type':'application/json',
				'Access-Control-Allow-Origin':'*'
			}
			var consumerObj = {
					email_id:$scope.email_id, 
					phone_no: $scope.phone_no, 
					city:$scope.city,
					age:$scope.age, 
					password: $scope.password, 
					confirmpassword:$scope.confirmpassword
			};

			console.log(consumerObj);

			var res = $http.post("http://54.193.11.3:8080/DODSample/consumerRegistration", consumerObj);
			
			res.success(function(data, status, headers, config) {
				alert(JSON.stringify(consumerObj));
				alert("success !!")
				$scope.consumers.push(data);
			});

			res.error(function(data, status, headers, config) {
				alert( "Exception details: " + JSON.stringify({data: data}));
			});
	

		$scope.email_id='';
		$scope.phone_no='';
		$scope.city='';
		$scope.age='';
		$scope.password='';
		$scope.confirmpassword='';
	}

}]);