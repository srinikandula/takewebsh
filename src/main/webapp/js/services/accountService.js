/**
 * Created by skandula on 4/20/16.
 */
'use strict';
/*global angular, _*/

var takewebsh = angular.module('takewebsh');
takewebsh.service('accountService', function ($rootScope, $http, $log, $window) {
    var  accounts = [];
    return {

        loadAccounts : function(loadComplete) {
            $http.get('/api/account/list')
                .success(function (data) {
                    accounts = data;
                    console.log("loading complete");
                    //loadComplete(data);
                    $rootScope.$broadcast('testEvent');
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
        },
        getAccounts: function(){
            console.log("get accounts "+ accounts);
            return accounts;
        }
    }
});


