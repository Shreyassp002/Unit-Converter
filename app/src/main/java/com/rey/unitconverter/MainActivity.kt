package com.rey.unitconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rey.unitconverter.ui.theme.UnitConverterTheme
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      UnitConverterTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
          UnitConverter()
        }
      }
    }
  }
}

@Composable
fun UnitConverter() {
  var inputValue by remember { mutableStateOf("") }
  var outputValue by remember { mutableStateOf("") }
  var inputUnit by remember { mutableStateOf("Centimeter") }
  var outputUnit by remember { mutableStateOf("Meter") }
  var iExpanded by remember { mutableStateOf(false) }
  var oExpanded by remember { mutableStateOf(false) }
  var conversionFactor = remember { mutableStateOf(1.0) }
  var oConversionFactor = remember { mutableStateOf(1.0) }

  fun convertUnits(){
    // ?: --> elvis operator
    val inputValueDouble = inputValue.toDoubleOrNull() ?: 0.0
    val result = (inputValueDouble * conversionFactor.value * 100 / oConversionFactor.value).roundToInt()/ 100
    outputValue = result.toString()
  }

  Column(
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Text("Unit Converter",
      style = MaterialTheme.typography.displaySmall
    )
    Spacer(modifier = Modifier.height(20.dp))
    OutlinedTextField(
      value = inputValue,
      onValueChange = {
        inputValue = it
        convertUnits()
      },
      label = { Text(text = "Enter Value")}
    )
    Spacer(modifier = Modifier.height(20.dp))

    Row {
      //Input Box
      Box {
        //Input Button
        Button(onClick = { iExpanded = true }) {
          Text(text = inputUnit)
          Icon(Icons.Default.ArrowDropDown , contentDescription ="Arrow Down")
        }
        DropdownMenu(expanded = iExpanded, onDismissRequest = { iExpanded = false }) {
          DropdownMenuItem(text = { Text("Centimeter")}, onClick = {
            iExpanded = false
            inputUnit = "Centimeter"
            conversionFactor.value = 0.01
            convertUnits()
          })
          DropdownMenuItem(text = { Text("Meter")}, onClick = {
            iExpanded = false
            inputUnit = "Meter"
            conversionFactor.value = 1.0
            convertUnits()
          })
          DropdownMenuItem(text = { Text("Feet")}, onClick = {
            iExpanded = false
            inputUnit = "Feet"
            conversionFactor.value = 0.3048
            convertUnits()
          })
          DropdownMenuItem(text = { Text("Millimeter")}, onClick = {
            iExpanded = false
            inputUnit = "Millimeter"
            conversionFactor.value = 0.001
            convertUnits()
          })
        }
      }


      Spacer(modifier = Modifier.width(20.dp))

      //Output Box
      Box {
        //Output Button
        Button(onClick = { oExpanded = true }) {
          Text(text = outputUnit)
          Icon(Icons.Default.ArrowDropDown , contentDescription ="Arrow Down")
        }
        DropdownMenu(expanded = oExpanded, onDismissRequest = { oExpanded = false }) {
          DropdownMenuItem(text = { Text("Centimeter")}, onClick = {
            oExpanded = false
            outputUnit = "Centimeter"
            oConversionFactor.value = 0.01
            convertUnits()
          })
          DropdownMenuItem(text = { Text("Meter")}, onClick = {
            oExpanded = false
            outputUnit = "Meter"
            oConversionFactor.value = 1.0
            convertUnits()
          })
          DropdownMenuItem(text = { Text("Feet")}, onClick = {
            oExpanded = false
            outputUnit = "Feet"
            oConversionFactor.value = 0.3048
            convertUnits()
          })
          DropdownMenuItem(text = { Text("Millimeter")}, onClick = {
            oExpanded = false
            outputUnit = "Millimeter"
            oConversionFactor.value = 0.001
            convertUnits()
          })
        }
      }

    }

    Spacer(modifier = Modifier.height(20.dp))

    Text("Result: $outputValue $outputUnit",
      style = MaterialTheme.typography.titleLarge
      )
  }
}

@Preview(showBackground = true)
@Composable
fun UnitConverterPreview() {
  UnitConverter()
}
