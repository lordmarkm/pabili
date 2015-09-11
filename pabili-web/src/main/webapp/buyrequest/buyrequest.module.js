define([
   'angular',
   'buyrequest/controller/BuyRequestRootController',
   'buyrequest/controller/BuyRequestHeaderDetailsController',
   'buyrequest/service/BuyRequestHeaderService',
   'buyrequest/resolve/BuyRequestHeaderDetailsResolve'
], function (angular, BuyRequestRootController, BuyRequestHeaderDetailsController,
    BuyRequestHeaderService,
    BuyRequestHeaderDetailsResolve) {
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
      });

    }]);
});