const linearSeach = (arr, target) => {
    for(index in arr){
        if(arr[index] === target)
            return `Target ${target} found at ${index}th index!`
    }
    return 'Target not found!'
}

console.log(linearSeach([1,8,9,5,7,6,4,6,2,3], 3))