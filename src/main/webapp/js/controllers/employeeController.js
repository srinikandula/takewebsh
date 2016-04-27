/**
 * Created by CrazyNaveen on 4/18/16.
 */
'use strict'

var takewebsh = angular.module("takewebsh");

takewebsh.controller("employeeController", function($scope, employeeService, $http, $log){
    $scope.employees = [];
    $scope.employee = {};


    $scope.loadEmployees = function() {
        employeeService.loadEmployees($scope.loadEmployeesComplete);
    }
    $scope.loadEmployeesComplete = function(data){
        $scope.employees = data;
    }

    $scope.loadEmployee = function(employee) {
        employeeService.loadEmployee(employee, function(data){
            $scope.employee = data;
        });

    }


    $scope.createEmployee = function() {
        employeeService.createEmployee($scope.employee, function(){
            $scope.loadEmployees();
            $scope.employee = {};
        });

    }


    $scope.deleteEmployee = function(id) {
        employeeService.deleteEmployee(id, function(){
            $scope.loadEmployees();

        });
    }


    /*$scope.createEmployee = function() {

        $http.post("api/employee/create?name=" + $scope.employee.name + "&address=" + $scope.employee.address + "&salary=" + $scope.employee.salary)
            .success(function (data) {
                    $scope.loadEmployees();
                    $scope.employee = {};
            })
            .error(function (error) {
                    $log.debug("error creating employee");
            });

    }

    $scope.deleteEmployee = function(employee) {
        $http.delete("api/employee/delete?id=" + employee.employeeId)
            .success(function (message) {
                $log.debug("Employee is deleted");
                $scope.loadEmployees();
            })
            .error(function (error) {
                $log.debug("error in deleting employee");
            });

    }

    $scope.loadEmployees = function(){
     $http.get("api/employee/list")
     .success(function(data){
     $scope.employees = data;
     })
     .error(function(error){
     $log.debug("error retrieving employees");
     });

     }

     $scope.loadEmployee = function(employee) {
     $http.get('/api/employee/'+employee.employeeId)
     .success(function (data) {
     $scope.employee = data;
     })
     .error(function (error) {
     $log.debug("error retrieving employee");
     });
     }

*/

    $scope.loadEmployees();


});