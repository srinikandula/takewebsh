var app = angular.module('myApp', [
    'ui.router',
    'myApp.studentModule',
]);

app.config(['$stateProvider','$urlRouterProvider',
    function ($stateProvider, $urlRouterProvider) {
        $stateProvider
            .state('students', {
                url: '/',
                templateUrl: 'partials/list.html',
                controller: 'studentController'
            });
        $urlRouterProvider.otherwise('/');
    }]);