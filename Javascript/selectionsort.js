const selectionSort = (arr) => {
    let current,
        replaceIndex
        
    for(let i = 0; i < arr.length; i++){
        current = arr[i]
        for(let j = i; j < arr.length; j++){
            if(arr[j] < current){
                current        = arr[j],
                replaceIndex   = j
            }
        }
        arr[replaceIndex] = arr[i]
        arr[i]     = current 
        
    }
    return arr
}

console.log(selectionSort([8,4,3,5,4,9,7,8,8,5,6,1,7,3,5,4,2,1,3,2]))