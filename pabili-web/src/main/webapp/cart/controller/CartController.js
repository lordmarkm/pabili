define(function () {
  return ['$scope', '$modal', 'BuyRequestHeaderService',
    function ($scope, $modal, BuyRequestHeaderService) {

    $scope.decrement = function (buyRequest, index) {
      buyRequest.quantity = buyRequest.quantity - 1;
      if (buyRequest.quantity <= 0) {
        $scope.cart.buyRequests.splice(index, 1);
      }
    };

    //When the user clicks the "Create Buy Request Button"
    $scope.createBuyRequest = function () {
      $modal.open({
        templateUrl: 'buyrequest/view/modal_buyrequest_header.html',
        controller: ['$scope', '$modalInstance', function ($modalScope, $modalInstance) {
          $modalScope.buyRequestHeader = $scope.cart;
          $modalScope.buyRequestHeader.title = defaultTitle($modalScope.buyRequestHeader);
          $modalScope.ok = function () {
            BuyRequestHeaderService.save($modalScope.buyRequestHeader, function () {
              alert('Buy request created!');
            });
            $modalInstance.close(true);
          };
          $modalScope.close = function () {
            $modalInstance.close(false);
          };
        }]
      });
    };

    function defaultTitle(cart) {
      if (cart.buyRequests.length === 1 && cart.buyRequests[0].posting) {
        return cart.buyRequests[0].quantity + 'x ' + cart.buyRequests[0].posting.title;
      } else {
        return cart.buyRequests.length + ' items';
      }
    }
  }];
});