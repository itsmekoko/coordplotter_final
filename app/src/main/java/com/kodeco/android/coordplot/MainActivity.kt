package com.kodeco.android.coordplot

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import com.kodeco.android.coordplot.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set the main content view to be the PlotSurface composable
        setContent {
            MyApplicationTheme {
                PlotSurface()
            }
        }
    }
}

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
            // Render the map with the blue circle
            Map(xPercent, yPercent)
            // Slider to adjust the xPercent (horizontal position)
            Slider(
                value = xPercent,
                onValueChange = { xPercent = it },
                valueRange = 0f..1f,
                modifier = Modifier.padding(top = 16.dp)
            )
            // Slider to adjust the yPercent (vertical position)
            Slider(
                value = yPercent,
                onValueChange = { yPercent = it },
                valueRange = 0f..1f,
                modifier = Modifier.padding(top = 16.dp)
            )
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

@Composable
fun Map(xPercent: Float, yPercent: Float, modifier: Modifier = Modifier) {
    // Yellow box representing the map
    Box(
        modifier = modifier
            .size(300.dp)
            .background(Color.Yellow)
    ) {
        // Blue circle that will be moved based on xPercent and yPercent
        Box(
            modifier = Modifier
                // Offset determines the position of the blue circle on the yellow box
                // The .coerceIn() function ensures the blue circle stays inside the yellow box.
                .offset(
                    x = (xPercent * (300.dp - 36.dp)).coerceIn(0.dp, 300.dp - 36.dp),
                    y = (yPercent * (300.dp - 36.dp)).coerceIn(0.dp, 300.dp - 36.dp)
                )
                .size(36.dp)
                .clip(CircleShape)
                .background(Color.Blue)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MapPreview() {
    MyApplicationTheme {
        // Preview of the Map composable with centered blue circle
        Map(xPercent = 0.5f, yPercent = 0.5f)
    }
}
