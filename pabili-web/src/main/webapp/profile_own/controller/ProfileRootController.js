define(function () {
  return ['$scope', 'ProfileService',
    function ($scope, ProfileService) {

    $scope.profile = ProfileService.get();

  }];
});