/**
 * Created by CrazyNaveen on 4/24/16.
 */
'use strict'

var takewebsh = angular.module('takewebsh',['ngRoute']);

takewebsh.config(['$routeProvider',
    function ($routeProvider){
        $routeProvider.
            when('/',{
            templateUrl: 'views/employeeList.html',
            controller: 'EmployeeListController'
        }).
            when('employee/create',{
            templateUrl: 'views/createEmployee.html',
            controller: 'AddEmployeeController'
        })
        /*when('employee/delete',{
            templateUrl: 'views/deleteEmployee',
            controller: 'DeleteEmployeeController'
        })*/
        when('employee/update/:id',{
            templateUrl: 'views/createEmployee.html',
            controller: 'AddEmployeeController'
        })
            .otherWise({
                redirectTo:'/'
            })

    }
]);


