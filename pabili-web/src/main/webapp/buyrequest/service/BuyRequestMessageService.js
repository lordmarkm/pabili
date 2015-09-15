define(function () {
  return ['$resource', function ($resource) {
    return $resource('buyrequestMessage/:buyRequestHeaderId');
  }];
});