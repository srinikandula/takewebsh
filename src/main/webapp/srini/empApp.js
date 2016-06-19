var app = angular.module('empApp', []);

app.controller('employeeController', function($scope, $http) {
    $scope.empId = null;
    $scope.empAddress = null;
    $scope.empName = null;
    $scope.empSalary = null;
    $scope.employees = [];
    $scope.update_emp_info = function(){

    };
    $scope.create_emp_info = function() {
        $.ajax({
            url: "/api/employee/create?address="+$scope.empAddress+"&name="+$scope.empName+"&salary="+$scope.empSalary,
            data: {
            },
            type: "POST"
        }).done(function( ) {
            $scope.loadEmployees();
        }).fail(function( xhr, status, errorThrown ) {
            alert( "Sorry, there was a problem!" );
            console.log( "Error: " + errorThrown );
            console.log( "Status: " + status );
            console.dir( xhr );
        });

    };
    $scope.loadEmployees = function(){
        console.log("loading employees");
        $http.get('/api/employee/list')
            .success(function (data) {
                $scope.employees = data;

            })
            .error(function (error) {
                $log.debug("error retrieving accounts");
            });
    };
    $scope.load_emp_info = function(empId) {
        console.log("loading person info with id " + c);
        $.ajax({
            url: "/api/employee/"+ c,
            data: {

            },
            type: "GET",
            dataType : "json"
        }).done(function(employee ) {
            $scope.empId = employee.employeeId;
            $scope.empAddress = employee.address;
            $scope.empName = employee.name;
            $scope.empSalary = employee.salary;

        }).fail(function( xhr, status, errorThrown ) {
            alert( "Sorry, there was a problem!" );
            console.log( "Error: " + errorThrown );
            console.log( "Status: " + status );
            console.dir( xhr );
        });
    };

    $scope.delete_emp_info = function(empId) {

    };


    $scope.loadEmployees();
});