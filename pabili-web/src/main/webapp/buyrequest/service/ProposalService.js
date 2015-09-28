define(function () {
  return ['$resource', function ($resource) {
    return $resource('proposal', {}, {
      getGopherProposals: {
        url: 'proposal/gopher',
        method: 'GET'
      }
    });
  }];
});