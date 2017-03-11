var app = angular.module("myApp");

app.controller("studentListController", function($scope, studentService, $location) {
    $scope.students = [];
    $scope.student = {};

    $scope.loadStudents = function() {
        studentService.loadStudents($scope.loadStudentsComplete);
    }
    $scope.loadStudentsComplete = function(data){
        $scope.students = data;
    }
    $scope.saveStudent = function(){
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