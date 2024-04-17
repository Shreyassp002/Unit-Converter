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
  var conversionFactor = remember { mutableStateOf(0.01) }


  Column(
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Text("Unit Converter")
    Spacer(modifier = Modifier.height(20.dp))
    OutlinedTextField(
        value = inputValue,
        onValueChange = {
          inputValue = it
        // Will Implement Later when value changes
        },
        label = { Text(text = "Enter Value")}
    )
    Spacer(modifier = Modifier.height(20.dp))

    Row {
      Box {
        Button(onClick = { /*TODO*/}) {
          Text(text = "Select")
          Icon(Icons.Default.ArrowDropDown , contentDescription ="Arrow Down")
        }
        DropdownMenu(expanded = false, onDismissRequest = { /*TODO*/ }) {
          DropdownMenuItem(text = { Text("Centimeter")}, onClick = { /*TODO*/ })
          DropdownMenuItem(text = { Text("Meter")}, onClick = { /*TODO*/ })
          DropdownMenuItem(text = { Text("Feet")}, onClick = { /*TODO*/ })
          DropdownMenuItem(text = { Text("Millimeter")}, onClick = { /*TODO*/ })
        }
      }


      Spacer(modifier = Modifier.width(20.dp))

      Box {
        Button(onClick = { /*TODO*/}) {
          Text(text = "Select")
          Icon(Icons.Default.ArrowDropDown , contentDescription ="Arrow Down")
        }
        DropdownMenu(expanded = false, onDismissRequest = { /*TODO*/ }) {
          DropdownMenuItem(text = { Text("Centimeter")}, onClick = { /*TODO*/ })
          DropdownMenuItem(text = { Text("Meter")}, onClick = { /*TODO*/ })
          DropdownMenuItem(text = { Text("Feet")}, onClick = { /*TODO*/ })
          DropdownMenuItem(text = { Text("Millimeter")}, onClick = { /*TODO*/ })
        }
      }

    }

    Spacer(modifier = Modifier.height(20.dp))

    Text("Result:")
  }
}

@Preview(showBackground = true)
@Composable
fun UnitConverterPreview() {
  UnitConverter()
}
