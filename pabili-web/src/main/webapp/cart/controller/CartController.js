define(function () {
  return ['$scope',
    function ($scope) {

    $scope.decrement = function (buyRequest, index) {
      buyRequest.quantity = buyRequest.quantity - 1;
      if (buyRequest.quantity <= 0) {
        $scope.cart.buyRequests.splice(index, 1);
      }
    };

  }];
});