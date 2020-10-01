// Custom implementation of Array.prototype.flatMap with ability for levels to flat

function customFlat(arr, level, resArr=[]){
  if(level === 0 )  return arr;
  
  for(let item of arr){
    if(Array.isArray(item)){
      resArr.push(...item);
    }else{
      resArr.push(item);
    }
  }
  resArr = customFlat(resArr, --level);
  
  return resArr;
 }