(function ($localStorage) {
    'use strict';

    angular
        .module('app', ['ngRoute', 'ngStorage', 'ngCookies'])
        .config(config)
        .run(run);
//todo: добавлять для навигации
    function config($routeProvider, $httpProvider) {
        $routeProvider
            .when('/animals', {
                templateUrl: 'animals/animals.html',
                controller: 'animalsController'
            })
            .when('/profile_animal/:animalIdParam', {
                templateUrl: 'profile_animal/profile_animal.html',
                controller: 'profileAnimalController'
            })
            .otherwise({
                redirectTo: '/'
            });
    };

    function run($rootScope, $http, $localStorage) {
        if ($localStorage.animalCareCurrentUser) {
            $http.defaults.headers.common.Authorization = 'Bearer ' + $localStorage.animalCareCurrentUser.token;
        }
    };
})();

angular.module('app').controller('indexController', function ($scope, $http, $localStorage, $location, $cookies) {
    const contextPath = 'http://localhost:9090/care';

    $scope.tryToAuth = function () {
        $http.post(contextPath + '/auth', $scope.user)
            .then(function successCallback(response) {
                if (response.data.token) {
                    $http.defaults.headers.common.Authorization = 'Bearer ' + response.data.token;
                    $localStorage.animalCareCurrentUser = {username: $scope.user.username, token: response.data.token};

                    $scope.userLoginShow = 'Hello, ' + $scope.user.username;
                    $scope.user.username = null;
                    $scope.user.password = null;
                }
            }, function errorCallback(response) {
            });
    };

    $scope.clearUser = function () {
        delete $localStorage.animalCareCurrentUser;
        $scope.userLoginShow = null;
        $http.defaults.headers.common.Authorization = '';
    };

    $scope.tryToLogout = function () {
        $scope.clearUser();
        $location.path('/');
    };

    $scope.isUserLoggedIn = function () {
        if ($localStorage.animalCareCurrentUser) {
            return true;
        } else {
            return false;
        }
    };

});