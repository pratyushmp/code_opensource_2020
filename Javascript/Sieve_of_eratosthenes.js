var eratosthenes=(n)=>
{
    var array = [],output = [];
    for (var i = 0; i <=n; i++)
        array.push(true);
    for (var i = 2; i<=Math.sqrt(n); i++)
    {
        if (array[i]) 
            for (var j = i * i; j < n; j += i) 
                array[j] = false;
    }

    for (var i = 2; i <=n; i++)
        if(array[i])
            output.push(i);
    
    return output;
};

eratosthenes(15).forEach(i=>console.log(i));