define(function () {
  return {
    profile: ['ProfileService', function (ProfileService) {
      return ProfileService.get().$promise;
    }]
  };
});
