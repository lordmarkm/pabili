define(function () {
  return ['$scope', 'BuyerProfileService', 'profile',
    function ($scope, BuyerProfileService, profile) {

    $scope.banks = [
        {
          enum: 'BDO',
          name: 'Banco de Oro (BDO)'
        },
        {
          enum: 'SECURITY_BANK',
          name: 'Security Bank'
        }
    ];
    $scope.profile = profile;
    $scope.buyerProfile = cloneBuyerProfile(profile);

    function cloneBuyerProfile(profile) {
      console.debug('initializing from existing profile. existing profile=' + JSON.stringify(profile));
      var buyerProfile = {};
      buyerProfile.shippingAddress = profile.buyerProfile.shippingAddress ? {
          addressLine1: profile.buyerProfile.shippingAddress.addressLine1,
          addressLine2: profile.buyerProfile.shippingAddress.addressLine2,
          city: profile.buyerProfile.shippingAddress.city,
          province: profile.buyerProfile.shippingAddress.province
      } : {};
      buyerProfile.reimbursementAccount = profile.buyerProfile.reimbursementAccount ? {
          bank: profile.buyerProfile.reimbursementAccount.bank,
          accountName: profile.buyerProfile.reimbursementAccount.accountName,
          accountNumber: profile.buyerProfile.reimbursementAccount.accountNumber
      } : {};
      return buyerProfile;
    };

    $scope.saveBuyerProfile = function () {
      console.debug('saving buyer profile: ' + $scope.buyerProfile);
      BuyerProfileService.save($scope.buyerProfile, function (data) {
        alert('Saved! ' + JSON.stringify(data));
      })
    };

  }];
});