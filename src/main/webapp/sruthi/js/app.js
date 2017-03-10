var app = angular.module("myApp", ["ngRoute"]);
app.config(function($routeProvider) {
    $routeProvider
        .when("/", {
            templateUrl : "main.html"
        })
        .when("/netflix", {
            templateUrl : "netflix.html"
        })
        .when("/hulu", {
            templateUrl : "hulu.html"
        })
        .when("/sling", {
            templateUrl : "sling.html"
        })
        .otherwise({
            redirectTo: '/'
        })
});