define([
   'angular',
   'posting/controller/PostingController',
   'posting/controller/NewPostController',
   'posting/service/PostingService'
], function (angular, PostingController, NewPostController, 
    PostingService) {
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
        controller: NewPostController,
        templateUrl: 'posting/view/new.html',
        abstract: true
      })
      .state('default.posting.new.start', {
        url: '/start',
        templateUrl: 'posting/view/new_start.html',
        access: 'ROLE_USER'
      })
      .state('default.posting.new.details', {
        url: '/details',
        templateUrl: 'posting/view/new_details.html',
        access: 'ROLE_USER'
      })
      .state('default.posting.new.location', {
        url: '/location',
        templateUrl: 'posting/view/new_location.html',
        access: 'ROLE_USER'
      })
      .state('default.posting.new.images', {
        url: '/images',
        templateUrl: 'posting/view/new_images.html',
        access: 'ROLE_USER'
      });

    }]);

});