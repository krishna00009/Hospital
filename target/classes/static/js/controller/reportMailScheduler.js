app.controller('reportMailSchedulerCtrl',
    function ($scope, $rootScope, $http, Notification) {
        $scope.schedule = {};
        $scope.hospitalServerURL = "/hospital";

        // fro getting List
        $scope.schedulerReportsList = function () {
            $http.post($scope.hospitalServerURL+'/schedulerList').
            then(function (response) {
                var data = response.data;
                console.log(data);
                $scope.schedulerList = data;
            });
        };


        $scope.disable=false;
        $scope.schedulerReportsList();
        $scope.saveSchedule = function () {
            var details;
            details={
                reportType:$scope.reportType,
                subject:$scope.emailSub,
                body:$scope.emailBody,
                reportName:$scope.reportModule,
                toEmail:$scope.toEmail
            }
            var emailvalidation= $scope.toEmail;
            if (angular.isUndefined(emailvalidation) ||emailvalidation==""||emailvalidation==null) {
                Notification.warning({message: 'Please Enter Valid Email', positionX: 'center', delay: 2000});
            }else if($scope.reportModule==""||angular.isUndefined($scope.reportModule)){
                Notification.warning({message: 'Please Select Report Module', positionX: 'center', delay: 2000});
            }else if($scope.reportType==""||angular.isUndefined($scope.reportType)){
                Notification.warning({message: 'Please Select Report Type', positionX: 'center', delay: 2000});
            }else if($scope.emailBody==""||angular.isUndefined($scope.emailBody)){
                Notification.warning({message: 'Email Body cant be Empty', positionX: 'center', delay: 2000});
            }else if($scope.emailSub==""||angular.isUndefined($scope.emailSub)){
                Notification.warning({message: 'Email Sub cant be Empty', positionX: 'center', delay: 2000});
            }
            else {
                $scope.disable=true;
                $http.post($scope.hospitalServerURL +'/saveScheduler', angular.toJson(details)).then(function (response) {
                    Notification.success({message: 'Mail Sent Successfully', positionX: 'center', delay: 2000});
                    $scope.removeDetails();
                },function (errorResponse) {
                    Notification.error({message: 'Something went wrong, please try again',positionX: 'center',delay: 2000});
                })
            }
        }


        $scope.BackServices=function(){
            window.location.href='#!/services_masters';
        };

        $scope.removeDetails=function(){
            $scope.reportType="";
            $scope.emailSub="";
            $scope.emailBody="";
            $scope.reportModule="";
            $scope.toEmail="";
            $scope.disable=false;
        }

        $scope.addScheduler=function () {
            $("#add_new_scheduler").modal('show');
        }

        $scope.openDate1 = function () {
            $scope.popup1.opened = true;
        };

        $scope.hospitalServerURL = "/hospital";
        $scope.deleteMailScheduler = function(mail) {
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
                        $http.post('/deleteMailScheduler?searchSchedulerText=' + mail.id).then(function (response) {
                            var data = response.data;
                            if (data == "") {
                                $scope.schedulerReportsList();
                                Notification.success({
                                    message: 'Report Mail Scheduler Record is Deleted Successfully',
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
                }
            });
        };
    });