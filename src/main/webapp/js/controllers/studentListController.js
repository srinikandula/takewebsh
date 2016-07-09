/**
 * Created by devendra on 4/28/2016.
 */
"use strict";

var app = angular.module("Springs");

app.controller("StudentListController", function($scope, studentService, $location){
    $scope.students = [];
    $scope.student ={};


    $scope.loadStudents = function() {
        studentService.loadStudents($scope.loadStudentsComplete);
    }
    $scope.loadStudentsComplete = function(data){
    $scope.students = data;
    }

    $scope.gotoCreateStudent = function(){
        $location.url("/student/create");
    }
    $scope.loadStudent = function(studentId){
        $location.url("/student/update/"+studentId);
    }
    $scope.deleteStudent = function(studentId){
        studentService.deleteStudent(studentId, function(){
            $scope.loadStudents();
        });
    }
    $scope.loadStudents();
});