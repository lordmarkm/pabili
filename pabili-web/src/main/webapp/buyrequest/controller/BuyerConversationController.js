define(function () {
  return ['$scope', '$stateParams', 'buyRequestHeader', 'messages', 'BuyRequestMessageService',
    function ($scope, $stateParams, buyRequestHeader, messages, BuyRequestMessageService) {

    //Expose the posting from the resolve
    console.debug('Got header=' + JSON.stringify(buyRequestHeader));
    $scope.buyRequestHeader = buyRequestHeader;
    $scope.messages = messages;
    $scope.gopherUsername = $stateParams.gopherUsername;

    $scope.postMessage = function () {
      BuyRequestMessageService.save({
        buyRequestHeaderId: buyRequestHeader.id
      }, {
        sender: $scope.principal.username,
        gopher: $scope.gopherUsername,
        message: $scope.message
      }, function (response) {
        $scope.messages.push(response);
      });
    };

  }];
});