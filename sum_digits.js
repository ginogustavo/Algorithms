function sum_digits(number){
    sum = 0
    while(number>0){
        remainder = number % 10
        sum = sum + remainder
        number = Math.floor(number / 10)
    }
    return sum
}
//Test
console.log(sum_digits(53))

/*
O(log N)
*/