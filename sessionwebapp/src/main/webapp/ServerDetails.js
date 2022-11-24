var serverFunction = function($scope, $http)
{
        $scope.server={"sessionCounter":"", "ipAddress":"","hostName":""};


        $scope.alertData = function()
        {
	            
                var httpcall = $http.get("ServerDetails");
                httpcall.then(retval);
        };

        var retval=function(response) 
        {


         $scope.server=response.data;


        };

};

var app = angular.module('ServerModule',[]);
app.controller('ServerController', serverFunction);