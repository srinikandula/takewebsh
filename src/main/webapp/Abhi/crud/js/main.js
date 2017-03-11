var app = angular.module("myApp",['ngRoute']);
    app.config(['$routeProvider',
                function ($routeProvider) {
                $routeProvider
                    .when('/',{
                        templateUrl:'view/listView.html',
                        controller: 'studentListController'
                    })
                    .when('/addStudent',{
                        templateUrl:'view/studentAdd.html',
                        controller: 'studentAddController'
                    })
                    .when('/updateStudent/:id',{
                        templateUrl:'view/studentAdd.html',
                        controller: 'studentAddController'
                    })
                    .otherwise({
                        redirectTo: '/'
                    })
                }]);