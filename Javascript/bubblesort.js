const bubbleSort = (arr) => {
    let aux, 
        sorted = false
    while(!sorted){
        sorted = true
        for(let i = 0; i < arr.length; i++){
            if(arr[i + 1] && arr[i] > arr[i + 1]){
               sorted         = false 
               aux            = arr[i]
               arr[i]         = arr[i + 1]
               arr[i + 1]     = aux 
            }
        }
    }
    return arr
}

console.log(bubbleSort([64,321,47,21,92,11,3]))