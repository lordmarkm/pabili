define([
   'angular',
   'moment',
   'core/controller/RootController',
   'core/service/GenericConfirmService',
   'core/service/BankService',
   'core/filter/CreditCardFilter'
], function (angular, moment, RootController, GenericConfirmService, BankService, CreditCardFilter) {
  console.debug('Configuring core.module');
  angular.module('core.module', [])
    .service('confirm', GenericConfirmService)
    .service('BankService', BankService)
    .filter('creditcard', CreditCardFilter)
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
    }])

    .filter('fromNow', function() {
      return function(date) {
        return moment(date).fromNow();
      };
    });

});