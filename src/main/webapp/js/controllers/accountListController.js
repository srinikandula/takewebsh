/**
 * Created by skandula on 4/18/16.
 */
"use strict";
var app = angular.module("takewebsh");

app.controller("AccountListController", function($scope, $rootScope, accountService, $location) {
    $scope.accounts = [];
    $scope.account = {};
    $scope.loadAccounts = function() {
        accountService.loadAccounts(function(data){
            $scope.accounts = data;
            $rootScope.$broadcast("AccountsLoaded",{message:'Hey'});
        });
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
    $scope.$on('AccountsLoaded', function(){
        $scope.accounts = accountService.getAccounts();
    });
    $scope.loadAccounts();
}).controller("CountController", function($scope, accountService, $location) {
    console.log('Count controller is loading...');
    $scope.accounts = [];
    $scope.$on('AccountsLoaded', function(event,args){
        console.log('received broadcast...')
        $scope.accounts = accountService.getAccounts();
    });
});