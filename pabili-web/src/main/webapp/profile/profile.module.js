define([
   'angular'
], function (angular) {
  console.debug('Configuring profile.module');
  angular.module('profile.module', [])
    .config(['$stateProvider', function ($stateProvider) {

      $stateProvider.state('default.profile', {
        url: 'profile',
        templateUrl: 'profile/view/profile.html',
        abstract: true,
        access: 'ROLE_USER'
      })
      .state('default.profile.summary', {
        url: '',
        templateUrl: 'profile/view/summary.html'
      })
      .state('default.profile.postings', {
        url: '/postings',
        templateUrl: 'profile/view/postings.html'
      });
    
    }]);

});