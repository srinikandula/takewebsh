/**
 * Created by CrazyNaveen on 4/24/16.
 */

var app = angular.module("takewebsh");
app.controller("AddEmployeeController", function($scope,employeService, $http, $location,$routeParams){

    $scope.employees = [];
    $scope.employee = {};
    $scope.employeeId = $routeParams.id;


    $scope.loadEmployee = function(employeeId) {
        employeeService.loadEmployee($scope.employeeId, function(data){
            $scope.employee = data;
        });

    }
    if($scope.employeeId){
        $scope.loadEmployee();
    }
    $scope.createEmployee = function() {
        if (employee.employeeId) {
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

            $http.post("api/employee/create?name=" + $scope.employee.name + "&address=" + $scope.employee.address + "&salary=" + employee.salary)
                .success(function (data) {
                    $location.url("/");
                    $scope.employee = {};

                })
                .error(function (error) {
                    $log.debug("error creating employee");
                });
        }
    }




});