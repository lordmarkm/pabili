define([
   'angular',
   'buyrequest/controller/BuyRequestRootController',
   'buyrequest/controller/BuyRequestHeaderDetailsController',
   'buyrequest/controller/BuyRequestHeaderConversationController',
   'buyrequest/controller/BuyerConversationController',
   'buyrequest/service/BuyRequestHeaderService',
   'buyrequest/service/BuyRequestMessageService',
   'buyrequest/resolve/BuyRequestHeaderDetailsResolve',
   'buyrequest/resolve/GopherConversationResolve',
   'buyrequest/resolve/BuyerConversationResolve'
], function (angular, BuyRequestRootController, BuyRequestHeaderDetailsController,
    BuyRequestHeaderConversationController, BuyerConversationController,
    BuyRequestHeaderService, BuyRequestMessageService,
    BuyRequestHeaderDetailsResolve, GopherConversationResolve, BuyerConversationResolve) {
  console.debug('Configuring buyrequest.module');
  angular.module('buyrequest.module', [])
    .service('BuyRequestHeaderService', BuyRequestHeaderService)
    .service('BuyRequestMessageService', BuyRequestMessageService)
    .config(['$stateProvider', function ($stateProvider) {

      $stateProvider.state('default.buyrequest', {
        url: 'buyrequest',
        controller: BuyRequestRootController,
        template: '<ui-view></ui-view>',
        abstract: true
      })
      .state('default.buyrequest.details', {
        url: '/{buyRequestHeaderId}/{title}',
        controller: BuyRequestHeaderDetailsController,
        resolve: BuyRequestHeaderDetailsResolve,
        templateUrl: 'buyrequest/view/header_details.html'
      })
      .state('default.buyrequest.convo_gopher', {
        url: '/convo_g/{buyRequestHeaderId}/{title}',
        controller: BuyRequestHeaderConversationController,
        templateUrl: 'buyrequest/view/convo_gopher.html',
        resolve: GopherConversationResolve,
        access: 'ROLE_USER'
      })
      .state('default.buyrequest.convo_buyer', {
        url: '/convo_b/{buyRequestHeaderId}/{title}/{gopherUsername}',
        controller: BuyerConversationController,
        templateUrl: 'buyrequest/view/convo_buyer.html',
        resolve: BuyerConversationResolve,
        access: 'ROLE_USER'
      });

    }]);
});