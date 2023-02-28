package com.example.jetpackcomposecalculator

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposecalculator.ui.theme.LightGray
import com.example.jetpackcomposecalculator.ui.theme.MediumGray
import com.example.jetpackcomposecalculator.ui.theme.Orange

@Composable
fun Calculator(
    state: CalculatorState,
    buttonSpacing: Dp = 8.dp,
    modifier: Modifier = Modifier,
    onAction: (CalculatorActions) -> Unit
) {

    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {

            Text(
                text = state.number1 + "${state.operation ?: ""}" + state.number2,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp),
                fontWeight = FontWeight.Light,
                fontSize = 80.sp,
                color = Color.White,
                maxLines = 2
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {

                CalculatorButton(
                    btnText = "AC",
                    modifier = Modifier
                        .background(color = LightGray)
                        .aspectRatio(2f)
                        .weight(2f), onClick = { onAction(CalculatorActions.Clear) }
                )
                CalculatorButton(
                    btnText = "Del",
                    modifier = Modifier
                        .background(color = LightGray)
                        .aspectRatio(1f)
                        .weight(1f), onClick = { onAction(CalculatorActions.Delete) }
                )
                CalculatorButton(
                    btnText = "/",
                    modifier = Modifier
                        .background(color = Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorActions.Operation(CalculatorOperations.Division)) }
                )


            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {

                CalculatorButton(
                    btnText = "7",
                    modifier = Modifier
                        .background(color = MediumGray)
                        .aspectRatio(1f)
                        .weight(1f), onClick = { onAction(CalculatorActions.Number(7)) }
                )
                CalculatorButton(
                    btnText = "8",
                    modifier = Modifier
                        .background(color = MediumGray)
                        .aspectRatio(1f)
                        .weight(1f), onClick = { onAction(CalculatorActions.Number(8)) }
                )
                CalculatorButton(
                    btnText = "9",
                    modifier = Modifier
                        .background(color = MediumGray)
                        .aspectRatio(1f)
                        .weight(1f), onClick = { onAction(CalculatorActions.Number(9)) }
                )
                CalculatorButton(
                    btnText = "x",
                    modifier = Modifier
                        .background(color = Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorActions.Operation(CalculatorOperations.Multiplication)) }
                )


            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {

                CalculatorButton(
                    btnText = "4",
                    modifier = Modifier
                        .background(color = MediumGray)
                        .aspectRatio(1f)
                        .weight(1f), onClick = { onAction(CalculatorActions.Number(4)) }
                )
                CalculatorButton(
                    btnText = "5",
                    modifier = Modifier
                        .background(color = MediumGray)
                        .aspectRatio(1f)
                        .weight(1f), onClick = { onAction(CalculatorActions.Number(5)) }
                )
                CalculatorButton(
                    btnText = "6",
                    modifier = Modifier
                        .background(color = MediumGray)
                        .aspectRatio(1f)
                        .weight(1f), onClick = { onAction(CalculatorActions.Number(6)) }
                )
                CalculatorButton(
                    btnText = "-",
                    modifier = Modifier
                        .background(color = Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorActions.Operation(CalculatorOperations.Subtraction)) }
                )


            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {

                CalculatorButton(
                    btnText = "1",
                    modifier = Modifier
                        .background(color = MediumGray)
                        .aspectRatio(1f)
                        .weight(1f), onClick = { onAction(CalculatorActions.Number(1)) }
                )
                CalculatorButton(
                    btnText = "2",
                    modifier = Modifier
                        .background(color = MediumGray)
                        .aspectRatio(1f)
                        .weight(1f), onClick = { onAction(CalculatorActions.Number(2)) }
                )
                CalculatorButton(
                    btnText = "3",
                    modifier = Modifier
                        .background(color = MediumGray)
                        .aspectRatio(1f)
                        .weight(1f), onClick = { onAction(CalculatorActions.Number(3)) }
                )
                CalculatorButton(
                    btnText = "+",
                    modifier = Modifier
                        .background(color = Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorActions.Operation(CalculatorOperations.Addition)) }
                )


            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {

                CalculatorButton(
                    btnText = "0",
                    modifier = Modifier
                        .background(color = MediumGray)
                        .aspectRatio(2f)
                        .weight(2f), onClick = { onAction(CalculatorActions.Number(0)) }
                )
                CalculatorButton(
                    btnText = ".",
                    modifier = Modifier
                        .background(color = MediumGray)
                        .aspectRatio(1f)
                        .weight(1f), onClick = { onAction(CalculatorActions.Decimal) }
                )
                CalculatorButton(
                    btnText = "=",
                    modifier = Modifier
                        .background(color = Orange)
                        .aspectRatio(1f)
                        .weight(1f), onClick = { onAction(CalculatorActions.Calculate) }
                )


            }
        }

    }
}

//@Composable
//fun CalculatorRow(
//    buttonSpacing: Dp,
//    onAction: (CalculatorActions) -> Unit,
//    buttonTextTriplet: Triple<String, String, String>,
//    backgroundColorTriplet: Triple<Color, Color, Color>,
//    aspectRationTriplet: Triple<Float, Float, Float>,
//    weightTriplet: Triple<Float, Float, Float>,
//    actionTriplet: Triple<CalculatorActions, CalculatorActions, CalculatorActions>,
//) {
//    Row(
//        modifier = Modifier.fillMaxWidth(),
//        horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
//    ) {
//
//        CalculatorButton(
//            btnText = buttonTextTriplet.first,
//            modifier = Modifier
//                .background(color = backgroundColorTriplet.first)
//                .aspectRatio(aspectRationTriplet.first)
//                .weight(weightTriplet.first), onClick = { onAction(actionTriplet.first) }
//        )
//        CalculatorButton(
//            btnText = buttonTextTriplet.second,
//            modifier = Modifier
//                .background(color = backgroundColorTriplet.second)
//                .aspectRatio(aspectRationTriplet.second)
//                .weight(weightTriplet.second), onClick = { onAction(actionTriplet.second) }
//        )
//        CalculatorButton(
//            btnText = buttonTextTriplet.third,
//            modifier = Modifier
//                .background(color = backgroundColorTriplet.third)
//                .aspectRatio(aspectRationTriplet.third)
//                .weight(weightTriplet.third),
//            onClick = { onAction(actionTriplet.third) }
//        )
//
//
//    }
//}