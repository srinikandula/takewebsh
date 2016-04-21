/**
 * Created by devendra on 4/18/2016.
 */

var app = angular.module("Springs", []);

app.controller("studentController", function($scope, $http, $log) {
    $scope.students = [];
    $scope.student = {};
    $scope.loadStudents = function () {
        $http.get('/api/student/list')
            .success(function (data) {
                $scope.students = data;
            })
            .error(function (error) {
                $log.debug("error retrieving data");

            });
    }
    $scope.loadStudent = function (student) {
        $http.get('/api/student/' + student.studentId)
            .success(function (data) {
                $scope.student = data;
            })
            .error(function (error) {
                $log.debug("error retrieving accounts");
            });
    }
    $scope.createAccount = function () {
        if ($scope.student.studentId) {
            $http.put('/api/student/update/' + $scope.student.studentId + '?firstName=' + $scope.student.firstName + '&lastName=' + $scope.student.lastName)
                .success(function (data) {
                    $scope.loadStudents();
                    $scope.student = {};
                })
                .error(function (error) {
                    $log.debug("error retrieving accounts");
                });
        } else {
            $http.post('/api/student/create?fName=' + $scope.student.firstName + '&lName=' + $scope.student.lastName)
                .success(function (data) {
                    $scope.loadStudents();
                    $scope.student = {};
                })
                .error(function (error) {
                    $log.debug("error retrieving data");

                });
        }
    }
    $scope.deleteStudent = function (student) {
        $http.delete('/api/student/delete?id=' + student.studentId)
            .success(function (message) {
                $log.debug("account deleted");
                $scope.loadStudents();
            })
            .error(function (error) {
                $log.debug("error retrieving data");
            });
     }

    $scope.loadStudents();

});
