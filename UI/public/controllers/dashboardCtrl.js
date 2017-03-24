(function () {
    'use strict';

    angular.module('MyApp').controller('DashboardController', DashboardController).constant('PromotionSchema', {
                  type: 'object',
                  properties: {
                    id: { type: 'string', title: 'Promotion Id' },
                    product_id: { type: 'string', title: 'Product Id' },
                    catid: { type: 'string', title: 'Category' },

                    brandId: { type: 'string', title: 'Brand' },
                    discount: { type: 'string', title: 'Discount' },
                    originalPrice: { type: 'string', title: 'Original Price' },

                    discountText: { type: 'string', title: 'Discount Text' },
                    locationId: { type: 'string', title: 'Location' },
                    description: { type: 'string', title: 'Description' }

                      }
                });

    DashboardController.$inject = ['UserService', '$rootScope','$scope','$location','FlashService','$uibModal', '$log','$localStorage','uiGridConstants'];
    function DashboardController(UserService, $rootScope,$scope,$location,FlashService,$uibModal, $log,$localStorage,uiGridConstants) {
        var vm = this;

        /*vm.allPromotions = [];*/
        vm.merchantPromotions= [];
        vm.allCategories = [];
        vm.allBrands = [];
        vm.brands = [];
        vm.merchantProducts = [];
        vm.merchantLocations= [];
        vm.merchantBeacons = [];
        vm.beaconPromotionList = [];
        vm.mainBeaconPromotion = [];
        vm.bpid = [];

        vm.merchantPromotion = merchantPromotion;
        vm.showBeaconActionForm = showBeaconActionForm;
        vm.updateP = vm.updateP;
        

/*        vm.activeClass='promotions';
        vm.getActiveClass =getActiveClass;
        vm.isActive = isActive;
        function getActiveClass(activeClass) {
            return vm.activeClass = activeClass;
        }
        function isActive(activeClass) {
            return vm.activeClass === activeClass;
        }*/

       /* vm.allUsers = [];
        vm.deleteUser = deleteUser;*/


        initController();

        function initController() {
            loadCurrentUser();
            loadMerchantPromotions();
            loadMerchantProducts();
            loadMerchantLocations();
            loadAllBrands();
            loadAllCategories();
            
            /*loadAllUsers();*/
        }

      /*  function loadCurrentUser() {
            UserService.GetByUsername($rootScope.globals.currentUser.username)
                .then(function (merchant) {
                    vm.merchant = merchant;
                    console.log($rootScope.globals.currentUser.username);
                });
                
        }*/

        function loadCurrentUser() {

                /*console.log($rootScope.globals.currentUser.id);*/

           /* UserService.GetMerchantInfo()
                .then(function (res) {
                    vm.merchant = res;
                    console.log(vm.merchant );
                });*/ 
               
        }

         function loadMerchantPromotions() {
                vm.merchatid={
                    "id":$rootScope.globals.currentUser.id
                };
                console.log(vm.merchatid);
                UserService.GetMerchantPromotions(vm.merchatid)
                .then(function (promotions) {
                    vm.gridPromotions.data = promotions.data;
                    console.log(vm.gridPromotions.data);

                    /*UserService.GetMerchantBeacons(vm.merchatid)
                    .then(function (beacons) {
                        vm.merchantBeacons= beacons.data;
                        vm.beaconPromotionlistObject = [];

                        for (var i=0; i < vm.merchantBeacons.length; i++){
                            vm.beaconObject=
                                {
                                "beaconUID":vm.merchantBeacons[i].beaconUid,
                                "beaconMinorValue":vm.merchantBeacons[i].beaconMinorValue,
                                "beaconMajorValue":vm.merchantBeacons[i].beaconMajorValue
                                }
                            
                            vm.beaconPromotionlistObject.push(vm.beaconObject);
                        }
                        console.log("out");
                        console.log(vm.beaconPromotionlistObject);

                        UserService.GetMerchantBeaconsPromotions(vm.beaconPromotionlistObject)
                        .then(function (beaconPromotion) {
                            vm.beaconPromotionList = beaconPromotion.data;
                            
                            console.log(vm.beaconPromotionList);
                            console.log("Beacon Pro");

                            for(var i=0; i<vm.beaconPromotionList.length;i++){
                                console.log(vm.beaconPromotionList[i].promotionDtos);
                                console.log("pushing");
                                vm.mainBeaconPromotion.push(vm.beaconPromotionList[i].promotionDtos);
                            }
                            console.log('After pushed');
                            console.log(vm.mainBeaconPromotion);

                            for(var i=0; i<vm.mainBeaconPromotion.length;i++){
                                for(var j=0; j<vm.mainBeaconPromotion[i].length;j++){
                                    for(var k=0;k < vm.merchantPromotions.length;k++){

                                        if(vm.mainBeaconPromotion[i][j].id == vm.merchantPromotions[k].id){
                                            console.log(vm.mainBeaconPromotion[i][j].id);
                                            console.log(vm.merchantPromotions[k].id);
                                            vm.bpid.push(vm.mainBeaconPromotion[i][j].id);
                                            
                                        }
                                    }
                                }
                            }
                            console.log(' b ids')
                            console.log(vm.bpid);
                            
                        });
                    });*/
                });
        }/*end loadMerchantPromotions*/

        vm.gridPromotions = {
            enableFiltering: false,
            enableSorting: true,
            /*showGridFooter: true,*/
            enableGridMenu: true,
            paginationPageSizes: [10, 20],
            paginationPageSize: 10,
            onRegisterApi: function(gridApi){
              vm.gridApi = gridApi;
              vm.gridApi.grid.registerRowsProcessor( vm.singleFilter, 200 );
            },
            columnDefs: [
              /*{ field: 'id',
                sort: {
                  direction: uiGridConstants.ASC,
                  priority: 2
                }
               },*/
              { field: 'brandName', suppressRemoveSort: true,cellTooltip:
                function( row, col ) {
                  return 'Double click to edit: ' + row.entity.brandName;
                }, headerTooltip: 
                function( col ) {
                  return col.displayName;
                }
               },
              { field: 'categoryName',cellTooltip:
                function( row, col ) {
                  return 'Double click to edit: ' + row.entity.categoryName;
                }, headerTooltip: 
                function( col ) {
                  return col.displayName;
                },
                sort: {
                  direction: uiGridConstants.DESC,
                  priority: 1
                }
              },
              { field: 'discount',type: 'number'},
              { field: 'discountText', enableSorting: false },
              { field: 'locationName' },
              { field: 'originalPrice',type: 'number' },
              { field: 'startdate',type: 'date' },
              { field: 'enddate',type: 'date' },
              {
                name:'Actions',
                cellTemplate :'views/partials/edit-promotion-button.html'
              }
            ]
            
        };
        vm.filter = function() {
            vm.gridApi.grid.refresh();
        };

        vm.singleFilter = function( renderableRows ){
            var matcher = new RegExp(vm.filterValue);
            renderableRows.forEach( function( row ) {
              var match = false;
              [ 'brandName', 'categoryName', 'discount','discountText','locationName','originalPrice' ].forEach(function( field ){
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


        function loadMerchantProducts() {
                vm.merchatid={
                    "merchantId":$rootScope.globals.currentUser.id
                };
                console.log(vm.merchatid);
                UserService.GetMerchantProducts(vm.merchatid)
                .then(function (products) {
                    console.log(products.data);
                    vm.merchantProducts = products.data[0].merchantProducts;
                    console.log(vm.merchantProducts);
                    
                });
        }


        vm.showMe = function(grid,row){
            console.log(grid);
            console.log(row.entity);
            var modalInstance = $uibModal.open({
                templateUrl: 'views/partials/edit-merchant-promotion.html',
                controller: 'EditMerchantPromotionCtrl',
                controllerAs: 'vm',
                resolve: {
                    grid: function () { return grid; },
                    row: function () { return row; }
                }

            });
            modalInstance.result.then(function (selectedItem) {
                vm.selected = selectedItem;

            }, function () {
                $log.info('Modal dismissed at: ' + new Date());
            });

        };

        function loadMerchantLocations() {
                
                UserService.GetLocations()
                .then(function (locations) {
                    vm.merchantLocations = locations.data;
                    /*console.log(locations.data);*/
                });

        }/*end loadMerchantLocations method*/


        function loadAllCategories() {
                UserService.GetCategories()
                .then(function (categories) {
                    vm.allCategories = categories.data;
                    console.log(vm.allCategories);
                });
        }

        function loadAllBrands() {
                UserService.GetBrands()
                .then(function (res) {

                    vm.allBrands = res.data;

                    console.log(vm.allBrands);

                    /*for (var i = 0; i < vm.allBrands.length; i++) {
                        console.log(vm.allBrands[i].brands[i]);
                    }*/   

                });
        }

        vm.populateDemands = function(catid){
            vm.brands = vm.allBrands[catid-1].brands;
        };

        function merchantPromotion(){
            vm.dataLoading = true;
            console.log(vm.promotion);
            console.log($rootScope.globals.currentUser.id);
            var headers = {
                'Content-Type':'application/json',
                'Access-Control-Allow-Origin':'*'
            };
            vm.addPromotion = {
                "merchatid":$rootScope.globals.currentUser.id,
                "product_id":vm.promotion.product_id,
                "description":vm.promotion.description,
                "product_image":vm.promotion.product_image,
                "originalPrice":vm.promotion.originalPrice,
                "discount":vm.promotion.discount,
                "locationId":vm.promotion.location_id,
                "catid":vm.promotion.catid,
                "brandId":vm.promotion.brandId,
                "discountText":vm.promotion.discountText
            };
            console.log('after add merchant promotion');
            console.log(vm.addPromotion);
            UserService.CreatePromotion(vm.addPromotion).then(function (response) {
                if (response.success) {
                    /*FlashService.Success('Promotion Posted successful', true);*/
                    loadMerchantPromotions();
                    vm.resetPromotionForm();
                    $location.path('dashboard/promotions');

                } else {
                    FlashService.Error(response.message);
                    console.log('errorrrr')
                    vm.dataLoading = false;
                }
            });
        }

        vm.resetPromotionForm = function(){
            vm.promotion.product_id='';
            vm.promotion.description='';
             vm.promotion.product_image='';
             vm.promotion.originalPrice='';
             vm.promotion.discount='';
             vm.promotion.location='';
             vm.promotion.catid='';
             vm.promotion.brandId='';
        }

        function showBeaconActionForm(promotionid,e){
            vm.message = "Show beacon Form Button Clicked";
            console.log(vm.message);
            console.log(promotionid);
            var elem = e.target;
            console.log("Elemtnt promotion");
            console.log(elem);
            var modalInstance = $uibModal.open({
                templateUrl: 'views/partials/addBeacons-to-promotion.html',
                controller: 'AddBeaconToPromotionCtrl',
                controllerAs: 'vm',
                resolve: {
                    promotion_id: promotionid,
                    elem:elem
                }

            });
            modalInstance.result.then(function (selectedItem) {
                vm.selected = selectedItem;

            }, function () {
                $log.info('Modal dismissed at: ' + new Date());
            });
        }

    }

})();

