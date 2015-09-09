define(function () {
  return ['$resource', function ($resource) {
    return $resource('buyerprofile/:username');
  }];
});