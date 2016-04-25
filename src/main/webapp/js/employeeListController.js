/**
 * Created by CrazyNaveen on 4/24/16.
 */

'use strict'

var app = angular.module("takewebsh",[]);

app.controller("employeeListController", function($scope, employeeService, $location) {
    $scope.employees = [];
    $scope.employee = {};


    $scope.loadEmployees = function () {
        employeeService.loadEmployees($scope.loadEmployeesComplete);
    }
    $scope.loadEmployeesComplete = function (data) {
        $scope.employees = data;
    }

    $scope.goToCreateEmployee = function(){
        $location.url("employee/create");
    }

    $scope.loadEmployee = function(employeeId){
        $location.url("employee/update/"+$scope.employeeId);
    }
    $scope.loadEmployees();
});