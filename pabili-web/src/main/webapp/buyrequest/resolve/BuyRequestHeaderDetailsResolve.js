define(function () {
  return {
    buyRequestHeader: ['BuyRequestHeaderService', '$stateParams', function (BuyRequestHeaderService, $stateParams) {
      return BuyRequestHeaderService.get({postingId: $stateParams.postingId});
    }]
  };
});
