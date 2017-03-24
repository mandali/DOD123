(function () {
    'use strict';

    angular.module('MyApp').controller('EditMerchantPromotionCtrl', EditMerchantPromotionCtrl);

    EditMerchantPromotionCtrl.$inject = ['UserService', '$rootScope','$scope','$location','FlashService','$uibModal', '$log','$uibModalInstance','grid','row'];

    function EditMerchantPromotionCtrl(UserService, $rootScope,$scope,$location,FlashService,$uibModal, $log,$uibModalInstance,grid,row,PromotionSchema) {
    	var vm = this;


        initController();
        function initController() {
            
        }

        vm.promotion = angular.copy(row.entity);
        

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
                    console.log(elem);                   
                    $uibModalInstance.close('closed');

                } else {
                    FlashService.Error(response.message);
                    console.log('errorrrr')
                    $uibModalInstance.close('closed');
                    vm.dataLoading = false;
                }
            });

    };

    vm.cancel = function () {
        $uibModalInstance.dismiss('cancel');
    };

    }

})();