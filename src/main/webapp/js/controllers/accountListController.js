/**
 * Created by skandula on 4/18/16.
 */
"use strict";
var app = angular.module("takewebsh");

app.controller("AccountListController", function($scope, accountService, $location) {
    $scope.accounts = [];
    $scope.account = {};
    $scope.loadAccounts = function() {
        accountService.loadAccounts($scope.loadAccountsComplete);
        $scope.accounts = accountService.getAccounts();
        //accountService.loadAccounts();
    }

    $scope.loadAccountsComplete = function(data){
        $scope.accounts = data;
    }
    $scope.gotoCreateAccount = function(){
        $location.url('/account/create');
    }
    $scope.loadAccount = function(accountId){
        $location.url('/account/update/'+accountId);
    }
    $scope.deleteAccount = function(account) {
        accountService.deleteAccount(account.id, function() {
            $scope.loadAccounts();
        });
    }
    $scope.$on('testEvent', function(){
        $scope.accounts = accountService.getAccounts();
    });

    $scope.loadAccounts();
});