function fib(n, memo){
    if(n <= 0) return 0
    if(n == 1) return 1
    if(memo[n] != undefined){
        return memo[n]
    }
    
    memo[n] = fib(n-1, memo) + fib(n-2, memo)
    return memo[n]
}

// console.log(fib(10, memo))
// console.log(memo)

function allFib(n){
    var memo = []
    //initial values
    memo[0]=0
    memo[1]=1
    for(var i=0;i<n;i++){
        console.log("Number: "+i+ " fib: "+fib(i,memo))
    }
}

allFib(10)

/*Each call of fib, we have already computed and stored 
values for fib(n-1) abd fib(n-2), then we just look up them

 O(n) */