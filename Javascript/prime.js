const isPrime = (number) => {
    let prime = true
    for(let i = 1; i < number; i++){
        for(let j = 1; j < number; j++){
            if(i * j === number)
                prime = false
        }
    }
    return prime
}

console.log(isPrime(process.argv[2]))