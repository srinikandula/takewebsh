var app = angular.module('myApp', [
    'ui.router',
    'myApp.studentModule',
]);

app.config(['$stateProvider','$urlRouterProvider',
    function ($stateProvider, $urlRouterProvider) {
        $stateProvider
            .state('students', {
                url: '/',
                templateUrl: 'view/listView.html',
                controller: 'studentController'
            });
        $urlRouterProvider.otherwise('/');
    }]);