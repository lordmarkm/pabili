define([
   'angular',
   'profile/controller/ProfileRootController',
   'profile/controller/BuyRequestController',
   'profile/controller/PostingController',
   'profile/service/ProfileService',
   'profile/service/BuyRequestService',
   'posting/service/PostingService'
], function (angular, ProfileRootController, BuyRequestController, PostingController, ProfileService,
    BuyRequestService, PostingService) {
  console.debug('Configuring profile.module');
  angular.module('profile.module', [])
    .service('ProfileService', ProfileService)
    .service('BuyRequestService', BuyRequestService)
    .service('PostingService', PostingService)
    .config(['$stateProvider', function ($stateProvider) {

      $stateProvider.state('default.profile', {
        url: 'profile',
        controller: ProfileRootController,
        templateUrl: 'profile/view/profile.html',
        abstract: true
      })
      .state('default.profile.summary', {
        url: '',
        templateUrl: 'profile/view/summary.html',
        access: 'ROLE_USER'
      })
      .state('default.profile.buyrequests', {
        url: '/postings',
        controller: BuyRequestController,
        templateUrl: 'profile/view/buy_requests.html',
        access: 'ROLE_USER'
      })
      .state('default.profile.shipments', {
        url: '/shipments',
        templateUrl: 'profile/view/shipments.html',
        access: 'ROLE_USER'
      })
      .state('default.profile.for_sale', {
        url: '/for_sale',
        controller: PostingController,
        templateUrl: 'profile/view/for_sale.html',
        access: 'ROLE_USER'
      });
    }]);

});