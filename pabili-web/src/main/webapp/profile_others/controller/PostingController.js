define(function () {
  return ['$scope', '$stateParams', 'PostingService',
    function ($scope, $stateParams, PostingService) {

    $scope.postings = PostingService.get({
      username: $stateParams.username
    });

  }];
});