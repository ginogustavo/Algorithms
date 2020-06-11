function is_prime(number){

    if(number<=1){
        return false;
    }

    for(var i=2; i*i<=number;i++){
        if(number%i ==0){
            return false
        }
    }
    return true
}

//Test
var test_number = 97
var validation = is_prime(test_number)
var message = test_number + ((validation)?" is":" is not")  +  " a prime number"
console.log(message)
