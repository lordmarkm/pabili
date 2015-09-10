define(function () {

  return function () {
    return function(str) {
      if(typeof str !== "undefined"){
          var nums = str.substr(0,19).replace(/[^\d]/gi,"");
          var r = nums.match(/(\d){4}/g);
          r[1] = r[1].replace(/[0-9]/g, "*");
          r[2] = r[2].replace(/[0-9]/g, "*");
          r = r.slice(0,5);
          if(r){
              var nStr = "", nums;
              for (var i=0;i<r.length;i++){
                  nStr += i != r.length-1 ? r[i] + ((i<3)?" ":"") : r[i];
              }
              nums = (nums.length % 4 !== 0 ? nStr + " " + nums.substr((r.length * 4),nums.length) : nStr);
              str = nums;
          } else {
              str = nums;
          }
          return str;
      }
    };
  };

});