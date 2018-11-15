/*
    Basic FizzBuzz:
    Write a function which prints out the numbers 1-100, with the following substitutions:
    Each multiple of 3 replaced with 'fizz'
    Each multiple of 5 replaced with 'buzz'
    Each multiple of both 3 and 5 replaced with 'fizzbuzz'
*/
function fizzBuzz1(){
    for(i=1; i<101; i++) {
        if (i % 3 == 0 && i % 5 == 0){
            console.log('fizzbuzz');
        } else if(i % 5 == 0){
            console.log('buzz');
        } else if(i % 3 == 0) {
            console.log('fizz');
        } else {
            console.log(i);
        }
    }

}

/*
    Variable-length FizzBuzz:
    Write a function which prints out the numbers m-n, with the following substitutions:
    Each multiple of 3 replaced with 'fizz'
    Each multiple of 5 replaced with 'buzz'
    Each multiple of both 3 and 5 replaced with 'fizzbuzz'
    Validation that m <= n is a plus. 
*/
function fizzBuzz2(m,n){
    let lowerNum = m;
    let higherNum = n;

    if (lowerNum >= higherNum){
        console.log('error: invalid numbers')
    }else for(i=lowerNum; i <= higherNum; i++){
        if (i % 3 == 0 && i % 5 == 0 && i !== 0){
            console.log('fizzbuzz');
        } else if(i % 5 == 0 && i !== 0){
            console.log('buzz');
        } else if(i % 3 == 0 && i !== 0) {
            console.log('fizz');
        } else {
            console.log(i);
        }
    }
}

/*
    Variable-length, varying-fizz/buzz number FizzBuzz:
    Write a function which prints out the numbers m-n, with the following substitutions:
    Each multiple of fizzNum replaced with 'fizz'
    Each multiple of buzzNum replaced with 'buzz'
    Each multiple of both fizzNum and BuzzNum replaced with 'fizzbuzz'
    Validation that m <= n is a plus. 
*/
function fizzBuzz3(m,n,fizzNum,buzzNum){
    let lowerNum = m;
    let higherNum = n;
    let fizzy = fizzNum;
    let buzzy = buzzNum;

    if (lowerNum >= higherNum){
        console.log('error: invalid numbers')
    }else for(i=lowerNum; i <= higherNum; i++){
        if (i % fizzy == 0 && i % buzzy == 0 && i !== 0){
            console.log('fizzbuzz');
        } else if(i % buzzy == 0 && i !== 0){
            console.log('buzz');
        } else if(i % fizzy == 0 && i !== 0) {
            console.log('fizz');
        } else {
            console.log(i);
        }
    }
}
    
    

/*
    Variable-length FizzBuzz with arrays:
    Write a function which prints out the numbers m-n with substitutions of: 
    each element of the numbers array replaced by the element at the same index of the terms array.
    e.g., to mimic the behavior of fizzBuzz1, you would call the function like so:
    fizzBuzz4(1,100,[3,5],['fizz','buzz'])
    Validation the m <= n is a plus. 
    The arrays may have any length, but validation that their length is the SAME is a plus. 
*/
function fizzBuzz4(m,n,numbers,terms){
    if (isNaN(Number(m)) || isNaN(Number(n)) || m > n){
        console.log('invalid input');
        return;}
    let output = "";
    for(i = m; i < n; i++){
        for(let j in numbers){
            if(i % numbers[j] === 0){
                output += terms[j];
            }
        } 
        if (output){
            console.log(output);
        } else {
            console.log(i);
        }
    output = "";
    }
}

