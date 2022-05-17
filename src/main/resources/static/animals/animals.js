angular.module('app').controller('animalsController', function ($scope, $http, $localStorage, $location) {
    const contextPath = 'http://localhost:9090/care';

    $scope.isUserLoggedIn = function () {
        if ($localStorage.animalCareCurrentUser) {
            return true;
        } else {
            return false;
        }
    };

//    $scope.loadPage = function (page) {
//        $http({
//            url: contextPath + '/api/v1/products',
//            method: 'GET',
//            params: {
//                p: page,
//                title: $scope.filter ? $scope.filter.title : null,
//                min_price: $scope.filter ? $scope.filter.min_price : null,
//                max_price: $scope.filter ? $scope.filter.max_price : null
//            }
//        }).then(function (response) {
//            $scope.productsPage = response.data;
//
//            let minPageIndex = page - 2;
//            if (minPageIndex < 1) {
//                minPageIndex = 1;
//            }
//
//            let maxPageIndex = page + 2;
//            if (maxPageIndex > $scope.productsPage.totalPages) {
//                maxPageIndex = $scope.productsPage.totalPages;
//            }
//
//            $scope.paginationArray = $scope.generatePagesIndexes(minPageIndex, maxPageIndex);
//        });
//    };

    $scope.loadPage = function () {
            $http({
                url: contextPath + '/api/v1/animals',
                method: 'GET'
            }).then(function (response) {
                $scope.animalsPage = response.data;
            });
    };

    $scope.showProfileAnimal = function (animalId) {
        $location.path('/profile_animal/' + animalId);
    };

//    $scope.generatePagesIndexes = function (startPage, endPage) {
//        let arr = [];
//        for (let i = startPage; i < endPage + 1; i++) {
//            arr.push(i);
//        }
//        return arr;
//    };
//
// todo добавить пагинацию
//    $scope.loadPage(1);
    $scope.loadPage();
});