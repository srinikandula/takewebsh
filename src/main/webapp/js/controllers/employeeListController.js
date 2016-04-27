/**
 * Created by CrazyNaveen on 4/24/16.
 */
"use strict";
var app = angular.module("takewebsh");

app.controller("EmployeeListController", function($scope, employeeService, $location) {
    $scope.employees = [];
    $scope.employee = {};


    $scope.loadEmployees = function () {
        employeeService.loadEmployees($scope.loadEmployeesComplete);
    }
    $scope.loadEmployeesComplete = function (data) {
        $scope.employees = data;
    }

    $scope.gotoCreateEmployee = function(){
        $location.url("/employee/create");
    }

    $scope.loadEmployee = function(employeeId){
        $location.url("/employee/update/"+employeeId);
    }
    $scope.deleteEmployee = function(employeeId) {
       employeeService.deleteEmployee(employeeId, function() {
            $scope.loadEmployees();
        });
    }
    $scope.loadEmployees();
});