var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope) {
    $scope.firstName= "John";
    $scope.lastName= "Doe";
});

app.controller('secondCtrl', function($scope) {
    $scope.firstName= "Joe";
    $scope.lastName= "Walsh";
});

app.controller('thirdCtrl', function($scope) {
    $scope.firstName= "Joe";
    $scope.lastName= "Walsh";
});