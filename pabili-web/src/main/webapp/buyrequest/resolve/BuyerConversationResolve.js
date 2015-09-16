define(function () {
  return {
    buyRequestHeader: ['BuyRequestHeaderService', '$stateParams', function (BuyRequestHeaderService, $stateParams) {
      return BuyRequestHeaderService.get({buyRequestHeaderId: $stateParams.buyRequestHeaderId});
    }],
    messages: ['BuyRequestMessageService', '$stateParams', function (BuyRequestMessageService, $stateParams) {
      return BuyRequestMessageService.query({
        role: 'buyer',
        gopherUsername: $stateParams.gopherUsername,
        buyRequestHeaderId: $stateParams.buyRequestHeaderId
      })
    }]
  };
});
