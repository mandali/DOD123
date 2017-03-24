(function () {
    'use strict';


angular.module('MyApp').controller('MerchantRegiCtrl', MerchantRegiCtrl);

MerchantRegiCtrl.$inject = ['UserService', '$location', '$rootScope', 'FlashService'];

function MerchantRegiCtrl(UserService, $location, $rootScope, FlashService) {

var vm = this;
vm.merchantSignup = merchantSignup;
 
        function merchantSignup() {

            
            vm.dataLoading = true;
            console.log(vm.merchant);

            var headers = {
                'Content-Type':'application/json',
                'Access-Control-Allow-Origin':'*'
            };

            UserService.Create(vm.merchant).then(function (response) {

            /*    response.success(function(data, status, headers, config) {
                    FlashService.Success('Registration successful', true);
                    console.log('success')
                    $location.path('/dashboard');
                });

                response.error(function(data, status, headers, config) {
                    FlashService.Error(response.message);
                    vm.dataLoading = false;
                });*/



                    if (response.success) {
                        FlashService.Success('Registration successful', true);
                        $location.path('/login');
                    } else {
                        FlashService.Error(response.message);
                        console.log('errorrrr')
                        vm.dataLoading = false;
                    }
 

               });
        }
    }

})(); 