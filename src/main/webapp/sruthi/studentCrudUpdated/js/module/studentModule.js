"use strict";

angular.module('myApp.studentModule',['ui.bootstrap','ngTable'])
    .controller("studentController",function($rootScope, $scope, $uibModal, $log, studentService, NgTableParams, $filter){
        $scope.students = [];
        $scope.student = {};
        $scope.currentPageOfStudents=[];

        var loadTableData = function (tableParams, $defer) {
            var data = studentService.getStudents();
            if(tableParams) {
                var orderedData = tableParams.sorting() ? $filter('orderBy')(data, tableParams.orderBy()) : data;
                $scope.students = orderedData;
                tableParams.total(data.length);
                tableParams.data = orderedData;
                if (angular.isDefined($defer)) {
                    $defer.resolve(orderedData);
                }
                $scope.currentPageOfStudents = orderedData.slice((tableParams.page() - 1) * tableParams.count(), tableParams.page() * tableParams.count());
            }
        };

        $scope.$on('studentsInitComplete', function (e, value) {
            loadTableData($scope.studentsContentTableParams);
        });
        $scope.$on('studentsInitStart', function (e, value) {
            studentService.loadStudents();
        });
        $scope.studentsContentTableParams = new NgTableParams(
            {
                page: 1,
                count:25,
                sorting: {
                    firstName: 'asc'
                },
            },
            {
                total: $scope.currentPageOfStudents.length,
                getData: function (params) {
                    console.log('sort..');
                    loadTableData(params);
                }
            }
        );


        $scope.loadStudents = function() {
            studentService.loadStudents($scope.loadStudentsComplete);
        };
        $scope.loadStudentsComplete = function(data){
            $scope.students = data;
        };

        $scope.handleClickAddStudent = function (size) {
            $rootScope.modalInstance = $uibModal.open({
                templateUrl: 'add-student-modal.html',
                controller: 'studentAddController',
                size: size,
                resolve: {
                    studentId: function () {
                        return null;
                    }
                }
            });
        };

        $scope.handleClickUpdateStudent = function (studentId) {
            $rootScope.modalInstance = $uibModal.open({
                templateUrl: 'update-student-modal.html',
                controller: 'studentAddController',
                resolve: {
                    studentId: function () {
                        return studentId;
                    }
                }
            });
        };

        $scope.deleteStudent = function(studentId) {
            studentService.deleteStudent(studentId, function() {
                $scope.loadStudents();
            });
        }

        $scope.loadStudents();

    })

    .controller("studentAddController", function($scope, $rootScope, studentService, $http, $log, $location, studentId) {
        $scope.students = [];
        $scope.student = {};

        $scope.cancel = function () {
            $rootScope.modalInstance.dismiss('cancel');
        };
        $scope.isInputValid = function () {
            return ($scope.student.firstName  || '') !== '';
        };


        $scope.loadStudent = function() {
            studentService.loadStudent(studentId, function(data){
                $scope.student = data;
            });
        }
        if(studentId) {
            $scope.loadStudent();
        }
        $scope.createStudent = function() {
            if($scope.student.studentId) {
                $http.put('/api/student/update/'+$scope.student.studentId +'?firstName='+$scope.student.firstName+'&lastName='+$scope.student.lastName)
                    .success(function (data) {
                        swal("Great", "Student Data has been updated successfully", "success");
                        $scope.student = {};
                        $rootScope.$broadcast('studentsInitStart')
                        $rootScope.modalInstance.dismiss('Updated');
                    })
                    .error(function (error) {
                        $log.debug("error retrieving student details");
                        swal("oops", error, "error");
                    });
            }
            else {
                $http.post('/api/student/create?fName=' +$scope.student.firstName + '&lName=' +$scope.student.lastName)
                    .success(function (data) {
                        swal("Great", "Student Data has been successfully added", "success");
                        $scope.student = {};
                        $rootScope.$broadcast('studentsInitStart')
                        $rootScope.modalInstance.dismiss('Saved');

                    })
                    .error(function (error) {
                        $log.debug("error retrieving student details");
                        swal("oops", error, "error");
                    });
            }
        }
    })


    .factory('studentService',function ($rootScope,$log,$http) {
        var students = [];
        return {
            loadStudents: function (loadComplete) {
                $http.get('/api/student/list')
                    .then(function(response){
                        students = response.data;
                        $rootScope.$broadcast('studentsInitComplete');
                    },function(error){
                        swal("oops", error, "error");
                    });
            },

            getStudents: function () {
                return students;
            },
            loadStudent: function (studentId, loadComplete) {
                $http.get('/api/student/' + studentId)
                    .success(function (data) {
                        loadComplete(data);
                    })
                    .error(function (error) {
                        $log.debug("error retrieving student details");
                    });
            },
            deleteStudent: function (studentId, callback) {

                swal({
                        title: "Are you sure?",
                        text: "Are you sure you want to delete the Student Data?",
                        type: "warning",
                        showCancelButton: true,
                        closeOnConfirm: false,
                        confirmButtonText: "Yes, delete it!",
                        confirmButtonColor: "#ec6c62"
                    }, function () {

                        $http.delete('/api/student/delete?id=' + studentId)
                            .success(function (message) {
                                callback(message);
                                swal("Deleted!", "Data has been deleted successfully!", "success");
                            })
                            .error(function (error) {
                                $log.debug("error deleting student details");
                                swal("Oops", "We couldn't connect to the server!", "error");
                            });
                    }
                )
            }
        }
});