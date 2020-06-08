app.controller("logCtrl",function($state,$scope,$http,$window){




$scope.login=function()
{
var uname = $scope.username;
var pass = $scope.password;

if ($scope.username == 'admin' && $scope.password == 'admin') {
alert('Login Sucessfull');
$state.go('home');
}
else
{
alert('Login Failed');
$scope.username = null;
$scope.password = null;
}
}

});