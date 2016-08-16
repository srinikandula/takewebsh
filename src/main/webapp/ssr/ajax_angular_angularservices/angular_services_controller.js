/**
 * Created by Sridhar Reddy S on 7/12/2016.
 */

var app=angular.module("app",[ ]);
app.controller("empController",function($scope,empServices, $http){
        $scope.loadEmployees=function(){
            empServices.loadEmployees($scope.loadEmplpoyeesCallBack);
        };
    $scope.loadEmployeesCallBack = function(employeeList) {
        $scope.employees = employeeList;
    };
});
