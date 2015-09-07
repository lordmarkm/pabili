define([
   'angular',
   'cart/controller/CartController',
   'cart/service/ShoppingCartService'
], function (angular, CartController, ShoppingCartService) {
  console.debug('Configuring cart.module');
  angular.module('cart.module', [])
    .service('ShoppingCartService', ShoppingCartService)
    .config(['$stateProvider', function ($stateProvider) {

      $stateProvider.state('default.cart', {
        url: 'cart',
        controller: CartController,
        templateUrl: 'cart/view/cart.html',
        access: 'ROLE_USER'
      });

    }]);

});