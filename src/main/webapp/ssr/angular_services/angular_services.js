/**
 * Created by Sridhar Reddy S on 7/9/2016.
 */
var myApp=angular
            .module("myModule",[])
            .controller("myController",function($scope,$http){
                $scope.loademployees();
            });