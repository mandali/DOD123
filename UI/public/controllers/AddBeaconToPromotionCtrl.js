(function () {
    'use strict';

    angular.module('MyApp').controller('AddBeaconToPromotionCtrl', AddBeaconToPromotionCtrl);

    AddBeaconToPromotionCtrl.$inject = ['UserService', '$rootScope','$scope','$location','FlashService','$uibModal', '$log','$uibModalInstance','promotion_id','elem'];

    function AddBeaconToPromotionCtrl(UserService, $rootScope,$scope,$location,FlashService,$uibModal, $log,$uibModalInstance,promotion_id,elem) {
    	var vm = this;

    	vm.form = {};
        vm.promotion_id = promotion_id;
        vm.merchantBeacons= [];
        vm.merchantailes = [];

        initController();
        function initController() {
            loadMerchantBeacons();
            loadMerchantAiles();
        }

        function loadMerchantBeacons() {
                /*vm.merchatid={
                    "merchantId":$rootScope.globals.currentUser.id
                };
                console.log(vm.merchatid);*/
                vm.merchatid={
                    "merchantId":$rootScope.globals.currentUser.id
                };

                UserService.GetMerchantBeacons(vm.merchatid)
                .then(function (beacons) {
                    console.log(beacons.data);
                    vm.merchantBeacons = beacons.data
                    console.log(vm.merchantBeacons);
                    
                });

        }/*end loadMerchantProducts method*/


        function loadMerchantAiles() {
                vm.merchatid={
                    "merchantId":$rootScope.globals.currentUser.id
                };
                console.log(vm.merchatid);
                UserService.GetMerchantAiles(vm.merchatid)
                .then(function (ailes) {
                    console.log(ailes.data);
                    vm.merchantailes = ailes.data;
                    console.log(vm.merchantailes);
                    
                });
        }


    	vm.submitAddPromotionToBeacon = function () {

    		console.log('fdsdfsdf');

            var headers = {
                'Content-Type':'application/json',
                'Access-Control-Allow-Origin':'*'
            };
            vm.addPromotionToBeaconObject = {
                "merchantId":$rootScope.globals.currentUser.id,
                "promotionId":""+vm.promotion_id,
                "beaconId":vm.beaconId,
                "aisleId":vm.aisleId
            };
            console.log('after addpromotion to beacon');
            console.log(vm.addPromotionToBeaconObject);

            UserService.AddPromotionToBeacon(vm.addPromotionToBeaconObject).then(function (response) {
                if (response.success) {
                    /*FlashService.Success('Promotion Posted successful', true);*/
                    /*loadMerchantPromotions();*/
                    /*vm.resetPromotionForm();*/
                    /*$('#btn-dy').text('Added');
                    $("#btn-dy").css("background-color","green");*/
                    /*$location.path('dashboard/promotions');*/
                    console.log(elem);
                    /*elem.innerText = "Added";*/
                    /*$('#btn-dy').text('Added');*/
                    $uibModalInstance.close('closed');

                } else {
                    FlashService.Error(response.message);
                    console.log('errorrrr')
                    $uibModalInstance.close('closed');
                    vm.dataLoading = false;
                }
            });

    		
        /*if (vm.form.userForm) {
            console.log('user form is in scope');
            console.log(vm.addBeaconToPromotionform.userForm);
            $uibModalInstance.close('closed');
        } else {
            console.log('userform is not in scope');
        }*/
    };

    vm.cancel = function () {
        $uibModalInstance.dismiss('cancel');
    };

    }

})();