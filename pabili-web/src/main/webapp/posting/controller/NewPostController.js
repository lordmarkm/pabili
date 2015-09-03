define(function () {
  return ['$scope', '$state', 'PostingService',
    function ($scope, $state, PostingService) {

    //Initialize empty posting
    $scope.post = {
        location: {}
    };

    //Validation 
    $scope.invalidDetails = function () {
      if (!$scope.post.title || $scope.post.title.length < 10) return true;
      if (!$scope.post.description || $scope.post.description.length < 40) return true;
      if (!$scope.post.price || $scope.post.price < 1) return true;
      return false;
    };
    $scope.invalidLocation = function () {
      if (!$scope.post.location.location) return true;
    };
    $scope.invalidImage = function () {
      if (!$scope.post.thumbnailUrl) return true;
    };

    //Submi
    $scope.submitPosting = function () {
      PostingService.save($scope.post, function (response) {
        
      });
    };
  }];
});