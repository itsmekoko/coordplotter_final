package com.kodeco.android.coordplot.ui.theme.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import androidx.compose.ui.unit.times
import com.kodeco.android.coordplot.R
import com.kodeco.android.coordplot.ui.theme.MyApplicationTheme

@Composable
fun Map(xPercent: Float, yPercent: Float, modifier: Modifier = Modifier) {
    // Yellow box representing the map
    BoxWithConstraints(
        modifier = modifier
            .background(Color.Blue)
    ) {
        val boxSize = min(maxWidth, maxHeight) - 100.dp

        // Yellow box representing the map
        Box(
            modifier = modifier
                .size(boxSize)
                .background(Color.Blue)
        ) {
            // Blue circle that will be moved based on xPercent and yPercent
            Image(
                painter = painterResource(id = R.drawable.pacman_asset),
                contentDescription = null,
                modifier = Modifier
                    .offset(
                        x = (xPercent * (boxSize - 36.dp)).coerceIn(0.dp, boxSize - 36.dp),
                        y = (yPercent * (boxSize - 36.dp)).coerceIn(0.dp, boxSize - 36.dp)
                    )
                    .size(36.dp)
            )
        }
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