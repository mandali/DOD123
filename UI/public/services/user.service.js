(function () {
    'use strict';

angular.module('MyApp').factory('UserService', UserService);

UserService.$inject = ['$http'];

    function UserService($http) {

        var service = {};

       /* service.GetAll = GetAll;
        service.GetById = GetById;*/
       /* service.GetByUsername = GetByUsername;*/

        service.GetMerchantInfo = GetMerchantInfo;
        service.Create = Create;
        service.GetMerchantPromotions = GetMerchantPromotions;
        service.GetMerchantBeaconsPromotions = GetMerchantBeaconsPromotions;
        service.GetMerchantProducts = GetMerchantProducts;
        service.GetLocations = GetLocations;
        service.GetMerchantBeacons = GetMerchantBeacons;
        service.GetMerchantAiles = GetMerchantAiles;
        service.GetCategories = GetCategories;
        service.GetBrands = GetBrands;

        service.GetListBrands = GetListBrands;
        service.GetCountries = GetCountries;
        service.GetCities = GetCities;
        service.CreateMerchantLocation = CreateMerchantLocation;

        service.AddPromotionToBeacon= AddPromotionToBeacon;
        service.CreatePromotion = CreatePromotion;
        service.CreateMerchantProduct= CreateMerchantProduct;

        service.EditPromotion = EditPromotion;
        service.DeletePromotion = DeletePromotion;

    /*    service.Update = Update;
        service.Delete = Delete;*/

        return service;

     /*   function GetAll() {
            return $http.get('/api/users').then(handleSuccess, handleError('Error getting all users'));
        }

        function GetById(id) {
            return $http.get('/api/users/' + id).then(handleSuccess, handleError('Error getting user by id'));
        }*/

        function GetMerchantInfo() {
            return $http.get('http://54.193.11.3:8080/Discounts/merchantlogin').then(handleSuccess, handleError('Error getting merchant details'));
        }
        function Create(merchant) {
            return $http.post('http://54.193.11.3:8080/Discounts/merchantRegistration', merchant).then(handleSuccess, handleError('Error creating user'));
        }
        function GetMerchantPromotions(id) {
            return $http.post('http://54.193.11.3:8080/Discounts/promotion/merchantid',id).then(handleSuccess, handleError('Error getting user by username'));
        }

        function GetMerchantBeaconsPromotions(beaconsList) {
            return $http.post('http://54.193.11.3:8080/Discounts/listbeaconsbyuidmajorminor',beaconsList).then(handleSuccess, handleError('Error getting user by username'));
        }

        function GetMerchantProducts(id) {
            return $http.post('http://54.193.11.3:8080/Discounts/merchantproducts',id).then(handleSuccess, handleError('Error getting user by username'));
        }
        function GetMerchantAiles(id) {
            return $http.post('http://54.193.11.3:8080/Discounts/listaisle',id).then(handleSuccess, handleError('Error getting user by username'));
        }
        function GetLocations() {
            return $http.get('http://54.193.11.3:8080/Discounts/locations').then(handleSuccess, handleError('Error getting user by username'));
        }

        function GetCountries() {
            return $http.get('http://54.193.11.3:8080/Discounts/countries').then(handleSuccess, handleError('Error getting user by username'));
        }
        function GetCities() {
            return $http.get('http://54.193.11.3:8080/Discounts/cities').then(handleSuccess, handleError('Error getting user by username'));
        }

         function GetMerchantBeacons(id) {
            return $http.post('http://54.193.11.3:8080/Discounts/listbeaconsbymerchantid',id).then(handleSuccess, handleError('Error getting user by username'));
        }
        function GetCategories() {
            return $http.get('http://54.193.11.3:8080/Discounts/categories').then(handleSuccess, handleError('Error getting user by username'));
        }
        function GetBrands() {
            return $http.get('http://54.193.11.3:8080/Discounts/brands').then(handleSuccess, handleError('Error getting user by username'));
        }
        function GetListBrands() {
            return $http.get('http://54.193.11.3:8080/Discounts/listbrands').then(handleSuccess, handleError('Error getting user by username'));
        }

        function CreatePromotion(promotion) {
            return $http.post('http://54.193.11.3:8080/Discounts/createpromotions',promotion).then(handleSuccess, handleError('Error getting user by username'));
        }
        function AddPromotionToBeacon(addPromotionToBeaconObject) {
            return $http.post('http://54.193.11.3:8080/Discounts/createmerchantpromotionbeacon',addPromotionToBeaconObject).then(handleSuccess, handleError('Error getting user by username'));
        }
        function CreateMerchantProduct(product) {
            return $http.post('http://54.193.11.3:8080/Discounts/createproduct',product).then(handleSuccess, handleError('Error getting user by username'));
        }
        function CreateMerchantLocation(location) {
            return $http.post('http://54.193.11.3:8080/Discounts/createlocation',location).then(handleSuccess, handleError('Error getting user by username'));
        }

        function EditPromotion(updatedPromotion,id) {
            return $http.put('http://54.193.11.3:8080/Discounts/updatepromotion/'+id,updatedPromotion).then(handleSuccess, handleError('Error getting user by username'));
        }
        function DeletePromotion(id) {
            return $http.delete('http://54.193.11.3:8080/Discounts/promotion/'+id).then(handleSuccess, handleError('Error getting user by username'));
        }

        /*local APIs*/
        /*function GetBrands() {
            return $http.get('http://192.168.0.122:8080/Discounts/brands').then(handleSuccess, handleError('Error getting  brnds'));
        }*/

       /* function Update(user) {
            return $http.put('/api/users/' + user.id, user).then(handleSuccess, handleError('Error updating user'));
        }

        function Delete(id) {
            return $http.delete('/api/users/' + id).then(handleSuccess, handleError('Error deleting user'));
        }*/


        // private functions

        function handleSuccess(res) {
            return res.data;
        }

        function handleError(error) {
            return function () {
                return { success: false, message: error };
            };
        }
    }

})();
