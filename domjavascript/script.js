// Global array
var demoArray = [10, 20, 30, 40, 50];

// 1. Variables and Data Types
function demonstrateVariables() {
    var x = 10;
    var y = 20;
    var z = 30;
    document.getElementById('variablesOutput').textContent = 
        "var x = " + x + "\nvar y = " + y + "\nvar z = " + z;
}

function demonstrateDataTypes() {
    var str = "Hello";
    var num = 42;
    var bool = true;
    document.getElementById('variablesOutput').textContent = 
        "String: " + str + "\nNumber: " + num + "\nBoolean: " + bool;
}

// 2. String Functions
function stringToUpperCase() {
    var text = document.getElementById('stringInput').value;
    document.getElementById('stringOutput').textContent = text.toUpperCase();
}

function stringLength() {
    var text = document.getElementById('stringInput').value;
    document.getElementById('stringOutput').textContent = "Length: " + text.length;
}

function stringSplit() {
    var text = document.getElementById('stringInput').value;
    var words = text.split(' ');
    document.getElementById('stringOutput').textContent = "Words: " + words.join(', ');
}

// 3. Array Functions
function arrayPush() {
    demoArray.push(60);
    document.getElementById('arrayOutput').textContent = "Array: [" + demoArray + "]";
}

function arrayPop() {
    demoArray.pop();
    document.getElementById('arrayOutput').textContent = "Array: [" + demoArray + "]";
}

function arrayMap() {
    var result = [];
    for (var i = 0; i < demoArray.length; i++) {
        result.push(demoArray[i] * 2);
    }
    document.getElementById('arrayOutput').textContent = "Doubled: [" + result + "]";
}

function resetArray() {
    demoArray = [10, 20, 30, 40, 50];
    document.getElementById('arrayOutput').textContent = "Array: [" + demoArray + "]";
}

// 4. Math Functions
function mathRandom() {
    var random = Math.random();
    document.getElementById('mathOutput').textContent = "Random: " + random;
}

function mathMax() {
    var num1 = document.getElementById('mathInput1').value;
    var num2 = document.getElementById('mathInput2').value;
    var max = Math.max(num1, num2);
    document.getElementById('mathOutput').textContent = "Max: " + max;
}

function mathPow() {
    var num1 = document.getElementById('mathInput1').value;
    var num2 = document.getElementById('mathInput2').value;
    var result = Math.pow(num1, num2);
    document.getElementById('mathOutput').textContent = num1 + " ^ " + num2 + " = " + result;
}

// 5. Conditional Statements
function checkEvenOdd() {
    var num = document.getElementById('conditionInput').value;
    if (num % 2 == 0) {
        document.getElementById('conditionOutput').textContent = num + " is Even";
    } else {
        document.getElementById('conditionOutput').textContent = num + " is Odd";
    }
}

function checkGrade() {
    var marks = document.getElementById('conditionInput').value;
    var grade;
    if (marks >= 90) {
        grade = 'A+';
    } else if (marks >= 70) {
        grade = 'B';
    } else if (marks >= 50) {
        grade = 'C';
    } else {
        grade = 'F';
    }
    document.getElementById('conditionOutput').textContent = "Grade: " + grade;
}

// 6. Loops
function forLoop() {
    var n = document.getElementById('loopInput').value;
    var output = "";
    for (var i = 1; i <= n; i++) {
        output += i + " ";
    }
    document.getElementById('loopOutput').textContent = "For Loop: " + output;
}

function whileLoop() {
    var n = document.getElementById('loopInput').value;
    var output = "";
    var i = 1;
    while (i <= n) {
        output += i + " ";
        i++;
    }
    document.getElementById('loopOutput').textContent = "While Loop: " + output;
}

// 7. Functions
function add(a, b) {
    return a + b;
}

function normalFunction() {
    var num1 = document.getElementById('funcInput1').value;
    var num2 = document.getElementById('funcInput2').value;
    var result = add(num1, num2);
    document.getElementById('functionOutput').textContent = num1 + " + " + num2 + " = " + result;
}

function calculateFactorial() {
    var num = document.getElementById('funcInput1').value;
    var result = 1;
    for (var i = 1; i <= num; i++) {
        result = result * i;
    }
    document.getElementById('functionOutput').textContent = "Factorial: " + result;
}

// 8. DOM Manipulation
function createElements() {
    var container = document.getElementById('domDemo');
    var heading = document.createElement('h3');
    heading.textContent = 'Dynamic Content!';
    container.appendChild(heading);
    document.getElementById('domOutput').textContent = 'Element created!';
}

function clearDOMDemo() {
    document.getElementById('domDemo').innerHTML = '';
    document.getElementById('domOutput').textContent = 'Cleared!';
}