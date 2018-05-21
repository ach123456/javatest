<!doctype html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>
            AngularJS 
        </title>
        <!-- Load AngularJS -->
        <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
        <script type="text/javascript">
            var app = angular.module("UserManagement", []);
         
            //Controller Part
            app.controller("UserManagementController", function($scope, $http) {
         
                //Initialize page with default data which is blank in this example
                $scope.vehicals = [];
                $scope.form = {
                    id : -1,
                    car : "",
                    Truck : "",
                    bike : ""
                };
         
                //Now load the data from server
                _refreshPageData();
         
                //HTTP POST/PUT methods for add/edit vehical
                $scope.submitvehical = function() {
         
                    var method = "";
                    var url = "";
                    if ($scope.form.id == -1) {
                        //Id is absent so add vehical - POST operation
                        method = "POST";
                        url = 'vehical';
                    } else {
                        //If Id is present, it's edit operation - PUT operation
                        method = "PUT";
                        url = 'vehical/' + $scope.form.id;
                    }
         
                    $http({
                        method : method,
                        url : url,
                        data : angular.toJson($scope.form),
                        headers : {
                            'Content-Type' : 'application/json'
                        }
                    }).then( _success, _error );
                };
         
                //HTTP DELETE- delete vehical by Id
                $scope.removevehical = function(vehical) {
                    $http({
                        method : 'DELETE',
                        url : 'vehical/' + vehical.id
                    }).then(_success, _error);
                };
 
                //In case of edit vehical, populate form with vehical data
                $scope.editvehical = function(vehical) {
                    $scope.form.car = vehical.car;
                    $scope.form.Truck = vehical.Truck;
                    $scope.form.bike = vehical.bike;
                    $scope.form.id = vehical.id;
                };
         
                /* Private Methods */
                //HTTP GET- get all vehicals collection
                function _refreshPageData() {
                    $http({
                        method : 'GET',
                        url : 'vehical/'
                    }).then(function successCallback(response) {
                        $scope.vehicals = response.data.vehicals;
                    }, function errorCallback(response) {
                        console.log(response.statusText);
                    });
                }
         
                function _success(response) {
                    _refreshPageData();
                    _clearForm()
                }
         
                function _error(response) {
                    console.log(response.statusText);
                }
         
                //Clear the form
                function _clearForm() {
                    $scope.form.car = "";
                    $scope.form.Truck = "";
                    $scope.form.bike = "";
                    $scope.form.id = -1;
                };
            });
        </script>
        <style>
            .button {
                cursor: pointer;
                color: blue;
            }
            td,th{
                border: 1px solid gray;
                width: 25%;
                text-align: left;
            }
            table {
                width: 600px;
            }
        </style>
    <head>
    <body ng-app="UserManagement" ng-controller="UserManagementController">
         <h1>
            AngularJS - Use $http to invoke RESTful APIs
        </h1>
 
        <table>
            <tr>
                <th>car</th>
                <th>Truck</th>
                <th>bike</th>
                <th>Actions</th>
            </tr>
 
            <tr ng-repeat="vehical in vehicals">
                <td>{{ vehical.car }}</td>
                <td>{{ vehical.Truck }}</td>
                <td>{{ vehical.bike }}</td>
                <td><a ng-click="editvehical( vehical )" class="button">Edit</a> | <a ng-click="removevehical( vehical )" class="button">Remove</a></td>
            </tr>
 
        </table>
 
        <h2>Add/Edit vehical</h2>
 
        <form ng-submit="submitvehical()">
            <table>
                <tr>
                    <td>car</td>
                    <td><input type="text" ng-model="form.car" size="60" /></td>
                </tr>
                <tr>
                    <td>Truck</td>
                    <td><input type="text" ng-model="form.Truck" size="60" /></td>
                </tr>
                <tr>
                    <td>bike</td>
                    <td><input type="text" ng-model="form.bike" size="60" /></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Submit" /></td>
                </tr>
            </table>
        </form>
 
    </body>
</html>

