/**
 * Created by Sridhar Reddy S on 7/12/2016.
 */
var app=angular.module("myApp",[ ]);
app.controller("empController",function($scope,$http){
        $scope.loadEmployees=function(){
            $http.get("/api/employee/list")
                .success(function(response){
                    $scope.employees=response;
                })
                .error(function( xhr, status, errorThrown ) {
                alert( "Sorry, there was a problem!" );
                console.log( "Error: " + errorThrown );
                console.log( "Status: " + status );
                console.dir( xhr );
            })
        };
        $scope.loadEmployees();
        $scope.emp_load=function(c){
            $http.get("/api/employee/"+c)
                .success(function(response){
                    $scope.emp_id=response.employeeId;
                    $scope.emp_name=response.name;
                    $scope.emp_add=response.address;
                    $scope.emp_sal=response.salary;
                }).error(function (error) {
                $log.debug("error retrieving accounts");
            })
        };
        $scope.emp_create=function(){
            $http.post("/api/employee/create?address="+$scope.emp_add+"&name="+$scope.emp_name+"&salary="+$scope.emp_sal)
                .success(function(){
                    $scope.loadEmployees();
                    $scope.emp_name="";
                    $scope.emp_add="";
                    $scope.emp_sal="";
                }).error(function(error){
                $log.debug("error retrieving accounts");
            })
        };
        $scope.emp_update=function(){
            var c=$scope.emp_id;
            $http.put("/api/employee/update/"+c+"?name="+$scope.emp_name+"&address="+$scope.emp_add+"&salary="+$scope.emp_sal)
                .success(function(){
                    $scope.loadEmployees();
                    $scope.emp_id="";
                    $scope.emp_name="";
                    $scope.emp_add="";
                    $scope.emp_sal="";
                }).error(function(error){
                $log.debug("error retrieving accounts");
            })
        };
        $scope.emp_delete=function(c){
            $http.delete("/api/employee/delete?id="+c)
                .success(function(){
                    $scope.loadEmployees();
                }).error(function(error){
                $log.debug("error retrieving accounts");
            });

        };
});

app.controller("accController",function($scope,$http){
    $scope.loadAccounts=function(){
        $http.get("/api/account/list")
            .success(function(response){
                $scope.accounts=response;
            })
            .error(function( xhr, status, errorThrown ) {
                alert( "Sorry, there was a problem!" );
                console.log( "Error: " + errorThrown );
                console.log( "Status: " + status );
                console.dir( xhr );
            })
    };
    $scope.loadAccounts();
    $scope.emp_load=function(c){
        $http.get("/api/employee/"+c)
            .success(function(response){
                $scope.emp_id=response.employeeId;
                $scope.emp_name=response.name;
                $scope.emp_add=response.address;
                $scope.emp_sal=response.salary;
            }).error(function (error) {
            $log.debug("error retrieving accounts");
        })
    };
    $scope.emp_create=function(){
        $http.post("/api/employee/create?address="+$scope.emp_add+"&name="+$scope.emp_name+"&salary="+$scope.emp_sal)
            .success(function(){
                $scope.loadEmployees();
                $scope.emp_name="";
                $scope.emp_add="";
                $scope.emp_sal="";
            }).error(function(error){
            $log.debug("error retrieving accounts");
        })
    };
    $scope.emp_update=function(){
        var c=$scope.emp_id;
        $http.put("/api/employee/update/"+c+"?name="+$scope.emp_name+"&address="+$scope.emp_add+"&salary="+$scope.emp_sal)
            .success(function(){
                $scope.loadEmployees();
                $scope.emp_id="";
                $scope.emp_name="";
                $scope.emp_add="";
                $scope.emp_sal="";
            }).error(function(error){
            $log.debug("error retrieving accounts");
        })
    };
    $scope.emp_delete=function(c){
        $http.delete("/api/employee/delete?id="+c)
            .success(function(){
                $scope.loadEmployees();
            }).error(function(error){
            $log.debug("error retrieving accounts");
        });

    };
});
