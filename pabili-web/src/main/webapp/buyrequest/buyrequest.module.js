define([
   'angular',
   'buyrequest/service/BuyRequestService'
], function (angular, BuyRequestService) {
  console.debug('Configuring buyrequest.module');
  angular.module('buyrequest.module', [])
    .service('BuyRequestService', BuyRequestService);
});