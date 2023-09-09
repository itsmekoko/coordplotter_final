package com.kodeco.android.coordplot.ui.theme.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kodeco.android.coordplot.ui.theme.MyApplicationTheme

@Composable
fun PlotSurface() {
    // Define state variables to track x and y percentages for positioning the blue circle
    var xPercent by remember { mutableFloatStateOf(0.5f) }
    var yPercent by remember { mutableFloatStateOf(0.5f) }
    // Main surface for the UI
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {


        // Center the Map and Sliders using a Column
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {

            Map(xPercent, yPercent)

            // Render the map with the blue circle
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically

            ) {
                Text(
                    text = "X Axis: ${(xPercent * 100).toInt()}%", modifier = Modifier
                        .padding(start = 8.dp)
                        .width(120.dp)
                )
                Slider(
                    value = xPercent,
                    onValueChange = { xPercent = it },
                )
            }

            // Row for the yPercent slider and its value
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Y Axis: ${(yPercent * 100).toInt()}%", modifier = Modifier
                        .padding(start = 8.dp)
                        .width(120.dp)
                )
                Slider(
                    value = yPercent,
                    onValueChange = { yPercent = it },
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable

fun PlotSurfacePreview() {
    MyApplicationTheme {
        // Preview of the main PlotSurface composable
        PlotSurface()
    }
}