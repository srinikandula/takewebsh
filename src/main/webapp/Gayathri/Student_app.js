var app = angular.module('StdApp', [])  //Defining a Angular module

app.controller('StudentCtrl', function($scope, $http){
        $scope.stdId = null;
        $scope.stdFirstName = null;
        $scope.stdLastName = null;
        $scope.stdAddress = null;
        $scope.students = [];
        $scope.update_std_info = function(){

        } ;
        $scope.create_std_info = function(){
            $http.post("api/student/create?firstname="+$scope.stdFirstName + "@lastname =" + $scope.stdLastName + "@address=" +$scope.stdAddress)
                .success(function() {
                    $scope.Loadstudents();
                })
                .error(function (error) {
                    $scope.status = 'Unable to retrive data ' + error.message;
                });

        };
        $scope.Loadstudents = function(){
                console.log("loading employees");
                $http.get('/api/student/list')
                    .success(function (data) {
                        $scope.students = data;

                    })
                    .error(function (error) {
                        $log.debug("Unable to retrive data");
                    });
        };
        $scope.load_std_info = function(stdId){
            console.log("loading person info with id " + c);
            $http.get("/api/student" + c)
                .then(function(student){
                    $scope.stdId = student.stdId;
                    $scope.stdFirstName = student.FisrtName;
                    $scope.stdLastName = student.LastName;
                    $scope.stdAddress = student.Address;
                }).error(function(){
                alert("error")
            });
        };

        $scope.delete_std_info = function(stdId){
            $http({
                method: 'DELETE',
                url:'/api/employee/delete/?id'+ stdId
            }).success(function(data){
                $scope.status = "The students data deleted successfully!!";
                $scope.students = data;
            }).error(function(error){
                $scope.status = 'Unable to delete data ' + error.message;
            })
        };
         $scope.Loadstudents();



});
