define(function () {
  return {
    buyRequestHeader: ['BuyRequestHeaderService', '$stateParams', function (BuyRequestHeaderService, $stateParams) {
      return BuyRequestHeaderService.get({buyRequestHeaderId: $stateParams.buyRequestHeaderId});
    }],
    messages: ['BuyRequestMessageService', '$stateParams', function (BuyRequestMessageService, $stateParams) {
      return BuyRequestMessageService.query({
        role: 'gopher',
        buyRequestHeaderId: $stateParams.buyRequestHeaderId
      });
    }],
    shippingChannels: ['ShippingChannelService', function (ShippingChannelService) {
      return ShippingChannelService.query();
    }],
    proposals: ['$stateParams', 'ProposalService', function ($stateParams, ProposalService) {
      return ProposalService.getGopherProposals({buyRequestHeaderId: $stateParams.buyRequestHeaderId});
    }]
  };
});
