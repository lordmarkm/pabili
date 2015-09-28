define(function () {
  return ['$scope', '$modal', 'buyRequestHeader', 'messages', 'shippingChannels', 'proposals', 'BuyRequestMessageService', 'ProposalService',
    function ($scope, $modal, buyRequestHeader, messages, shippingChannels, proposals, BuyRequestMessageService, ProposalService) {

    //Expose the posting from the resolve
    console.debug('Got header=' + JSON.stringify(buyRequestHeader));
    $scope.buyRequestHeader = buyRequestHeader;
    $scope.messages = messages;
    $scope.proposals = proposals;

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

    $scope.createProposal = function () {
      proposalModal().result.then(function (proposal) {
        proposal.buyRequestHeader = buyRequestHeader;
        $scope.proposals.push(ProposalService.save(proposal));
      });
    };

    function proposalModal() {
      return $modal.open({
        templateUrl: 'buyrequest/view/modal_proposal.html',
        controller: ['$scope', '$modalInstance', function ($modalScope, $modalInstance) {
          $modalScope.shippingChannels = shippingChannels;
          $modalScope.proposal = {
              shippingChannel: 'LBC'
          };
          $modalScope.ok = function () {
            $modalInstance.close($modalScope.proposal);
          };
          $modalScope.close = function () {
            $modalInstance.close(false);
          };
        }]
      });
    }


  }];
});