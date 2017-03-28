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
        

    	vm.updatePromotion = function () {

    		console.log('updating Promotion..');

            var headers = {
                'Content-Type':'application/json',
                'Access-Control-Allow-Origin':'*'
            };
            vm.promotionId= vm.promotion.id;

            vm.editPromotionObject = {
                "merchatid":$rootScope.globals.currentUser.id,
                "pId":vm.promotion.product_id,
                "catid":""+vm.promotion.catid,
                "brandId":""+vm.promotion.brandId,
                "discount":vm.promotion.discount,
                "originalPrice":vm.promotion.originalPrice,
                "discountText":vm.promotion.discountText,
                "description":vm.promotion.description,         
                "locationId":vm.promotion.locationId
            };
            console.log('after updated promotion object');
            console.log(vm.editPromotionObject);

            UserService.EditPromotion(vm.editPromotionObject,vm.promotionId).then(function (response) {
                if (response.success) {
                    /*FlashService.Success('Promotion Posted successful', true);*/
                    row.entity = angular.extend(row.entity, vm.promotion);
                    console.log(response);                  
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