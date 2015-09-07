define(function () {
  return ['$scope', '$stateParams', 'PostingService', 'ShoppingCartService',
    function ($scope, $stateParams, PostingService, ShoppingCartService) {

    $scope.postings = PostingService.get({
      username: $stateParams.username
    });

    //Add an item to cart
    $scope.addToCart = function (posting) {
      ShoppingCartService.addToCart($scope.authenticated(), posting);
    };

  }];
});