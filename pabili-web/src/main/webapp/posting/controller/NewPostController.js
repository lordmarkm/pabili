define(function () {
  return ['$scope', '$state', 'PostingService',
    function ($scope, $state, PostingService) {

    $scope.post = {};
    $scope.invalidDetails = function () {
      if (!$scope.post.title || $scope.post.title.length < 10) return true;
      if (!$scope.post.description || $scope.post.description.length < 40) return true;
      if (!$scope.post.price || $scope.post.price < 1) return true;
      return false;
    };
    $scope.invalidLocation = function () {
      if (!$scope.post.location) return true;
    };

  }];
});