app.controller('currentUserController',
    function($scope, $http, $location, $filter, Notification, ngTableParams,  $timeout, $window, $rootScope) {

        $scope.hospitalServerURL = "/hospital";
        $scope.word = /^[a-z]+[a-z0-9._]+@[a-z]+\.[a-z.]{2,5}$/;
        $scope.operation = 'Create';
        // $scope.stateName="Karnataka";
        // $scope.city="Bengaluru";
        // $scope.country = "India";




        $scope.adduser = function () {
            $scope.id = 0;
            $scope.firstname = "";
            $scope.lastname = "";
            $scope.email = "";
            $scope.phoneNumber ="";
            $scope.mobileNumber = "";
            $scope.address = "";
            $scope.zipCode ="";
            $scope.age ="";
            $scope.notes = "";
            $scope.username = "";
            $scope.password = "";
            $scope.retypepassword = "";
            $scope.calenderType = "";
            $scope.role=null;
            $scope.getRolesList();
            $("#submit").text("Save");
            $('#user-title').text("Add User");
            $("#add_user").modal('show');
        };


        $scope.saveCurrentUserDetails = function () {
            if (angular.isUndefined($scope.firstname) || $scope.firstname == '') {
                Notification.warning({message: 'firstname cannot be Empty', positionX: 'center', delay: 2000});
            }

            else if(angular.isUndefined($scope.lastname) || $scope.lastname == ''){
                Notification.warning({message: 'lastname can not be Empty', positionX: 'center', delay: 2000});
            }
            else if(angular.isUndefined($scope.username) || $scope.username == ''){
                Notification.warning({message: 'user name can not be Empty', positionX: 'center', delay: 2000});
            }
            // else if(angular.isUndefined($scope.email) || $scope.email == ''){
            //     Notification.warning({message: 'enter valid emailId', positionX: 'center', delay: 2000});
            // }
            // else if(angular.isUndefined() || $scope.retypepassword == ''){
            //     Notification.warning({message: 'retypepassword can not be Empty', positionX: 'center', delay: 2000});
            // }
            // else if(angular.isUndefined($scope.retypepassword) || $scope.retypepassword != $scope.password){
            //     Notification.warning({message: 'password and retype password should be same', positionX: 'center', delay: 2000});
            // }
            else {
                var saveCurrentUserDetails;
                saveCurrentUserDetails = {
                    id: $scope.id,
                    firstName: $scope.firstname,
                    lastName: $scope.lastname,
                    email: $scope.email,
                    phoneNumber: $scope.phoneNumber,
                    mobileNumber: $scope.mobileNumber,
                    city: $scope.city,
                    state: $scope.stateName,
                    country: $scope.country,
                    address: $scope.address,
                    zipCode: $scope.zipCode,
                    age:$scope.age,
                    notes: $scope.notes,
                    username: $scope.username,
                    password: $scope.password,
                    retypepassword: $scope.retypepassword,
                    calenderType: $scope.calenderType,
                    roles:$scope.role
                };
                $http.post($scope.hospitalServerURL + "/saveCurrentUserDetails", angular.toJson(saveCurrentUserDetails)).then(function (response) {
                    var data = response.data;
                    console.log(data);
                    if (data == "") {
                        Notification.error({message: ' Already exists', positionX: 'center', delay: 2000});
                    }
                    else {
                        $scope.getUserList();
                        $scope.getPaginatedUsersList();
                        $("#add_user").modal('hide');

                        Notification.success({
                            message: 'Current User Details is Created  successfully',
                            positionX: 'center',
                            delay: 2000
                        });
                    }
                }, function (error) {
                    Notification.error({
                        message: 'Something went wrong, please try again',
                        positionX: 'center',
                        delay: 2000
                    });
                });
            }
        };

        $scope.countryState = function(country){
            var url = "/hospital/getCountryState?countryName=" + country;
            $http.post(url).then(function (response) {
                var data = response.data;
                $scope.stateList = angular.copy(data);
                $scope.stateCity($scope.stateName);
            })

        }
        $scope.stateCity = function(state){
            var url = '/hospital/getStateCity?stateName=' + state;
            $http.post(url).then(function (response) {
                var data = response.data;
                $scope.cityList = angular.copy(data);
            })
        }
        $scope.getCountryList = function () {
            $http.post($scope.hospitalServerURL + '/getCountryList').then(function (response) {
                var data = response.data;
                $scope.countryList = angular.copy(data);
                $scope.countryState($scope.country);
                }, function (error) {
                Notification.error({
                    message: 'Something went wrong, please try again',
                    positionX: 'center',
                    delay: 2000
                });
            });
        }
        $scope.getRolesList = function () {
            $http.post($scope.hospitalServerURL + '/getRolesList').then(function (response) {
                var data = response.data;
                $scope.roleslist=data;
                }, function (error) {
                Notification.error({
                    message: 'Something went wrong, please try again',
                    positionX: 'center',
                    delay: 2000
                });
            });
        }
        $scope.getRolesList();
        //
        $scope.getCurrentUserList = function () {
            $http.post($scope.hospitalServerURL + '/getCurrentUser').then(function (response) {
                var data = response.data.object;
                // $scope.currentUserList = data;
                console.log(data);
                // for(var i=0; i<data.length;i++) {
                    $scope.id = data.id;
                    $scope.firstname = data.firstName;
                    $scope.lastname = data.lastName;
                    $scope.email = data.email;
                    $scope.phoneNumber = data.phoneNumber;
                    $scope.mobileNumber = data.mobileNumber;
                    // $scope.city = data.city;
                    // $scope.stateName = data.state;
                    $scope.address = data.address;
                    $scope.role = data.idRoles;
                    $scope.zipCode = data.zipCode;
                    $scope.notes = data.notes;
                    $scope.username = data.username;
                    $scope.password = data.password;
                    $scope.retypepassword = data.retypepassword;
                    $scope.calenderType = data.calenderType;
                // }

                // $scope.searchText = val;

            }, function (error) {
                Notification.error({
                    message: 'Something went wrong, please try again',
                    positionX: 'center',
                    delay: 2000
                });
            })
        };
        // $scope.getCurrentUserList();
        $scope.getCountryList();


        $scope.EditUser = function (data) {
            $scope.id=data.id;
            $scope.firstname = data.firstName;
            $scope.lastname = data.lastName;
            $scope.email = data.email;
            $scope.phoneNumber = data.phoneNumber;
            $scope.mobileNumber = data.mobileNumber;
            // $scope.city = data.city;
            // $scope.stateName = data.state;
            $scope.address = data.address;
            $scope.zipCode = data.zipCode;
            $scope.notes = data.notes;
            $scope.username = data.username;
            $scope.role = data.roles;
            $scope.password = data.password;
            $scope.retypepassword = data.retypepassword;
            $scope.calenderType = data.calenderType;
            $scope.operation = 'Edit';
            $("#submit").text("Update");
            $('#user-title').text("Edit User");
            $("#add_user").modal('show');

        }, function (error) {
            Notification.error({message: 'Something went wrong, please try again', positionX: 'center', delay: 2000});
        };


        $scope.DeleteUser=function(data) {
            bootbox.confirm({
                title: "Alert",
                message: "Do you want to Continue ?",
                buttons: {
                    confirm: {
                        label: 'OK'
                    },
                    cancel: {
                        label: 'Cancel'
                    }
                },
                callback: function (result) {
                    if (result == true) {
                        $http.post($scope.hospitalServerURL+ '/getDeleteUser?id=' + data.id).then(function (response, status, headers, config) {
                            var data = response.data;
                            Notification.success({
                                message: 'Users deleted  successfully',
                                positionX: 'center',
                                delay: 2000
                            });
                            $scope.getUserList();
                            $scope.getPaginatedUsersList();
                        }, function (error) {
                            Notification.error({
                                message: 'Something went wrong, please try again',
                                positionX: 'center',
                                delay: 2000
                            });
                            $scope.isDisabled = false;
                        });
                    }
                }
            });
        };

        $scope.backUsers=function() {
            window.location.href='/home#!/providers'
        };

        $scope.getUserList = function (searchText) {
            if(angular.isUndefined(searchText)){
                $scope.searchText="";
            }
            $(".loader").css("display", "block");
            $http.post($scope.hospitalServerURL + '/getUserList').then(function (response) {
                var data = response.data.object;
                console.log(data);
                $scope.userList = data;

            }, function (error) {
                Notification.error({
                    message: 'Something went wrong, please try again',
                    positionX: 'center',
                    delay: 2000
                });
            })

        };
        $scope.getUserList();


        $scope.getPaginatedUsersList = function (page) {
            switch (page) {
                case 'firstPage':
                    $scope.firstPage = true;
                    $scope.lastPage = false;
                    $scope.pageNo = 0;
                    $scope.isNext = false;
                    $scope.isPrev = false;
                    break;
                case 'lastPage':
                    $scope.lastPage = true;
                    $scope.firstPage = false;
                    $scope.pageNo = 0;
                    $scope.isNext = false;
                    $scope.isPrev = false;
                    break;
                case 'nextPage':
                    $scope.isNext = true;
                    $scope.isPrev = false;
                    $scope.lastPage = false;
                    $scope.firstPage = false;
                    $scope.pageNo = $scope.pageNo + 1;
                    break;
                case 'prevPage':
                    $scope.isPrev = true;
                    $scope.lastPage = false;
                    $scope.firstPage = false;
                    $scope.isNext = false;
                    $scope.pageNo = $scope.pageNo - 1;
                    break;
                default:
                    $scope.firstPage = true;
            }
            var paginationDetails;
            paginationDetails={
                firstPage: $scope.firstPage,
                lastPage: $scope.lastPage,
                pageNo: $scope.pageNo,
                prevPage: $scope.isPrev,
                nextPage: $scope.isNext
            }
            if(angular.isUndefined($scope.searchText)){
                $scope.searchText="";
            }
            $http.post($scope.hospitalServerURL + '/getPaginatedUsersList?searchText='+$scope.searchText,angular.toJson(paginationDetails)).then(function (response) {
                var data = response.data;
                console.log(data);
                $scope.userList = data.list;
                $scope.first = data.firstPage;
                $scope.last = data.lastPage;
                $scope.prev = data.prevPage;
                $scope.next = data.nextPage;
                $scope.pageNo = data.pageNo;
            }, function (error) {
                Notification.error({
                    message: 'Something went wrong, please try again',
                    positionX: 'center',
                    delay: 2000
                });
            })
        };
        $scope.getPaginatedUsersList();




    });
