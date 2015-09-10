define(function () {
  return ['$scope', '$state', 'confirm', 'BuyerProfileService', 'profile', 'banks',
    function ($scope, $state, confirm, BuyerProfileService, profile, banks) {

    $scope.banks = banks;
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
      BuyerProfileService.save($scope.buyerProfile, function (result) {

        confirm.confirm('Update successful', 'Buyer profile has been saved', 'Back to buyer profile')
          .result.then(function (ok) {
            if (ok) {
              $scope.profile.buyerProfile = result;
              $state.go('default.profile.buyrequests');
            }
          });

      });
    };

  }];
});