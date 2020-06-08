app.controller("ComCtrl",function($scope,$state,formService){
	$scope.Obj={};
$scope.getCom=[];

$scope.clear=function()
{
	$scope.Obj=null;
}

$scope.initBtn=function()
{
	alert("init");
	$scope.btnSave=true;
	$scope.btnUpdate=false;
}
$scope.initBtn();

$scope.editbtn=function()
{
	$scope.btnSave=false;
	$scope.btnUpdate=true;
}


$scope.save=function(Obj)
{

	formService.insertComRecord(Obj).then(function(response)
	{
		if(response.data.statusCode==200)
		{
			alert("insert successfully");
			$scope.getlist();
		
		}
		else
		{
			alert("insert failed");
		}
	})
}


$scope.getlist=function()
{

	formService.getComRecord().then(function(response)
	{
		$scope.getCom=response.data;
		// alert(response.data.result);
	})
}

$scope.getlist();


$scope.edit=function(companyId)
{
	
	formService.editComRecord(companyId).then(function(response)
	{
		$scope.Obj=response.data.result;
		alert(response.data.result);
	
	})
}

$scope.update=function(Obj)
{		

	formService.updateComRecord(Obj).then(function(response)
	{
		alert("update api");
		if(response.data.statusCode==200)
		{
			alert("update successfully");
			// alert(response.data);
				$scope.getlist();
		}
		else
		{
			alert("update failed");
		}
	})
}
});
app.service("formService",function($http){
	this.insertComRecord=function(Obj){
return $http.post(hostUrl + "insertComRecord",Obj);

	
}

this.getComRecord=function(){
return $http.get(hostUrl + "getComRecord");	
}

this.editComRecord=function(companyId){
return $http.post(hostUrl + "editComRecord/"+companyId);	
}

this.updateComRecord=function(Obj){
return $http.post(hostUrl + "updateComRecord",Obj);	
}



})
