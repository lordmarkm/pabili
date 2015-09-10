define(function () {
  return {
    profile: ['ProfileService', function (ProfileService) {
      return ProfileService.get().$promise;
    }],
    banks: ['BankService', function (BankService) {
      return BankService.query();
    }]
  };
});
