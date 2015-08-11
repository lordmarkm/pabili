define([
   'angular',
   'core/controller/RootController'
], function (angular, RootController) {
  console.debug('Configuring core.module');
  angular.module('core.module', [])
    .config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

      $urlRouterProvider
        .when('', '/browse')
        .when('/', '/browse');

      $stateProvider.state('default', {
        url: '/',
        templateUrl: 'core/view/default.html',
        controller: RootController,
        abstract: true
      });
    
    }])

    //Scroll to top on location change
    .run(['$rootScope', '$window', function ($rootScope, $window) {
      $rootScope.$on("$locationChangeSuccess", function() {
        $window.scrollTo(0,0);
      });
    }]);

});