/**
 * Created by CrazyNaveen on 4/21/16.
 */
'use strict';
/*global angular, _*/

var takewebsh = angular.module('takewebsh');
takewebsh.factory('employeeService', function ($rootScope, $http, $log, $window) {
    var employees = [];
    return {
        loadEmployees : function(loadComplete) {
            $http.get('/api/employee/list')
                .success(function (response) {
                    employees = response;
                    console.log("loading complete");
                    //loadComplete(data);

                    $rootScope.$broadcast("loadEvent");
                })
                .error(function (error) {
                    $log.debug("error retrieving employees");
                });
        },
        /*loadEmployee:function(employee, loadComplete) {
            $http.get('/api/employee/'+employee.employeeId)
                .success(function (data) {
                    loadComplete(data);
                })
                .error(function (error) {
                    $log.debug("error retrieving employee");
                });
        },*/
        loadEmployee:function(employeeId, loadComplete) {
            $http.get('/api/employee/'+employeeId)
                .success(function (data) {
                    loadComplete(data);
                })
                .error(function (error) {
                    $log.debug("error retrieving employee");
                });
        },
        deleteEmployee:function(id,callBackFunction){
            $http.delete('api/employee/delete?id='+ id)
                .success(function(){
                    $log.debug("Employee is deleted");
                    callBackFunction();
                })
                .error(function (error) {
                    $log.debug("error deleting employees");
                });
        },

        createEmployee:function(employee, callBackFunnction) {
            if (employee.employeeId) {
                $http.put('/api/employee/update/' + employee.employeeId + '?name=' + employee.name
                        + '&address=' +employee.address + '&salary=' + employee.salary)
                    .success(function (data) {
                        callBackFunnction(data);
                    })
                    .error(function (error) {
                        $log.debug("error retrieving employees");
                    });
            } else {

                $http.post("api/employee/create?name=" + employee.name + "&address=" + employee.address + "&salary=" + employee.salary)
                    .success(function (data) {
                        callBackFunnction(data);

                    })
                    .error(function (error) {
                        $log.debug("error creating employee");
                    });
            }


        },

        getEmployees : function(){
        return employees;
    }


    }
});



