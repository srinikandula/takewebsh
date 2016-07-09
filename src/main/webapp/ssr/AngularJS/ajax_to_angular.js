/**
 * Created by Sridhar Reddy S on 6/19/2016.
 */

var myApp=angular
    .module("myModule",[])
    .controller("myController",function($scope,$http){
        $scope.loadEmployees = function(){
            $http.get('/api/employee/list')
                .success(function (employee) {
                    $scope.employees = employee;
                })
                .error(function (error) {
                    $log.debug("error retrieving accounts");
                });
        };
        $scope.loadEmployees();
        $scope.emp_create = function(){
            $http.post('/api/employee/create?address=' + $scope.emp_add+ "&name=" +$scope.emp_name+"&salary=" +$scope.emp_salary)
                .success(function (data) {
                    $scope.employees=angular.copy(data);                    
                    $scope.loadEmployees();
                    $scope.emp_add="";
                    $scope.emp_name="";
                    $scope.emp_salary="";
                })
                .error(function (error) {
                    $log.debug("error retrieving accounts");
                });
        };
        $scope.emp_info_load = function(empInfo){
            $http.get('/api/employee/'+ empInfo)
                .success(function (employee) {
                    $scope.emp_id = employee.employeeId;
                    $scope.emp_add = employee.address;
                    $scope.emp_name = employee.name;
                    $scope.emp_salary = employee.salary;
                })
                .error(function (error) {
                    $log.debug("error retrieving accounts");
                });
        };
        $scope.emp_update = function(){
            var employeeId=$scope.emp_id;
            $http.put('/api/employee/update/'+employeeId+'?address=' + $scope.emp_add+ "&name=" +$scope.emp_name+"&salary=" +$scope.emp_salary)
                .success(function (data) {
                    $scope.employees=angular.copy(data);
                    $scope.loadEmployees();
                    $scope.emp_id="";
                    $scope.emp_add="";
                    $scope.emp_name="";
                    $scope.emp_salary="";
                })
                .error(function (error) {
                    $log.debug("error retrieving accounts");
                });
        };
        $scope.emp_info_delete = function(employeeId){
            $http.delete('/api/employee/delete/?id='+employeeId)
                .success(function () {
                    $scope.loadEmployees();
                })
                .error(function (error) {
                    $log.debug("error retrieving accounts");
                });
        };
    });
