define(function () {
  return ['$scope', 'BuyRequestService',
    function ($scope, BuyRequestService) {

    BuyRequestService.get().$promise.then(function (data) {
      $scope.buyRequestHeaders = data.data;
    });

    //Get the first image url
    $scope.headerImageSource = function (buyRequestHeader) {
      var imageUrl = 0;
      angular.forEach(buyRequestHeader.buyRequests, function (buyRequest) {
        if (buyRequest.posting && buyRequest.posting.imageUrl) {
          imageUrl = buyRequest.posting.imageUrl;
        }
      });
      return imageUrl || '/images/no_image.jpg';
    };

  }];
});