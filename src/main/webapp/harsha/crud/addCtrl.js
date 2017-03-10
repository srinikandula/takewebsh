/**
 * Created by sriharshakota on 3/9/17.
 */
var app = angular.module("myApp");

app.controller("addCtrl", function($scope, $rootScope,$routeParams, crudservices, $http, $log, $location ) {
    $scope.employees = [];
    $scope.employee = {};
    $scope.employeeId = $routeParams.id;
    console.log($scope.employeeId);

    $scope.$on("event",function(){
       console.log("Event received in the Add controller")
    });

    $scope.loadEmployee = function(){
        console.log("fns is called");

        crudservices.loadEmployee($scope.employeeId,function(data){
            console.log($scope.employeeId);
            $scope.employee = data;
        });
    }

    if($scope.employeeId){
        $scope.loadEmployee();
    }
    $scope.createEmployee = function(){
        if($scope.employee.employeeId){
            $http.put('/api/employee/update/'+$scope.employee.employeeId+'?name='
                +$scope.employee.name+'&address='+$scope.employee.address+'&salary='+$scope.employee.salary)
                .success(function(){
                    $location.url('/');
                    $scope.employee = {};
                })
                .error(function(error){
                    $log.debug("Error Retriving Employee");
                });
        }
        else {
            $http.post('/api/employee/create?name=' + $scope.employee.name + '&address='
                + $scope.employee.address+'&salary='+$scope.employee.salary)
                .success(function () {
                    $location.url('/');
                    $scope.employee = {};
                })
                .error(function (error) {
                    $log.debug('Error Retriving Employee');
                });
            }
        }

    });