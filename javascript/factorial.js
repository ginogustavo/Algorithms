function factorial(n){
    if(n<0) return 1
    if(n==1) return 1
    return n* factorial(n-1)
}

//Test
console.log( factorial(4) )

//Straight recursion from n to n-1, n-2 ... 1
// O(n)