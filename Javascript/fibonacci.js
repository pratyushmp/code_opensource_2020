const fibonacci = (terms) => {
    let sequence = new Array(),
        i        = 1
    sequence.push(0)
    sequence.push(1)
    while(i <= terms){
        sequence.push(sequence[i] + sequence[i-1])
        i++
    }
    return sequence
}

console.log(fibonacci(15))