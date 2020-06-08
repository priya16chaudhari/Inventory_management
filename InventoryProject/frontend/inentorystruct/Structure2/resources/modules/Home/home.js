app.controller("homeCtrl",function($state,$scope,$http,$window,$timeout,$q,inventoryService,$element){
 $scope.date = new Date();
$scope.firstBtn = true;

      $scope.searchTerm;
      $scope.clearSearchTerm = function() {
        $scope.searchTerm = '';
      };
      $element.find('input').on('keydown', function(ev) {
          ev.stopPropagation();
      });



  

$scope.cheackqty=function(inventoryobj6)
{
	// alert("cheackqty"+JSON.stringify(inventoryobj6));

	if (inventoryobj6.productUnit<inventoryobj6.qtty) {
		alert("Limited Stock")
	}
	else 
	{
		// alert("nooooo");

		$scope.firstBtn = false;

	}

}

 $scope.resetdata=function()
   {
   		$scope.customerobj=null;
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





    $scope.resetdata1=function()
   {
   		$scope.inventoryobj=null;
   }
     $scope.initBtn1=function(){
        $scope.btnSave1=true;
        $scope.btnUpdate1=false;
     }

     $scope.updateBtn1=function(){
        $scope.btnSave1=false;
        $scope.btnUpdate1=true;
     }
     $scope.initBtn1();


$scope.mobList=[{
"mobNo":"9999999999"},
{"mobNo":"8888888888"},
{"mobNo":"6666666666"},
];

this.getMatchess = function(searchTextt) 
{
var deferred = $q.defer();
$timeout(function() {
var statess = $scope.mobList.filter(function(state) 
{
return (state.mobNo.toUpperCase().indexOf(searchTextt.toUpperCase()) !== -1); 
});
deferred.resolve(statess);
}, 1500);
return deferred.promise;
}

$scope.asdd=function(){
  alert('hi');
}

$scope.printToCart = function(printSectionId) {
        var innerContents = document.getElementById(printSectionId).innerHTML;
        var popupWinindow = window.open('', '_blank', 'width=600,height=700');
        popupWinindow.document.open();
        popupWinindow.document.write('<html><head><link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css"><link href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css"></head><body onload="window.print()">' + innerContents + '</html>');
        popupWinindow.document.close();
      }

//Customer

$scope.customerobj={};
$scope.inserDetailsCustomer=function(customerobj)
{
	inventoryService.insertCustomerRecord(customerobj).then(function(response){
		if (response.data.statusCode == 200)
		 {
			alert('Insert Succesfully');
			$scope.getListCustomer();
			// $scope.resetdata();
			
		}
		else
		{
			alert('Insert Failed');
		}
	})
}


$scope.getListCustomer=function()
{
	inventoryService.getCustomerRecord().then(function(response){
	$scope.customerDetailList=response.data;


	})
}
$scope.getListCustomer();

$scope.showcustomer=false;


$scope.customerDetailListnamewise=[]
$scope.getCutomerNames=function(pp1)
{


	if ($scope.myVar1) {

		$scope.showcustomer=true;
		$scope.showmobile=false;
	}


	inventoryService.customerdetailsList(pp1).then(function(response){
	$scope.customerDetailListnamewise=response.data.result;

$scope.inventoryobj8={};
         // alert("student list response is"+JSON.stringify($scope.customerDetailListnamewise));

	})
}



$scope.editCustomer=function(customerId)
{
  
  // alert("hhhhhhhhhhhhhh");
    $scope.updateBtn();
    // alert("ediy");
   inventoryService.editCustomerRecordIdWise(customerId).then(function(response)
   {
      $scope.customerobj=response.data.result;
      
      
   })
}



$scope.updateCustomer=function(customerobj)
{		
// alert("update");
	inventoryService.updateCustomerRecord(customerobj).then(function(response)
	{
		// alert("update api");
		if(response.data.statusCode==200)
		{
			alert("update successfully");
			// alert(response.data);
				$scope.getListCustomer();
				$scope.resetdata();
		}
		else
		{
			alert("update failed");
		}
	})
}

$scope.delete=function(customerId)
{
	inventoryService.deleteCustomerRecord(customerId).then(function(response){
		if (response.data.statusCode == 200)
		 {
			alert('delete Succesfully');
			$scope.getListCustomer();
			
		}
		else
		{
			alert('delete Failed');
		}
	})
}


$scope.getCustomerList=function()
{
   inventoryService.getCutomerName().then(function(response){
   $scope.customerNameList=response.data.result;


   })
}
$scope.getCustomerList();
	$scope.showmobile=false;
$scope.getContactDetailMobile=function(cotactNumber)
{

	if (cotactNumber!=" ") {

		$scope.showmobile=true;
			$scope.showcustomer=false;
	}
   inventoryService.getDetailsMobileNumberWise(cotactNumber).then(function(response){
   $scope.customerDetailMobile=response.data.result;


$scope.inventoryobj1={};


         // alert("student list  is"+JSON.stringify($scope.customerDetailMobile));

   })
}

// $scope.getContactDetailMobile();

//Inventory



$scope.inventoryobj={};
$scope.inserDetails=function(inventoryobj)
{
	inventoryService.insertInventoryRecord(inventoryobj).then(function(response){
		if (response.data.statusCode == 200)
		 {
			alert('Insert Succesfully');
			$scope.getList();


$scope.getListProductLists();

			
		}
		else
		{
			alert('Insert Failed');
		}
	})
}
$scope.delete1=function(productId)
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


$scope.edit1=function(productId)
{
   // alert("hiii");

    $scope.updateBtn1();

// alert("djhfdfgh"+JSON.stringify($scope.productId));
   

   inventoryService.editinventoryRecordIdWise(productId).then(function(response)
   {
      $scope.inventoryobj=response.data.result;
      
      
   
   })
}


$scope.update1=function(inventoryobj)
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



$scope.getListProductLists=function()
{
   inventoryService.getInventoryRecordProductName().then(function(response){
   $scope.productNamesLis=response.data.result;

   
   
   })
}
$scope.getListProductLists();



$scope.inventoryobj6={};
$scope.editss=function(pp)
{
	
$scope.inventoryobj7={}


        
	inventoryService.editinventoryRecordproductNames($scope.inventoryobj4.pp).then(function(response)
	{

	


		$scope.inventoryobj6=response.data.result;


	})
}

$scope.next=function(inventoryobj6)
{
	if ($scope.myVar) {
		

$scope.inventoryobj6.productUnit=$scope.inventoryobj6.productUnit-$scope.inventoryobj6.qtty;


	inventoryService.updateinventoryRecordfinal(inventoryobj6).then(function(response)
	{
		// alert("update api");
		if(response.data.statusCode==200)
		{
			// alert("update successfully");
			// alert(response.data);
				$scope.getList();
		}
		else
		{
			// alert("update failed");
		}
	})



	}


}

});


app.service('inventoryService',function($http){
//customer
  this.insertCustomerRecord=function(customerobj){
    //alert(stud);
    return $http.post(hostUrl+"insertCustomerRecord",customerobj);
  }

 this.getCustomerRecord=function(){
 //  alert(inventoryobj);
    return $http.get(hostUrl+"getCustomerRecord");
       }



 this.customerdetailsList=function(customerobj){
 //  alert(inventoryobj);
    return $http.post(hostUrl+"customerdetailsList",customerobj);
       }

this.editCustomerRecordIdWise=function(customerId){
return $http.post(hostUrl+"editCustomerRecordIdWise/"+customerId);  
}

this.updateCustomerRecord=function(customerobj){
return $http.post(hostUrl + "updateCustomerRecord",customerobj);	
}


this.deleteCustomerRecord=function(customerId){
return $http.delete(hostUrl + "deleteCustomerRecord/"+customerId);  
}


  this.getCutomerName=function(){
 //  alert(inventoryobj);
    return $http.get(hostUrl+"getCutomerName");
       }

this.getDetailsMobileNumberWise=function(contactNumber){
return $http.get(hostUrl+"getDetailsMobileNumberWise/"+contactNumber);  
}

//inventory


 this.insertInventoryRecord=function(inventoryobj){
    //alert(stud);
    return $http.post(hostUrl+"insertInventoryRecord",inventoryobj);
  }


 this.getInventoryRecord=function(){
 //  alert(inventoryobj);
    return $http.get(hostUrl+"getInventoryRecord");
       }



this.editinventoryRecordIdWise=function(productId){
return $http.post(hostUrl + "editinventoryRecordIdWise/"+productId);  
}

this.updateinventoryRecord=function(inventoryobj){
return $http.post(hostUrl + "updateinventoryRecord",inventoryobj);	
}



this.updateinventoryRecordfinal=function(inventoryobj6){
return $http.post(hostUrl + "updateinventoryRecordfinal",inventoryobj6);	
}


this.deleteInventoryRecord=function(productId){
return $http.delete(hostUrl + "deleteInventoryRecord/"+productId);  
}


        this.getInventoryRecordProductName=function(){
 //  alert(inventoryobj);
    return $http.get(hostUrl+"getInventoryRecordProductName");
       }




this.editinventoryRecordproductNames=function(inventoryobj4){
return $http.post(hostUrl + "editinventoryRecordproductNames",inventoryobj4);	
}

});



