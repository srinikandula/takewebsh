angular.module('myApp',[])
       .controller('myController',function ($scope) {
          $scope.message = "welcome to my page"
       })
        // .directive('myDirective',function () {
        //     return{
        //         templateUrl: 'index1.html',
        //         transclude: true,
        //         link: function (scope,iElement,iAttributes,controller, transclude) {
        //             var content = transclude();
        //             iElement.find("#one").append(content);
        //         }
        //     }
        // })
        .directive('myDirective',function () {
            return{
                templateUrl: 'index1.html',
                transclude: true,
                    controller: function ($scope,$element,$attrs, $transclude) {
                    var content = $transclude();
                    $element.find("#one").append(content);
                }
            }
        })