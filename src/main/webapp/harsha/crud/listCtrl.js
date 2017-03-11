/**
 * Created by sriharshakota on 3/10/17.
 */
var app = angular.module('myApp');
app.controller('listCtrl',function($scope, $location, crudservices){

    $scope.employees = [];
    $scope.employee = {};

    $scope.loadEmployees = function(){
        crudservices.loadEmployees();
        $scope.employees = crudservices.getEmployees();
    }


    $scope.gotoCreateEmployee = function(){
        $location.url('/employee/create');
    }
    $scope.loadEmployee = function(eId){
        $location.url('/employee/update/'+eId);
    }
    $scope.deleteEmployee = function(employee) {
        crudservices.deleteEmployee(employee.employeeId, function() {
            $scope.loadEmployees();
        });
    }
    $scope.$on('event', function(){
        $scope.employees = crudservices.getEmployees();
    });

    $scope.loadEmployees();
});
