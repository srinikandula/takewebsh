var app = angular.module("sruApp");

app.controller("listController", function($scope, sruService, $location) {
    $scope.students = [];
    $scope.student = {};

    $scope.loadStudents = function() {
        sruService.loadStudents($scope.loadCompleteStudents);
    }
    $scope.loadCompleteStudents = function(data){
        $scope.students = data;
    }
    $scope.gotostudentCreate = function(){
        $location.url('/addStudent');
    }
    $scope.loadStudent = function(studentId){
        $location.url('/updateStudent/'+studentId);
    }
    $scope.deleteStudent = function(studentId) {
        studentService.deleteStudent(studentId, function() {
            $scope.loadStudents();
        });
    }
    $scope.loadStudents();
});