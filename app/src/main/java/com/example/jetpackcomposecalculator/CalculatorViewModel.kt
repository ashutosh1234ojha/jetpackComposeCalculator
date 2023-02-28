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

        if (state.operation == null) {
            if (state.number1.length >= MAX_NUMBER_LENGTH)
                return
            state = state.copy(number1 = state.number1 + number)
            return


        }
        if (state.number2.length >= MAX_NUMBER_LENGTH) {
            return
        }
        state = state.copy(number2 = state.number2 + number)


    }

    private fun performDeletion() {
        when {
            state.number2.isNotBlank() -> state = state.copy(number2 = state.number2.dropLast(1))
            state.operation != null -> state = state.copy(operation = null)
            state.number1.isNotBlank() -> state = state.copy(number1 = state.number1.dropLast(1))

        }
    }

    private fun enterDecimal() {
        if (state.operation == null && !state.number1.contains(".") && state.number1.isNotBlank()) {
            state = state.copy(number1 = state.number1 + ".")
            return
        }
        if (!state.number2.contains(".") && state.number2.isNotBlank()) {
            state = state.copy(number2 = state.number2 + ".")

        }

    }

    private fun enterOperations(operations: CalculatorOperations) {

        if (state.number1.isNotBlank()) {
            state = state.copy(operation = operations)
        }
    }

    private fun performCalculation() {
        val number1 = state.number1.toDoubleOrNull()
        val number2 = state.number2.toDoubleOrNull()
        if (number1 != null && number2 != null) {
            val result = when (state.operation) {
                is CalculatorOperations.Addition -> number1 + number2
                is CalculatorOperations.Subtraction -> number1 - number2
                is CalculatorOperations.Multiplication -> number1 * number2
                is CalculatorOperations.Division -> number1 / number2
                null -> return
            }

            state = state.copy(number1 = result.toString().take(15), number2 = "", operation = null)
        }

    }

    companion object {
        val MAX_NUMBER_LENGTH = 8
    }
}
