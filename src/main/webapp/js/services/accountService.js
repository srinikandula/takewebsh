/**
 * Created by skandula on 4/20/16.
 */
'use strict';
/*global angular, _*/

var takewebsh = angular.module('takewebsh');
takewebsh.factory('accountService', function ($rootScope, $http, $log, $window) {
    return {
        loadAccounts : function(loadComplete) {
            $http.get('/api/account/list')
                .success(function (accounts) {
                    loadComplete(accounts);
                })
                .error(function (error) {
                    $log.debug("error retrieving accounts");
                });
        },
        loadAccount:function(account, loadComplete) {
        $http.get('/api/account/'+account.id)
            .success(function (data) {
                loadComplete(data);
            })
            .error(function (error) {
                $log.debug("error retrieving accounts");
            });
    }
    }
});


