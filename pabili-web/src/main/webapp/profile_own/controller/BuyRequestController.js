define(function () {
  return ['$scope', 'BuyRequestService',
    function ($scope, BuyRequestService) {

    $scope.buyrequests = BuyRequestService.query();

  }];
});