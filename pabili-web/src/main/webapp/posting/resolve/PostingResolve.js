define(function () {
  return {
    posting: ['PostingService', '$stateParams', function (PostingService, $stateParams) {
      return PostingService.get({postingId: $stateParams.postingId});
    }]
  };
});
