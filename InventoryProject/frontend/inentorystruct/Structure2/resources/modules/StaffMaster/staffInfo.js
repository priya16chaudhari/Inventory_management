app.controller('inventoryCtrl', function($state,$scope,$timeout,inventoryService,$q) {

$scope.bankList=[{
"bankName":"Bank of Baroda"},
{"bankName":"Bank of India"},
{"bankName":"Bank of Maharashtra"},
{"bankName":"Canara Bank"},{"bankName":"Central Bank of India"},{"bankName":"Indian Bank"},{"bankName":"Indian Overseas Bank"},{"bankName":"Punjab and Sind Bank"},
{"bankName":"State Bank of India"},{"bankName":"UCO Bank"},{"bankName":"Union Bank of India"},{"bankName":"Axis Bank"},{"bankName":"HDFC Bank"},{"bankName":"IndusInd Bank"},{"bankName":"ICICI Bank"},{"bankName":"Yes Bank"}];

this.getMatches = function(searchText) 
{
var deferred = $q.defer();
$timeout(function() {
var states = $scope.bankList.filter(function(state) 
{
return (state.bankName.toUpperCase().indexOf(searchText.toUpperCase()) !== -1); 
});
deferred.resolve(states);
}, 1500);
return deferred.promise;
}

$scope.asd=function(){
  alert('hi');
}

     $scope.initBtn=function(){
        $scope.btnSave=true;
        $scope.btnUpdate=false;
     }

     $scope.updateBtn=function(){
        $scope.btnSave=false;
        $scope.btnUpdate=true;
     }
     $scope.initBtn();

$scope.inventoryDetailsList=[];



$scope.inventoryDetailsList1=[];

$scope.list1=[];
   $scope.resetdata=function()
   {
   		$scope.inventoryobj=null;
   }

$scope.inventoryobj={};
$scope.inserDetails=function(inventoryobj)
{
	inventoryService.insertInventoryRecord(inventoryobj).then(function(response){
		if (response.data.statusCode == 200)
		 {
			alert('Insert Succesfully');
			$scope.getList()
			
		}
		else
		{
			alert('Insert Failed');
		}
	})
}

$scope.getList=function()
{
	inventoryService.getInventoryRecord().then(function(response){
	$scope.inventoryDetailsList=response.data;


	})
}
$scope.getList();



$scope.getListProductList=function()
{
   inventoryService.getInventoryRecordProductName().then(function(response){
   $scope.inventoryDetailsList1=response.data.result;

   
   // // console.log("student list response is"+JSON.stringify(response));    
   //       console.log("student list  is"+JSON.stringify($scope.inventoryDetailsList1));



   // //       alert("student list response is"+JSON.stringify(response));

   //       alert("student list  is"+JSON.stringify($scope.inventoryDetailsList1));
   
   })
}
$scope.getListProductList();



   $scope.edit=function(row){
      
     $scope.inventoryobj=row;
     $scope.updateBtn();
     }



// $scope.edit=function(a)
// {
// 	alert("hiiii");

// 	alert("data"+JSON.stringify($scope.a));
// // $scope.proName={}
// // 	$scope.proName=$scope.inventoryobj.productName;

// alert("djdksdksd"+JSON.stringify($scope.proName));
// 	inventoryService.editinventoryRecord($scope.proName).then(function(response)
// 	{
// 		$scope.list1=response.data;
		
		
// 	console.log("student list response is"+JSON.stringify(response));		
// 			console.log("student list  is"+JSON.stringify($scope.list1));



// 			alert("student list response is"+JSON.stringify(response));

// 			alert("student list  is"+JSON.stringify($scope.list1));
	
// 	})

// }

// 	$scope.proName={};

// $scope.edit=function(proName)
// {
// 	alert("hiii");

// 	alert("lgjkfjgkfgjfkgjfgf"+JSON.stringify($scope.proName));

// 	inventoryService.editinventoryRecord(proName).then(function(response)
// 	{
// 		$scope.list1=response.data;
		
		
// 	console.log("student list response is"+JSON.stringify(response));		
// 			console.log("student list  is"+JSON.stringify($scope.list1));



// 			// alert("student list response is"+JSON.stringify(response));

// 			// alert("student list  is"+JSON.stringify($scope.list1));
	
// 	})
// }



// $scope.editss=function(productId)
// {
//    alert("hiii");

// alert("djhfdfgh"+JSON.stringify($scope.productId));
   

//    inventoryService.editinventoryRecordIdWise(productId).then(function(response)
//    {
//       $scope.list3=response.data;
      
      
//    console.log("student list response is"+JSON.stringify(response));    
//          console.log("student list  is"+JSON.stringify($scope.list3));
   
//    })
// }



// $scope.edit("abcd");

$scope.update=function(inventoryobj)
{		

	inventoryService.updateinventoryRecord(inventoryobj).then(function(response)
	{
		alert("update api");
		if(response.data.statusCode==200)
		{
			alert("update successfully");
			// alert(response.data);
				$scope.getList();
		}
		else
		{
			alert("update failed");
		}
	})
}

});




app.service('inventoryService',function($http){

  this.insertInventoryRecord=function(inventoryobj){
    //alert(stud);
    return $http.post(hostUrl+"insertInventoryRecord",inventoryobj);
  }



 this.getInventoryRecord=function(){
 //  alert(inventoryobj);
    return $http.get(hostUrl+"getInventoryRecord");
       }


        this.getInventoryRecordProductName=function(){
 //  alert(inventoryobj);
    return $http.get(hostUrl+"getInventoryRecordProductName");
       }



this.editinventoryRecord=function(productName){
return $http.post(hostUrl + "editinventoryRecord/"+productName);	
}


this.editinventoryRecordIdWise=function(productId){
return $http.post(hostUrl + "editinventoryRecordIdWise/"+productId);  
}

this.updateinventoryRecord=function(inventoryobj){
return $http.post(hostUrl + "updateinventoryRecord",inventoryobj);	
}


});

