"use strict";

var ser = angular.module("myApp");
ser.factory('studentService',function ($rootScope,$log,$http) {
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