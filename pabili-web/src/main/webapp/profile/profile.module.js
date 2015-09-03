define([
   'angular',
   'profile/controller/ProfileRootController',
   'profile/service/ProfileService'
], function (angular, ProfileRootController, ProfileService) {
  console.debug('Configuring profile.module');
  angular.module('profile.module', [])
    .service('ProfileService', ProfileService)
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
      .state('default.profile.postings', {
        url: '/postings',
        templateUrl: 'profile/view/postings.html',
        access: 'ROLE_USER'
      })
      .state('default.profile.shipments', {
        url: '/shipments',
        templateUrl: 'profile/view/shipments.html',
        access: 'ROLE_USER'
      });
    }]);

});