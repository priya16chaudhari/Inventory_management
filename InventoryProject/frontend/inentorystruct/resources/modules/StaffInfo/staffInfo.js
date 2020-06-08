app.controller('inventoryCtrl', function($state,$scope,inventoryService,$window) {



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
$scope.delete=function(productId)
{
	inventoryService.deleteInventoryRecord(productId).then(function(response){
		if (response.data.statusCode == 200)
		 {
			alert('delete Succesfully');
			$scope.getList();
			
		}
		else
		{
			alert('delete Failed');
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

         // alert("student list  is"+JSON.stringify($scope.inventoryDetailsList1));
   
   })
}
$scope.getListProductList();



   $scope.edit=function(row){
      
     $scope.inventoryobj=row;
     $scope.updateBtn();
     }






$scope.list3=[]
$scope.inventoryobj2={}

// $scope.h={}

$scope.editss=function(pp)
{
	// alert("hiii");

	// alert("dfdfd"+JSON.stringify($scope.inventoryobj.pp));

	  // inventoryobj.inventoryModel = inventoryobj.inventoryModel;
   //      inventoryobj.productId = inventoryobj.inventoryModel.productId;

        
	inventoryService.editinventoryRecordproductNames($scope.inventoryobj.pp).then(function(response)
	{

	
		$scope.inventoryobj2=response.data.result;


			// alert("obj"+JSON.stringify($scope.inventoryobj2));


			// alert("data"+JSON.stringify($scope.inventoryobj2.detailList.productName));
			// 	alert("list"+JSON.stringify($scope.inventoryobj2.detailList));


				$scope.list3=$scope.inventoryobj2.detailList;

				// $scope.h=$scope.list3;

				// alert("h"+JSON.stringify($scope.h));
				alert("h"+JSON.stringify($scope.inventoryobj2.productName));
				
// $scope.a = $scope.list3[2];
// console.log($scope.a);
	})
}



$scope.edit=function(productId)
{
   // alert("hiii");

    $scope.updateBtn();

// alert("djhfdfgh"+JSON.stringify($scope.productId));
   

   inventoryService.editinventoryRecordIdWise(productId).then(function(response)
   {
      $scope.inventoryobj=response.data.result;
      
      
   // console.log("student list response is"+JSON.stringify(response));    
   //       console.log("student list  is"+JSON.stringify($scope.list3));



         // alert("student list response is"+JSON.stringify(response));

         // alert("student list  is"+JSON.stringify($scope.list1));
   
   })
}



// $scope.edit("abcd");

$scope.update=function(inventoryobj)
{		

	inventoryService.updateinventoryRecord(inventoryobj).then(function(response)
	{
		// alert("update api");
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

$scope.b={}


$scope.a=function(pp)
{
	alert("ff"+JSON.stringify(pp));
    // var name = $scope.list3[index].productName;
    //             var country = $scope.list3[index].productSpecification;
    //             $window.alert("Name: " + name + "\nCountry: " + country);// alert("hiii");

//   alert("product NAme"+JSON.stringify($scope.inventoryobj.pp));

//   alert("qty"+JSON.stringify($scope.inventoryobj.qty));
// alert("qty"+JSON.stringify($scope.inventoryobj.qty));

// $scope.b=$scope.inventoryobj.pp;
// $scope.b=$scope.inventoryobj.qty;

// alert("hfhvf"+JSON.stringify($scope.b));
// alert("djhfdfgh"+JSON.stringify($scope.productId));
   

   // inventoryService.editinventoryRecordIdWise(productId).then(function(response)
   // {
   //    $scope.inventoryobj=response.data.result;
      
      
   // // console.log("student list response is"+JSON.stringify(response));    
   // //       console.log("student list  is"+JSON.stringify($scope.list3));



   //       alert("student list response is"+JSON.stringify(response));

   //       alert("student list  is"+JSON.stringify($scope.list1));
   
   // })
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



this.editinventoryRecordproductNames=function(inventoryobj){
return $http.post(hostUrl + "editinventoryRecordproductNames",inventoryobj);	
}


this.editinventoryRecordIdWise=function(productId){
return $http.post(hostUrl + "editinventoryRecordIdWise/"+productId);  
}

this.updateinventoryRecord=function(inventoryobj){
return $http.post(hostUrl + "updateinventoryRecord",inventoryobj);	
}
this.deleteInventoryRecord=function(productId){
return $http.delete(hostUrl + "deleteInventoryRecord/"+productId);  
}

});

