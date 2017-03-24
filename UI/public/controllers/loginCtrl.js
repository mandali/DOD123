(function () {
    'use strict';

    angular
        .module('MyApp')
        .controller('LoginController', LoginController);

    LoginController.$inject = ['$location', '$rootScope','AuthenticationService', 'FlashService','UserService'];

    function LoginController($location,$rootScope,AuthenticationService, FlashService,UserService) {
        var vm = this;
        $rootScope.merchant = {};

        /*vm.merchant = {};*/

        vm.merchantLogin = merchantLogin;

        (function initController() {
            // reset login status
            AuthenticationService.ClearCredentials();
        })();

        function merchantLogin() {
            vm.dataLoading = true;

            AuthenticationService.Login(vm.mobileno, vm.password)
              .success(function(res) {

                /*AuthenticationService.SetCredentials(vm.mobileno, vm.password);

                console.log(res.data.data.mobilenumber);
                console.log(res.data.data.password);
                $rootScope.merchant = res.data.data;
                console.log($rootScope.merchant);*/
                
                console.log(res.data.data);
                console.log(vm.password);

                AuthenticationService.SetCredentials(res.data.data,vm.password);
                              
                FlashService.Success('LoggedIn successful', true);
                $location.path('/dashboard/promotions');
              })
              .error(function(err) {
                console.log(err);
                FlashService.Error(err.data.message);
                vm.dataLoading = false;
              });

        };
    }

})();
