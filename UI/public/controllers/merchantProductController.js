(function () {
    'use strict';

    angular.module('MyApp').controller('MerchantProductController', MerchantProductController);

    MerchantProductController.$inject = ['UserService', '$rootScope','$scope','$location','FlashService','$uibModal', '$log','uiGridConstants'];
    function MerchantProductController(UserService, $rootScope,$scope,$location,FlashService,$uibModal, $log,uiGridConstants) {
    	var vm = this;

    	vm.gridProducts= [];
        vm.merchantProduct = merchantProduct;

    	initController();
    	function initController() {
            loadMerchantProducts();
        }

        function loadMerchantProducts() {
                vm.merchatid={
                    "merchantId":$rootScope.globals.currentUser.id
                };
                console.log(vm.merchatid);
                UserService.GetMerchantProducts(vm.merchatid)
                .then(function (products) {
                	console.log(products.data);
                    vm.gridProducts.data = products.data[0].merchantProducts;
                    console.log(vm.gridProducts.data);
                    
                });

        }/*end loadMerchantProducts method*/

        vm.gridProducts = {
            enableFiltering: false,
            enableSorting: true,
            showGridFooter: true,
            onRegisterApi: function(gridApi){
              vm.gridApi = gridApi;
              vm.gridApi.grid.registerRowsProcessor( vm.singleFilter, 200 );
            },
            columnDefs: [
              
              { field: 'productId' },
              { field: 'productDescription' },
              { field: 'createdDate' }
            ]
            
        };
        vm.filter = function() {
            vm.gridApi.grid.refresh();
        };

        vm.singleFilter = function( renderableRows ){
            var matcher = new RegExp(vm.filterValue);
            renderableRows.forEach( function( row ) {
              var match = false;
              [ 'productId', 'productDescription', 'createdDate'].forEach(function( field ){
                if ( row.entity[field].match(matcher) ){
                  match = true;
                }
              });
              if ( !match ){
                row.visible = false;
              }
            });
            return renderableRows;
        };

        function merchantProduct(){
            vm.addProduct = {
                "merchantId":$rootScope.globals.currentUser.id,
                "productDescription":vm.description
            }
            console.log(vm.addProduct);
            UserService.CreateMerchantProduct(vm.addProduct)
                .then(function (response) {
                    if (response.success) {
                        loadMerchantProducts();
                        $location.path('dashboard/products');
                    } else {
                        FlashService.Error(response.message);
                        console.log('errorrrr')
                        vm.dataLoading = false;
                    }
                });

        }/*end merchantProduct method*/


    }/*end controller*/

})();