package com.example.jetpackcomposecalculator

sealed class CalculatorOperations(val operations:String){
    object Addition:CalculatorOperations("+")
    object Subtraction:CalculatorOperations("-")
    object Multiplication:CalculatorOperations("*")
    object Division:CalculatorOperations("/")

}
