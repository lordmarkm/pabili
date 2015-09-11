define(function () {
  return ['$scope', 'buyRequestHeader',
    function ($scope, buyRequestHeader) {

    //Expose the posting from the resolve
    console.debug('Got header=' + JSON.stringify(buyRequestHeader));
    $scope.buyRequestHeader = buyRequestHeader;

  }];
});