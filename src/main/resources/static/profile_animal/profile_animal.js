angular.module('app').controller('profileAnimalController', function ($scope, $http, $localStorage, $location, $routeParams) {
    const contextPath = 'http://localhost:9090/care';

    $scope.loadProfileAnimal = function () {
            $http({
                url: contextPath + '/api/v1/animals/' + $routeParams.animalIdParam,
                method: 'GET'
            }).then(function (response) {
                $scope.profileAnimal = response.data;
            });
        };

    $scope.loadProfileAnimal();
});