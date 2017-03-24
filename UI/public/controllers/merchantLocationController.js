(function () {
    'use strict';

    angular.module('MyApp').controller('MerchantLocationController', MerchantLocationController);

    MerchantLocationController.$inject = ['UserService', '$rootScope','$scope','$location','FlashService','$uibModal', '$log','uiGridConstants'];
    function MerchantLocationController(UserService, $rootScope,$scope,$location,FlashService,$uibModal, $log,uiGridConstants) {
    	var vm = this;


        vm.allCountries = [];
        vm.allCities = [];
    	vm.gridLocations= [];

        vm.merchantLocation = merchantLocation;
        /*vm.merchantLocation = merchantLocation;*/
        
    	initController();
    	function initController() {
            loadMerchantLocations();
            loadAllCountries();
            loadAllCities();
        }

        function loadMerchantLocations() {
                /*vm.merchatid={
                    "merchantId":$rootScope.globals.currentUser.id
                };
                console.log(vm.merchatid);*/
                UserService.GetLocations()
                .then(function (locations) {
                    vm.gridLocations.data = locations.data;
                	console.log(vm.gridLocations.data);
                });

        }/*end loadMerchantProducts method*/

        vm.gridLocations = {
            enableFiltering: false,
            enableSorting: true,
            showGridFooter: true,
            onRegisterApi: function(gridApi){
              vm.gridApi = gridApi;
              vm.gridApi.grid.registerRowsProcessor( vm.singleFilter, 200 );
            },
            columnDefs: [
              
              { field: 'locationId' },
              { field: 'locationName' },
              { field: 'lattitude' },
              { field: 'countryId' },
              { field: 'cityId' }
            ]
            
        };
        vm.filter = function() {
            vm.gridApi.grid.refresh();
        };

        vm.singleFilter = function( renderableRows ){
            var matcher = new RegExp(vm.filterValue);
            renderableRows.forEach( function( row ) {
              var match = false;
              [ 'locationId', 'locationName', 'lattitude','countryId','cityId'].forEach(function( field ){
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


        function loadAllCountries() {
                
                UserService.GetCountries()
                .then(function (countries) {
                    vm.allCountries = countries.data;
                    console.log(vm.allCountries);
                });

        }/*end loadAllCountries method*/

        function loadAllCities() {
                
                UserService.GetCities()
                .then(function (cities) {
                    vm.allCities = cities.data;
                    console.log(vm.allCities);
                });

        }/*end loadAllCities method*/

        function merchantLocation(){
            /*vm.addProduct = {
                "merchantId":$rootScope.globals.currentUser.id,
                "productDescription":vm.description
            }*/
            console.log(vm.location);
            UserService.CreateMerchantLocation(vm.location)
                .then(function (response) {
                    if (response.success) {
                        loadMerchantLocations();
                        $location.path('dashboard/locations');
                    } else {
                        FlashService.Error(response.message);
                        console.log('errorrrr')
                        vm.dataLoading = false;
                    }
                });

        }/*end merchantLocation method*/

    }/*end controller*/

})();