var app = angular.module("sruApp");

app.controller("addController", function($scope,$http, $rootScope,$routeParams, sruService, $log, $location) {
    $scope.students = [];
    $scope.student = {};
    $scope.studentId = $routeParams.id;

    $scope.loadStudent = function() {
        sruService.loadStudent($scope.studentId, function(data){
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
                    $log.debug("error retrieving details");
                });
        }
        else {
            $http.post('/api/student/create?fName=' +$scope.student.firstName + '&lName=' +$scope.student.lastName)
                .success(function (data) {
                    $location.url('/addStudent');
                    $scope.student = {};
                    $scope.message='Student Created';
                })
                .error(function (error) {
                    $log.debug("error retrieving details");
                });
        }
    }
    $scope.goToList = function () {
        $location.url('/');
    }
});