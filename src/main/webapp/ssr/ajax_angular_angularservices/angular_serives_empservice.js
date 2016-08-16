/**
 * Created by Sridhar Reddy S on 7/12/2016.
 */

var app=angular.module("app");
app.factory("empServices",function($rootScope,$http, $log, $window){
    return {
        loadEmployees: function (loadComplete) {
            $http.get("/api/employee/list")
                .success(function (response) {
                    loadComplete(response);
                })
                .error(function (xhr, status, errorThrown) {
                    alert("Sorry, there was a problem!");
                    console.log("Error: " + errorThrown);
                    console.log("Status: " + status);
                    console.dir(xhr);
                })
        }
    }         
});
    
