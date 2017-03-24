(function () {
    'use strict';

    angular.module('MyApp').controller('MerchantBeaconController', MerchantBeaconController);

    MerchantBeaconController.$inject = ['UserService', '$rootScope','$scope','$location','FlashService','$uibModal', '$log','uiGridConstants'];
    function MerchantBeaconController(UserService, $rootScope,$scope,$location,FlashService,$uibModal, $log,uiGridConstants) {
    	var vm = this;

    	vm.gridBeacons= [];
        /*vm.merchantProduct = merchantProduct;*/

    	initController();
    	function initController() {
            loadMerchantBeacons();
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
                    vm.gridBeacons.data = beacons.data
                    console.log(vm.gridBeacons.data);
                    
                });

        }/*end loadMerchantProducts method*/

       vm.gridBeacons = {
            enableFiltering: false,
            enableSorting: true,
            showGridFooter: true,
            onRegisterApi: function(gridApi){
              vm.gridApi = gridApi;
              vm.gridApi.grid.registerRowsProcessor( vm.singleFilter, 200 );
            },
            columnDefs: [
              { field: 'beaconId' },
              { field: 'beaconName' },
              { field: 'beaconUid' },
              { field: 'beaconMajorValue' },
              { field: 'beaconMinorValue' },
              { field: 'beaconStatus' },
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
              [ 'beaconId', 'beaconName', 'beaconUid','beaconMajorValue','beaconMinorValue','beaconStatus'].forEach(function( field ){
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


    }/*end controller*/

})();