package com.kodeco.android.coordplot.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.kodeco.android.coordplot.R
import kotlinx.coroutines.delay

// The SplashScreen composable function is defined here which takes a NavController as a parameter.
@Composable
fun SplashScreen(navController: NavController) {

    /* The Box composable places its children on top of each other,with the last child drawn on top.
     * Here it is modified to fill the maximum size and has a blue background.
     */

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue),
        contentAlignment = Alignment.Center // Aligns the content to the center of the box.
    ) {

        /* The Image composable is used to display an image resource.
         * Here it is displaying the plotter_logo resource.
         */
        Image(
            // References to the logo drawable resource
            painter = painterResource(id = R.drawable.plotter_logo),
            //This should ideally contain a description of the image.
            contentDescription = null,
            // The size of the image is set to 400 dp.
            modifier = Modifier.size(400.dp)

        )

        //LaunchedEffect is a side effect that only runs once, when the composable is first applied.
        LaunchedEffect(Unit) {
            // Delays the execution for 2000 milliseconds (2 seconds)
            delay(2000)
            // Navigates to the "main" destination (PlotSurface composable).
            navController.navigate("main") {
                // Clears the splash screen from the back stack to prevent navigating back to it.
                popUpTo("splash") { inclusive = true }
            }
        }
    }
}
