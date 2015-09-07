define(function () {
  return ['$scope', '$state', '$rootScope', '$sessionStorage', 'PostingService',
    function ($scope, $state, $rootScope, $sessionStorage, PostingService) {

    //Initialize empty posting
    $scope.post = {
        location: {}
    };

    //Retrieve from local storage if existing (useful if user refreshes page while editing posting)
    if ($sessionStorage.post) {
      $scope.post = $sessionStorage.post;
    }

    //Store post on state change (user clicks next)
    $rootScope.$on('$stateChangeStart', function() {
      $sessionStorage.post = $scope.post;
    });

    //Validation 
    $scope.invalidDetails = function () {
      if (!$scope.post.title || $scope.post.title.length < 10) return true;
      if (!$scope.post.description || $scope.post.description.length < 40) return true;
      if (!$scope.post.price || $scope.post.price < 1) return true;
      return false;
    };
    $scope.invalidLocation = function () {
      if (!$scope.post.location.name) return true;
    };
    $scope.invalidImage = function () {
      if (!$scope.post.imageUrl) return true;
    };

    //Submit
    $scope.submitPosting = function () {
      PostingService.save($scope.post, function (response) {
        delete $sessionStorage.post;
      });
    };
  }];
});