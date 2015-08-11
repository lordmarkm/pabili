define([
   'angular',
   'authentication/controller/AuthenticationController',
   'authentication/service/AuthenticationService'
], function (angular, AuthenticationController, AuthenticationService) {

  console.debug('Configuring authentication.module');
  angular.module('authentication.module', [])
    .service('auth', AuthenticationService)
    .config(['$stateProvider', function ($stateProvider) {
      $stateProvider.state('default.login', {
        url: 'login?msg',
        templateUrl: 'authentication/view/login.html',
        controller: AuthenticationController
      });
    }]);

});