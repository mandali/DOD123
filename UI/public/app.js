(function () {
    'use strict';

angular.module('MyApp', ['ngResource', 'ngMessages', 'ui.router','ngCookies','ngStorage','ui.bootstrap','ui.grid','ui.grid.edit','ui.grid.pagination']).config(config).run(run);

config.$inject = ['$stateProvider', '$urlRouterProvider'];

function config($stateProvider, $urlRouterProvider) {

$urlRouterProvider.otherwise('/');


$stateProvider
.state('home',{
    url: '/',
    views: {
        '': {
          templateUrl: 'views/home.html'
        },
        'nav@home': {
          templateUrl: 'layouts/nav.html'
        },
        'body@home': {
          templateUrl: 'views/partials/main-body.html'
        },
        'footer@home': {
          templateUrl: 'layouts/footer.html'
        }
    }
})
.state('login',{
    url: '/login',
    views: {
        '': {
          templateUrl: 'views/login.html'
        },
        'nav@login': {
          templateUrl: 'layouts/nav.html'
        },
        'body@login': {
          templateUrl: 'views/partials/login-body.html',
          controller: 'LoginController',
          controllerAs: 'vm'
        },
        'footer@login': {
          templateUrl: 'layouts/footer.html'
        }
    }
})
.state('merchant_registration',{
    url: '/merchant_registration',
    views: {
        '': {
          templateUrl: 'views/merchant-registration.html'
        },
        'nav@merchant_registration': {
          templateUrl: 'layouts/nav.html'
        },
        'body@merchant_registration': {
          templateUrl: 'views/partials/merchant-registration-body.html',
          controller: 'MerchantRegiCtrl',
          controllerAs: 'vm'
        },
        'footer@merchant_registration': {
          templateUrl: 'layouts/footer.html'
        }
    }
})
.state('dashboard',{
    url: '/dashboard/promotions',
    views: {
        '': {
          templateUrl: 'views/promotions.html'
        },
        'nav@dashboard': {
          templateUrl: 'layouts/nav.html'
        },
        'sidebar@dashboard': {
          templateUrl: 'layouts/sidebar.html'
        },
        'body@dashboard': {
          templateUrl: 'views/partials/promotion-body.html',
          controller: 'DashboardController',
          controllerAs: 'vm'
        }
    }
})
.state('promotions', {
      url:'/dashboard/promotions/new',
      views: {
        '': {
          templateUrl: 'views/promotions.html'
        },
        'nav@promotions': {
          templateUrl: 'layouts/nav.html'
        },
        'sidebar@promotions': {
          templateUrl: 'layouts/sidebar.html'

        },
        'body@promotions': {
          templateUrl: 'views/partials/promotion-body-new.html',
          controller: 'DashboardController',
          controllerAs: 'vm'
        }
    }
})

.state('products',{
    url: '/dashboard/products',
    views: {
        '': {
          templateUrl: 'views/products.html'
        },
        'nav@products': {
          templateUrl: 'layouts/nav.html'
        },
        'sidebar@products': {
          templateUrl: 'layouts/sidebar.html'
        },
        'body@products': {
          templateUrl: 'views/partials/product-body.html',
          controller: 'MerchantProductController',
          controllerAs: 'vm'
        }
    }
})
.state('productsNew',{
    url: '/dashboard/products/new',
    views: {
        '': {
          templateUrl: 'views/products.html'
        },
        'nav@productsNew': {
          templateUrl: 'layouts/nav.html'
        },
        'sidebar@productsNew': {
          templateUrl: 'layouts/sidebar.html'
        },
        'body@productsNew': {
          templateUrl: 'views/partials/product-body-new.html',
          controller: 'MerchantProductController',
          controllerAs: 'vm'
        }
    }
})

.state('brands',{
    url: '/dashboard/brands',
    views: {
        '': {
          templateUrl: 'views/brands.html'
        },
        'nav@brands': {
          templateUrl: 'layouts/nav.html'
        },
        'sidebar@brands': {
          templateUrl: 'layouts/sidebar.html'
        },
        'body@brands': {
          templateUrl: 'views/partials/brand-body.html',
          controller: 'MerchantBrandController',
          controllerAs: 'vm'
        }
    }
})
.state('locationsNew',{
    url: '/dashboard/locations/new',
    views: {
        '': {
          templateUrl: 'views/locations.html'
        },
        'nav@locationsNew': {
          templateUrl: 'layouts/nav.html'
        },
        'sidebar@locationsNew': {
          templateUrl: 'layouts/sidebar.html'
        },
        'body@locationsNew': {
          templateUrl: 'views/partials/location-body-new.html',
          controller: 'MerchantLocationController',
          controllerAs: 'vm'
        }
    }
})
.state('locations',{
    url: '/dashboard/locations',
    views: {
        '': {
          templateUrl: 'views/locations.html'
        },
        'nav@locations': {
          templateUrl: 'layouts/nav.html'
        },
        'sidebar@locations': {
          templateUrl: 'layouts/sidebar.html'
        },
        'body@locations': {
          templateUrl: 'views/partials/location-body.html',
          controller: 'MerchantLocationController',
          controllerAs: 'vm'
        }
    }
})
.state('beacons',{
    url: '/dashboard/beacons',
    views: {
        '': {
          templateUrl: 'views/beacons.html'
        },
        'nav@beacons': {
          templateUrl: 'layouts/nav.html'
        },
        'sidebar@beacons': {
          templateUrl: 'layouts/sidebar.html'
        },
        'body@beacons': {
          templateUrl: 'views/partials/beacon-body.html',
          controller: 'MerchantBeaconController',
          controllerAs: 'vm'
        }
    }
})
.state('beaconsNew',{
    url: '/dashboard/beacons/new',
    views: {
        '': {
          templateUrl: 'views/beacons.html'
        },
        'nav@beaconsNew': {
          templateUrl: 'layouts/nav.html'
        },
        'sidebar@beaconsNew': {
          templateUrl: 'layouts/sidebar.html'
        },
        'body@beaconsNew': {
          templateUrl: 'views/partials/beacon-body-new.html',
          controller: 'MerchantBeaconController',
          controllerAs: 'vm'
        }
    }
});

}


 run.$inject = ['$rootScope', '$location', '$cookies', '$http'];

function run($rootScope, $location, $cookies, $http) {
       
        $rootScope.globals = $cookies.getObject('globals') || {};


        if ($rootScope.globals.currentUser) {
            $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata;
        }        

        $rootScope.$on('$locationChangeStart', function (event, next, current) {
            var restrictedPage = $.inArray($location.path(), ['/login', '/merchant_registration','/consumer_registration']) === -1;
           
           
            var loggedIn = $rootScope.globals.currentUser;
            
            if (restrictedPage && !loggedIn) {
                $location.path('/');
            }
        });
    }


})();



    