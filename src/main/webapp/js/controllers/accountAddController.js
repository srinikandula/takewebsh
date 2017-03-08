/**
 * Created by skandula on 4/18/16.
 */
var app = angular.module("takewebsh");

app.controller("AccountAddController", function($scope, $rootScope, accountService, $http, $log, $location, $routeParams) {
    $scope.accounts = [];
    $scope.account = {};
    $scope.accountId = $routeParams.id;
    $scope.$on('testEvent', function(){
       console.log("test event received in AccountAddController ");

    });
    $scope.loadAccount = function() {
        accountService.loadAccount($scope.accountId, function(data){
            $scope.account = data;
        });
        $rootScope.$broadcast('test');
    }
    //if there is an account id then load that account
    if($scope.accountId) {
        $scope.loadAccount();
    }
    $scope.createAccount = function() {
        if($scope.account.id) {
            $http.put('/api/account/update/'+$scope.account.id+'?firstName='+$scope.account.firstName
                +'&lastName='+$scope.account.lastName+'&balance='+$scope.account.balance)
                .success(function (data) {
                    $location.url('/');
                    $scope.account = {};
                })
                .error(function (error) {
                    $log.debug("error retrieving accounts");
                });
        } else {
            $http.post('/api/account/create?firstName='+$scope.account.firstName
            +'&lastName='+$scope.account.lastName+'&balance='+$scope.account.balance)
            .success(function (data) {
                $location.url('/');
                $scope.account = {};
            })
            .error(function (error) {
                $log.debug("error retrieving accounts");
            });
        }
    }



});