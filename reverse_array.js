function reverse_array(array){
    
    for(var i=0;i<array.length/2;i++){

        last_value = array[array.length-i-1]

        first_value = array[i]

        array[array.length-i-1] = first_value

        array[i] = last_value
    }
    return array
}

//Test
array_test = [10,20,30,40,100,80]
console.log("Original order: "+ array_test)

reversed_array = reverse_array(array_test)
console.log("Reversed order: "+reversed_array)