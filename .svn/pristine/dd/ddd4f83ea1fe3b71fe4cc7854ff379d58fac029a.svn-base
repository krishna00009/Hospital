app.controller('appReportCtrl',
    function ($scope,$http,Notification,$filter) {
        $scope.hospitalServerURL = "/hospital";
            $scope.dt = new Date();
            $scope.dt1 = new Date();
        $scope.getAppointmentList=function () {
            if ($scope.dt1 < $scope.dt) {
                Notification.error({message: "ToDate Should not Less Than FromDate", positionX: 'center', delay: 2000})
            } else {
                $http.post($scope.hospitalServerURL + '/getAppointmentreport?fromdate=' + $scope.dt + '&todate=' + $scope.dt1).then(function (response) {
                    var data = response.data.object;
                    $scope.appointmentList = data;

                })
            }
        }
  $scope.getAppointmentList();


        $scope.open9 = function () {
            $scope.popup9.opened = true;
        };
        $scope.popup9 = {
            opened: false
        };
        $scope.open10 = function () {
            $scope.popup10.opened = true;
        };
        $scope.popup10 = {
            opened: false
        };


});