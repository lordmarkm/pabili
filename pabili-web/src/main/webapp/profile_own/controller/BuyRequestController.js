define(function () {
  return ['$scope', 'BuyRequestService',
    function ($scope, BuyRequestService) {

    BuyRequestService.get().$promise.then(function (data) {
      $scope.buyRequestHeaders = data.data;
      console.debug(data);
    });

    //Get the first image url
    $scope.imageSource = function (buyRequestHeader) {
      
    };

  }];
});