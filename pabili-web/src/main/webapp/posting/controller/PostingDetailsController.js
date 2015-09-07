define(function () {
  return ['$scope', 'posting', 'PostingService',
    function ($scope, posting, PostingService) {

    //Expose the posting from the resolve
    $scope.post = posting;

  }];
});