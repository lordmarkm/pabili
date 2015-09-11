define([
   'angular',
   'buyrequest/controller/BuyRequestRootController',
   'buyrequest/service/BuyRequestHeaderService'
], function (angular, BuyRequestRootController, BuyRequestHeaderService) {
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
        templateUrl: 'buyrequest/view/header_details.html'
      });

    }]);
});