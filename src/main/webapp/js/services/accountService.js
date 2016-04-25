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
        loadAccount:function(accountId, loadComplete) {
        $http.get('/api/account/'+accountId)
            .success(function (data) {
                loadComplete(data);
            })
            .error(function (error) {
                $log.debug("error retrieving accounts");
            });
        },
        deleteAccount :function(accountId, callback){
            $http.delete('/api/account/delete?id='+accountId)
                .success(function (message) {
                   callback(message);
                })
                .error(function (error) {
                    $log.debug("error deleting accounts");
                });
        }
    }
});


