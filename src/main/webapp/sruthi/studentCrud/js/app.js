var app = angular.module("sruApp",['ngRoute']);
app.config(['$routeProvider',
    function ($routeProvider) {
        $routeProvider
            .when('/',{
                templateUrl:'views/list.html',
                controller: 'listController'
            })
            .when('/addStudent',{
                templateUrl:'views/add.html',
                controller: 'addController'
            })
            .when('/updateStudent/:id',{
                templateUrl:'views/add.html',
                controller: 'addController'
            })
            .otherwise({
                redirectTo: '/'
            })
    }]);