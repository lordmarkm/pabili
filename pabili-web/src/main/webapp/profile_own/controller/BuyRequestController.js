define(function () {
  return ['$scope', 'BuyRequestHeaderService',
    function ($scope, BuyRequestHeaderService) {

    BuyRequestHeaderService.get().$promise.then(function (data) {
      $scope.buyRequestHeaders = data.data;
      $scope.buyRequestHeaderChunks = chunk(data.data, 4);
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

    function chunk(arr, size) {
      var newArr = [];
      for (var i=0; i<arr.length; i+=size) {
        newArr.push(arr.slice(i, i+size));
      }
      return newArr;
    }

  }];
});