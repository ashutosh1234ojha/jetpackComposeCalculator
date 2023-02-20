package com.example.jetpackcomposecalculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {
    var state by mutableStateOf(CalculatorState())

    fun onAction(actions: CalculatorActions) {

        when (actions) {
            CalculatorActions.Calculate -> performCalculation()
            CalculatorActions.Clear -> state = CalculatorState()
            CalculatorActions.Decimal -> enterDecimal()
            CalculatorActions.Delete -> performDeletion()
            is CalculatorActions.Number -> enterNumber(actions.number)
            is CalculatorActions.Operation -> enterOperations(actions.operations)
        }
    }

    private fun enterNumber(number: Int) {

    }

    private fun performDeletion() {
        TODO("Not yet implemented")
    }

    private fun enterDecimal() {
        TODO("Not yet implemented")
    }

    private fun enterOperations(operations: CalculatorOperations) {

        if (state.number1.isNotBlank()){
           // state=state.copy(operation=operations)
        }
    }

    private fun performCalculation() {
        TODO("Not yet implemented")
    }
}