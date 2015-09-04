define(function () {
  return ['$scope', 'PostingService',
    function ($scope, PostingService) {

    $scope.postings = PostingService.get();

  }];
});