package com.example.bmijc.screen

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize

@Composable
fun Main_screen(applicationContext: Context) {
    var weight by remember { mutableStateOf("") }
    var height by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }
    var comments by remember { mutableStateOf("") }
    var color by remember { mutableStateOf(Color.White) }

    var expandedFt by remember { mutableStateOf(false) }
    var expandedIn by remember { mutableStateOf(false) }
    var totalInch by remember { mutableStateOf("") }

    val feetList = listOf("3", "4", "5", "6", "7", "8")
    val inchesList = listOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12")

    var selectedFeet by remember { mutableStateOf("") }
    var selectedInches by remember { mutableStateOf("") }

    val iconFt = if (expandedFt) {
        Icons.Filled.KeyboardArrowDown
    } else {
        Icons.Filled.KeyboardArrowUp
    }

    val iconIn = if (expandedIn) {
        Icons.Filled.KeyboardArrowDown
    } else {
        Icons.Filled.KeyboardArrowUp
    }

    val focusManager = LocalFocusManager.current

    var textFiledSizeFeet by remember { mutableStateOf(Size.Zero) }
    var textFiledSizeInches by remember { mutableStateOf(Size.Zero) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0D0C1D))
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) { focusManager.clearFocus() },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .fillMaxHeight(0.21f)
                .background(shape = RoundedCornerShape(15.dp), color = Color(0xFF161B33)),
            contentAlignment = Alignment.Center
        ) {
            Column(modifier = Modifier.padding(start = 30.dp)) {
                Text(
                    text = "Weight",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start,
                    color = Color(0xFF767B8E)
                )
                Spacer(modifier = Modifier.height(2.dp))
                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.Bottom) {
                    TextField(
                        value = weight, onValueChange = { weight = it },
                        textStyle = TextStyle(
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 45.sp,
                            color = Color.White
                        ),
                        singleLine = true,
                        placeholder = {
                            Text(
                                text = "0",
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 45.sp,
                                color = Color(0xFF767B8E)
                            )
                        },
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Number
                        ),
                        modifier = Modifier.fillMaxWidth(0.55f),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            focusedIndicatorColor = Color.White,
                            unfocusedIndicatorColor = Color(0xFF0A0C17),

                            )
                    )
                    Spacer(modifier = Modifier.width(14.dp))
                    Text(
                        text = "Kg",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth(1f),
                        textAlign = TextAlign.Start,
                        color = Color(0xFF767B8E)
                    )
                }
            }

        }

        Spacer(modifier = Modifier.fillMaxHeight(0.03f))

        Box(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .fillMaxHeight(0.27f)
                .background(shape = RoundedCornerShape(15.dp), color = Color(0xFF161B33)),
            contentAlignment = Alignment.Center
        ) {
            Column(modifier = Modifier.padding(horizontal = 30.dp)) {
                Text(
                    text = "Height",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start,
                    color = Color(0xFF767B8E)
                )
                Spacer(modifier = Modifier.height(2.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    TextField(
                        value = selectedFeet, onValueChange = { selectedFeet = it },
                        modifier = Modifier
                            .fillMaxWidth(0.235f)
                            .onGloballyPositioned { coordinates ->
                                textFiledSizeFeet = coordinates.size.toSize()
                                Log.d("textFiledSizeInches", "ft: $textFiledSizeFeet")
                            },
                        textStyle = TextStyle(
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 45.sp,
                            color = Color.White
                        ),
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        ),
                        placeholder = {
                            Text(
                                text = "0",
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 45.sp,
                                color = Color(0xFF767B8E)
                            )
                        },
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            focusedIndicatorColor = Color.White,
                            unfocusedIndicatorColor = Color(0xFF0A0C17)
                        ),
                    )


                    Spacer(modifier = Modifier.width(8.dp))



                    Box(
                        modifier = Modifier
                            .fillMaxHeight(0.24f)
                            .fillMaxWidth(0.11f)
                            .background(
                                color = Color(0xFF767B8E),
                                shape = RoundedCornerShape(7.dp)
                            )
                            .clickable { expandedFt = !expandedFt },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            iconFt,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }

                    DropdownMenu(
                        expanded = expandedFt,
                        onDismissRequest = { expandedFt = false },
                        modifier = Modifier.width(
                            with(LocalDensity.current) { textFiledSizeFeet.width.toDp() },
                        ),
                    ) {
                        feetList.forEach { label ->
                            DropdownMenuItem(text = { Text(text = label) }, onClick = {
                                selectedFeet = label
                                expandedFt = false
                            })
                        }

                    }

                    Spacer(modifier = Modifier.width(20.dp))

                    TextField(
                        value = selectedInches, onValueChange = { selectedInches = it },
                        modifier = Modifier
                            .fillMaxWidth(0.395f)
                            .onGloballyPositioned { coordinates ->
                                textFiledSizeInches = coordinates.size.toSize()
                                Log.d("textFiledSizeInches", "inches: $textFiledSizeInches")
                            },
                        textStyle = TextStyle(
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 45.sp,
                            color = Color.White
                        ),
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        ),
                        placeholder = {
                            Text(
                                text = "0",
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 45.sp,
                                color = Color(0xFF767B8E)
                            )
                        },
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            focusedIndicatorColor = Color.White,
                            unfocusedIndicatorColor = Color(0xFF0A0C17)
                        ),
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxHeight(0.24f)
                            .fillMaxWidth(0.24f)
                            .background(
                                color = Color(0xFF767B8E),
                                shape = RoundedCornerShape(7.dp)
                            )
                            .clickable { expandedIn = !expandedIn },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            iconIn,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }

                    DropdownMenu(
                        expanded = expandedIn,
                        onDismissRequest = { expandedIn = false },
                        modifier = Modifier.width(with(LocalDensity.current) { textFiledSizeInches.width.toDp() }),
                    ) {
                        inchesList.forEach { label ->
                            DropdownMenuItem(text = { Text(text = label) }, onClick = {
                                selectedInches = label
                                expandedIn = false
                            })
                        }

                    }
                }
            }

        }

        Spacer(modifier = Modifier.fillMaxHeight(0.05f))




        Button(
            onClick = {
                focusManager.clearFocus()
                if (selectedFeet.isNotEmpty() && selectedInches.isNotEmpty() && weight.isNotEmpty()) {
                    totalInch =
                        (selectedFeet.toDouble() * 12 + selectedInches.toDouble() * 1.2).toString()
                    height = (totalInch.toDouble() * 2.54).toString()
                    Log.d("checkheight", "Main_screen: $height")
                    result =
                        (weight.toFloat() / ((height.toFloat() / 100) * (height.toFloat() / 100))).toString()
                } else {
                    Toast.makeText(applicationContext, "Fill All Details", Toast.LENGTH_SHORT)
                        .show()
                }

            },
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .fillMaxHeight(0.16f)
                .background(color = Color.Transparent),
            colors = ButtonDefaults.textButtonColors(
                containerColor = Color(0xFF474973)
            ),
            shape = RoundedCornerShape(15.dp)
        ) {
            Text(
                text = "Calculate",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 27.sp
            )
        }



        if (result.isNotEmpty()) {
            Spacer(modifier = Modifier.fillMaxHeight(0.063f))
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .fillMaxHeight(0.48f)
                    .background(shape = RoundedCornerShape(15.dp), color = Color(0xFF161B33)),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(15.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    val formattedResult = if (result.isNotEmpty()) {
                        String.format("%.1f", result.toDouble())
                    } else {
                        ""
                    }
                    Text(
                        text = formattedResult,
                        fontSize = 60.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                    if (result.isEmpty()) {
                        comments = ""
                    } else {
                        when (result.toDouble()) {
                            in 0.0..18.5 -> {
                                comments = "Underweight"
                                color = Color(0xFFF09E17)
                            }

                            in 18.5..24.9 -> {
                                comments = "Normal"
                                color = Color(0xFF36AA29)
                            }

                            in 25.0..29.9 -> {
                                comments = "Overweight"
                                color = Color(0xFFBE0000)
                            }

                            else -> {
                                comments = "Obsessed"
                                color = Color(0xFFBE0000)
                            }
                        }
                    }
                    Text(
                        text = comments,
                        fontSize = 32.sp,
                        color = color,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(5.dp))

                }

            }
        } else {

        }
        Spacer(modifier = Modifier.fillMaxHeight(0.06f))
        Text(
            text = "(Normal Range is 18.5 - 24.9)",
            fontSize = 15.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF767B8E)
        )

    }
}
