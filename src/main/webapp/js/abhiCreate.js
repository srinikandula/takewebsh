var mod = angular.module("myApp", [])
    .controller("myController", function ($scope) {
        var employees = [
            {firstName : "Abhinav",lastName : "Surapaneni",email : "abhirocksnow@gmail.com",phone : 8326829666 },
            {firstName : "Sruthi",lastName : "Chintalapati",email : "chsruthi94@gmail.com",phone : 8322751165 },
            {firstName : "Sri Harsha",lastName : "Kota",email : "sharsha142@gmail.com",phone : 6176506713 },
            {firstName : "Vamsidhar",lastName : "Grandhi",email : "vamsigrandhi@gmail.com",phone : 8326829506 }
        ];
        $scope.employees = employees;
    });