var app = angular.module("myApp");

app.controller("studentAddController", function($scope, $rootScope, studentService, $http, $log, $location, $routeParams) {
    $scope.students = [];
    $scope.student = {};
    $scope.studentId = $routeParams.id;

    $scope.loadStudent = function() {
        studentService.loadStudent($scope.studentId, function(data){
            $scope.student = data;
        });
    }
    if($scope.studentId) {
        $scope.loadStudent();
    }
    $scope.createStudent = function() {
        if($scope.student.studentId) {
            $http.put('/api/student/update/'+$scope.student.studentId +'?firstName='+$scope.student.firstName+'&lastName='+$scope.student.lastName)
                .success(function (data) {
                    $location.url('/');
                    $scope.student = {};
                })
                .error(function (error) {
                    $log.debug("error retrieving student details");
                });
        }
        else {
            $http.post('/api/student/create?fName=' +$scope.student.firstName + '&lName=' +$scope.student.lastName)
                .success(function (data) {
                    $location.url('/');
                    $scope.student = {};
                })
                .error(function (error) {
                    $log.debug("error retrieving student details");
                });
        }
    }
});