define(function () {
  return ['$localStorage', '$modal', function ($localStorage, $modal) {


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

      var cart = $localStorage.cart;
      for (var i = 0; i < cart.posts.length; i++) {
        if (cart.posts[i].posting.id === posting.id) {
          
        } else {
          
        }
      }

      $localStorage.cart.posts.push(posting);
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