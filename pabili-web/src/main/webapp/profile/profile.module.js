define([
   'angular'
], function (angular) {
  console.debug('Configuring profile.module');
  angular.module('profile.module', [])
    .config(['$stateProvider', function ($stateProvider) {

      $stateProvider.state('default.profile', {
        url: 'profile',
        templateUrl: 'profile/view/profile.html'
      });
    
    }]);

});