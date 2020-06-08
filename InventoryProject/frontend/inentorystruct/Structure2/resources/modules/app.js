var app=angular.module('myApp', ['ngMaterial','ui.router','ui.bootstrap','smart-table','ngSanitize']);


var hostUrl="http://localhost:9911/";


app.config(function($stateProvider, $urlRouterProvider) 
{

	$urlRouterProvider.otherwise('/login');
 	$stateProvider

.state('staffInfo', {
    
    url : '/staffInfo',

    templateUrl : 'resources/modules/StaffMaster/staffInfo.html'

    })

.state('pdf', {
    
    url : '/pdf',

    templateUrl : 'resources/modules/Pdf/pdf.html'

    })

.state('home', {
    
    url : '/home',

    templateUrl : 'resources/modules/Home/home.html'

    })

.state('first', {
    
    url : '/first',

    templateUrl : 'resources/modules/First/first.html'

    })

.state('login', {
    
    url : '/login',

    templateUrl : 'resources/modules/Login/login.html'

    })
 });

