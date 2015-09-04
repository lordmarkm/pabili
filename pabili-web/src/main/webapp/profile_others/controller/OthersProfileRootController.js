define(function () {
  return ['$scope', '$stateParams', 'ProfileService',
    function ($scope, $stateParams, ProfileService) {

    $scope.username = $stateParams.username;
    $scope.profile = ProfileService.get({username: $stateParams.username});

  }];
});