package com.anucodes.assesmentoneclick

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.anucodes.assesmentoneclick.ui.theme.AssesmentOneClickTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AssesmentOneClickTheme {
                HomeScreen(modifier = Modifier
                    .fillMaxWidth())
            }
        }
    }
}


@Composable
fun HomeScreen(modifier: Modifier){

    //Remebering the states of all the textFields.
    var firstText by remember{ mutableStateOf(TextFieldValue("")) }
    var secondText by remember{ mutableStateOf(TextFieldValue("")) }
    var thirdText by remember{ mutableStateOf(TextFieldValue("")) }

    //Variables to store the list that is entered by the user.
    var numList1 by remember { mutableStateOf(listOf<Int>()) }
    var numList2 by remember { mutableStateOf(listOf<Int>()) }
    var numList3 by remember { mutableStateOf(listOf<Int>()) }

    //Variables that hold the value after the calculations.
    var intersection by remember { mutableStateOf(listOf<Int>()) }
    var union by remember { mutableStateOf(listOf<Int>()) }
    var max by remember { mutableIntStateOf(0) }

    //Variable that is responsible for displaying the output.
    var showResults by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp, 50.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(value = firstText,
            onValueChange = {
                firstText = it
            },
            label = { Text(text = "Enter the series of number")},
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            )
        )

        Spacer(modifier = modifier.size(10.dp))

        TextField(value = secondText,
            onValueChange = {
                secondText = it
            },
            label = { Text(text = "Enter the series of number") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            ))

        Spacer(modifier = modifier.size(10.dp))

        TextField(value = thirdText,
            onValueChange = {
                thirdText = it
            },
            label = { Text(text = "Enter the series of number") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            )
        )

        Spacer(modifier = modifier.size(20.dp))

        Button(onClick = {

            //Converting the user entered text into the list of Integers
            val nums1 = firstText.text.split(",").mapNotNull { it.trim().toIntOrNull() }
            numList1 = nums1

            val nums2 = secondText.text.split(",").mapNotNull { it.trim().toIntOrNull() }
            numList2 = nums2

            val nums3 = thirdText.text.split(",").mapNotNull { it.trim().toIntOrNull() }
            numList3 = nums3

            //getting the values after intersection.
            intersection = intersectionFun(numList3, numList2, numList1)
            union = unionFun(numList3, numList2, numList1)
            max = maxi(numList3, numList2, numList1)

            //Displaying the calculated values.
            showResults = true
        }) {
            Text(text = "Calculate!!",
                fontSize = 18.sp)
        }
        Spacer(modifier = modifier.size(20.dp))
        if(showResults){

            Text(text = "Intersection: $intersection",
                fontSize = 20.sp)

            Spacer(modifier = modifier.size(20.dp))

            Text(text = "Union: $union",
                fontSize = 20.sp)

            Spacer(modifier = modifier.size(20.dp))

            Text(text = "Largest: $max",
                fontSize = 20.sp)

        }
    }
}
