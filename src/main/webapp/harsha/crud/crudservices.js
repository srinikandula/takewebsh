/**
 * Created by sriharshakota on 3/10/17.
 */
var services = angular.module ("myApp");
services.service ("crudservices",  function ($rootScope, $log, $location, $http ) {

    var employees=[];
    return{

        loadEmployees : function(){
            $http.get('/api/employee/list')

                .success(function(data){
                    employees = data;
                    console.log("Employee data retrived");
                    $rootScope.$broadcast('event');
                })
                .error(function(error){
                    $log.debug("Error retriving Employee data");

                });
        },
        loadEmployee : function(employeeId ,myfunctionreference){
            $http.get('/api/employee/'+employeeId)
                .success(function(data){
                    myfunctionreference(data);
                    //loadComplete = data;

                })
                .error(function(error){
                    $log.debug("Error retriving Employee data");
                });
        },
        deleteEmployee : function(employeeId, callback){
            $http.delete('/api/employee/delete?id='+employeeId)

                .success(function(message){
                    callback(message);
                })
                .error(function(error){
                    $log.debug("Error deleting employee data");
                });

        },
        getEmployees : function(){
            console.log("get employess"+employees);
            return employees;
        }

    };

});