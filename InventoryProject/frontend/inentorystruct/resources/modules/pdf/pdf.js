app.controller('pdfCtrl', function($state,$scope,$timeout,pdfService,$q) {
 $scope.date = new Date();
 $scope.printToCart = function(printSectionId) {
        var innerContents = document.getElementById(printSectionId).innerHTML;
        var popupWinindow = window.open('', '_blank', 'width=600,height=700');
        popupWinindow.document.open();
        popupWinindow.document.write('<html><head><link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css"><link href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css"></head><body onload="window.print()">' + innerContents + '</html>');
        popupWinindow.document.close();
      }







$scope.getList=function()
{
	pdfService.getCustomerRecord().then(function(response){
	$scope.inventoryDetailsList=response.data;


	})
}
$scope.getList();



$scope.getListproduct=function()
{
	pdfService.getInventoryRecord().then(function(response){
	$scope.inventoryDetailsList1=response.data;


	})
}
$scope.getListproduct();



});



app.service('pdfService',function($http){

  // this.insertInventoryRecord=function(inventoryobj){
  //   //alert(stud);
  //   return $http.post(hostUrl+"insertInventoryRecord",inventoryobj);
  // }



 this.getCustomerRecord=function(){
 //  alert(inventoryobj);
    return $http.get(hostUrl+"getCustomerRecord");
       }



// this.editinventoryRecordproductNames=function(inventoryobj){
// return $http.post(hostUrl + "editinventoryRecordproductNames",inventoryobj);	
// }

//         this.getInventoryRecordProductName=function(){
//  //  alert(inventoryobj);
//     return $http.get(hostUrl+"getInventoryRecordProductName");
//        }



// this.editinventoryRecordproductNames=function(inventoryobj){
// return $http.post(hostUrl + "editinventoryRecordproductNames",inventoryobj);	
// }


// this.editinventoryRecordIdWise=function(productId){
// return $http.post(hostUrl + "editinventoryRecordIdWise/"+productId);  
// }

// this.updateinventoryRecord=function(inventoryobj){
// return $http.post(hostUrl + "updateinventoryRecord",inventoryobj);	
// }
// this.deleteInventoryRecord=function(productId){
// return $http.delete(hostUrl + "deleteInventoryRecord/"+productId);  
// }

});


