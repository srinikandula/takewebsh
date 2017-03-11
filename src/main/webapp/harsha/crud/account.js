/**
 * Created by sriharshakota on 3/9/17.
 */

var app = angular.module("myApp",['ngRoute']);

app.config(['$routeProvider',
    function ($routeProvider) {
        $routeProvider.
        when('/', {
            templateUrl: 'list.html',
            controller: 'listCtrl'
        })
            .when('/employee/create', {
                templateUrl: 'add.html',
                controller: 'addCtrl'
            })
            .when('/employee/update/:id', {
                templateUrl: 'add.html',
                controller: 'addCtrl'
            }).otherwise({
            redirectTo: '/'
        })}]);