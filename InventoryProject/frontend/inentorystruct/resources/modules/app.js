var app=angular.module('myApp', ['ngMaterial','ui.router','ui.bootstrap','smart-table','ngSanitize']);


var hostUrl="http://localhost:8123/";


app.config(function($stateProvider, $urlRouterProvider) 
{

	$urlRouterProvider.otherwise('/staffInfo');
 	$stateProvider

 	

 


.state('staffInfo', {
    
    url : '/staffInfo',

    templateUrl : 'resources/modules/staffInfo/staffInfo.html'

    })





.state('pdf', {
    
    url : '/pdf',

    templateUrl : 'resources/modules/pdf/pdf.html'

    })








 });

