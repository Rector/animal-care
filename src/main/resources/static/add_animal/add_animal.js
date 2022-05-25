angular.module('app').controller('addAnimalController', function ($scope, $http, $localStorage, $location, $cookies) {
    const contextPath = 'http://localhost:9090/care';

    $scope.tryToAddAnimal = function () {
        $http.post(contextPath + '/api/v1/animals', $scope.addAnimal)
            .then(function successCallback(response) {
                 $location.path('/animals');
            }, function errorCallback(response) {
            });
    };

});