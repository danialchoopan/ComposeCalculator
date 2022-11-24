package ir.danialchoopan.composecalculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.danialchoopan.composecalculator.ui.theme.LightGray
import ir.danialchoopan.composecalculator.ui.theme.Orange

@Composable
fun CalculatorM(
    state: CalculatorStateDataClass,
    modifier: Modifier = Modifier,
    buttonSpacing: Dp,
    onAction: (CalculatorActionSealed) -> Unit
) {
    var cal_display by remember {
        mutableStateOf("")
    }
    if (state.number1 == "" && state.number2 == "") {
        cal_display = "0"
    } else {
        cal_display = state.number1 + (state.operation?.symbol ?: "") + state.number2
    }
    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            //display calculation
            Text(
                text = cal_display,
                textAlign = TextAlign.Left,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 22.dp),
                fontSize = 70.sp,
                color = Color.White,
                maxLines = 2,
            )

            //button row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {

                //ac button
                CalculatorBtn(symbol = "AC",
                    modifier = Modifier
                        .background(LightGray)
                        .aspectRatio(2f)
                        .weight(2f),
                    onClick = {
                        onAction(CalculatorActionSealed.Clear)
                    }) //end btn ac

                // delete button
                CalculatorBtn(symbol = "C",
                    modifier = Modifier
                        .background(LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActionSealed.Delete)
                    }) //end btn delete

                // divide button
                CalculatorBtn(symbol = "/",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActionSealed.Operation(CalculatorOperationSealed.Divide))
                    }) //end btn divide

            }//end row


            //button row number
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {

                CalculatorBtn(symbol = "7",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActionSealed.Number(7))
                    })
                CalculatorBtn(symbol = "8",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActionSealed.Number(8))
                    })
                CalculatorBtn(symbol = "9",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActionSealed.Number(9))
                    })
                CalculatorBtn(symbol = "x",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActionSealed.Operation(CalculatorOperationSealed.Multiply))
                    })

            }//end row

            //button row number
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {

                CalculatorBtn(symbol = "4",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActionSealed.Number(4))
                    })
                CalculatorBtn(symbol = "5",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActionSealed.Number(5))
                    })
                CalculatorBtn(symbol = "6",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActionSealed.Number(6))
                    })
                CalculatorBtn(symbol = "-",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActionSealed.Operation(CalculatorOperationSealed.Subtract))
                    })

            }//end row


            //button row number
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {

                CalculatorBtn(symbol = "1",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActionSealed.Number(1))
                    })
                CalculatorBtn(symbol = "2",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActionSealed.Number(2))
                    })
                CalculatorBtn(symbol = "3",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActionSealed.Number(3))
                    })
                CalculatorBtn(symbol = "+",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActionSealed.Operation(CalculatorOperationSealed.Add))
                    })

            }//end row


            //button row number
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {

                CalculatorBtn(symbol = "0",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(2f)
                        .weight(2f),
                    onClick = {
                        onAction(CalculatorActionSealed.Number(0))
                    })
                CalculatorBtn(symbol = ".",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActionSealed.Decimal)
                    })
                CalculatorBtn(symbol = "=",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActionSealed.Calculate)
                    })

            }//end row
        }
    }
}