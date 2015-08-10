define([
   'angular'
], function (angular) {

  console.debug('Configuring browse.module');
  angular.module('browse.module', [])
    .config(['$stateProvider', function ($stateProvider) {
      $stateProvider.state('default.browse', {
        url: 'browse',
        templateUrl: 'browse/view/browse.html'
      })
      .state('default.browse.personals', {
        url: '/personals',
        templateUrl: 'browse/view/personals.html'
      });
    }]);

});