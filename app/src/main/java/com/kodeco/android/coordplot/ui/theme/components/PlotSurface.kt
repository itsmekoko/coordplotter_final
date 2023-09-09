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

// The main composable function that renders the plot surface with a map and sliders
// for controlling the x and y positions.
@Composable
fun PlotSurface() {
    // State variables to hold the current values of the x and y sliders.
    // Initialized to 0.5f to start in the center of the surface.
    var xPercent by remember { mutableFloatStateOf(0.5f) }
    var yPercent by remember { mutableFloatStateOf(0.5f) }

    // Main surface which houses the entire UI, with a white background.
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {

        // Column to align the map and sliders in the center of the surface.
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {

            // Map composable function call with the current x and y percentages as parameters.
            Map(xPercent, yPercent)

            // Row for the X-axis control: contains a label and a slider.
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    // Text for showing the percent value
                    text = "X Axis: ${(xPercent * 100).toInt()}%",
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .width(120.dp)
                )
                // Slider to control the x-position,
                // updates the xPercent state variable on value change.
                Slider(
                    value = xPercent,
                    onValueChange = { xPercent = it },
                )
            }

            // Row for the Y-axis control: contains a label and a slider.
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    // Text for showing the percent value
                    text = "Y Axis: ${(yPercent * 100).toInt()}%",
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .width(120.dp)
                )
                // Slider to control the y-position,
                // updates the yPercent state variable on value change.
                Slider(
                    value = yPercent,
                    onValueChange = { yPercent = it },
                )
            }
        }
    }
}

// Preview function to visualize the PlotSurface composable during development.
@Preview(showBackground = true)
@Composable
fun PlotSurfacePreview() {
    MyApplicationTheme {
        // Display a preview of the PlotSurface composable.
        PlotSurface()
    }
}
