function fib(number){
    if(number<=0) return 0
    if(number==1) return 1
    
    return fib(number-1)+fib(number-2)
}

//Test
console.log(fib(10))
/*
Runtime O(2^n)  -> branches ^ depth
to be precise: O(1.6^n)
At the bottom of the call stack, there is sometimes only one call
*/