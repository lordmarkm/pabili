define([
   'angular',
   'posting/controller/PostingController',
   'posting/service/PostingService'
], function (angular, PostingController, PostingService) {
  console.debug('Configuring posting.module');
  angular.module('posting.module', [])
    .service('PostingService', PostingService)
    .config(['$stateProvider', function ($stateProvider) {

      $stateProvider.state('default.posting', {
        url: 'posting',
        controller: PostingController,
        templateUrl: 'posting/view/posting.html',
        abstract: true
      })
      .state('default.posting.new', {
        url: '/new',
        templateUrl: 'posting/view/new.html',
        access: 'ROLE_USER'
      });

    }]);

});