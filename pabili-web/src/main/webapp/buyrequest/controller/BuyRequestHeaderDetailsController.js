define(function () {
  return ['$scope', 'buyRequestHeader',
    function ($scope, buyRequestHeader) {

    //Expose the posting from the resolve
    $scope.buyRequestHeader = buyRequestHeader;

  }];
});