var app = angular.module("takewebsh",[]);

app.controller("employeeController", function($scope, $http, $log) {
    $scope.employees = [];
    $scope.employee = {};
    $scope.author ="Harsha";
});