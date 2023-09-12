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

/* The Map composable function which takes xPercent and yPercent as parameters
 * to determine the position of the Pac-Man image within the box.
 */
@Composable
fun Map(xPercent: Float, yPercent: Float, modifier: Modifier = Modifier) {

    /* A layout composable that measures its children with the given constraints,
     * then applies the given modifier to the layout's size and constraints.
     */
    BoxWithConstraints(
        modifier = modifier
            .background(Color.Blue) // Setting the background color of the outermost box to blue.
    ) {

        /* Calculating the size for the inner box to maintain a padding of 100.dp
         * from the constraints.
         */
        val boxSize = min(maxWidth, maxHeight) - 100.dp

        // Creating an inner box with a size determined by boxSize and a blue background.
        Box(
            modifier = modifier
                .size(boxSize)
                .background(Color.Blue) // Setting the background color of the inner box to blue.
        ) {

            // Displaying the Pac-Man image and setting its position based on xPercent and yPercent.
            Image(
                // Reference to the Pac-Man drawable resource.
                painter = painterResource(id = R.drawable.pacman_asset),
                contentDescription = null,
                modifier = Modifier
                    .offset(
                        // Calculating the x and y-offset for the image within allowed bounds.
                        x = (xPercent * (boxSize - 36.dp)).coerceIn(0.dp, boxSize - 36.dp),
                        y = (yPercent * (boxSize - 36.dp)).coerceIn(0.dp, boxSize - 36.dp)
                    )
                    .size(36.dp) // Setting the size of the Pac-Man image.
            )
        }
    }
}

// Preview function to visualize the Map composable during development.
@Preview(showBackground = true)
@Composable
fun MapPreview() {

    // Applying the application theme to the preview.
    MyApplicationTheme {
        /* Invoking the Map composable with initial values to position the Pac-Man
         * at the center of the box.
         */

        Map(xPercent = 0.5f, yPercent = 0.5f)
    }
}
