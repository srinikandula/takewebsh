/**
 * Created by devendra on 4/21/2016.
 */

'use strict';

var Springs = angular.module('Springs');
Springs.factory('studentService',function($rootScope, $http, $log, $window){
    return {

        loadStudents:function(loadComplete) {
            $http.get('/api/student/list')
                .success(function (students) {
                    loadComplete(students);
                })
                .error(function (error) {
                    $log.debug("error retrieving accounts");
                });
        },

        loadStudent:function(studentId, loadComplete) {
            $http.get('/api/student/' + studentId)
                .success(function (data) {
                    loadComplete(data);
                })
                .error(function (error) {
                    $log.debug("error retrieving accounts");
                });
        },

        deleteStudent:function(studentId,callBackFunction) {
            $http.delete('api/student/delete?id='+studentId)
                .success(function(message) {
                    $log.debug("account deleted");
                    callBackFunction();
                })
                .error(function (error) {
                    $log.debug("error retrieving data");
                });
        },
        createAccount: function (student,callBackFunction) {
            if (student.studentId) {
                $http.put('/api/student/update/'+student.studentId +'?firstName='+student.firstName+'&lastName='+student.lastName)
                    .success(function (data) {
                        callBackFunction(data);
                    })
                    .error(function (error) {
                        $log.debug("error retrieving accounts");
                    });
            } else {
                $http.post('/api/student/create?fName=' +student.firstName + '&lName=' +student.lastName)
                    .success(function (data) {
                       callBackFunction(data);
                    })
                    .error(function (error) {
                        $log.debug("error retrieving data");

                    });
            }
        }
    }


});