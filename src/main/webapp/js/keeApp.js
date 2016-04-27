/**
 * Created by CrazyNaveen on 4/24/16.
 */
'use strict'

var app = angular.module('takewebsh',['ngRoute']);

app.config(['$routeProvider',
    function ($routeProvider){
        $routeProvider.
            when('/',{
            templateUrl: 'views/employeeList.html',
            controller: 'EmployeeListController'
        }).
            when('/employee/create',{
            templateUrl: 'views/createEmployee.html',
            controller: 'AddEmployeeController'
        }).
             when('/employee/update/:id',{
            templateUrl: 'views/createEmployee.html',
            controller: 'AddEmployeeController'
        }).
            otherwise({
                redirectTo:'/'
            })

    }
]);


