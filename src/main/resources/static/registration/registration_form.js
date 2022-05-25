angular.module('app').controller('registrationFormController', function ($scope, $http, $localStorage, $location, $cookies) {
    const contextPath = 'http://localhost:9090/care';

    $scope.tryToSignUp = function () {
        $http.post(contextPath + '/api/v1/users/register', $scope.userRegister)
            .then(function successCallback(response) {
                if (response.data) {
                    $scope.userRegister.username = null;
                    $scope.userRegister.password = null;
                    $scope.userRegister.email = null;
                    $location.path('/');
                }
            }, function errorCallback(response) {
            });
    };

});