define(function () {
  return ['$sessionStorage', '$modal', function ($sessionStorage, $modal) {


    this.addToCart = function (authorized, posting) {
      if (!authorized) {
        $modal.open({
          templateUrl: 'cart/view/modal_not_logged_in.html',
          controller: ['$scope', '$state', '$modalInstance', function ($scope, $state, $modalInstance) {
            $scope.ok = function () {
              $modalInstance.close();
            };
            $scope.logIn = function () {
              $state.go('default.login');
              $modalInstance.close();
            };
          }]
        });
        return;
      }

      var existing = false;
      var cart = $sessionStorage.cart;
      console.debug(cart);
      for (var i = 0; i < cart.buyRequests.length; i++) {
        if (cart.buyRequests[i].posting.id === posting.id) {
          cart.buyRequests[i].quantity++;
          existing = true;
        }
      }
      if (!existing) {
        $sessionStorage.cart.buyRequests.push({
            title: posting.title,
            description: posting.description,
            quantity: 1,
            posting: posting
        });
      };

      $modal.open({
        templateUrl: 'cart/view/modal_add_to_cart.html',
        controller: ['$scope', '$state', '$modalInstance', function ($scope, $state, $modalInstance) {
          $scope.post = posting;
          $scope.modalTitle = 'Add to cart success';
          $scope.ok = function () {
            $modalInstance.close();
          };
          $scope.viewCart = function () {
            $state.go('default.cart');
            $modalInstance.close();
          };
        }]
      });
    };


  }];
});