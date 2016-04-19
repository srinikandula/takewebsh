/**
 * Created by skandula on 4/18/16.
 */
var app = angular.module("takewebsh", []);

app.controller("accountController", function($scope, $http, $log) {
    $scope.accounts = [];
    $scope.account = {};
    $scope.loadAccounts = function() {
        $http.get('/api/account/list')
            .success(function (data) {
                $scope.accounts = data;
            })
            .error(function (error) {
                $log.debug("error retrieving accounts");
            });
    }
    $scope.loadAccount = function(account) {
        $http.get('/api/account/'+account.id)
            .success(function (data) {
                $scope.account = data;
            })
            .error(function (error) {
                $log.debug("error retrieving accounts");
            });
    }
    $scope.createAccount = function() {
        if($scope.account.id) {
            $http.put('/api/account/update/'+$scope.account.id+'?firstName='+$scope.account.firstName
                +'&lastName='+$scope.account.lastName+'&balance='+$scope.account.balance)
                .success(function (data) {
                    $scope.loadAccounts();
                    $scope.account = {};
                })
                .error(function (error) {
                    $log.debug("error retrieving accounts");
                });
        } else {
            $http.post('/api/account/create?fName='+$scope.account.firstName
            +'&lName='+$scope.account.lastName+'&balance='+$scope.account.balance)
            .success(function (data) {
                $scope.loadAccounts();
                $scope.account = {};
            })
            .error(function (error) {
                $log.debug("error retrieving accounts");
            });
        }
    }

    $scope.deleteAccount = function(account) {
        $http.delete('/api/account/delete?id='+account.id)
            .success(function (message) {
               $log.debug("account deleted");
               $scope.loadAccounts();
            })
            .error(function (error) {
                $log.debug("error deleting accounts");
            });

    }

    $scope.loadAccounts();
});