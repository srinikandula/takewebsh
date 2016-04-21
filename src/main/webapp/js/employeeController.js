/**
 * Created by CrazyNaveen on 4/18/16.
 */

var app = angular.module("takewebsh",[]);

app.controller("employeeController", function($scope, $http,$log){
    $scope.employees = [];
    $scope.employee = {};

    $scope.loadEmployees = function(){
        $http.get("api/employee/employeeListJstl")
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


    $scope.createEmployee = function() {
        if ($scope.employee.employeeId) {
            $http.put('/api/employee/update/' + $scope.employee.employeeId + '?name=' + $scope.employee.name
                    + '&address=' + $scope.employee.address + '&salary=' + $scope.employee.salary)
                .success(function (data) {
                    $scope.loadEmployees();
                    $scope.employee = {};
                })
                .error(function (error) {
                    $log.debug("error retrieving employees");
                });
        } else {

            $http.post("api/employee/create?name=" + $scope.employee.name + "&address=" + $scope.employee.address + "&salary=" + $scope.employee.salary)
                .success(function (data) {
                    $scope.loadEmployees();
                    $scope.employee = {};
                })
                .error(function (error) {
                    $log.debug("error creating employee");
                });

        }
    }

    $scope.createEmployee = function() {

        $http.post("api/employee/create?name=" + $scope.employee.name + "&address" + $scope.employee.address + "&salary" + $scope.employee.salary)
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



    $scope.loadEmployees();


});