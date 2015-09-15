define(function () {
  return ['$scope', 'buyRequestHeader', 'messages', 'BuyRequestMessageService',
    function ($scope, buyRequestHeader, messages, BuyRequestMessageService) {

    //Expose the posting from the resolve
    console.debug('Got header=' + JSON.stringify(buyRequestHeader));
    $scope.buyRequestHeader = buyRequestHeader;
    $scope.messages = messages;

    $scope.postMessage = function () {
      BuyRequestMessageService.save({
        buyRequestHeaderId: buyRequestHeader.id
      }, {
        sender: $scope.principal.username,
        gopher: $scope.principal.username,
        message: $scope.message
      }, function (response) {
        $scope.messages.push(response);
      });
    };

  }];
});