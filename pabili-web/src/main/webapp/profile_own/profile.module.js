define([
   'angular',
   'profile_own/controller/ProfileRootController',
   'profile_own/controller/BuyRequestController',
   'profile_own/controller/PostingController',
   'profile_own/controller/BuyerProfileController',
   'profile_own/service/ProfileService',
   'profile_own/service/BuyRequestService',
   'posting/service/PostingService',
   'profile_own/service/BuyerProfileService',
   'profile_own/resolve/BuyerProfileResolve'
], function (angular, ProfileRootController, BuyRequestController, PostingController, BuyerProfileController,
    ProfileService,
    BuyRequestService, PostingService, BuyerProfileService,
    BuyerProfileResolve) {
  console.debug('Configuring profile.module');
  angular.module('profile.module', [])
    .service('ProfileService', ProfileService)
    .service('BuyRequestService', BuyRequestService)
    .service('PostingService', PostingService)
    .service('BuyerProfileService', BuyerProfileService)
    .config(['$stateProvider', function ($stateProvider) {

      $stateProvider.state('default.profile', {
        url: 'profile',
        controller: ProfileRootController,
        templateUrl: 'profile_own/view/profile.html',
        abstract: true
      })
      .state('default.profile.summary', {
        url: '',
        templateUrl: 'profile_own/view/summary.html',
        access: 'ROLE_USER'
      })
      .state('default.profile.buyrequests', {
        url: '/postings',
        controller: BuyRequestController,
        templateUrl: 'profile_own/view/buy_requests.html',
        access: 'ROLE_USER'
      })
      .state('default.profile.shipments', {
        url: '/shipments',
        templateUrl: 'profile_own/view/shipments.html',
        access: 'ROLE_USER'
      })
      .state('default.profile.for_sale', {
        url: '/for_sale',
        controller: PostingController,
        templateUrl: 'profile_own/view/for_sale.html',
        access: 'ROLE_USER'
      })
      
      //Activation/Editing of buyer profile
      .state('default.buyer_profile', {
        url: 'buyer_profile',
        controller: BuyerProfileController,
        template: '<ui-view></ui-view>',
        resolve: BuyerProfileResolve,
        abstract: true
      })
      .state('default.buyer_profile.shipping_addr', {
        url: '/shipping_address',
        templateUrl: '/profile_own/view/shipping_addr.html'
      })
      .state('default.buyer_profile.reimbursement_acct', {
        url: '/reimbursement_acct',
        templateUrl: '/profile_own/view/reimbursement_acct.html'
      });
    }]);

});