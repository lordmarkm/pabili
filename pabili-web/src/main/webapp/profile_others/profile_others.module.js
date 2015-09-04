/**
 * This module is for viewing other people's profile. Separated from profile.module.js beause
 * there may be too many differences in display and handling between the two.
 */
define([
   'angular',
   'profile_others/controller/OthersProfileRootController',
   'profile_others/controller/PostingController',
   'profile_own/service/ProfileService'
], function (angular, OthersProfileRootController, PostingController, ProfileService) {
  console.debug('Configuring profile_others.module');
  angular.module('profile_others.module', [])
    .service('ProfileService', ProfileService)
    .config(['$stateProvider', function ($stateProvider) {

      $stateProvider.state('default.profile_others', {
        url: 'profile/{username}',
        controller: OthersProfileRootController,
        templateUrl: 'profile_others/view/profile.html',
        abstract: true
      })
      .state('default.profile_others.summary', {
        url: '',
        templateUrl: 'profile_others/view/summary.html'
      })
      .state('default.profile_others.for_sale', {
        url: '/postings',
        controller: PostingController,
        templateUrl: 'profile_others/view/for_sale.html'
      });

    }]);

});