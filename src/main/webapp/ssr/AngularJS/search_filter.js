/**
 * Created by Sridhar Reddy S on 6/25/2016.
 */
var myApp=angular
            .module("myModule",[])
            .controller("myController",function($scope){
                var employees=[
                    {id:201,name:"Sridhar",salary:5000,address:"Boston"},
                    {id:202,name:"Reddy",salary:6000,address:"Bridgeport"},
                    {id:203,name:"Syamala",salary:7000,address:"Jersey City"},
                    {id:204,name:"Sridhar Reddy",salary:8000,address:"Hyderabad"},
                    {id:205,name:"Sridhar Reddy Syamala",salary:9000,address:"Guntur"},
                ];
                $scope.employees=employees;
            });
