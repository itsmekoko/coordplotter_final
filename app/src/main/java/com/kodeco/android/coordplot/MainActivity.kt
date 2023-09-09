package com.kodeco.android.coordplot

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kodeco.android.coordplot.ui.theme.components.PlotSurface
import com.kodeco.android.coordplot.ui.theme.screens.SplashScreen

// This is the main activity class that inherits from ComponentActivity.
class MainActivity : ComponentActivity() {

    // The onCreate method is called when the activity is first created.
    // It is used to perform one-time initialization.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // setContent is a Compose function that sets the content of the activity to the Composable that is passed to it.
        setContent {

            // Creating an instance of NavController which controls the navigation within a NavHost.
            val navController = rememberNavController()

            // NavHost is a container for navigation, which holds the navigation graph.
            NavHost(navController, startDestination = "splash") {

                // Creating a composable corresponding to the "splash" route.
                // SplashScreen takes NavController as a parameter to perform navigation actions.
                composable("splash") { SplashScreen(navController) }

                // Creating a composable corresponding to the "main" route.
                // PlotSurface is a function that displays the main content of the app.
                composable("main") { PlotSurface() }
            }
        }
    }
}

