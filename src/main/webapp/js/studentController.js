/**
 * Created by devendra on 4/18/2016.
 */

var app = angular.module("Springs", []);

app.controller("studentController", function($scope,$http, studentService, $log) {
    $scope.students = [];
    $scope.student = {};

    $scope.loadStudents = function() {
        studentService.loadStudents($scope.loadStudentsComplete);
    }
    $scope.loadStudentsComplete = function(data){
        $scope.students = data;
    }

    $scope.loadStudent = function(student) {
        studentService.loadStudent(student, function(data){
            $scope.student = data;
        });

    }


    $scope.createAccount = function() {
        studentService.createAccount($scope.student, function(){
            $scope.loadStudents();
            $scope.student={};
        });
    }

    $scope.deleteStudent=function(student){
        studentService.deleteStudent(student,function(){
            $scope.loadStudents();
        });
    }

    /* $scope.deleteStudent = function (student) {
         $http.delete('/api/student/delete?id=' + student.studentId)
             .success(function (message) {
                 $log.debug("account deleted");
                 $scope.loadStudents();
             })
             .error(function (error) {
                 $log.debug("error retrieving data");
             });
     }*/

    $scope.loadStudents();

});


/* $scope.createAccount = function () {
     studentService.createAccount($scope.student, function(){
            $scope.loadStudents();
     });
 }

 $scope.deleteStudent = function (student) {
     studentService.deleteStudent(student, function(data){
        $scope.student=data;
     });
 }

 $scope.loadStudents();
});*/
