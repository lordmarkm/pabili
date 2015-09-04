define(function () {
  return ['$scope', '$state', '$rootScope', '$localStorage', 'PostingService',
    function ($scope, $state, $rootScope, $localStorage, PostingService) {

    //Initialize empty posting
    $scope.post = {
        location: {}
    };

    //Retrieve from local storage if existing (useful if user refreshes page while editing posting)
    if ($localStorage.post) {
      $scope.post = $localStorage.post;
    }

    //Store post on state change (user clicks next)
    $rootScope.$on('$stateChangeStart', function() {
      $localStorage.post = $scope.post;
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
        delete $localStorage.post;
      });
    };
  }];
});