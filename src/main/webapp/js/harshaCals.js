/**
 * Created by sriharshakota on 3/7/17.
 */
var x;
var app = angular.module("myApp",[]);
app.controller ("myCtrl", function($scope){

    var user = {
        operand1 : '',
        operator : '',
        operand2 : ''
    };

    $scope.num = function(nom){

        if (user.operand1 == eval(x) && (user.operator != ''))
        {
            user.operand2 += nom;
            $scope.output = user.operand2;

        }


        else
        {
            if (user.operator == "")
            {
                user.operand1 += nom;
                $scope.output = user.operand1;

            }
            else if ((user.operand1 != '') && (user.operator != '') )
            {
                user.operand2 += nom;
                $scope.output = user.operand2;

            }
            else{
                $scope.output = "Undefined";

            }

        }

    };


    $scope.myOperator = function (command)
    {
        $scope.output = command;
        user.operator = command;
    };

    $scope.equ = function()
    {
        x = user.operand1 + user.operator + user.operand2;
        $scope.output = eval(x);

        user.operand1 = eval(x);
        user.operand2 = '';
        user.operator = '';
    };

    $scope.clearAll = function ()
    {
        $scope.output = '';
        user.operand1 = '';
        user.operand2 = '';
        user.operator = '';

    };

});