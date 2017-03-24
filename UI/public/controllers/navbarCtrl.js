(function () {
    'use strict';

    angular.module('MyApp').controller('NavbarCtrl', NavbarCtrl);

    NavbarCtrl.$inject = ['$location', 'AuthenticationService', 'FlashService'];
    function NavbarCtrl($location, AuthenticationService, FlashService) {
    	/*var vm = this;
        AuthenticationService.GetMerchantAllInfo(vm.mobileno);*/
    }

})();