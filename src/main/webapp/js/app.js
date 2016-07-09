/**
 * Created by skandula on 4/23/16.
 */

var app = angular.module("takewebsh", [ 'ngRoute']);

app.config(['$routeProvider',
    function ($routeProvider) {
        $routeProvider.
            when('/', {
                templateUrl: 'views/accountsList.html',
                controller: 'AccountListController'
            })
            .when('/account/create', {
                templateUrl: 'views/accountCreate.html',
                controller: 'AccountAddController'
            })
            .when('/account/update/:id', {
                templateUrl: 'views/accountCreate.html',
                controller: 'AccountAddController'
            }).otherwise({
                redirectTo: '/'
            })}]);

