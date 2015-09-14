define([
   'angular',
   'buyrequest/controller/BuyRequestRootController',
   'buyrequest/controller/BuyRequestHeaderDetailsController',
   'buyrequest/controller/BuyRequestHeaderConversationController',
   'buyrequest/service/BuyRequestHeaderService',
   'buyrequest/resolve/BuyRequestHeaderDetailsResolve',
   'buyrequest/resolve/BuyRequestHeaderConversationResolve'
], function (angular, BuyRequestRootController, BuyRequestHeaderDetailsController,
    BuyRequestHeaderConversationController,
    BuyRequestHeaderService,
    BuyRequestHeaderDetailsResolve, BuyRequestHeaderConversationResolve) {
  console.debug('Configuring buyrequest.module');
  angular.module('buyrequest.module', [])
    .service('BuyRequestHeaderService', BuyRequestHeaderService)
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
        resolve: BuyRequestHeaderConversationResolve,
        access: 'ROLE_USER'
      })
      .state('defaul.buyrequest.convo_buyer', {
        url: '/convo_b/{buyRequestHeaderId}/{title}/{gopherUsername}',
        access: 'ROLE_USER'
      });

    }]);
});