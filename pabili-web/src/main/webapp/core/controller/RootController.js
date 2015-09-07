define(function () {
  return ['$scope', '$rootScope', '$state', '$localStorage', 'auth', function ($scope, $rootScope, $state, $localStorage, auth) {
    $scope.contextPath = 'laundry';
    $scope.authenticated = function () {
      return $scope.principal ? true : false;
    };
    $scope.isAuthorized = function (permission) {
      if (!$scope.principal) {
        return false;
      }
      for (var i in $scope.principal.authorities) {
        if ($scope.principal.authorities[i].authority === permission) {
          return true;
        }
      }
      return false;
    };

    //String to url friendly string http://stackoverflow.com/questions/1053902/how-to-convert-a-title-to-a-url-slug-in-jquery
    $scope.convertToSlug = function(str) {
        if (!str) {
          return 'no-title';
        }
        return str
            .toLowerCase()
            .replace(/[^\w ]+/g,'')
            .replace(/ +/g,'-');
    };

    //Shopping card
    if (!$localStorage.cart) {
      $localStorage.cart = {
          posts: []
      };
    }
    $scope.cart = $localStorage.cart;

    //Check user authorities and redirect where appropriate
    auth.then(function(authentication) {
//      if (!authentication.principal) {
//        $state.go('default.login');
//      }
      $scope.principal = authentication.principal;
    });

    $rootScope.$on('$stateChangeStart', function (event, toState) {
      if (typeof toState.access != 'undefined' && !$scope.isAuthorized(toState.access)) {
        event.preventDefault();
        $state.go('default.login', {msg: "unauthorized"});
      }
    });
  }];
});