var ara = angular.module("sruApp");
ara.factory('sruService',function ($rootScope,$log,$http) {
    var students=[];
    return {
        loadStudents: function(loadComplete) {
            $http.get('/api/student/list')
                .success(function (students) {
                    loadComplete(students);
                })
                .error(function (error) {
                    $log.debug("error retrieving details");
                });
        },
        loadStudent: function(studentId, loadComplete) {
            $http.get('/api/student/'+studentId)
                .success(function (data) {
                    loadComplete(data);
                })
                .error(function (error) {
                    $log.debug("error retrieving details");
                });
        },
        deleteStudent: function(studentId, callback){
            $http.delete('/api/student/delete?id='+studentId)
                .success(function (message) {
                    callback(message);
                })
                .error(function (error) {
                    $log.debug("error deleting details");
                });
        },
    }
});