/**
 * Created by devendra on 4/28/2016.
 */


'use strict';

var app = angular.module('Springs',['ngRoute']);

app.config(['$routeProvider', function($routeProvider){
    $routeProvider.
        when('/',{
        templateUrl: 'views/studentList.html',
        controller: 'StudentListController'
    }).
        when('/student/create',{
        templateUrl: 'views/studentCreate.html',
        controller: 'studentAddController'
    }).
        when('/student/update/:id',{
        templateUrl: 'views/studentCreate.html',
        controller: 'studentAddController'
    }).
        otherwise({
        redirectTo:'/'
    })

    }
]);