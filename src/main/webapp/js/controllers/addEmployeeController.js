/**
 * Created by CrazyNaveen on 4/24/16.
 */
var app = angular.module("takewebsh");

app.controller("AddEmployeeController", function($scope, employeeService, $http, $location, $routeParams){

    $scope.employees = [];
    $scope.employee = {};
    $scope.employeeId = $routeParams.id;


    $scope.loadEmployee = function() {
        employeeService.loadEmployee($scope.employeeId, function(data){
            $scope.employee = data;
        });

    }
    if($scope.employeeId){
        $scope.loadEmployee();
    }
    $scope.createEmployee = function() {
        if ($scope.employee.employeeId) {
            $http.put('/api/employee/update/' + $scope.employee.employeeId + '?name=' + $scope.employee.name
                    + '&address=' +$scope.employee.address + '&salary=' + $scope.employee.salary)
                .success(function (data) {
                    $location.url("/");
                    $scope.employee = {};
                })
                .error(function (error) {
                    $log.debug("error retrieving employees");
                });
        } else {

            $http.post("api/employee/create?name=" + $scope.employee.name + "&address=" + $scope.employee.address + "&salary=" + $scope.employee.salary)
                .success(function (data) {
                    $location.url("/");
                    $scope.employee = {};

                })
                .error(function (error) {
                    $log.debug("error creating employee");
                });
        }
    }


   /* $scope.createEmployee = function(employee){
        employeService.createEmployee(employee);
        employeService.loadEmployees();
    }*/


});