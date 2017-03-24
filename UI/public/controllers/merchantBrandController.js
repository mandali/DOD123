(function () {
    'use strict';

    angular.module('MyApp').controller('MerchantBrandController', MerchantBrandController);

    MerchantBrandController.$inject = ['UserService', '$rootScope','$scope','$location','FlashService','$uibModal', '$log','uiGridConstants'];
    function MerchantBrandController(UserService, $rootScope,$scope,$location,FlashService,$uibModal, $log,uiGridConstants) {
    	var vm = this;

    	vm.gridBrands= [];
        
    	initController();

    	function initController() {
            loadMerchantBrands();
            
        }

        function loadMerchantBrands() {
                /*vm.merchatid={
                    "merchantId":$rootScope.globals.currentUser.id
                };
                console.log(vm.merchatid);*/
                UserService.GetListBrands()
                .then(function (brands) {
                    vm.gridBrands.data = brands.data;
                	console.log(vm.gridBrands.data);
                });

        }/*end loadMerchantProducts method*/

        vm.gridBrands = {
            enableFiltering: false,
            enableSorting: true,
            showGridFooter: true,
            onRegisterApi: function(gridApi){
              vm.gridApi = gridApi;
              vm.gridApi.grid.registerRowsProcessor( vm.singleFilter, 200 );
            },
            columnDefs: [
              { field: 'brandId' },
              { field: 'brandName' },
              { field: 'brandDescription' },
              { field: 'brandRating' }
            ]
            
        };
        

    }/*end controller*/

})();