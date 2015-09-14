define(function () {
  return ['$scope', '$stateParams', 'BuyRequestHeaderService',
    function ($scope, $stateParams, BuyRequestHeaderService) {

    console.debug('$sP.username=' + $stateParams.username);
    BuyRequestHeaderService.get({username: $stateParams.username}).$promise.then(function (data) {
      $scope.buyRequestHeaders = data.data;
      $scope.buyRequestHeaderChunks = chunk(data.data, 4);
    });

    function chunk(arr, size) {
      var newArr = [];
      for (var i=0; i<arr.length; i+=size) {
        newArr.push(arr.slice(i, i+size));
      }
      return newArr;
    }

  }];
});